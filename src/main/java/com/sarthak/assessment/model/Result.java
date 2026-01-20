package com.sarthak.assessment.model;

public class Result {

    private int resultId;
    private int attemptId;
    private int score;
    private double percentage;
    private String passFail;

    // No-arg constructor
    public Result() {}

    // Constructor while saving result
    public Result(int attemptId, int score, double percentage, String passFail) {
        this.attemptId = attemptId;
        this.score = score;
        this.percentage = percentage;
        this.passFail = passFail;
    }

    // Getters & Setters
    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public int getAttemptId() {
        return attemptId;
    }

    public void setAttemptId(int attemptId) {
        this.attemptId = attemptId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getPassFail() {
        return passFail;
    }

    public void setPassFail(String passFail) {
        this.passFail = passFail;
    }
}
