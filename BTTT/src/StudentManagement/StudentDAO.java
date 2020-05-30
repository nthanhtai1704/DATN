package StudentManagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentDAO {

	//The number of student

	public ArrayList<Student> countStudent() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Student> studentList = new ArrayList<Student>();

		try {
			connection = ConnnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT COUNT(id) FROM student");
			while (resultSet.next()) {
				studentList.add(convertToStudent(resultSet));
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
		return studentList;
	}
	
	//Number of male students
	public ArrayList<Student> countStudentMale() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Student> studentList = new ArrayList<Student>();

		try {
			connection = ConnnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM student where gender = 'male'");
			while (resultSet.next()) {
				studentList.add(convertToStudent(resultSet));
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
		return studentList;
	}
	
	//List of female students
	public ArrayList<Student> listStudentFemale() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Student> studentList = new ArrayList<Student>();

		try {
			connection = ConnnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM student where gender = 'female'");
			while (resultSet.next()) {
				studentList.add(convertToStudent(resultSet));
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
		return studentList;
	}

	//Student list has not update phone numbers
	public ArrayList<Student> listStudentNotHavaTelephone() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Student> studentList = new ArrayList<Student>();

		try {
			connection = ConnnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM student where telephone is NULL");
			while (resultSet.next()) {
				studentList.add(convertToStudent(resultSet));
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
		return studentList;
	}

	//List of students over 18 years old
	public ArrayList<Student> listStudentOver18YearsOld() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Student> studentList = new ArrayList<Student>();

		try {
			connection = ConnnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM student where age > 18");
			while (resultSet.next()) {
				studentList.add(convertToStudent(resultSet));
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
		return studentList;
	}

	//List of good students
	public ArrayList<Student> listOfGoodStudent() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Student> studentList = new ArrayList<Student>();

		try {
			connection = ConnnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM student where score > 80");
			while (resultSet.next()) {
				studentList.add(convertToStudent(resultSet));
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
		return studentList;
	}

	//List of weak students
	public ArrayList<Student> listOfWeakStudent() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Student> studentList = new ArrayList<Student>();

		try {
			connection = ConnnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM student where score < 45");
			while (resultSet.next()) {
				studentList.add(convertToStudent(resultSet));
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
		return studentList;
	}

	//list of students named nike
	public ArrayList<Student> listOfStudentNameNike() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Student> studentList = new ArrayList<Student>();

		try {
			connection = ConnnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM student where fist_name = 'nike' OR  last_name = 'nike'");
			while (resultSet.next()) {
				studentList.add(convertToStudent(resultSet));
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
		return studentList;
	}

	private static Student convertToStudent(ResultSet rs) throws SQLException {
		Student student = new Student();
		student.setId(rs.getInt(1));
		student.setFistName(rs.getString(2));
		student.setLastName(rs.getString(3));
		student.setGender(rs.getString(4));
		student.setAge(rs.getInt(5));
		student.setTelephone(rs.getString(6));
		student.setScore(rs.getInt(7));

		return student;
	}
	
	// Display user list
		public static void displayUserList(ArrayList<Student> studentList) {
			for (Student student : studentList) {
				System.out.println(student.getId()
						+  " - " + student.getFistName().trim() + " " + student.getLastName());
			}
		} 
}
