package udn.ute.guitarshopda.bo;

public class GioHang {
	private int idGH;
	private int idTV;
	private int idSP;
	private int soLuong;
	private String tenSP;
	private String anh;
	private int gia;
	private String diaChi;
	private SanPham sp;
	private int tongSP;
	
	public int getTongSP() {
		return tongSP;
	}
	public void setTongSP(int tongSP) {
		this.tongSP = tongSP;
	}
	public SanPham getSp() {
		return sp;
	}
	public void setSp(SanPham sp) {
		this.sp = sp;
	}
	public int getIdGH() {
		return idGH;
	}
	public void setIdGH(int idGH) {
		this.idGH = idGH;
	}
	public int getIdTV() {
		return idTV;
	}
	public void setIdTV(int idTV) {
		this.idTV = idTV;
	}
	public int getIdSP() {
		return idSP;
	}
	public void setIdSP(int idSP) {
		this.idSP = idSP;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
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
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public GioHang() {
		super();
	}
	public GioHang(int idGH, int idTV, int idSP, int soLuong, String tenSP, String anh, int gia, String diaChi) {
		super();
		this.idGH = idGH;
		this.idTV = idTV;
		this.idSP = idSP;
		this.soLuong = soLuong;
		this.tenSP = tenSP;
		this.anh = anh;
		this.gia = gia;
		this.diaChi = diaChi;
	}
	
	
}
