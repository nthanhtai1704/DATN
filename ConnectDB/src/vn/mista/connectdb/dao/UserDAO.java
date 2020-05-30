package vn.mista.connectdb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vn.mista.connectdb.bo.User;
import vn.mista.connectdb.utils.ConnectionFactory;

public class UserDAO {
	
	// Get All User In Database
	public static ArrayList<User> getAllUser() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<User> userList = new ArrayList<User>();

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM users");
			while (resultSet.next()) {
				userList.add(convertToUser(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
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
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return userList;
	}

	//Find User by name
	public static ArrayList<User> findUserByUsername(String name) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<User> userList = new ArrayList<User>();

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM users WHERE name = '" + name + "'");
			while (resultSet.next()) {
				userList.add(convertToUser(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
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
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return userList;
	}
	private static User convertToUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt(1));
		user.setName(rs.getString(2));
		user.setPass(rs.getString(3));
		user.setAge(rs.getInt(4));

		return user;
	}
	
	// insert User 
	public static void addUser(User user) {
		Connection connection = null;
		Statement statement = null;
		String insertSQL = "INSERT INTO users( name, pass, age) VALUES ('" + user.getName() + "','" + user.getPass()
				+ "','" + user.getAge() + "')";

		System.out.println(insertSQL);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			statement.execute(insertSQL);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	// Update User by ID
	public static void updatePassUser(String newPass, int id) {
		Connection connection = null;
		Statement statement = null;
		String updateSQL = "Update users SET pass = '"+ newPass +"' WHERE id = '" + id +"' ";
		//System.out.println(insertSQL);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			statement.execute(updateSQL);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	 
	// Delete User by ID
	public static void deleteUser(int id) {
		Connection connection = null;
		Statement statement = null;
		String deleteSQL = "DELETE FROM users WHERE id = '" + id +"'";
		//System.out.println(insertSQL);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			statement.execute(deleteSQL);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// Delete User 
	public static void deleteUser2(ArrayList<User> userList) {
		Connection connection = null;
		Statement statement = null;
		String idList = generateIdList(userList);
		String sql = "DELETE FROM users WHERE id IN ("+idList+")";
		//System.out.println(sql);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			statement.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(statement != null) {
				try {
					statement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	//Add User
	public static void addUserViaPreparedStatement(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertSQL = "INSERT INTO users( name, pass, age) VALUES (?,?,?)";
		//System.out.println(insertSQL);
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPass());
			preparedStatement.setInt(3, user.getAge());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	// Display user list
	public static void displayUserList(ArrayList<User> userList) {
		System.out.println(String.format("%-5s%-20s%-20s%10s", "ID", "USERNAME", "PASSWORD", "AGE"));
		for (User user : userList) {
			System.out.println(String.format("%-5s%-20s%-20s%10s", user.getId(), 
					user.getName(), user.getPass(),user.getAge()));
		}
	}
	
	private static String generateIdList(ArrayList<User> userList) {
		String idList = "";
		for (User user : userList) {
			idList = idList + user.getId() + ",";
		}
		idList = idList.substring(0, idList.length() - 1);
		return idList;
	}
}
