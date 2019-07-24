package com.belatrixsf.javaexercise.service.impl;

import com.belatrixsf.javaexercise.dao.LoggerDao;
import com.belatrixsf.javaexercise.enums.Level;
import com.belatrixsf.javaexercise.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Date;
import java.util.Objects;

@Service
public class LoggerServiceImpl implements LoggerService {

    private final LoggerDao loggerDao;

    @Value("${properties.logger.database-log}")
    private Boolean logToDatabase;

    @Value("${properties.logger.message-log}")
    private Boolean logMessage;

    @Value("${properties.logger.warning-log}")
    private Boolean logWarning;

    @Value("${properties.logger.error-log}")
    private Boolean logError;

    @Autowired
    public LoggerServiceImpl(LoggerDao loggerDao) {
        this.loggerDao = loggerDao;
    }

    @Override
    public void logMessage(String message, Integer level) {
        if(!(Objects.nonNull(message) && message.trim().isEmpty())){
            return;
        }
    }

    private String formatMessage(String messageText, Integer level) {
        Level levelEnum = Level.getCode(level);
        if(Objects.nonNull(levelEnum)){
            return levelEnum.getValue() + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
        } else
            return Level.ERROR.getValue() + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
    }
}
