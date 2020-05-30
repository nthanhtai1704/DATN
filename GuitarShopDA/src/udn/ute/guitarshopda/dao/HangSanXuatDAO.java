package udn.ute.guitarshopda.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import udn.ute.guitarshopda.bo.HangSanXuat;
import udn.ute.guitarshopda.dbconnection.ConnectionFactory;

public class HangSanXuatDAO {
	public static ArrayList<HangSanXuat> getAllHSX() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		ArrayList<HangSanXuat> listProduct = new ArrayList<HangSanXuat>();

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM HANGSX");
			while (resultSet.next()) {
				listProduct.add(convertToHSX(resultSet));
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

		return listProduct;

	}
	
	public static void insertHSX(HangSanXuat hsx) {
		Connection connection = null;
		Statement statement = null;
		String sql = "INSERT INTO HANGSX(TEN_HANGSX) VALUES (N'"+hsx.getTenHSX()+"')";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			statement.execute(sql);
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
			}
		}
		
	}
	
	public static void updateHSX(HangSanXuat hsx) {
		Connection connection = null;
		Statement statement = null;
		String sql = "UPDATE HANGSX SET TEN_HANGSX=N'"+hsx.getTenHSX()+"' WHERE ID_HANGSX ='"+hsx.getIdHSX()+"'";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			statement.execute(sql);
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
			}
		}
		
	}
	public static void deleteHSX(int id) {
		Connection connection = null;
		Statement statement = null;
		String sql = "DELETE FROM HANGSX WHERE ID_HANGSX ='"+id+"'";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			statement.execute(sql);
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
			}
		}
		
	}
	
	public static HangSanXuat getHSXByID(int id) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM HANGSX WHERE ID_HANGSX ='"+id+"'";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				HangSanXuat hsx = convertToHSX(resultSet);
				return hsx;
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

	public static HangSanXuat convertToHSX(ResultSet rs) throws SQLException {
		HangSanXuat hsx = new HangSanXuat();
		hsx.setIdHSX(rs.getInt(1));
		hsx.setTenHSX(rs.getString(2));
		return hsx;
		
	}
}
