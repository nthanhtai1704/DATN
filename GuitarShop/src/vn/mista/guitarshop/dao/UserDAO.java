package vn.mista.guitarshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vn.mista.guitarshop.bo.User;
import vn.mista.guitarshop.dbconnection.ConnectionFactory;



public class UserDAO {

	// Select all Book
		public ArrayList<User> getAllUser(){
			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet = null;
			
			ArrayList<User> listUser = new ArrayList<User>();
			
			try {
				connection = ConnectionFactory.getConnection();
				statement = connection.createStatement();
				resultSet = statement.executeQuery("SELECT * FROM users");
				while(resultSet.next()) {
					listUser.add(convertToUser(resultSet));
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
	public void insertUser(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			String sql = "INSERT INTO users(user_name,password,full_name,tel,id_card,email,address) "
					+ "VALUES(?,?,?,?,?,?,?)";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getFullName());
			preparedStatement.setString(4, user.getTel());
			preparedStatement.setInt(5, user.getIdCard());
			preparedStatement.setString(6, user.getEmail());
			preparedStatement.setString(7, user.getAddress());
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
	public void updateUser(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			String sql = "UPDATE users SET "
					+ "user_name=?, password=?,full_name=?,"
					+ "tel=?,id_card=?,email=?,address=?,"
					+ "role=? WHERE user_id =?";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getFullName());
			preparedStatement.setString(4, user.getTel());
			preparedStatement.setInt(5, user.getIdCard());
			preparedStatement.setString(6, user.getEmail());
			preparedStatement.setString(7, user.getAddress());
			preparedStatement.setString(8, user.getRole());
			preparedStatement.setInt(9, user.getUserID());
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

	// Delete user
	public void deleteUser(int id) {
		Connection connection = null;
		Statement statement = null;
		String sql = "DELETE FROM users WHERE user_id = '" + id + "'";
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

	public User getUser(int id) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM users where user_id = '"+id+"'");
			while(resultSet.next()) {
				User user = convertToUser(resultSet);
				return user;
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
	public User findUserByUsernameAndPassword(String username, String password) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(
					"SELECT * from users where user_name ='" + username + "' "
							+ "and password='" + password + "'");
			while (resultSet.next()) {
				User user = convertToUser(resultSet);
				return user;
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

	// Convert to user
	public static User convertToUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setUserID(rs.getInt(1));
		user.setUserName(rs.getString(2));
		user.setPassword(rs.getString(3));
		user.setFullName(rs.getString(4));
		user.setTel(rs.getString(5));
		user.setIdCard(rs.getInt(6));
		user.setEmail(rs.getString(7));
		user.setAddress(rs.getString(8));
		user.setRole(rs.getString(9));
		return user;
	}
}
