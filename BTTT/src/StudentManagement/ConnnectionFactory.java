package StudentManagement;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnnectionFactory {

	public static final String URL = "jdbc:mysql://localhost:3306/StudentManagement";
	public static final String USER = "nthanhtai";
	public static final String PASS = "12345";

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			throw new RuntimeException("Error connecting to the database", e);
		}
	}

	public static void main(String[] args) {
		ConnnectionFactory.getConnection();
		System.out.println("Succesfully");
	}
}
