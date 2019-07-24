package com.belatrixsf.javaexercise.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Level {

    MESSAGE(Integer.valueOf(1), "Message ", java.util.logging.Level.INFO),
    WARNING(Integer.valueOf(2), "Warning ", java.util.logging.Level.WARNING),
    ERROR(Integer.valueOf(3), "Error ", java.util.logging.Level.SEVERE);

    private static final Map<Integer, Level> lookup = new HashMap<>();

    private Integer code;
    private String value;
    private java.util.logging.Level levelLog;

    static {
        Arrays.asList(Level.values()).forEach(x -> lookup.put(x.getCode(), x));
    }

    private Level(Integer code, String value, java.util.logging.Level levelLog){
        this.code = code;
        this.value = value;
        this.levelLog = levelLog;
    }

    public static Level getCode(Integer code){
        return lookup.get(code);
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public java.util.logging.Level getLevelLog() {
        return levelLog;
    }
}
