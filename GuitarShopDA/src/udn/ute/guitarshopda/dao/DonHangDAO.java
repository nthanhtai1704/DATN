package udn.ute.guitarshopda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import udn.ute.guitarshopda.bo.DonHang;
import udn.ute.guitarshopda.bo.HangSanXuat;
import udn.ute.guitarshopda.dbconnection.ConnectionFactory;

public class DonHangDAO {
	
	public static ArrayList<DonHang> getAllOrder(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<DonHang> orderList = new ArrayList<DonHang>();
		String sql = "spDonHang_getAll";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				orderList.add(convertToDonHang1(resultSet));
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
		
		return orderList;
		
	}
	
	public static DonHang getOrderByID(int id) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "spDonHang_getByID '"+id+"'";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				DonHang dh = convertToDonHang1(resultSet);
				return dh;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}if(statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}if(statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
		return null;
		
	}
	
	public static void updateOrder(int idDH, String tinhTrang) {
		Connection connection = null;
		Statement statement = null;
		String sql = "UPDATE DONHANG SET TINH_TRANG =N'"+tinhTrang+"' WHERE ID_DONHANG = '"+idDH+"'";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			statement.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static ArrayList<DonHang> getOrderByStatus(String status){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<DonHang> orderList = new ArrayList<DonHang>();
		String sql = "spDonHang_getByStatus N'"+status+"'";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				orderList.add(convertToDonHang1(resultSet));
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
		
		return orderList;
		
	}
	public static void insertDH(DonHang dh) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO DONHANG(ID_TV,ID_SP,SO_LUONG, TONG_TIEN) VALUES(?,?,?,?)";
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, dh.getIdTV());
			preparedStatement.setInt(2, dh.getIdSP());
			preparedStatement.setInt(3, dh.getSoLuong());
			preparedStatement.setInt(4, dh.getTongTien());
			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static DonHang convertToDonHang(ResultSet rs) throws SQLException {
		DonHang dh = new DonHang();
		dh.setIdDH(rs.getInt(1));
		dh.setIdTV(rs.getInt(2));
		dh.setNgayMua(rs.getString(3));
		dh.setSoLuong(rs.getInt(4));
		dh.setTongTien(rs.getInt(5));
		dh.setTinhTrang(rs.getString(6));
		return dh;
		
	}
	public static DonHang convertToDonHang1(ResultSet rs) throws SQLException {
		DonHang dh = new DonHang();
		dh.setIdDH(rs.getInt(1));
		dh.setIdSP(rs.getInt(2));
		dh.setTenSP(rs.getString(3));
		dh.setAnh(rs.getString(4));
		dh.setGia(rs.getInt(5));
		dh.setIdTV(rs.getInt(6));
		dh.setHoTen(rs.getString(7));
		dh.setDiaCHi(rs.getString(8));
		dh.setSoLuong(rs.getInt(9));
		dh.setNgayMua(rs.getString(10));
		dh.setTongTien(rs.getInt(11));
		dh.setTinhTrang(rs.getString(12));
		dh.setEmail(rs.getString(13));
		return dh;
		
	}
}
