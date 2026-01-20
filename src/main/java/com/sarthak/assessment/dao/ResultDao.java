package com.sarthak.assessment.dao;

import com.sarthak.assessment.model.Result;
import com.sarthak.assessment.jdbc.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ResultDao {

    public boolean saveResult(Result result) {

        String sql = """
                INSERT INTO results (attempt_id, score, percentage, pass_fail)
                VALUES (?, ?, ?, ?)
                """;

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, result.getAttemptId());
            ps.setInt(2, result.getScore());
            ps.setDouble(3, result.getPercentage());
            ps.setString(4, result.getPassFail());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error saving result", e);
        }
    }
}
