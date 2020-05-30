package vn.mista.guitarshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.Part;

import vn.mista.guitarshop.bo.Product;
import vn.mista.guitarshop.dbconnection.ConnectionFactory;


public class ProductDAO {
	
	// Select all Book
		public ArrayList<Product> getAllProduct(){
			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet = null;
			
			ArrayList<Product> listProduct = new ArrayList<Product>();
			
			try {
				connection = ConnectionFactory.getConnection();
				statement = connection.createStatement();
				resultSet = statement.executeQuery("SELECT * FROM SANPHAM");
				while(resultSet.next()) {
					listProduct.add(convertToProduct(resultSet));
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
			
			return listProduct;
			
		}
		
		// Find Product by name
		public ArrayList<Product> findProductByName(String name) {
			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet = null;
			
			ArrayList<Product> listProduct = new ArrayList<Product>();
			try {
				connection = ConnectionFactory.getConnection();
				statement = connection.createStatement();
				resultSet = statement.executeQuery("SELECT * FROM product WHERE product_name = '"+ name +"'");
				while(resultSet.next()) {
					listProduct.add(convertToProduct(resultSet));
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
			return listProduct;
		}
		
		//Insert book
		public void insertProduct(Product product) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			String sql = "INSERT INTO product(product_img,product_name,product_type,amount,price) VALUES (?,?,?,?,?)";
			try {
				connection = ConnectionFactory.getConnection();
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setBytes(1, product.getProductImg());
				preparedStatement.setString(2, product.getProductName());
				preparedStatement.setString(3, product.getProductType());
				preparedStatement.setInt(4, product.getAmount());
				preparedStatement.setInt(5, product.getPrice());
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
		
		//Update product
		public void updateProduct(Product product) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			try {
				String sql = "UPDATE product SET product_name =?, product_img =?,"
						+ " product_type=?,amount=?,price=? WHERE product_id=?";
				connection = ConnectionFactory.getConnection();
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, product.getProductName());
				preparedStatement.setBytes(2, product.getProductImg());
				preparedStatement.setString(3, product.getProductType());
				preparedStatement.setInt(4, product.getAmount());
				preparedStatement.setInt(5, product.getPrice());
				preparedStatement.setInt(6, product.getProductID());
				preparedStatement.executeUpdate();
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
		
		//Delete book by Id
		public void deleteProduct (int id) {
			Connection connection = null;
			Statement statement = null;
			String sql = "DELETE FROM product WHERE product_id = '"+id+"'";
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
		
		//Get Product
		public Product getProduct(int id) {
			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet = null;
			try {
				connection = ConnectionFactory.getConnection();
				statement = connection.createStatement();
				resultSet = statement.executeQuery("SELECT * FROM product where product_id = '"+id+"'");
				while(resultSet.next()) {
					Product product = convertToProduct(resultSet);
					return product;
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
		//extractFile
		public static String extractFileName(Part part) {
			String contentDisp = part.getHeader("content-disposition");
			String[] items = contentDisp.split(";");
			for(String s : items) {
				if(s.trim().startsWith("filename")) {
					return s.substring(s.indexOf("=") + 2, s.length()-1);
				}
			}
			return "";
			
		}
		
		//Convert to Product
		public static Product convertToProduct(ResultSet rs) throws SQLException {
			Product product = new Product();
			product.setProductID(rs.getInt(1));
			byte[] imgData = rs.getBytes("product_img");
			product.setProductImg(imgData);
			product.setProductName(rs.getString(3));
			product.setProductType(rs.getString(4));
			product.setAmount(rs.getInt(5));
			product.setPrice(rs.getInt(6));
			return product;
			
		}
		

}
