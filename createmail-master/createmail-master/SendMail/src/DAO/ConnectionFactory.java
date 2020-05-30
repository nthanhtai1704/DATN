package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	public static final String URL ="jdbc:sqlserver://localhost:1433;databaseName=searchAjax";
	public static final String username = "sa";
	public static final String password = "123";	
	public static Connection getConnection() 
	{
		
			try {
				 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");			
				return DriverManager.getConnection(URL,username,password);
		}catch(SQLException | ClassNotFoundException ex ){
			throw new RuntimeException("Loi",ex);
		}	
	}
	/*public static final String URL ="jdbc:mysql://localhost:3306/testimages";
	public static final String user = "duynguyen";
	public static final String password = "12345";
	
	
	public static Connection getConnection()
	{
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				return DriverManager.getConnection(URL,user,password);
		}catch(SQLException | ClassNotFoundException ex){
			throw new RuntimeException("Loi",ex);
		}
		
	}*/
	public static void main(String a[]) {
		ConnectionFactory.getConnection();
	}
}
