package com.sarthak.assessment.model;

public class StudentAnswer {

    private int answerId;
    private int attemptId;
    private int questionId;
    private char selectedOption;
    private boolean isCorrect;

    // No-arg constructor
    public StudentAnswer() {}

    // Constructor while saving answer
    public StudentAnswer(int attemptId, int questionId, char selectedOption) {
        this.attemptId = attemptId;
        this.questionId = questionId;
        this.selectedOption = selectedOption;
    }

    // Constructor when fetched from DB
    public StudentAnswer(int answerId, int attemptId, int questionId,
                         char selectedOption, boolean isCorrect) {
        this.answerId = answerId;
        this.attemptId = attemptId;
        this.questionId = questionId;
        this.selectedOption = selectedOption;
        this.isCorrect = isCorrect;
    }

    // Getters & Setters
    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public int getAttemptId() {
        return attemptId;
    }

    public void setAttemptId(int attemptId) {
        this.attemptId = attemptId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public char getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(char selectedOption) {
        this.selectedOption = selectedOption;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
