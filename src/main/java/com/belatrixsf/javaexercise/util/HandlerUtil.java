package com.belatrixsf.javaexercise.util;

import org.springframework.beans.factory.annotation.Value;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class HandlerUtil {

    @Value("${properties.logger.name-log}")
    private String nameLog;

    private Logger logger = Logger.getLogger(nameLog);

    @Value("${properties.logger.file-log}")
    private Boolean logToFile;

    @Value("${properties.logger.console-log}")
    private Boolean logToConsole;

    @Value("${properties.logger.file-path}")
    private String filePath;

    private FileHandler fileHandler;
    private ConsoleHandler consoleHandler;



}
