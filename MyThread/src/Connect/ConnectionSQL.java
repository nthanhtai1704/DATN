package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ConnectionSQL {

	public static void main(String[] args) {
		System.out.println("ket noi csdl");
		try {
			 Class.forName("net.sourceforge.jtds.jdbc.Driver");
			 String url ="jdbc:jtds:sqlserver://localhost:1433/mutilmedia";
			 
			 
			/*com.microsoft.sqlserver.jdbc.SQLServerDriver
			 * Class.forName("com.mysql.cj.jdbc.Driver"); String url =
			 * "jdbc:mysql://localhost:3306/khachhang";
			 */
			Connection connection =  DriverManager.getConnection(url,"tai","123");
			Statement statement = connection.createStatement();
			String sql = "Select * from users";
			ResultSet rs = statement.executeQuery(sql);
			
			
			/*
			 * ResultSetMetaData rsmd = rs.getMetaData(); int soCot = rsmd.getColumnCount();
			 * for(int j = 1;j<=soCot;j++) { System.out.println(rsmd.getColumnLabel(j)); }
			 * 
			 * while(rs.next()) { for(int i =1; i<=soCot;i++) {
			 * System.out.println(rs.getObject(i)); } } rs.close(); statement.close();
			 */
			while(rs.next()) {
				int id = rs.getInt("idUser");
				String hoTen = rs.getString("full_name");
				String diaChi = rs.getString("id_card");
				
				System.out.println("Id: " + id + "Ho ten: "+hoTen+ " Dia chi: "+ diaChi );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}