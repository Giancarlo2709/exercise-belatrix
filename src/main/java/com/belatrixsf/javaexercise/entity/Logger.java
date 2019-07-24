package com.belatrixsf.javaexercise.entity;

import javax.persistence.*;

@Entity
@Table(name = "logger")
public class Logger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long loggerId;

    private String message;

    private Integer level;
}
