package com.sarthak.assessment.dao;

import com.sarthak.assessment.model.Exam;
import com.sarthak.assessment.jdbc.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ExamDao {

    // Create Exam (ADMIN)
    public boolean createExam(Exam exam) {

        String sql = """
                INSERT INTO exams
                (exam_title, duration_minutes, total_marks, created_by, exam_date)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, exam.getExamTitle());
            ps.setInt(2, exam.getDurationMinutes());
            ps.setInt(3, exam.getTotalMarks());
            ps.setInt(4, exam.getCreatedBy());
            ps.setDate(5, Date.valueOf(exam.getExamDate()));

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error creating exam", e);
        }
    }

    // Fetch all exams
    public List<Exam> getAllExams() {

        List<Exam> exams = new ArrayList<>();
        String sql = "SELECT * FROM exams";

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {
                exams.add(new Exam(
                        rs.getInt("exam_id"),
                        rs.getString("exam_title"),
                        rs.getInt("duration_minutes"),
                        rs.getInt("total_marks"),
                        rs.getInt("created_by"),
                        rs.getDate("exam_date").toLocalDate()
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error fetching exams", e);
        }

        return exams;
    }
}
