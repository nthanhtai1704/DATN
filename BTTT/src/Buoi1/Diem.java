package Buoi1;

public class Diem {

	protected int x, y;

	public Diem() {
		super();
	}

	public Diem(int p, int q) {
		super();
		this.x = p;
		this.y = q;
	}
	
	public static double khoangCach(Diem a, Diem b) {
		return Math.sqrt((b.x - a.x) *(b.x - a.x) + (b.y - a.y)*(b.y - a.y));
	}
}
