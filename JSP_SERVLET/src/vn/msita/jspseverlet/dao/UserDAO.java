package vn.msita.jspseverlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vn.msita.jspservlet.bo.User;
import vn.msita.jspservlet.dbconnection.ConnectionFactory;

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
				resultSet = statement.executeQuery("SELECT * FROM user");
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
			String sql = "INSERT INTO user(username, password, role) VALUES(?,?,?)";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setInt(3, user.getRole());
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
			String sql = "UPDATE user set username =?, password =?, role =? WHERE id =?";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setInt(3, user.getRole());
			preparedStatement.setInt(4, user.getId());
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
	public void deleteUser(int id) {
		Connection connection = null;
		Statement statement = null;
		String sql = "DELETE FROM user WHERE id = '" + id + "'";
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

	// Login
	public User findUserByUsernameAndPassword(String username, String password) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(
					"SELECT * from user where username ='" + username + "' and password='" + password + "'");
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

	// Convert to user
	public static User convertToUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt(1));
		user.setUserName(rs.getString(2));
		user.setPassword(rs.getString(3));
		user.setRole(rs.getInt(4));
		return user;
	}
}
