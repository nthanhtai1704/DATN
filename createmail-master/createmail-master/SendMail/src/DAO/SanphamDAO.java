package DAO;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.Part;

import model.Sanpham;

public class SanphamDAO {
	public void insertProduct(Sanpham product) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO themsanpham(avatar,name,species,quantity) VALUES (?,?,?,?)";
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setBytes(1, product.getAvatar());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setString(3, product.getSpecies());
			preparedStatement.setInt(4, product.getQuantity());			
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
	public void insert(Sanpham sanpham) {
		Connection connection = null;
		Statement statement = null;
		String insert = "Insert into themsanpham(avatar,name,species,quantity)values('"+sanpham.getAvatar()+"','"+sanpham.getName()+"','"+sanpham.getSpecies()+"','"+sanpham.getQuantity()+"')";
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
	public ArrayList<Sanpham> getAllProduct(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		ArrayList<Sanpham> listProduct = new ArrayList<Sanpham>();
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM themsanpham");
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
	//extract file
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
	public static byte[] readFile(InputStream inputStream) {
		ByteArrayOutputStream bos = null;
		try {
			byte[] buffer = new byte[1024];
			bos = new ByteArrayOutputStream();
			for (int len; (len = inputStream.read(buffer)) != -1;) {
                bos.write(buffer, 0, len);
            }
			
		} catch (Exception e) {
            System.err.println(e.getMessage());
        }
		return bos.toByteArray();
	}
	
	private Sanpham convertToProduct(ResultSet rs) throws SQLException {
		Sanpham sp = new Sanpham();
		sp.setId(rs.getInt(1));
		byte [] imgdata = rs.getBytes("avatar");
		sp.setAvatar(imgdata);
		sp.setName(rs.getString(3));
		sp.setSpecies(rs.getString(4));
		sp.setQuantity(rs.getInt(5));
		return sp;
	}
}
