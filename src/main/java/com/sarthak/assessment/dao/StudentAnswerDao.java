package com.sarthak.assessment.dao;

import com.sarthak.assessment.model.StudentAnswer;
import com.sarthak.assessment.jdbc.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentAnswerDao {

    // Save student answer
    public boolean saveAnswer(StudentAnswer answer) {

        String sql = """
                INSERT INTO student_answers
                (attempt_id, question_id, selected_option, is_correct)
                VALUES (?, ?, ?, ?)
                """;

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, answer.getAttemptId());
            ps.setInt(2, answer.getQuestionId());
            ps.setString(3, String.valueOf(answer.getSelectedOption()));
            ps.setBoolean(4, answer.isCorrect());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error saving student answer", e);
        }
    }
}
