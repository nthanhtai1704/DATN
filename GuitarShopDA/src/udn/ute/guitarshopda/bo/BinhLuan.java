package udn.ute.guitarshopda.bo;

public class BinhLuan {
	private int idBL;
	private int idTV;
	private int idSP;
	private String hoTen;
	private String loiBL;
	public int getIdBL() {
		return idBL;
	}
	public void setIdBL(int idBL) {
		this.idBL = idBL;
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
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getLoiBL() {
		return loiBL;
	}
	public void setLoiBL(String loiBL) {
		this.loiBL = loiBL;
	}
	public BinhLuan() {
		super();
	}
	public BinhLuan(int idBL, int idTV, int idSP, String hoTen, String loiBL) {
		super();
		this.idBL = idBL;
		this.idTV = idTV;
		this.idSP = idSP;
		this.hoTen = hoTen;
		this.loiBL = loiBL;
	}
	
	
}
