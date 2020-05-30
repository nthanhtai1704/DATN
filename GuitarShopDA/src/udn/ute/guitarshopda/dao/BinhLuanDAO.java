package udn.ute.guitarshopda.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import udn.ute.guitarshopda.bo.BinhLuan;
import udn.ute.guitarshopda.dbconnection.ConnectionFactory;

public class BinhLuanDAO {

	public static ArrayList<BinhLuan> getAllComment(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<BinhLuan> commentList = new ArrayList<BinhLuan>();
		String sql = "Select * from BINH_LUAN";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				commentList.add(convertComment(resultSet));
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
			if(resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return commentList;
		
	}
	
	public static void insertComment(BinhLuan bl) {
		Connection connection = null;
		Statement statement = null;
		String sql = "INSERT INTO BINHLUAN(ID_SP,ID_TV,HO_TEN,LOI_BLUAN) VALUES"
				+ "('"+bl.getIdSP()+"','"+bl.getIdTV()+"',N'"+bl.getHoTen()+"',N'"+bl.getLoiBL()+"')";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(sql);
			
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
	
	public static ArrayList<BinhLuan> getCommentById (int id){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<BinhLuan> blList = new ArrayList<BinhLuan>();
		String sql = "SELECT * FROM BINHLUAN WHERE ID_SP= '"+id+"' ";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				blList.add(convertComment(resultSet));
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
			if(resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return blList;
		
	}
	

	
	public static BinhLuan convertComment(ResultSet rs) throws SQLException {
		BinhLuan bl = new BinhLuan();
		bl.setIdBL(rs.getInt(1));
		bl.setIdSP(rs.getInt(2));
		bl.setIdTV(rs.getInt(3));
		bl.setHoTen(rs.getString(4));
		bl.setLoiBL(rs.getString(5));
		return bl;
	}
}
