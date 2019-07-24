package com.belatrixsf.javaexercise.service;

import com.belatrixsf.javaexercise.exception.LoggerException;

public interface LoggerService {

    void logMessage(String message, Integer level) throws LoggerException;
}
