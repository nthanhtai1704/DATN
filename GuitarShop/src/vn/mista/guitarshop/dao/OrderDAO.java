package vn.mista.guitarshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vn.mista.guitarshop.bo.Item;
import vn.mista.guitarshop.bo.Order;
import vn.mista.guitarshop.bo.Product;
import vn.mista.guitarshop.bo.User;
import vn.mista.guitarshop.dbconnection.ConnectionFactory;

public class OrderDAO {
	// Select all Order
			public ArrayList<Order> getAllOrder(){
				Connection connection = null;
				Statement statement = null;
				ResultSet resultSet = null;
				
				ArrayList<Order> listOrder = new ArrayList<Order>();
				
				try {
					connection = ConnectionFactory.getConnection();
					statement = connection.createStatement();
					resultSet = statement.executeQuery("SELECT * FROM orders");
					while(resultSet.next()) {
						listOrder.add(convertToOrder(resultSet));
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
				
				return listOrder;
				
			}
			
			// Find Order by name
			public ArrayList<Order> findOrderByName(String name) {
				Connection connection = null;
				Statement statement = null;
				ResultSet resultSet = null;
				
				ArrayList<Order> listOrder = new ArrayList<Order>();
				try {
					connection = ConnectionFactory.getConnection();
					statement = connection.createStatement();
					resultSet = statement.executeQuery("SELECT * FROM order WHERE product_name = '"+ name +"'");
					while(resultSet.next()) {
						listOrder.add(convertToOrder(resultSet));
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
					if(resultSet != null) {
						try {
							resultSet.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				return listOrder;
			}
			
			//Insert book
			public void insertProduct(Order order) {
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				String sql = "INSERT INTO orders(user_id,user_name,password,"
						+ "full_name,tel,id_card,email,address,product_id,"
						+ "product_img,product_name,product_type,quantity,price )"
						+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				try {
					connection = ConnectionFactory.getConnection();
					preparedStatement = connection.prepareStatement(sql);
				
					preparedStatement.setInt(1, order.getCustomer().getUserID());
					preparedStatement.setString(2, order.getCustomer().getUserName());
					preparedStatement.setString(3, order.getCustomer().getPassword());
					preparedStatement.setString(4, order.getCustomer().getFullName());
					preparedStatement.setString(5, order.getCustomer().getTel());
					preparedStatement.setInt(6, order.getCustomer().getIdCard());
					preparedStatement.setString(7, order.getCustomer().getEmail());
					preparedStatement.setString(8, order.getCustomer().getAddress());
					preparedStatement.setInt(9, order.getItems().get(1).getProduct().getProductID());
					preparedStatement.setBytes(10, order.getItems().get(1).getProduct().getProductImg());
					preparedStatement.setString(11, order.getItems().get(1).getProduct().getProductName());
					preparedStatement.setString(12, order.getItems().get(1).getProduct().getProductType());
					preparedStatement.setInt(13, order.getItems().get(1).getQuantity());
					preparedStatement.setInt(14, order.getItems().get(1).getProduct().getPrice());
					
					
					preparedStatement.execute();
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
			
			//Get Order
			public Order getOrder(int id) {
				Connection connection = null;
				Statement statement = null;
				ResultSet resultSet = null;
				try {
					connection = ConnectionFactory.getConnection();
					statement = connection.createStatement();
					resultSet = statement.executeQuery("SELECT * FROM orders where order_id = '"+id+"'");
					while(resultSet.next()) {
						Order order = convertToOrder(resultSet);
						return order;
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
			
			//Convert to Order
			public static Order convertToOrder(ResultSet rs) throws SQLException {
				User user = new User();
				Order order = new Order();
				try {
				order.setOrderID(rs.getInt(1));
				order.setCustomer(user);
				
				((Item) order.getItems()).getProduct().setProductID(rs.getInt(2));
				byte[] imgData = rs.getBytes("product_img");
				((Item) order.getItems()).getProduct().setProductImg(imgData);
				((Item) order.getItems()).getProduct().setProductName(rs.getString(3));
				((Item) order.getItems()).getProduct().setProductType(rs.getString(4));
				((Item) order.getItems()).getProduct().setAmount(rs.getInt(5));
				((Item) order.getItems()).getProduct().setPrice(rs.getInt(6));
				}catch (Exception e) {
					e.printStackTrace();
				}
				return order;
				
			}

}
