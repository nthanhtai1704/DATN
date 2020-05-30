package Connect;

public class KhachHang {
	 private int id;
	    private String tenKH;
	    private String diaChi;
	    private double luong;

	    public KhachHang(int id, String tenKH, String diaChi, double luong) {
	        this.id = id;
	        this.tenKH = tenKH;
	        this.diaChi = diaChi;
	        this.luong = luong;
	    }

	    public int getId() {
	        return id;
	    }

	    public String getTenKH() {
	        return tenKH;
	    }

	    public String getDiaChi() {
	        return diaChi;
	    }

	    public double getLuong() {
	        return luong;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public void setTenKH(String tenKH) {
	        this.tenKH = tenKH;
	    }

	    public void setDiaChi(String diaChi) {
	        this.diaChi = diaChi;
	    }

	    public void setLuong(double luong) {
	        this.luong = luong;
	    }
	    
	   
}
