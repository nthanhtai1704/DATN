package udn.ute.btltm.main;

import java.util.ArrayList;

import udn.ute.btltm.bo.Student;
import udn.ute.btltm.dao.StudentDAO;

public class Main {

	public static void main(String[] args) {

		StudentDAO studentDAO = new StudentDAO();
		ArrayList<Student> listStudent = studentDAO.getAllStudent();
		System.out.println("ID        Name          Born    Room ");
		for(Student list : listStudent) {
			System.out.println(list.getId() + "     "+list.getName() +"    "+ list.getBorn() +"   "+ list.getRoom());
		}
	}

}
