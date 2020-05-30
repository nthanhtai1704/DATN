package test;

public class Student {

	private int id;
	private String name;
	private int diemToan ;
	private int diemLy;
	private int diemHoa;
	private int diemTong;
	
	
	public Student() {
		super();
	}
	public Student(int id, String name, int diemToan, int diemLy, int diemHoa, int diemTong) {
		super();
		this.id = id;
		this.name = name;
		this.diemToan = diemToan;
		this.diemLy = diemLy;
		this.diemHoa = diemHoa;
		this.diemTong = diemTong;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDiemToan() {
		return diemToan;
	}
	public void setDiemToan(int diemToan) {
		this.diemToan = diemToan;
	}
	public int getDiemLy() {
		return diemLy;
	}
	public void setDiemLy(int diemLy) {
		this.diemLy = diemLy;
	}
	public int getDiemHoa() {
		return diemHoa;
	}
	public void setDiemHoa(int diemHoa) {
		this.diemHoa = diemHoa;
	}
	public int getDiemTong() {
		return diemTong;
	}
	public void setDiemTong(int diemTong) {
		this.diemTong = diemTong;
	}
	public static Student xuatThongTin(Student student) {
		System.out.println("Id: " + student.getId());
		System.out.println("Name: " +student.getName());
		System.out.println("Diem Toan: "+student.getDiemToan());
		System.out.println("Diem Ly: " + student.getDiemLy());
		System.out.println("Diem Hoa: " + student.getDiemHoa());
		int tongDiem = (student.getDiemToan() + student.getDiemLy()*2 + student.getDiemHoa()*3)/5;
		System.out.println("Tong diem: " + tongDiem);
		return student;
	}
}
