package com.sarthak.assessment.model;

import java.time.LocalDate;

public class Exam {

    private int examId;
    private String examTitle;
    private int durationMinutes;
    private int totalMarks;
    private int createdBy;        // admin user_id
    private LocalDate examDate;

    // No-arg constructor
    public Exam() {}

    // Constructor for creating new exam
    public Exam(String examTitle, int durationMinutes, int totalMarks,
                int createdBy, LocalDate examDate) {
        this.examTitle = examTitle;
        this.durationMinutes = durationMinutes;
        this.totalMarks = totalMarks;
        this.createdBy = createdBy;
        this.examDate = examDate;
    }

    // Constructor for fetching from DB
    public Exam(int examId, String examTitle, int durationMinutes,
                int totalMarks, int createdBy, LocalDate examDate) {
        this.examId = examId;
        this.examTitle = examTitle;
        this.durationMinutes = durationMinutes;
        this.totalMarks = totalMarks;
        this.createdBy = createdBy;
        this.examDate = examDate;
    }

    // Getters & Setters
    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getExamTitle() {
        return examTitle;
    }

    public void setExamTitle(String examTitle) {
        this.examTitle = examTitle;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }
}
