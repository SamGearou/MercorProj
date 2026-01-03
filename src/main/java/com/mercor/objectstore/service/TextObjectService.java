package com.mercor.objectstore.service;

import com.mercor.objectstore.model.TextObject;
import com.mercor.objectstore.repository.TextObjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TextObjectService {

    private static final Logger logger = LoggerFactory.getLogger(TextObjectService.class);
    private final TextObjectRepository repository;

    @Autowired
    public TextObjectService(TextObjectRepository repository) {
        this.repository = repository;
        logger.info("TextObjectService initialized");
    }

    public TextObject save(String key, String content) {
        logger.debug("Saving object with key={}, content length={}", key, content != null ? content.length() : 0);
        
        Optional<TextObject> existing = repository.findByKey(key);
        if (existing.isPresent()) {
            logger.debug("Object with key={} already exists, updating content", key);
            TextObject obj = existing.get();
            logger.info("Updating existing object with key={}, id={}", key, obj.getId());
            obj.setContent(content);
            TextObject updated = repository.save(obj);
            logger.info("Successfully updated object with key={}, id={}", key, updated.getId());
            logger.debug("Updated object: id={}, createdAt={}, updatedAt={}", 
                updated.getId(), updated.getCreatedAt(), updated.getUpdatedAt());
            return updated;
        } else {
            logger.debug("Object with key={} does not exist, creating new", key);
            logger.info("Creating new object with key={}", key);
            TextObject newObj = new TextObject(key, content);
            TextObject saved = repository.save(newObj);
            logger.info("Successfully created new object with key={}, id={}", key, saved.getId());
            logger.debug("Created object: id={}, createdAt={}", saved.getId(), saved.getCreatedAt());
            return saved;
        }
    }

    public Optional<TextObject> findByKey(String key) {
        logger.debug("Finding object by key={}", key);
        Optional<TextObject> result = repository.findByKey(key);
        if (result.isPresent()) {
            logger.debug("Found object with key={}, id={}", key, result.get().getId());
        } else {
            logger.debug("Object with key={} not found", key);
        }
        return result;
    }

    public List<TextObject> findAll() {
        logger.debug("Finding all objects");
        List<TextObject> result = repository.findAll();
        logger.debug("Found {} objects", result.size());
        return result;
    }

    public boolean existsByKey(String key) {
        logger.debug("Checking if object exists with key={}", key);
        boolean exists = repository.existsByKey(key);
        logger.debug("Object with key={} exists: {}", key, exists);
        return exists;
    }

    public void deleteByKey(String key) {
        logger.debug("Deleting object with key={}", key);
        logger.info("Deleting object with key={}", key);
        repository.deleteByKey(key);
        logger.info("Successfully deleted object with key={}", key);
    }
}

