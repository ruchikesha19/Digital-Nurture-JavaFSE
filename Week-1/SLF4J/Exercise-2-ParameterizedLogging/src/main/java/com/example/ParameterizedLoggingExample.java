package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String user = "Ruchi";
        int id = 502;
        String action = "viewed gitignore";

        // Parameterized logging using placeholder {}
        logger.info("User {} (ID: {}) performed action: '{}'", user, id, action);
        logger.warn("Attention: Operation '{}' was completed with execution ID: {}", action, id);
    }
}
