package com.mercor.objectstore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/health")
public class HealthController {

    private static final Logger logger = LoggerFactory.getLogger(HealthController.class);
    private final DataSource dataSource;

    @Autowired
    public HealthController(DataSource dataSource) {
        this.dataSource = dataSource;
        logger.info("HealthController initialized");
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> health() {
        logger.debug("Health check endpoint called");
        Map<String, Object> health = new HashMap<>();
        health.put("status", "UP");
        health.put("service", "Object Store API");
        
        // Check database connection
        logger.debug("Checking database connection");
        try (Connection connection = dataSource.getConnection()) {
            boolean isValid = connection.isValid(2); // 2 second timeout
            if (isValid) {
                health.put("database", "UP");
                logger.debug("Database connection is valid");
                logger.info("Health check: Service UP, Database UP");
            } else {
                health.put("database", "DOWN");
                health.put("status", "DOWN");
                logger.warn("Database connection is invalid");
                logger.error("Health check: Service DOWN, Database DOWN - Connection invalid");
            }
        } catch (SQLException e) {
            health.put("database", "DOWN");
            health.put("databaseError", e.getMessage());
            health.put("status", "DOWN");
            logger.error("Database connection failed: {}", e.getMessage(), e);
            logger.error("Health check: Service DOWN, Database DOWN - SQLException: {}", e.getMessage());
        }
        
        // Determine HTTP status
        if ("UP".equals(health.get("status"))) {
            return ResponseEntity.ok(health);
        } else {
            return ResponseEntity.status(503).body(health);
        }
    }

    @GetMapping("/simple")
    public ResponseEntity<Map<String, String>> simpleHealth() {
        logger.debug("Simple health check endpoint called");
        Map<String, String> health = new HashMap<>();
        health.put("status", "UP");
        logger.debug("Simple health check: UP");
        return ResponseEntity.ok(health);
    }
}