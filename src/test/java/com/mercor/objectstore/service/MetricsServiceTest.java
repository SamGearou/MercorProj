package com.mercor.objectstore.service;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MetricsServiceTest {

    private MeterRegistry meterRegistry;
    private MetricsService metricsService;

    @BeforeEach
    void setUp() {
        meterRegistry = new SimpleMeterRegistry();
        metricsService = new MetricsService(meterRegistry);
    }

    @Test
    void testIncrementObjectCreated() {
        // Given
        double initialCount = getCounterCount("objectstore.objects.created");

        // When
        metricsService.incrementObjectCreated();
        metricsService.incrementObjectCreated();

        // Then
        double finalCount = getCounterCount("objectstore.objects.created");
        assertEquals(initialCount + 2.0, finalCount, 0.001);
    }

    @Test
    void testIncrementObjectUpdated() {
        // Given
        double initialCount = getCounterCount("objectstore.objects.updated");

        // When
        metricsService.incrementObjectUpdated();
        metricsService.incrementObjectUpdated();
        metricsService.incrementObjectUpdated();

        // Then
        double finalCount = getCounterCount("objectstore.objects.updated");
        assertEquals(initialCount + 3.0, finalCount, 0.001);
    }

    @Test
    void testIncrementObjectDeleted() {
        // Given
        double initialCount = getCounterCount("objectstore.objects.deleted");

        // When
        metricsService.incrementObjectDeleted();

        // Then
        double finalCount = getCounterCount("objectstore.objects.deleted");
        assertEquals(initialCount + 1.0, finalCount, 0.001);
    }

    @Test
    void testIncrementObjectRetrieved() {
        // Given
        double initialCount = getCounterCount("objectstore.objects.retrieved");

        // When
        metricsService.incrementObjectRetrieved();
        metricsService.incrementObjectRetrieved();
        metricsService.incrementObjectRetrieved();
        metricsService.incrementObjectRetrieved();

        // Then
        double finalCount = getCounterCount("objectstore.objects.retrieved");
        assertEquals(initialCount + 4.0, finalCount, 0.001);
    }

    @Test
    void testAllCountersIncrement() {
        // Given
        double initialCreated = getCounterCount("objectstore.objects.created");
        double initialUpdated = getCounterCount("objectstore.objects.updated");
        double initialDeleted = getCounterCount("objectstore.objects.deleted");
        double initialRetrieved = getCounterCount("objectstore.objects.retrieved");

        // When
        metricsService.incrementObjectCreated();
        metricsService.incrementObjectUpdated();
        metricsService.incrementObjectDeleted();
        metricsService.incrementObjectRetrieved();

        // Then
        assertEquals(initialCreated + 1.0, getCounterCount("objectstore.objects.created"), 0.001);
        assertEquals(initialUpdated + 1.0, getCounterCount("objectstore.objects.updated"), 0.001);
        assertEquals(initialDeleted + 1.0, getCounterCount("objectstore.objects.deleted"), 0.001);
        assertEquals(initialRetrieved + 1.0, getCounterCount("objectstore.objects.retrieved"), 0.001);
    }

    @Test
    void testStartDatabaseOperationTimer() {
        // When
        var sample = metricsService.startDatabaseOperationTimer();

        // Then
        assertNotNull(sample);
    }

    @Test
    void testRecordDatabaseOperation() throws InterruptedException {
        // Given
        var sample = metricsService.startDatabaseOperationTimer();
        Thread.sleep(10); // Simulate some database operation time

        // When
        metricsService.recordDatabaseOperation(sample, "SELECT");

        // Then
        var timer = meterRegistry.find("objectstore.database.operation.duration")
                .tag("application", "objectstore")
                .tag("operation", "SELECT")
                .timer();
        assertNotNull(timer);
        assertEquals(1, timer.count());
        assertTrue(timer.totalTime(java.util.concurrent.TimeUnit.MILLISECONDS) > 0);
    }

    @Test
    void testRecordDatabaseOperationWithDifferentOperations() throws InterruptedException {
        // Given
        var sample1 = metricsService.startDatabaseOperationTimer();
        Thread.sleep(5);
        metricsService.recordDatabaseOperation(sample1, "SELECT");

        var sample2 = metricsService.startDatabaseOperationTimer();
        Thread.sleep(5);
        metricsService.recordDatabaseOperation(sample2, "INSERT");

        var sample3 = metricsService.startDatabaseOperationTimer();
        Thread.sleep(5);
        metricsService.recordDatabaseOperation(sample3, "UPDATE");

        // Then
        var selectTimer = meterRegistry.find("objectstore.database.operation.duration")
                .tag("application", "objectstore")
                .tag("operation", "SELECT")
                .timer();
        assertNotNull(selectTimer);
        assertEquals(1, selectTimer.count());

        var insertTimer = meterRegistry.find("objectstore.database.operation.duration")
                .tag("application", "objectstore")
                .tag("operation", "INSERT")
                .timer();
        assertNotNull(insertTimer);
        assertEquals(1, insertTimer.count());

        var updateTimer = meterRegistry.find("objectstore.database.operation.duration")
                .tag("application", "objectstore")
                .tag("operation", "UPDATE")
                .timer();
        assertNotNull(updateTimer);
        assertEquals(1, updateTimer.count());
    }

    @Test
    void testCounterTags() {
        // When
        metricsService.incrementObjectCreated();

        // Then
        var counter = meterRegistry.find("objectstore.objects.created")
                .tag("application", "objectstore")
                .counter();
        assertNotNull(counter);
        assertEquals("objectstore", counter.getId().getTag("application"));
    }

    @Test
    void testCounterDescriptions() {
        // When
        metricsService.incrementObjectCreated();

        // Then
        var counter = meterRegistry.find("objectstore.objects.created").counter();
        assertNotNull(counter);
        assertTrue(counter.getId().getDescription().contains("Total number of objects created"));
    }

    @Test
    void testMultipleIncrements() {
        // When
        for (int i = 0; i < 100; i++) {
            metricsService.incrementObjectCreated();
        }

        // Then
        double count = getCounterCount("objectstore.objects.created");
        assertEquals(100.0, count, 0.001);
    }

    @Test
    void testDatabaseOperationTimerWithMultipleCalls() throws InterruptedException {
        // When
        for (int i = 0; i < 5; i++) {
            var sample = metricsService.startDatabaseOperationTimer();
            Thread.sleep(5);
            metricsService.recordDatabaseOperation(sample, "SELECT");
        }

        // Then
        var timer = meterRegistry.find("objectstore.database.operation.duration")
                .tag("application", "objectstore")
                .tag("operation", "SELECT")
                .timer();
        assertNotNull(timer);
        assertEquals(5, timer.count());
    }

    @Test
    void testCountersAreIndependent() {
        // When
        metricsService.incrementObjectCreated();
        metricsService.incrementObjectUpdated();
        metricsService.incrementObjectDeleted();
        metricsService.incrementObjectRetrieved();

        // Then
        assertEquals(1.0, getCounterCount("objectstore.objects.created"), 0.001);
        assertEquals(1.0, getCounterCount("objectstore.objects.updated"), 0.001);
        assertEquals(1.0, getCounterCount("objectstore.objects.deleted"), 0.001);
        assertEquals(1.0, getCounterCount("objectstore.objects.retrieved"), 0.001);
    }

    @Test
    void testDatabaseOperationTimerTags() throws InterruptedException {
        // Given
        var sample = metricsService.startDatabaseOperationTimer();
        Thread.sleep(5);

        // When
        metricsService.recordDatabaseOperation(sample, "DELETE");

        // Then
        var timer = meterRegistry.find("objectstore.database.operation.duration")
                .tag("application", "objectstore")
                .tag("operation", "DELETE")
                .timer();
        assertNotNull(timer);
        assertEquals("objectstore", timer.getId().getTag("application"));
        assertEquals("DELETE", timer.getId().getTag("operation"));
    }

    /**
     * Helper method to get counter count from registry
     */
    private double getCounterCount(String name) {
        var counter = meterRegistry.find(name)
                .tag("application", "objectstore")
                .counter();
        return counter != null ? counter.count() : 0.0;
    }
}

