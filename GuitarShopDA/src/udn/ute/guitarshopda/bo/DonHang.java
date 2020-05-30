package udn.ute.guitarshopda.bo;

public class DonHang {
	private int idDH;
	private int idTV;
	private int idSP;
	private String ngayMua;
	private int soLuong;
	private int tongTien;
	private String tinhTrang;
	
	private String tenSP;
	private String anh;
	private int gia;
	private String diaCHi;
	private String hoTen;
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public String getDiaCHi() {
		return diaCHi;
	}
	public void setDiaCHi(String diaCHi) {
		this.diaCHi = diaCHi;
	}
	public int getIdSP() {
		return idSP;
	}
	public void setIdSP(int idSP) {
		this.idSP = idSP;
	}
	
	public int getTongTien() {
		return tongTien;
	}
	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}

	public int getIdDH() {
		return idDH;
	}
	public void setIdDH(int idDH) {
		this.idDH = idDH;
	}
	public int getIdTV() {
		return idTV;
	}
	public void setIdTV(int idTV) {
		this.idTV = idTV;
	}
	public String getNgayMua() {
		return ngayMua;
	}
	public void setNgayMua(String ngayMua) {
		this.ngayMua = ngayMua;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public DonHang() {
		super();
	}
	public DonHang(int idDH, int idTV, int idSP, String ngayMua, int soLuong, int tongTien, String tinhTrang) {
		super();
		this.idDH = idDH;
		this.idTV = idTV;
		this.idSP = idSP;
		this.ngayMua = ngayMua;
		this.soLuong = soLuong;
		this.tongTien = tongTien;
		this.tinhTrang = tinhTrang;
	}
	
}
