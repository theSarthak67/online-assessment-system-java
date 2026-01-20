package com.sarthak.assessment.dao;

import com.sarthak.assessment.model.ExamAttempt;
import com.sarthak.assessment.jdbc.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ExamAttemptDao {

    //Start Exam (insert attempt)
    public int startExam(ExamAttempt attempt) {

        String sql = """
                INSERT INTO exam_attempts (user_id, exam_id, start_time, status)
                VALUES (?, ?, ?, ?)
                """;

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    sql,
                    PreparedStatement.RETURN_GENERATED_KEYS
            )
        ) {

            ps.setInt(1, attempt.getUserId());
            ps.setInt(2, attempt.getExamId());
            ps.setTimestamp(3, Timestamp.valueOf(attempt.getStartTime()));
            ps.setString(4, attempt.getStatus());

            ps.executeUpdate();

            // Get generated attempt_id
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }

            return -1;

        } catch (SQLException e) {
            throw new RuntimeException("Error starting exam", e);
        }
    }

    //Finish Exam (update attempt)
    public boolean finishExam(int attemptId, String status) {

        String sql = """
                UPDATE exam_attempts
                SET end_time = ?, status = ?
                WHERE attempt_id = ?
                """;

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setTimestamp(1, Timestamp.valueOf(java.time.LocalDateTime.now()));
            ps.setString(2, status);
            ps.setInt(3, attemptId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error finishing exam", e);
        }
    }
}
