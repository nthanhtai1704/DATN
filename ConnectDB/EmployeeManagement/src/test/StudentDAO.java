package test;

import java.util.Scanner;

public class StudentDAO {

	public static Student nhapThongTin() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Id: ");
		int id = sc.nextInt();
		System.out.print("Name: ");
		String name = sc.next();
		System.out.print("Diem Toan: ");
		int diemToan = sc.nextInt();
		System.out.print("Diem Ly: ");
		int diemLy = sc.nextInt();
		System.out.print("Diem Hoa: ");
		int diemHoa = sc.nextInt();
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setDiemToan(diemToan);
		student.setDiemLy(diemLy);
		student.setDiemHoa(diemHoa);
		return student;
	}
	
}
