package com.belatrixsf.javaexercise.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "logger")
public class Logger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long loggerId;

    private String message;

    private Integer level;

    @CreatedDate
    private LocalDateTime createdDate;

    public Logger() {
        super();
    }

    public Long getLoggerId() {
        return loggerId;
    }

    public String getMessage() {
        return message;
    }

    public Integer getLevel() {
        return level;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setLoggerId(Long loggerId) {
        this.loggerId = loggerId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Logger logger = (Logger) o;
        return loggerId.equals(logger.loggerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loggerId);
    }

    @Override
    public String toString() {
        return "Logger{" +
                "loggerId=" + loggerId +
                ", message='" + message + '\'' +
                ", level=" + level +
                ", createdDate=" + createdDate +
                '}';
    }
}
