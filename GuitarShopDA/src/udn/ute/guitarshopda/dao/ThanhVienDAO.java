package udn.ute.guitarshopda.dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import udn.ute.guitarshopda.bo.ThanhVien;
import udn.ute.guitarshopda.dbconnection.ConnectionFactory;



public class ThanhVienDAO {
	// Select all ThanhVien
			public static ArrayList<ThanhVien> getAllUser(){
				Connection connection = null;
				Statement statement = null;
				ResultSet resultSet = null;
				
				ArrayList<ThanhVien> listUser = new ArrayList<ThanhVien>();
				
				try {
					connection = ConnectionFactory.getConnection();
					statement = connection.createStatement();
					resultSet = statement.executeQuery("SELECT * FROM THANHVIEN");
					while(resultSet.next()) {
						listUser.add(convertToThanhVien(resultSet));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					if(connection !=null) {
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
				
				return listUser;
				
			}
		
		// Insert User
		public static void insertUser(ThanhVien tv) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			try {
				String sql = "INSERT INTO THANHVIEN(HO_TEN,SDT,CMND,EMAIL,NGAY_SINH,DIA_CHI,TEN_DN,MAT_KHAU)"
						+ "VALUES(?,?,?,?,?,?,?,?)";
				connection = ConnectionFactory.getConnection();
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, tv.getHoTen());
				preparedStatement.setString(2, tv.getSdt());
				preparedStatement.setString(3, tv.getCmnd());
				preparedStatement.setString(4, tv.getEmail());
				preparedStatement.setString(5, tv.getNgaySinh());
				preparedStatement.setString(6, tv.getDiaChi());
				preparedStatement.setString(7, tv.getTenDN());
				preparedStatement.setString(8, tv.getMatKhau());
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

		public static void insertUserEmail(String email, String matKhau) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			try {
				String sql = "INSERT INTO THANHVIEN(EMAIL,MAT_KHAU)"
						+ "VALUES(?,?)";
				connection = ConnectionFactory.getConnection();
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, email);
				preparedStatement.setString(2, matKhau);
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
		// Update user
		public static void updateUser(ThanhVien tv) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			try {
				String sql = "UPDATE THANHVIEN SET HO_TEN=?,SDT=?,CMND=?,EMAIL=?,NGAY_SINH=?,DIA_CHI=?,TEN_DN=?,MAT_KHAU=?,QUYEN=? WHERE ID_TV=?";
				connection = ConnectionFactory.getConnection();
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, tv.getHoTen());
				preparedStatement.setString(2, tv.getSdt());
				preparedStatement.setString(3, tv.getCmnd());
				preparedStatement.setString(4, tv.getEmail());
				preparedStatement.setString(5, tv.getNgaySinh());
				preparedStatement.setString(6, tv.getDiaChi());
				preparedStatement.setString(7, tv.getTenDN());
				preparedStatement.setString(8, tv.getMatKhau());
				preparedStatement.setString(9, tv.getQuyen());
				preparedStatement.setInt(10, tv.getIdTV());
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

		public static void changePass(String email,String mk) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			try {
				String sql = "UPDATE THANHVIEN SET MAT_KHAU=? WHERE EMAIL=?";
				connection = ConnectionFactory.getConnection();
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, mk);
				preparedStatement.setString(2,email);
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
		// Delete user
		public static void deleteTV(int id) {
			Connection connection = null;
			Statement statement = null;
			String sql = "DELETE FROM THANHVIEN WHERE ID_TV = '" + id + "'";
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

		public static ThanhVien getUser(int id) {
			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet = null;
			try {
				connection = ConnectionFactory.getConnection();
				statement = connection.createStatement();
				resultSet = statement.executeQuery("SELECT * FROM THANHVIEN where ID_TV = '"+id+"'");
				while(resultSet.next()) {
					ThanhVien tv = convertToThanhVien(resultSet);
					return tv;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(connection != null) {
					try {
						connection.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if(statement != null) {
					try {
						statement.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}if(resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return null;
		}
		public static ThanhVien getUserByEmail(String email) {
			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet = null;
			try {
				connection = ConnectionFactory.getConnection();
				statement = connection.createStatement();
				resultSet = statement.executeQuery("SELECT * FROM THANHVIEN where EMAIL = '"+email+"'");
				while(resultSet.next()) {
					ThanhVien tv = convertToThanhVien(resultSet);
					return tv;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(connection != null) {
					try {
						connection.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if(statement != null) {
					try {
						statement.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}if(resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return null;
		}
		// Login
		public static ThanhVien findUserByUsernameAndPassword(String username, String password) {
			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet = null;
			try {
				connection = ConnectionFactory.getConnection();
				statement = connection.createStatement();
				resultSet = statement.executeQuery(
						"SELECT * from THANHVIEN where TEN_DN ='" + username + "' "
								+ "and MAT_KHAU='" + password + "'");
				while (resultSet.next()) {
					ThanhVien tv = convertToThanhVien(resultSet);
					return tv;
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
			return null;

		}

		public static String MD5(String input) {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] messageDigest = md.digest(input.getBytes());
				BigInteger number = new BigInteger(1,messageDigest);
				String hashtext = number.toString(16);
				while(hashtext.length() < 32) {
					hashtext="0"+hashtext;
				}
				return hashtext;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			
		}

	/*
	  public static void main(String[] args) { String pw = "123";
	  System.out.println("MD5: "+ThanhVienDAO.MD5(pw)); }
	 */
		// Convert to ThanhVien
		public static ThanhVien convertToThanhVien(ResultSet rs) throws SQLException {
			ThanhVien tv = new ThanhVien();
			tv.setIdTV(rs.getInt(1));
			tv.setHoTen(rs.getString(2));
			tv.setSdt(rs.getString(3));
			tv.setCmnd(rs.getString(4));
			tv.setEmai(rs.getString(5));
			tv.setNgaySinh(rs.getString(6));
			tv.setDiaChi(rs.getString(7));
			tv.setTenDN(rs.getString(8));
			tv.setMatKhau(rs.getString(9));
			tv.setQuyen(rs.getString(10));
			return tv;
		}
}
