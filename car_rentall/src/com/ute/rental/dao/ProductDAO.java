package com.ute.rental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ute.rental.bo.Product;
import com.ute.rental.dbconnection.ConnectionFactory;

public class ProductDAO {
	public ArrayList<Product> getAllProduct(){
		Connection  connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		ArrayList<Product> listproduct = new ArrayList<Product>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("Select * from product");
			while(resultset.next()) {
				listproduct.add(convertopt(resultset));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(connection != null) {
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(resultset != null) {
				try {
					resultset.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return listproduct;
		
	}

	private Product convertopt(ResultSet rs) throws SQLException {
		Product pt = new Product();
		pt.setIdproduct(rs.getInt(1));
		pt.setNameproduct(rs.getString(2));
		pt.setSpecies(rs.getString(3));
		pt.setQuantity(rs.getInt(4));
		pt.setAvatar(rs.getString(5));
		pt.setAvatar_sv(rs.getString(6));
		pt.setPrice(rs.getInt(7));
		return pt;
	}
	public void AddPt (Product product){
		Connection connection = null;
		Statement statement = null;
		String insert = "Insert into product(name_product,species_product,quantity,avatar,avatar_sv,price) values ('"+product.getNameproduct()+"','"+product.getSpecies()+"','"+product.getQuantity()+"','"+product.getAvatar()+"','"+product.getAvatar_sv()+"','"+product.getPrice()+"'";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(insert);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
		}				
	}
	
	public void deleteProduct(int id) {
		Connection connection = null;
		Statement statement = null;
		String sql = "DELETE FROM product WHERE id_product = '"+id+"' ";
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
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if(statement!=null) {
				try {
					statement.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
	//Update product
	public void updateProduct ( Product product) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "UPDATE product set name_product = ?, species_product = ?,"
				+ " quantity =? , avatar = ?,avatar_sv=?, price =? WHERE id_product = ?";
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, product.getNameproduct());
			preparedStatement.setString(2, product.getSpecies());
			preparedStatement.setInt(3, product.getQuantity());
			preparedStatement.setString(4, product.getAvatar());
			preparedStatement.setString(5, product.getAvatar_sv());
			preparedStatement.setInt(6, product.getPrice());
			preparedStatement.execute();
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
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();
		ArrayList<Product> listpro = dao.getAllProduct();	
		for(Product product :  listpro) {
			System.out.println( product.getIdproduct() + product.getNameproduct());
		}
	}
}
