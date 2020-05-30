package vn.mista.guitarshop.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;


import vn.mista.guitarshop.bo.User;
import vn.mista.guitarshop.dao.UserDAO;


public class ConnectionFactory {
	//public static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
	//public static final String USER = "root";
	//public static final String PASS = "170499";
	public static final String URL = "jdbc:sqlserver://THANHTAI:1433;databaseName=shopguitar";
	public static final String USER = "thanhtai";
	public static final String PASS = "170499";
	public static Connection getConnection () {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			throw new RuntimeException("Error connecting to the database",e);
		}
	}
	
	public static void main(String[] args) {
		ConnectionFactory.getConnection();
		UserDAO studentDAO = new UserDAO();
		ArrayList<User> listStudent = studentDAO.getAllUser();
		System.out.println("ID        Name          Born    Room ");
		for(User list : listStudent) {
			System.out.println(list.getUserID() + "     "+list.getFullName() +"    "+ list.getAddress() +"   "+ list.getRole());
		}
	}
}
