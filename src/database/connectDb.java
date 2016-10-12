package database;

import java.sql.*;

public class connectDb {
	Connection conn = null;
	
	public static Connection db(){
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:src\\finance.sqlite");
			return conn;
		} catch (Exception e) {
			System.out.println("Connection error ! " + e);
			return null;
		}
	}
}
