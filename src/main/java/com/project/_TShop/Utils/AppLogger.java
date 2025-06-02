package com.project._TShop.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppLogger {

    private static AppLogger instance;
    private final Logger logger;

    private AppLogger() {
        logger = LoggerFactory.getLogger(AppLogger.class);
    }

    public static AppLogger getInstance() {
        if (instance == null) {
            instance = new AppLogger();
        }
        return instance;
    }

    public void info(String message) {
        logger.info(message);
    }

    public void error(String message) {
        logger.error(message);
    }

    public void debug(String message) {
        logger.debug(message);
    }
}
