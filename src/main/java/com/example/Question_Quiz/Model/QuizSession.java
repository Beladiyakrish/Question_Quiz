package com.example.Question_Quiz.Model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class QuizSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Date startTime;
    private int correctAnswers;
    private int incorrectAnswers;

    public QuizSession() {
    }

    public QuizSession(Long id, Long userId, Date startTime, int correctAnswers, int incorrectAnswers) {
        this.id = id;
        this.userId = userId;
        this.startTime = startTime;
        this.correctAnswers = correctAnswers;
        this.incorrectAnswers = incorrectAnswers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void setIncorrectAnswers(int incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    public void incrementCorrectAnswers() {
        this.correctAnswers++;
    }

    public void incrementIncorrectAnswers() {
        this.incorrectAnswers++;
    }
}