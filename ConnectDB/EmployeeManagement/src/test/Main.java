package test;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Student> arrStudent = new ArrayList<>();
		Student student = new Student();
		StudentDAO dao = new StudentDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap bao nhieu student: ");
		int n = sc.nextInt();
		for(int i = 1; i<=n; i++) {
			System.out.println("Nhap student thu " + i);
			student = dao.nhapThongTin();
			arrStudent.add(student);
		}
		
		for(int i = 1;i<=arrStudent.size(); i++) {
			System.out.println();
			arrStudent.get(i).xuatThongTin(student);
			
		}
		
	}

}
