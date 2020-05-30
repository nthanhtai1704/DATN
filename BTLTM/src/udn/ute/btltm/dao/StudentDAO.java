package udn.ute.btltm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import udn.ute.btltm.bo.Student;
import udn.ute.btltm.dbconnection.ConnectionFactory;


public class StudentDAO {

	// Select all Book
			public ArrayList<Student> getAllStudent(){
				Connection connection = null;
				Statement statement = null;
				ResultSet resultSet = null;
				
				ArrayList<Student> listStudent = new ArrayList<Student>();
				
				try {
					connection = ConnectionFactory.getConnection();
					statement = connection.createStatement();
					resultSet = statement.executeQuery("SELECT * FROM student");
					while(resultSet.next()) {
						listStudent.add(convertToStudent(resultSet));
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
				
				return listStudent;
				
			}
			// Convert to user
			public static Student convertToStudent(ResultSet rs) throws SQLException {
				Student user = new Student();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setBorn(rs.getString(3));
				user.setRoom(rs.getString(4));
				return user;
			}
}
