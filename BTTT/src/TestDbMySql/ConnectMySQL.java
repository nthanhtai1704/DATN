package TestDbMySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectMySQL {

	private Connection con = null;

	public ConnectMySQL() {
		String url = "com.mysql.cj.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost:3306/StudentManagement";
		String user = "nthanhtai";
		String password = "12345";
		try {
			Class.forName(url);
			con = DriverManager.getConnection(dbUrl, user, password);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ResultSet getResultSet(String tableName) throws SQLException {
		ResultSet rs = null;
		Statement stmt = con.createStatement();
		String sql = "select * from " + tableName;
		rs = stmt.executeQuery(sql);
		return rs;
	}

	public void Close() throws SQLException {
		con.close();
	}

	public static void main(String[] args) throws SQLException {
		ConnectMySQL kn = new ConnectMySQL();
		try {
			ResultSet rs = kn.getResultSet("student");// Table Name
			while (rs.next()) {
				System.out.println("Id: " + rs.getString("id"));
				System.out.println("Full name: " + rs.getString("fist_name").trim() + " " + rs.getString("last_name").trim());
				System.out.println("Gender: " + rs.getString("gender"));
				System.out.println("Age: " + rs.getString("age"));
				if(rs.getString("telephone") != null) {
				System.out.println("Telephone: " + rs.getString("telephone"));}
				else {
					System.out.println("Telephone: " +"Student not have telephone!!");
				}
				System.out.println("Score: " + rs.getString("score"));
				System.out.println();
				// Field Name
			}
			kn.Close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
