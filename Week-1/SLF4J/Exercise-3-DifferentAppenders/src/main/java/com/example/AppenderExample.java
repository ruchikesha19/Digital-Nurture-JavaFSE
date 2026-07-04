package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderExample {
    private static final Logger logger = LoggerFactory.getLogger(AppenderExample.class);

    public static void main(String[] args) {
        logger.debug("Debug log message: App initialization started.");
        logger.info("Info log message: App is running normally.");
        logger.warn("Warning log message: Low disk space detected.");
        logger.error("Error log message: Database connection failed.");
    }
}
