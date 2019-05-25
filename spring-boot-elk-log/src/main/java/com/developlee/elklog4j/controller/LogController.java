package com.developlee.elklog4j.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Lensen
 * @desc
 * @since 2018/9/5 14:09
 */
@RestController
public class LogController {
    //private static final Logger logger = LogManager.getLogger(LogController.class);

    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    @GetMapping("/log")
    public String logDemo() {
        logger.info("the first log...");
        logger.trace("the second log...");
        logger.error("the third log... ");
        logger.warn("the fourth log...");
        return "logger is running...";
    }
}
