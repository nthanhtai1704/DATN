package StudentManagement;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		//The number of student
		StudentDAO studentDAO = new StudentDAO();
		ArrayList<Student> studentList = studentDAO.countStudent();
		System.out.println("Số lượng học sinh: " + studentList.size());
		System.out.println();
		
		//Number of male students
		ArrayList<Student> countStudentMale = studentDAO.countStudentMale();
		System.out.println("Số lượng học sinh nam: " + countStudentMale.size());
		System.out.println();
		
		//List of female students
		ArrayList<Student> listOfFemaleStudent = studentDAO.listStudentFemale();
		System.out.println("Danh sách học sinh nữ:");
		StudentDAO.displayUserList(listOfFemaleStudent);
		System.out.println();
		
		//Student list has not update phone numbers
		ArrayList<Student> listStudentNotHaveTelephone = studentDAO.listStudentNotHavaTelephone();
		System.out.println("Danh sách học sinh chưa cập nhật số điện thoại:");
/*		for(Student student : listStudentNotHaveTelephone) {
			System.out.println(student.getId() +  " - " + student.getFistName().trim() + " " + student.getLastName());
		}*/
		StudentDAO.displayUserList(listStudentNotHaveTelephone);
		System.out.println();
		
		//List of students over 18 years old
		ArrayList<Student> listStudentOver18YearsOld = studentDAO.listStudentOver18YearsOld();
		System.out.println("Danh sách học sinh trên 18 tuổi:");
		/*for(Student student : listStudentOver18YearsOld) {
			System.out.println(student.getId() +  " - " + student.getFistName().trim() + " " + student.getLastName());
		}*/
		StudentDAO.displayUserList(listStudentOver18YearsOld);
		System.out.println();
		
		//List of good students
		ArrayList<Student> listOfGoodStudent = studentDAO.listOfGoodStudent();
		System.out.println("Danh sách học sinh học giỏi (scores > 80):");
		/*for(Student student : listOfGoodStudent) {
			System.out.println(student.getId() +  " - " + student.getFistName().trim() + " " + student.getLastName());
		}*/
		StudentDAO.displayUserList(listOfGoodStudent);
		System.out.println();
		
		//List of weak students
		ArrayList<Student> listOfWeakStudent = studentDAO.listOfWeakStudent();
		System.out.println("Danh sách học sinh yếu (scores < 45):");
		/*for(Student student : listOfWeakStudent) {
			System.out.println(student.getId() +  " - " + student.getFistName().trim() + " " + student.getLastName());
		}*/
		StudentDAO.displayUserList(listOfWeakStudent);
		System.out.println();
		
		//List of students named nike
		ArrayList<Student> listOfStudentNameNike = studentDAO.listOfStudentNameNike();
		System.out.println("Danh sách học sinh có last_name hoặc first_name = ‘nike’:");
		/*for(Student student : listOfStudentNameNike) {
			System.out.println(student.getId() +  " - " + student.getFistName().trim() + " " + student.getLastName());
		}*/
		StudentDAO.displayUserList(listOfStudentNameNike);
	}

}
