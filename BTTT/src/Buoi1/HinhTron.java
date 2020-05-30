package Buoi1;

public class HinhTron{
	private double r;

	public HinhTron() {}
	
	public HinhTron(double r) {
		super();
		this.r = r;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	@Override
	public String toString() {
		return "HinhTron [r=" + r + "]";
	}
	
	public double tinhDT(double r) {
		double S;
		S= r*r * Math.PI;
		return S;
	}

}
