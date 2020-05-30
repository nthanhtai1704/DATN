package BTVN;

import java.util.ArrayList;

import BTVN.StudentUtils;

public class Main {
	public static void main(String[] args) {
		ArrayList<Student> listStudent = new ArrayList<>();
		// Read file
		listStudent = StudentUtils.readFile();

		// Number of students
		System.out.println("Number of student: " + listStudent.size());
		System.out.println();

		// Percent of gender
		int percent = StudentUtils.percentMale(listStudent);
		System.out.println("Percent of gender: " + percent + "/" + (100 - percent));
		System.out.println();

		// Students not have age
		ArrayList<Student> listNotAge = StudentUtils.studentNotAge(listStudent);
		System.out.println("Students not have age: ");
		for (Student student : listNotAge) {
			System.out.println("- " + student.getFistName() + " " + student.getLastName());
			System.out.println();
		}

		// Students not have telephone
		ArrayList<Student> listNotTel = StudentUtils.studentNotTelephone(listStudent);
		System.out.println("Students not have telephone: ");
		for (Student student : listNotTel) {
			System.out.println("- " + student.getFistName() + " " + student.getLastName());
			System.out.println();
		}

		// Sort list of students
			System.out.println("List of students");
			// show list student Excellent
			ArrayList<Student> listStudentEx = StudentUtils.showStudentExcellent(listStudent);
			System.out.println("* Excellent ");
			for (Student student : listStudentEx) {
				System.out.println(" " + student.getId() + " " + student.getFistName() + " " + student.getLastName());
			}
	
			// show list student Good
			ArrayList<Student> listStudentGood = StudentUtils.showStudentGood(listStudent);
			System.out.println("* Good ");
			for (Student student : listStudentGood) {
				System.out.println(" " + student.getId() + " " + student.getFistName() + " " + student.getLastName());
			}
	
			// show list student Bad
			ArrayList<Student> listStudentBad = StudentUtils.showStudentBad(listStudent);
			System.out.println("* Bad ");
			for (Student student : listStudentBad) {
				System.out.println(" " + student.getId() + " " + student.getFistName() + " " + student.getLastName());
			}
	}
}
