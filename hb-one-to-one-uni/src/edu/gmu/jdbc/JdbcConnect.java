package edu.gmu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnect {

	public static void main(String[] args) {

		String jdbcUrl = 
			"jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
		String user = "gmustudent";
		String pass = "gmustudent";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection successful!!!");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
