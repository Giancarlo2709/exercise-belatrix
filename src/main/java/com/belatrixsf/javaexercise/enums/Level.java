package com.belatrixsf.javaexercise.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Level {

    MESSAGE(Integer.valueOf(1), "Message "),
    WARNING(Integer.valueOf(2), "Warning "),
    ERROR(Integer.valueOf(3), "Error ");

    private static final Map<Integer, Level> lookup = new HashMap<>();

    private Integer code;
    private String value;

    static {
        Arrays.asList(Level.values()).forEach(x -> lookup.put(x.getCode(), x));
    }

    private Level(Integer code, String value){
        this.code = code;
        this.value = value;
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
}
