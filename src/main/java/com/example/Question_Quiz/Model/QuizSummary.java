package com.example.Question_Quiz.Model;

public class QuizSummary {
    private int correctAnswers;
    private int incorrectAnswers;

    public QuizSummary() {
    }

    public QuizSummary(int correctAnswers, int incorrectAnswers) {
        this.correctAnswers = correctAnswers;
        this.incorrectAnswers = incorrectAnswers;
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
}
