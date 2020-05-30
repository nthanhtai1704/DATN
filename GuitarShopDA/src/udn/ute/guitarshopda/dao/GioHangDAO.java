package udn.ute.guitarshopda.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import udn.ute.guitarshopda.bo.GioHang;
import udn.ute.guitarshopda.dbconnection.ConnectionFactory;

public class GioHangDAO {

	public static ArrayList<GioHang> getAllGioHang(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<GioHang> listGioHang = new ArrayList<GioHang>();
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("spGioHang_getAll");
			while (resultSet.next()) {
				listGioHang.add(convertToGioHang(resultSet));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return listGioHang;
		
	}
	
	public static void insertGioHang(GioHang gh) {
		Connection connection = null;
		Statement statement = null;
		String sql = "INSERT INTO GIOHANG(ID_TV,ID_SP,SO_LUONG) VALUES ('"+gh.getIdTV()+"','"+gh.getIdSP()+"','"+gh.getSoLuong()+"')";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			statement.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static ArrayList<GioHang> getGioHangByIdTV(int id){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<GioHang> listGioHang = new ArrayList<GioHang>();
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("spGioHang_getByIdTV'"+id+"'");
			while (resultSet.next()) {
				listGioHang.add(convertToGioHang(resultSet));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return listGioHang;
		
	}
	public static GioHang getGioHang(int id) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("spGioHang_getByIdSP'"+id+"'");
			while (resultSet.next()) {
				GioHang gh = convertToGioHang(resultSet);
				return gh;
			}
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
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public static GioHang countProduct(int id) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select dbo.TongSLGioHang'"+id+"'");
			while(resultSet.next()) {
				GioHang gh = countProductInCart(resultSet);
				return gh;
			}
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
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	public static void deleteGioHang(int id) {
		Connection connection= null;
		Statement statement = null;
		String sql = "DELETE FROM GIOHANG WHERE ID_GIOHANG = '"+id+"'";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			statement.execute(sql);
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
			if (statement != null) {
				try {
					statement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static GioHang convertToGioHang(ResultSet rs) throws SQLException {
		GioHang gh = new GioHang();
		gh.setIdGH(rs.getInt(1));
		gh.setIdSP(rs.getInt(2));
		gh.setTenSP(rs.getString(3));
		gh.setAnh(rs.getString(4));
		gh.setGia(rs.getInt(5));
		gh.setIdTV(rs.getInt(6));
		gh.setDiaChi(rs.getString(7));
		gh.setSoLuong(rs.getInt(8));
		
		return gh;
		
	}
	
	public static GioHang countProductInCart(ResultSet rs) throws SQLException {
		GioHang gh = new GioHang();
		gh.setTongSP(rs.getInt(1));
		return gh;
	}
}
