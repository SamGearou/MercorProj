package com.mercor.objectstore.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class MetricsService {

    private final Counter objectCreatedCounter;
    private final Counter objectUpdatedCounter;
    private final Counter objectDeletedCounter;
    private final Counter objectRetrievedCounter;
    private final MeterRegistry meterRegistry;

    public MetricsService(MeterRegistry registry) {
        this.meterRegistry = registry;
        
        this.objectCreatedCounter = Counter.builder("objectstore.objects.created")
                .description("Total number of objects created")
                .tag("application", "objectstore")
                .register(registry);

        this.objectUpdatedCounter = Counter.builder("objectstore.objects.updated")
                .description("Total number of objects updated")
                .tag("application", "objectstore")
                .register(registry);

        this.objectDeletedCounter = Counter.builder("objectstore.objects.deleted")
                .description("Total number of objects deleted")
                .tag("application", "objectstore")
                .register(registry);

        this.objectRetrievedCounter = Counter.builder("objectstore.objects.retrieved")
                .description("Total number of objects retrieved")
                .tag("application", "objectstore")
                .register(registry);
    }

    public void incrementObjectCreated() {
        objectCreatedCounter.increment();
    }

    public void incrementObjectUpdated() {
        objectUpdatedCounter.increment();
    }

    public void incrementObjectDeleted() {
        objectDeletedCounter.increment();
    }

    public void incrementObjectRetrieved() {
        objectRetrievedCounter.increment();
    }

    public Timer.Sample startDatabaseOperationTimer() {
        return Timer.start(meterRegistry);
    }

    public void recordDatabaseOperation(Timer.Sample sample, String operation) {
        Timer timer = Timer.builder("objectstore.database.operation.duration")
                .description("Database operation latency")
                .tag("application", "objectstore")
                .tag("operation", operation)
                .publishPercentiles(0.5, 0.95, 0.99)
                .register(meterRegistry);
        sample.stop(timer);
    }
}

