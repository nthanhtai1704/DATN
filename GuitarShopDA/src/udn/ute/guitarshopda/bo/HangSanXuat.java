package udn.ute.guitarshopda.bo;

public class HangSanXuat {
	private int idHSX;
	private String tenHSX;
	
	public HangSanXuat(int idHSX, String tenHSX) {
		super();
		this.idHSX = idHSX;
		this.tenHSX = tenHSX;
	}

	public int getIdHSX() {
		return idHSX;
	}

	public void setIdHSX(int idHSX) {
		this.idHSX = idHSX;
	}

	public String getTenHSX() {
		return tenHSX;
	}

	public void setTenHSX(String tenHSX) {
		this.tenHSX = tenHSX;
	}

	public HangSanXuat() {
		super();
	}
	
	
}
