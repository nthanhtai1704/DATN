package BTVN;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentUtils {

	// Read file
	public static ArrayList<Student> readFile() {
		ArrayList<Student> listStudent = new ArrayList<>();
		try {
			File ObjSt = new File("StudentInfo.txt");
			Scanner myReader = new Scanner(ObjSt);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] arr = data.split(";");
				Student student = new Student();
				for (int i = 0; i < arr.length; i++) {
					if (!arr[0].isEmpty()) {
						try {
							student.setId(Integer.parseInt(arr[0]));
						} catch (Exception e) {
							System.out.println("ERROR: The input 'ID' value is the number");
						}
					} else {
						student.setId(0);
					}

					if (!arr[1].isEmpty()) {
						student.setFistName(arr[1].trim());
					} else {
						student.setFistName("");
					}

					if (!arr[2].isEmpty()) {
						student.setLastName(arr[2].trim());
					} else {
						student.setLastName("");
					}

					if (!arr[3].isEmpty()) {
						student.setGender(arr[3].trim());
					} else {
						student.setGender("");
					}

					if (!arr[4].isEmpty()) {
						try {
							student.setAge(Integer.parseInt(arr[4]));
						} catch (Exception e) {
							System.out.println("ERROR: The input 'AGE' value is the number");
						}
					} else {
						student.setAge(0);
					}
					
					if (!arr[5].isEmpty()) {
						student.setTelephone(arr[5]);
					} else {
						student.setTelephone("");
					}
					if (Integer.valueOf(arr[6]) > 10 || Integer.valueOf(arr[6]) > 10 || arr[6].isEmpty()) {
						student.setScores(0);
					} else {
						student.setScores(Integer.parseInt(arr[6]));
					}
				}
				listStudent.add(student);
			}
			myReader.close();
		} catch (Exception e) {
			System.out.println("Read File Error!");
			e.printStackTrace();
		}
		return listStudent;
	}

	// Percent male in list student
	public static int percentMale(ArrayList<Student> listStudent) {
		int countMale = 0;
		for (int i = 0; i < listStudent.size(); i++) {
			if (listStudent.get(i).getGender().equals("Male")) {
				countMale++;
			}
		}
		return (countMale * 100 / listStudent.size());
	}
	
	// check Student not Age
	public static boolean checkAge(Student student) {
		if (student.getAge() == 0) {
			return false;
		}
		return true;
	}

	// List Student not age
	public static ArrayList<Student> studentNotAge(ArrayList<Student> listStudent) {
		ArrayList<Student> studentNotAge = new ArrayList<Student>();
		for (int i = 0; i < listStudent.size(); i++) {
			if (!checkAge(listStudent.get(i))) {
				studentNotAge.add(listStudent.get(i));
			}
		}
		return studentNotAge;
	}

	// check student not telephone
	public static boolean checkTelephone(Student student) {
		if ((student.getTelephone() == "")) {
			return false;
		}
		return true;
	}

	// List students not Telephone
	public static ArrayList<Student> studentNotTelephone(ArrayList<Student> listStudent) {
		ArrayList<Student> studentNotTelephone = new ArrayList<Student>();
		for (int i = 0; i < listStudent.size(); i++) {
			if (!checkTelephone(listStudent.get(i))) {
				studentNotTelephone.add(listStudent.get(i));
			}
		}
		return studentNotTelephone;
	}
	//check student Excellent
	public static boolean isExcellent(Student student) {
		if ((student.getScores() >= 8)) {
			return true;
		}
		return false;
	}
	
	//check student Good
	public static boolean isGood(Student student) {
		if (student.getScores() >= 5 && student.getScores() < 8) {
			return true;
		}
		return false;
	}

	//check student Bad
	public static boolean isBad(Student student) {
		if ((student.getScores() < 5)) {
			return true;
		}
		return false;
	}

	// List student Excellent
	public static ArrayList<Student> showStudentExcellent(ArrayList<Student> listStudent) {
		ArrayList<Student> listStudentExcellent = new ArrayList<Student>();
		for (int i = 0; i < listStudent.size(); i++) {
			if (isExcellent(listStudent.get(i))) {
				listStudentExcellent.add(listStudent.get(i));
			}
		}
		return listStudentExcellent;
	}

	// List student Good
	public static ArrayList<Student> showStudentGood(ArrayList<Student> listStudent) {
		ArrayList<Student> listStudentGood = new ArrayList<Student>();
		for (int i = 0; i < listStudent.size(); i++) {
			if (isGood(listStudent.get(i))) {
				listStudentGood.add(listStudent.get(i));
			}
		}
		return listStudentGood;
	}

	//List student Bad
	public static ArrayList<Student> showStudentBad(ArrayList<Student> listStudent) {
		ArrayList<Student> listStudentBad = new ArrayList<Student>();
		for (int i = 0; i < listStudent.size(); i++) {
			if (isBad(listStudent.get(i))) {
				listStudentBad.add(listStudent.get(i));
			}
		}
		return listStudentBad;
	}
}
