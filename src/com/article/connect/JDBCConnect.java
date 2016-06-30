package com.article.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnect {
	private static final String DB_PASSWORD = "mysql";
	private static final String DB_USERNAME = "root";
	private static final String DB_CONNECTION_STRING = "jdbc:mysql://localhost:3306/myarticles";
	static Connection connection = null;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		try {
			connection = DriverManager.getConnection(DB_CONNECTION_STRING,
					DB_USERNAME,DB_PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
		
	}
}
