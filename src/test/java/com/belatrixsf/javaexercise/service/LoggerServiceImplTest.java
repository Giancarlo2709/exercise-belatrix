package com.belatrixsf.javaexercise.service;

import com.belatrixsf.javaexercise.enums.Level;
import com.belatrixsf.javaexercise.exception.LoggerException;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoggerServiceImplTest {

    @Autowired
    LoggerService loggerService;

    @Test
    public void testLogMessage()throws LoggerException {
        loggerService.logMessage("Message Info Test", Level.MESSAGE.getCode());
    }


}
