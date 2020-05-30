package vn.mista.guitarshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vn.mista.guitarshop.bo.History;
import vn.mista.guitarshop.dbconnection.ConnectionFactory;

public class HistoryDAO {
	
	// Select all history
			public ArrayList<History> getAllHistory(){
				Connection connection = null;
				Statement statement = null;
				ResultSet resultSet = null;
				
				ArrayList<History> listHistory = new ArrayList<History>();
				
				try {
					connection = ConnectionFactory.getConnection();
					statement = connection.createStatement();
					resultSet = statement.executeQuery("SELECT * FROM history");
					while(resultSet.next()) {
						listHistory.add(convertToHistory(resultSet));
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
				
				return listHistory;
				
			}
			// Select all history by user id
			public ArrayList<History> getAllHistoryUser(int id){
				Connection connection = null;
				Statement statement = null;
				ResultSet resultSet = null;
				
				ArrayList<History> listHistory = new ArrayList<History>();
				
				try {
					connection = ConnectionFactory.getConnection();
					statement = connection.createStatement();
					resultSet = statement.executeQuery("SELECT * FROM history where user_id = '"+id+"'");
					while(resultSet.next()) {
						listHistory.add(convertToHistory(resultSet));
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
				
				return listHistory;
				
			}
			
			
			//Insert History
			public void insertHistory(History history) {
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				String sql = "INSERT INTO history(user_id,full_name,product_id,product_name,quantity,price)VALUES(?,?,?,?,?,?)";
				try {
					connection = ConnectionFactory.getConnection();
					try {
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setInt(1, history.getUserID());
					preparedStatement.setString(2, history.getFullName());
					preparedStatement.setInt(3, history.getProductID());
					preparedStatement.setString(4, history.getProductName());
					preparedStatement.setInt(5, history.getQuantity());
					preparedStatement.setInt(6, history.getPrice());
					preparedStatement.execute();
					}catch (Exception e) {
						e.printStackTrace();}
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
					if(preparedStatement != null) {
						try {
							preparedStatement.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
			
			
			//Delete history by Id
			public void deleteHistory (int id) {
				Connection connection = null;
				Statement statement = null;
				String sql = "DELETE FROM history WHERE history_id = '"+id+"'";
				try {
					connection = ConnectionFactory.getConnection();
					statement = connection.createStatement();
					statement.execute(sql);
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
				}
			}
			
			//Get History
			public History getHistory(int id) {
				Connection connection = null;
				Statement statement = null;
				ResultSet resultSet = null;
				try {
					connection = ConnectionFactory.getConnection();
					statement = connection.createStatement();
					resultSet = statement.executeQuery("SELECT * FROM history where history_id = '"+id+"'");
					while(resultSet.next()) {
						History history = convertToHistory(resultSet);
						return history;
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
	//Convert to History
			public static History convertToHistory(ResultSet rs) throws SQLException {
				History history = new History();
				history.setHistoryID(rs.getInt(1));
				history.setUserID(rs.getInt(2));
				history.setFullName(rs.getString(3));
				history.setProductID(rs.getInt(4));
				history.setProductName(rs.getString(5));
				history.setQuantity(rs.getInt(6));
				history.setPrice(rs.getInt(7));
				return history;
				
			}
}
