package com.ute.rental.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	public static final String URL ="jdbc:mysql://localhost:3306/mutilmedia";
	public static final String USER = "root";
	public static final String PASSWORD = "170499";
	//public static final String URL="jdbc:jtds:sqlserver://localhost:1433/mutilmedia";
	//public static final String USER = "tai";
//	public static final String PASSWORD = "123";
	
	public static Connection getConnection()
	{
		try {
			//Class.forName("net.sourceforge.jtds.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL,USER,PASSWORD);
		}catch(SQLException | ClassNotFoundException ex){
			throw new RuntimeException("Loi",ex);
		}
	}
	
	public static void main(String a[]) {
		ConnectionFactory.getConnection();
	}
}