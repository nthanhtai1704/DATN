package model;

public class Duynguyen {
	private int id;
	private String name;
	private String gioitinh;
	private String sdt;
	private String trangthai;
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
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	public Duynguyen(int id, String name, String gioitinh, String sdt, String trangthai) {
		super();
		this.id = id;
		this.name = name;
		this.gioitinh = gioitinh;
		this.sdt = sdt;
		this.trangthai = trangthai;
	}
	public Duynguyen() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
