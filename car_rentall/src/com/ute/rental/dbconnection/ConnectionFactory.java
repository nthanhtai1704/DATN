package com.ute.rental.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	public static final String URL ="jdbc:mysql://localhost:3306/mutilmedia";
	public static final String user = "root";
	public static final String password = "170499";
	
	
	public static Connection getConnection()
	{
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				return DriverManager.getConnection(URL,user,password);
		}catch(SQLException | ClassNotFoundException ex){
			throw new RuntimeException("Loi",ex);
		}
		
	}
	public static void main(String a[]) {
		ConnectionFactory.getConnection();
	}
}