package vn.msita.jspseverlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vn.msita.jspservlet.dbconnection.ConnectionFactory;
import vn.msita.jspservlet.bo.Book;

public class BookDAO {
	
	// Select all Book
	public ArrayList<Book> getAllBook(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		ArrayList<Book> listBook = new ArrayList<Book>();
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM book");
			while(resultSet.next()) {
				listBook.add(convertToBook(resultSet));
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
		
		return listBook;
		
	}
	
	// Find Book by name
	public ArrayList<Book> findBookByName(String name) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		ArrayList<Book> listBook = new ArrayList<Book>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM book WHERE name = '"+ name +"'");
			while(resultSet.next()) {
				listBook.add(convertToBook(resultSet));
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
		return listBook;
	}
	
	//Insert book
	public void insertBook(Book book) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO book(name, author, publisher, price) VALUES(?,?,?,?)";
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, book.getName());
			preparedStatement.setString(2, book.getAuthor());
			preparedStatement.setString(3, book.getPublisher());
			preparedStatement.setInt(4, book.getPrice());
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
	
	//Update book
	public void updateBook(Book book) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			String sql = "UPDATE BOOK SET name = ? , author = ? , publisher = ? , price = ? WHERE id = ?";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, book.getName());
			preparedStatement.setString(2, book.getAuthor());
			preparedStatement.setString(3, book.getPublisher());
			preparedStatement.setInt(4, book.getPrice());
			preparedStatement.setInt(5, book.getId());
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
	public void deleteBook (int id) {
		Connection connection = null;
		Statement statement = null;
		String sql = "DELETE FROM book WHERE id = '"+id+"'";
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
	
	//Get Book
	public Book getBook(int id) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM book where id = '"+id+"'");
			while(resultSet.next()) {
				Book book = convertToBook(resultSet);
				return book;
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
	//Login
	//public User login
	
	//Convert to book
	public static Book convertToBook (ResultSet rs) throws SQLException {
		Book book = new Book();
		book.setId(rs.getInt(1));
		book.setName(rs.getString(2));
		book.setAuthor(rs.getString(3));
		book.setPublisher(rs.getString(4));
		book.setPrice(rs.getInt(5));
		return book;
		
	}
}
