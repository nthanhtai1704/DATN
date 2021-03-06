package com.ute.rental.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ute.rental.bo.Users;
import com.ute.rental.dbconnection.ConnectionFactory;

public class UserDAO {
	public Users findUsernameAndpasswords(String username, String passwords) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery(
					"Select * from users where username='" + username + "' and passwords='" + passwords + "'");
			while (resultset.next()) {
				Users users = ConvertoUsers(resultset);
				return users;
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
			if (resultset != null) {
				try {
					resultset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public ArrayList<Users> getAllUsers() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		ArrayList<Users> listUsers = new ArrayList<Users>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("Select *from users");
			while (resultset.next()) {
				listUsers.add(ConvertoUsers(resultset));
			}
		} catch (SQLException e) {
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
			if (resultset != null) {
				try {
					resultset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return listUsers;
	}
	//update
	public void updateUser(Users users) {
		Connection connection = null;
		Statement statement = null;
		String sql = "Update users set full_name=N'"+users.getNameuser()+"',id_card='"+users.getIdCard()+"',"
				+ "date_birth='"+users.getDatebirth()+"',address=N'"+users.getAddress()+"',"
						+ "phone_number='"+users.getPhonenumber()+"',username='"+users.getUsername()+"',"
								+ "passwords='"+users.getPasswords()+"' WHERE idUser='"+users.getIdUser()+"'";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	public Users getUser(int id) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM users WHERE idUser = '" + id + "'";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Users user = ConvertoUsers(resultSet);
				return user;
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
		return null;
	}

	private Users ConvertoUsers(ResultSet rs) throws SQLException {
		Users users = new Users();
		users.setIdUser(rs.getInt(1));
		users.setNameuser(rs.getString(2));
		users.setIdCard(rs.getString(3));
		users.setDatebirth(rs.getString(4));
		users.setAddress(rs.getString(5));
		users.setPhonenumber(rs.getString(6));
		users.setUsername(rs.getString(7));
		users.setPasswords(rs.getString(8));
		users.setRoles(rs.getString(9));
		return users;
	}

	public void AddUsers(Users users) {
		Connection connection = null;
		Statement statement = null;
		String insert = "Insert into users(full_name,id_card,date_birth,address,phone_number,username,passwords,roles)values(N'"+users.getNameuser()+"','"+users.getIdCard() + "','" + users.getDatebirth() + "',N'"+users.getAddress() + "','"+ users.getPhonenumber() + "','"+users.getUsername() + "','"+users.getPasswords()+"','" + users.getRoles() + "')";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(insert);
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
		}
	}
	
	
}
