package com.sarthak.assessment.dao;

import com.sarthak.assessment.model.Question;
import com.sarthak.assessment.jdbc.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao {

    // Add question to exam (ADMIN)
    public boolean addQuestion(Question question) {

        String sql = """
                INSERT INTO questions
                (exam_id, question_text, option_a, option_b, option_c, option_d, correct_option, marks)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, question.getExamId());
            ps.setString(2, question.getQuestionText());
            ps.setString(3, question.getOptionA());
            ps.setString(4, question.getOptionB());
            ps.setString(5, question.getOptionC());
            ps.setString(6, question.getOptionD());
            ps.setString(7, String.valueOf(question.getCorrectOption()));
            ps.setInt(8, question.getMarks());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error adding question", e);
        }
    }

    // Fetch questions by exam
    public List<Question> getQuestionsByExamId(int examId) {

        List<Question> questions = new ArrayList<>();
        String sql = "SELECT * FROM questions WHERE exam_id = ?";

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, examId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                questions.add(new Question(
                        rs.getInt("question_id"),
                        rs.getInt("exam_id"),
                        rs.getString("question_text"),
                        rs.getString("option_a"),
                        rs.getString("option_b"),
                        rs.getString("option_c"),
                        rs.getString("option_d"),
                        rs.getString("correct_option").charAt(0),
                        rs.getInt("marks")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error fetching questions", e);
        }

        return questions;
    }
}
