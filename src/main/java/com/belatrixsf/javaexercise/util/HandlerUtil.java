package com.belatrixsf.javaexercise.util;

import com.belatrixsf.javaexercise.enums.Level;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Component
public class HandlerUtil {

    private FileHandler fileHandler;
    private ConsoleHandler consoleHandler;

    private Logger logger = Logger.getLogger(MessageUtil.NAME_LOG);

    /*@Value("${exercise.logger.file.log}")
    private Boolean logToFile;

    @Value("${exercise.logger.console.log}")
    private Boolean logToConsole;

    @Value("${exercise.logger.file.path}")
    private String filePath;*/

    public HandlerUtil(@Value("${exercise.logger.file.path}") String filePath,
                       @Value("${exercise.logger.file.log}") Boolean logToFile,
                       @Value("${exercise.logger.console.log}") Boolean logToConsole){
        try {
            System.out.println(filePath);
            File file = new File(filePath);
            if(!file.exists()){
                file.createNewFile();
            }

            fileHandler = new FileHandler(filePath);

            if(logToFile){
                logger.addHandler(fileHandler);
            } else if(logToConsole){
                consoleHandler = new ConsoleHandler();
                logger.addHandler(consoleHandler);
            }
        } catch(IOException io){
            io.printStackTrace();
        }
    }

    public void saveLogFile(String messageText, Integer level){
        Level levelEnum = Level.getCode(level);
        if(Objects.nonNull(levelEnum)){
            logger.log(levelEnum.getLevelLog(), messageText);
        } else
            logger.log(java.util.logging.Level.SEVERE, messageText);
    }



}
