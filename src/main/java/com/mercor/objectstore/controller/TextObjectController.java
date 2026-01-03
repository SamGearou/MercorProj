package com.mercor.objectstore.controller;

import com.mercor.objectstore.model.TextObject;
import com.mercor.objectstore.service.MetricsService;
import com.mercor.objectstore.service.TextObjectService;
import io.micrometer.core.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/objects")
@Timed(value = "objectstore.api", description = "API endpoint metrics")
public class TextObjectController {

    private static final Logger logger = LoggerFactory.getLogger(TextObjectController.class);
    private final TextObjectService service;
    private final MetricsService metricsService;

    @Autowired
    public TextObjectController(TextObjectService service, MetricsService metricsService) {
        this.service = service;
        this.metricsService = metricsService;
        logger.info("TextObjectController initialized");
    }

    @PostMapping
    @Timed(value = "objectstore.api.create_or_update", description = "Create or update object endpoint")
    public ResponseEntity<TextObject> createOrUpdate(@Valid @RequestBody Map<String, String> request) {
        logger.debug("Received POST request to create or update object");
        logger.debug("Request body: key={}, content length={}", 
            request.get("key"), 
            request.get("content") != null ? request.get("content").length() : 0);
        
        String key = request.get("key");
        String content = request.get("content");

        if (key == null || key.trim().isEmpty()) {
            logger.warn("Invalid request: key is null or empty");
            return ResponseEntity.badRequest().build();
        }
        if (content == null) {
            logger.warn("Invalid request: content is null for key={}", key);
            return ResponseEntity.badRequest().build();
        }

        logger.info("Creating or updating object with key={}", key);
        TextObject saved = service.save(key, content);
        
        // Track metrics
        if (saved.getUpdatedAt() != null) {
            metricsService.incrementObjectUpdated();
        } else {
            metricsService.incrementObjectCreated();
        }
        
        logger.info("Successfully saved object with key={}, id={}", key, saved.getId());
        logger.debug("Saved object details: id={}, createdAt={}, updatedAt={}", 
            saved.getId(), saved.getCreatedAt(), saved.getUpdatedAt());
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{key}")
    @Timed(value = "objectstore.api.get_by_key", description = "Get object by key endpoint")
    public ResponseEntity<TextObject> getByKey(@PathVariable String key) {
        logger.debug("Received GET request for key={}", key);
        logger.info("Retrieving object with key={}", key);
        
        Optional<TextObject> obj = service.findByKey(key);
        
        if (obj.isPresent()) {
            metricsService.incrementObjectRetrieved();
            logger.info("Successfully retrieved object with key={}, id={}", key, obj.get().getId());
            logger.debug("Retrieved object: id={}, content length={}", 
                obj.get().getId(), 
                obj.get().getContent() != null ? obj.get().getContent().length() : 0);
            return ResponseEntity.ok(obj.get());
        } else {
            logger.warn("Object not found for key={}", key);
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    @Timed(value = "objectstore.api.get_all", description = "Get all objects endpoint")
    public ResponseEntity<List<TextObject>> getAll() {
        logger.debug("Received GET request for all objects");
        logger.info("Retrieving all objects");
        
        List<TextObject> objects = service.findAll();
        logger.info("Successfully retrieved {} objects", objects.size());
        logger.debug("Retrieved {} objects from database", objects.size());
        
        return ResponseEntity.ok(objects);
    }

    @DeleteMapping("/{key}")
    @Timed(value = "objectstore.api.delete", description = "Delete object endpoint")
    public ResponseEntity<Void> deleteByKey(@PathVariable String key) {
        logger.debug("Received DELETE request for key={}", key);
        logger.info("Attempting to delete object with key={}", key);
        
        if (service.existsByKey(key)) {
            service.deleteByKey(key);
            metricsService.incrementObjectDeleted();
            logger.info("Successfully deleted object with key={}", key);
            return ResponseEntity.noContent().build();
        } else {
            logger.warn("Attempted to delete non-existent object with key={}", key);
            return ResponseEntity.notFound().build();
        }
    }
}