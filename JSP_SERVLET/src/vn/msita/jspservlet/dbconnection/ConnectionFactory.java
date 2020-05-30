package vn.msita.jspservlet.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {
	public static final String URL = "jdbc:mysql://localhost:3306/jsp";
	public static final String USER = "root";
	public static final String PASS = "170499";
	
	public static Connection getConnection () {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			throw new RuntimeException("Error connecting to the database",e);
		}
	}
	
	public static void main(String[] args) {
		ConnectionFactory.getConnection();
	}
}
