package udn.ute.guitarshopda.bo;

public class ThanhVien {
	private int idTV;
	private String hoTen;
	private String sdt;
	private String cmnd;
	private String email;
	private String ngaySinh;
	private String diaChi;
	private String tenDN;
	private String matKhau;
	private String quyen;
	
	
	public ThanhVien() {
		super();
	}

	public ThanhVien(int idTV, String hoTen, String sdt, String cmnd, String emai, String ngaySinh, String diaChi,
			String tenDN, String matKhau, String quyen) {
		super();
		this.idTV = idTV;
		this.hoTen = hoTen;
		this.sdt = sdt;
		this.cmnd = cmnd;
		this.email = emai;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.tenDN = tenDN;
		this.matKhau = matKhau;
		this.quyen = quyen;
	}

	public int getIdTV() {
		return idTV;
	}

	public void setIdTV(int idTV) {
		this.idTV = idTV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmai(String email) {
		this.email = email;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getTenDN() {
		return tenDN;
	}

	public void setTenDN(String tenDN) {
		this.tenDN = tenDN;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getQuyen() {
		return quyen;
	}

	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}
	
	
}
