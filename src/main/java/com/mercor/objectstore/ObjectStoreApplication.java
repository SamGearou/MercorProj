package com.mercor.objectstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ObjectStoreApplication {

    private static final Logger logger = LoggerFactory.getLogger(ObjectStoreApplication.class);

    public static void main(String[] args) {
        logger.info("Starting Object Store Application...");
        logger.debug("Application arguments: {}", java.util.Arrays.toString(args));
        
        SpringApplication.run(ObjectStoreApplication.class, args);
        
        logger.info("Object Store Application started successfully");
        logger.debug("Application is ready to accept requests");
    }
}

