package udn.ute.guitarshopda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.Part;

import udn.ute.guitarshopda.bo.LoaiSanPham;
import udn.ute.guitarshopda.bo.SanPham;
import udn.ute.guitarshopda.dbconnection.ConnectionFactory;

public class SanPhamDAO {

	public static ArrayList<SanPham> getAllProduct1() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		ArrayList<SanPham> listProduct = new ArrayList<SanPham>();

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("spSanPham_getAll");
			while (resultSet.next()) {
				listProduct.add(convertToSanPham1(resultSet));
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

	// Select all SP
	public static ArrayList<SanPham> getAllProduct() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		ArrayList<SanPham> listProduct = new ArrayList<SanPham>();

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM SANPHAM");
			while (resultSet.next()) {
				listProduct.add(convertToSanPham(resultSet));
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

	// Find Product by name
	public static ArrayList<SanPham> findProductByName(String name) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		ArrayList<SanPham> listProduct = new ArrayList<SanPham>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("spSanPham_getByName'" + name + "'");
			while (resultSet.next()) {
				listProduct.add(convertToSanPham1(resultSet));
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
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return listProduct;
	}

	// Find Product by species
	public static ArrayList<SanPham> findProductBySpecies(int id) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		ArrayList<SanPham> listProduct = new ArrayList<SanPham>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("spSanPham_getBySpecies'"+id+"'");
			while (resultSet.next()) {
				listProduct.add(convertToSanPham1(resultSet));
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
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return listProduct;
	}

	// Find Product by species
		public static ArrayList<SanPham> findProductByPrice(int min, int max) {
			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet = null;

			ArrayList<SanPham> listProduct = new ArrayList<SanPham>();
			try {
				connection = ConnectionFactory.getConnection();
				statement = connection.createStatement();
				resultSet = statement.executeQuery("sp_TimKiemTheoGia '"+min+"','"+max+"'");
				while (resultSet.next()) {
					listProduct.add(convertToSanPham1(resultSet));
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
				if (resultSet != null) {
					try {
						resultSet.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			return listProduct;
		}

	// Insert book
	public static void insertProduct(SanPham sp) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO SANPHAM(TEN_SP,ID_HANGSX,ID_LOAI,SO_LUONG,SO_LUONG_CON,NAM_SX,MAU_SAC,ANH,ANH_DD,GIA,MO_TA)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, sp.getTenSP());
			preparedStatement.setInt(2, sp.getIdHSX());
			preparedStatement.setInt(3, sp.getIdLoai());
			preparedStatement.setInt(4, sp.getSoLuong());
			preparedStatement.setInt(5, sp.getSoLuongCon());
			preparedStatement.setInt(6, sp.getNamSX());
			preparedStatement.setString(7, sp.getMauSac());
			preparedStatement.setString(8, sp.getAnh());
			preparedStatement.setString(9, sp.getAnhDD());
			preparedStatement.setInt(10, sp.getGia());
			preparedStatement.setString(11, sp.getMoTa());
			preparedStatement.execute();
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
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	// Update product
	public static void updateProduct(SanPham product) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			String sql = "UPDATE SANPHAM SET TEN_SP =?, ID_HANGSX =?, ID_LOAI =?,"
					+ " SO_LUONG=?,SO_LUONG_CON=?,NAM_SX=?,MAU_SAC=?," 
					+ "ANH=?,ANH_DD=?,GIA=?,MO_TA=? WHERE ID_SP=?";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, product.getTenSP());
			preparedStatement.setInt(2, product.getIdHSX());
			preparedStatement.setInt(3, product.getIdLoai());
			preparedStatement.setInt(4, product.getSoLuong());
			preparedStatement.setInt(5, product.getSoLuongCon());
			preparedStatement.setInt(6, product.getNamSX());
			preparedStatement.setString(7, product.getMauSac());
			preparedStatement.setString(8, product.getAnh());
			preparedStatement.setString(9, product.getAnhDD());
			preparedStatement.setInt(10, product.getGia());
			preparedStatement.setString(11, product.getMoTa());
			preparedStatement.setInt(12, product.getIdSP());
			preparedStatement.executeUpdate();
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
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	// Delete book by Id
	public static void deleteProduct(int id) {
		Connection connection = null;
		Statement statement = null;
		String sql = "DELETE FROM SANPHAM WHERE ID_SP = '" + id + "'";
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

	// Get Product
	public static SanPham getProduct(int id) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM SANPHAM where ID_SP = '" + id + "'");
			while (resultSet.next()) {
				SanPham product = convertToSanPham(resultSet);
				return product;
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
	
	// Get Product
		public static SanPham getProduct1(int id) {
			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet = null;
			try {
				connection = ConnectionFactory.getConnection();
				statement = connection.createStatement();
				resultSet = statement.executeQuery("spSanPham_getById'"+id+"'");
				while (resultSet.next()) {
					SanPham product = convertToSanPham1(resultSet);
					return product;
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

	// extractFile
	public static String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";

	}

	// Convert to Product
	public static SanPham convertToSanPham(ResultSet rs) throws SQLException {
		SanPham sp = new SanPham();
		sp.setIdSP(rs.getInt(1));
		sp.setTenSP(rs.getString(2));
		sp.setIdHSX(rs.getInt(3));
		sp.setIdLoai(rs.getInt(4));
		sp.setSoLuong(rs.getInt(5));
		sp.setSoLuongCon(rs.getInt(6));
		sp.setNamSX(rs.getInt(7));
		sp.setMauSac(rs.getString(8));
		sp.setAnh(rs.getString(9));
		sp.setAnhDD(rs.getString(10));
		sp.setGia(rs.getInt(11));
		return sp;

	}

	public static SanPham convertToSanPham1(ResultSet rs) throws SQLException {
		SanPham sp = new SanPham();
		sp.setIdSP(rs.getInt(1));
		sp.setTenSP(rs.getString(2));
		sp.setSoLuong(rs.getInt(3));
		sp.setSoLuongCon(rs.getInt(4));
		sp.setNamSX(rs.getInt(5));
		sp.setMauSac(rs.getString(6));
		sp.setAnh(rs.getString(7));
		sp.setAnhDD(rs.getString(8));
		sp.setGia(rs.getInt(9));
		sp.setTenLoai(rs.getString(10));
		sp.setTenHang(rs.getString(11));
		sp.setMoTa(rs.getString(12));
		return sp;

	}

}
