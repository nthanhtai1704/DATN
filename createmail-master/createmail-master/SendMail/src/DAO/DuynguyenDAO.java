package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Duy2;
import model.Duynguyen;
import model.Duynguyen2;
public class DuynguyenDAO {
	private static Ok ok = new Ok();
	public  void okok(Duy2 duy,Ok ok ) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();	
		String[] returnId = { "IDDUY" };
		String insert = "Insert into duy2(name) "
				+ "values ('"+duy.getName()+"')";
		PreparedStatement statement = conn.prepareStatement(insert, returnId);		
		int affectedRows = statement.executeUpdate();
		if (affectedRows == 0) {
		    throw new SQLException("Creating user failed, no rows affected.");
		}
		try (ResultSet rs = statement.getGeneratedKeys()) {
		    if (rs.next()) {		
		    	duy.setIdduy(rs.getInt(1)); 
		    	String insertt = "Insert into duynguyen(idduy,name,gioitinh,sdt,trangthai)values('"+duy.getIdduy()+"','"+ok.getName()+"','"+ok.getGioitinh()+"','"+ok.getSdt()+"','"+ok.getTrangthai()+"')";
		    	Connection connection = ConnectionFactory.getConnection();
		    	Statement statementt = connection.createStatement();
				statementt.executeUpdate(insertt);
		    }
		    rs.close();
		}
	}
	public  void okok1(Duy2 duy,Duynguyen2 ok) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();	
		String[] returnId = { "IDDUY" };
		String insert = "Insert into duy2(name) "
				+ "values ('"+duy.getName()+"')";
		PreparedStatement statement = conn.prepareStatement(insert, returnId);		
		int affectedRows = statement.executeUpdate();
		if (affectedRows == 0) {
		    throw new SQLException("Creating user failed, no rows affected.");
		}
		try (ResultSet rs = statement.getGeneratedKeys()) {
		    if (rs.next()) {		
		    	duy.setIdduy(rs.getInt(1)); 
		    	String insertt = "Insert into duynguyen2(idduy2,name) "
						+ "values ('"+duy.getIdduy()+"','"+duy.getName()+"')";
		    	Connection connection = ConnectionFactory.getConnection();
		    	Statement statementt = connection.createStatement();
				statementt.executeUpdate(insertt);
		    }
		    rs.close();
		}
	}
	public void AddCar (Duy2 duy){
		Connection connection = null;
		Statement statement = null;
		String insert = "Insert into duy2(idduy,name) "
				+ "values ('"+duy.getIdduy()+"','"+duy.getName()+"')";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(insert);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
			}
		}				
	

	
	public ArrayList<Duynguyen> searchEmployee(String name){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		ArrayList<Duynguyen> listproduct = new ArrayList<Duynguyen>();
		String sql = "select * from duynguyen where name = '"+name+"'";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery(sql);
			while(resultset.next()) {
				listproduct.add(covertoproduct(resultset));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(resultset != null) {
				try {
					resultset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return listproduct;
				
	}
	private Duynguyen covertoproduct(ResultSet rs) throws SQLException {
		Duynguyen product =  new Duynguyen();
		product.setId(rs.getInt(1));
		product.setName(rs.getString(2));
		product.setGioitinh(rs.getString(3));
		product.setSdt(rs.getString(4));
		product.setTrangthai(rs.getString(5));
		return product;
	}

	public static void main(String[] args) throws SQLException {
		String name = "hello Duy";
		
		Duynguyen2 duy2 = new Duynguyen2();
		duy2.setName(name);
		
		Duy2 duy = new Duy2();
		duy.setName(name);
		
		DuynguyenDAO dao = new DuynguyenDAO();
		dao.okok1(duy, duy2);
	}
}