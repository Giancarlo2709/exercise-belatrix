package com.belatrixsf.javaexercise.service.impl;

import com.belatrixsf.javaexercise.dao.LoggerDao;
import com.belatrixsf.javaexercise.entity.Logger;
import com.belatrixsf.javaexercise.enums.Level;
import com.belatrixsf.javaexercise.exception.LoggerException;
import com.belatrixsf.javaexercise.service.LoggerService;
import com.belatrixsf.javaexercise.util.HandlerUtil;
import com.belatrixsf.javaexercise.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.util.Date;
import java.util.Objects;

@Service
@Transactional
public class LoggerServiceImpl implements LoggerService {

    private final LoggerDao loggerDao;
    private final HandlerUtil handlerUtil;

    @Value("${exercise.logger.database.log}")
    private Boolean logToDatabase;

    @Value("${exercise.logger.file.log}")
    private Boolean logToFile;

    @Value("${exercise.logger.console.log}")
    private Boolean logToConsole;

    @Value("${exercise.logger.message.log}")
    private Boolean logMessage;

    @Value("${exercise.logger.warning.log}")
    private Boolean logWarning;

    @Value("${exercise.logger.error.log}")
    private Boolean logError;

    @Autowired
    public LoggerServiceImpl(LoggerDao loggerDao, HandlerUtil handlerUtil) {
        this.loggerDao = loggerDao;
        this.handlerUtil = handlerUtil;
    }

    @Override
    public void logMessage(String messageText, Integer level) throws LoggerException {
        if (!(Objects.nonNull(messageText) && !messageText.trim().isEmpty())) {
            return;
        }

        //valid configuration
        validateConfiguration();

        //valid level
        if (!validateLevel(level))
            throw new LoggerException(MessageUtil.LEVEL_SPECIFIED);

        messageText = getFormatMessage(messageText, level);

        if(logToDatabase) {
            saveLogger(messageText, level);
            handlerUtil.saveLogFile(MessageUtil.SAVED_TO_DATABASE, Level.MESSAGE.getCode());
        }

        handlerUtil.saveLogFile(messageText, level);
    }

    private void validateConfiguration()throws LoggerException {
        if(!(logToDatabase && logToConsole && logToFile)){
            throw new LoggerException(MessageUtil.INVALID_CONFIGURATION);
        }
    }

    private Boolean validateLevel(Integer level) {
        if(logMessage && Level.MESSAGE.getCode().equals(level))
            return Boolean.TRUE;

        if(logWarning && Level.MESSAGE.getCode().equals(level))
            return Boolean.TRUE;

        if(logError && Level.MESSAGE.getCode().equals(level))
            return Boolean.TRUE;

        return Boolean.FALSE;
    }

    private String getFormatMessage(String messageText, Integer level) {
        Level levelEnum = Level.getCode(level);
        if(Objects.nonNull(levelEnum)){
            return levelEnum.getValue() + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " - " + messageText;
        } else
            return Level.ERROR.getValue() + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " - " + messageText;
    }

    private Logger saveLogger(String messageText, Integer level){
        Logger logger = new Logger();
        logger.setMessage(messageText);
        logger.setLevel(level);

        return loggerDao.save(logger);
    }
}
