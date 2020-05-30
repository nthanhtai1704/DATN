package Buoi1;

public class HinhCau extends HinhTron implements Comparable<HinhTron>   {

	public HinhCau() {}
	
	public HinhCau(double r) {
		super(r);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double tinhDT(double r) {
		// TODO Auto-generated method stub
		return 4 * getR() * getR() * Math.PI;
	}
	

	@Override
	public int compareTo(HinhTron o) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
