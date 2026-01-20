package com.sarthak.assessment.model;

import java.time.LocalDateTime;

public class ExamAttempt {

    private int attemptId;
    private int userId;
    private int examId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;   // IN_PROGRESS, COMPLETED, TIMEOUT

    // No-arg constructor
    public ExamAttempt() {}

    // Constructor when exam starts
    public ExamAttempt(int userId, int examId, LocalDateTime startTime, String status) {
        this.userId = userId;
        this.examId = examId;
        this.startTime = startTime;
        this.status = status;
    }

    // Constructor when fetched from DB
    public ExamAttempt(int attemptId, int userId, int examId,
                       LocalDateTime startTime, LocalDateTime endTime, String status) {
        this.attemptId = attemptId;
        this.userId = userId;
        this.examId = examId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    // Getters & Setters
    public int getAttemptId() {
        return attemptId;
    }

    public void setAttemptId(int attemptId) {
        this.attemptId = attemptId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
