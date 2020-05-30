package udn.ute.guitarshopda.bo;

public class LoaiSanPham {
	private int idLoai;
	private String tenLoai;
	
	
	public LoaiSanPham() {
		super();
	}

	public LoaiSanPham(int idLoai, String tenLoai) {
		super();
		this.idLoai = idLoai;
		this.tenLoai = tenLoai;
	}

	public int getIdLoai() {
		return idLoai;
	}

	public void setIdLoai(int idLoai) {
		this.idLoai = idLoai;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	
	
}
