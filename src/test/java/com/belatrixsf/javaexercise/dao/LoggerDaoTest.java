package com.belatrixsf.javaexercise.dao;

import com.belatrixsf.javaexercise.entity.Logger;
import com.belatrixsf.javaexercise.enums.Level;
import org.junit.Assert;
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
public class LoggerDaoTest {

    @Autowired
    LoggerDao loggerDao;

    @Test
    public void loggerDaoNotNull(){
        Assert.assertNotNull("loggerDao is not null", loggerDao);
    }

    @Test
    public void saveLogger(){
        Logger logger = new Logger();
        logger.setMessage("MessageText Test Belatrix");
        logger.setLevel(Level.MESSAGE.getCode());
        logger = loggerDao.save(logger);
        Assert.assertNotNull("Logger inserted succesful", logger.getLoggerId());
    }

}
