package udn.ute.guitarshopda.bo;

public class SanPham {
	private int idSP;
	private String tenSP;
	private int idHSX;
	private int idLoai;
	private int soLuong;
	private int soLuongCon;
	private int namSX;
	private String mauSac;
	private String anh;
	private String anhDD;
	private int gia;
	private String tenLoai;
	private String tenHang;
	private String moTa;
	public SanPham() {
		super();
	}
	public SanPham(int idSP, String tenSP, int idHSX, int idLoai, int soLuong, int soLuongCon, int namSX,
			String mauSac, String anh, String anhDD, int gia, String moTa) {
		super();
		this.idSP = idSP;
		this.tenSP = tenSP;
		this.idHSX = idHSX;
		this.idLoai = idLoai;
		this.soLuong = soLuong;
		this.soLuongCon = soLuongCon;
		this.namSX = namSX;
		this.mauSac = mauSac;
		this.anh = anh;
		this.anhDD = anhDD;
		this.gia = gia;
		this.moTa = moTa;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public int getIdSP() {
		return idSP;
	}
	public void setIdSP(int idSP) {
		this.idSP = idSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public int getIdHSX() {
		return idHSX;
	}
	public void setIdHSX(int idHSX) {
		this.idHSX = idHSX;
	}
	public int getIdLoai() {
		return idLoai;
	}
	public void setIdLoai(int idLoai) {
		this.idLoai = idLoai;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getSoLuongCon() {
		return soLuongCon;
	}
	public void setSoLuongCon(int soLuongCon) {
		this.soLuongCon = soLuongCon;
	}
	public int getNamSX() {
		return namSX;
	}
	public void setNamSX(int namSX) {
		this.namSX = namSX;
	}
	public String getMauSac() {
		return mauSac;
	}
	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getAnhDD() {
		return anhDD;
	}
	public void setAnhDD(String anhDD) {
		this.anhDD = anhDD;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	public String getTenHang() {
		return tenHang;
	}
	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}
	
	
}
