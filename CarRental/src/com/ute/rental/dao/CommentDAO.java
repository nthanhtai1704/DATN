package com.ute.rental.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ute.rental.bo.Comment;
import com.ute.rental.dbconnection.ConnectionFactory;

public class CommentDAO {
	
	public ArrayList<Comment> getAllComment() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Comment> commentList = new ArrayList<Comment>();
		String sql = "Select * from comment_review";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				commentList.add(convertComment(resultSet));
			}
		} catch (Exception e) {
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
		return commentList;
		
	}
	
	public void insertComment(Comment comment) {
		Connection connection = null;
		Statement statement = null;
		String sql = "Insert into comment_review(id_product,idUser,full_name,comments) values"
				+ "('"+comment.getIdProduct()+"','"+comment.getIdUser()+"',N'"+comment.getFullName()+"',N'"+comment.getComment()+"')";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(sql);
			
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

	public ArrayList<Comment> getCommentById(int id) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Comment> listComment = new ArrayList<Comment>();
		String sql = "Select * from comment_review where id_product ='"+id+"'";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				listComment.add(convertComment(resultSet));
			}
		} catch (Exception e) {
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
		return listComment ;
	}
	public Comment convertComment(ResultSet rs) throws SQLException {
		Comment comment = new Comment();
		comment.setIdComment(rs.getInt(1));
		comment.setIdProduct(rs.getInt(2));
		comment.setIdUser(rs.getInt(3));
		comment.setFullName(rs.getString(4));
		comment.setComment(rs.getString(5));
		return comment;
		
	}

}
