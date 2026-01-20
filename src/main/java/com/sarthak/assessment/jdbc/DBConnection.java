package com.sarthak.assessment.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static final String URL="jdbc:mysql://localhost:3306/online_assessment_db";
	private static final String USER="root";
	private static final String PASSWORD="SarthakSQL@123";
	
	private DBConnection() {}
	
	public static Connection getConnection() {
		try { 
			return DriverManager.getConnection(URL, USER, PASSWORD);
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException("Database connection failed", e);
		}
	}
}
