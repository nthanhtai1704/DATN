package udn.ute.guitarshopda.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import udn.ute.guitarshopda.bo.GioHang;
import udn.ute.guitarshopda.bo.SanPham;
import udn.ute.guitarshopda.bo.ThanhVien;
import udn.ute.guitarshopda.dao.GioHangDAO;
import udn.ute.guitarshopda.dao.SanPhamDAO;
import udn.ute.guitarshopda.dao.ThanhVienDAO;

public class ConnectionFactory {
	//public static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
	//public static final String USER = "root";
	//public static final String PASS = "170499";
	public static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=shopguitar";
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
		
		
	}
}
