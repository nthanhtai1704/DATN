package vn.mista.mythread.javacore;

public class TinhGiaiThua {

	public static void main(String[] args) {
		int a = 2;
		int b = 0;
		int c = 5;

		System.out.println("Giai thừa của " + a + " là: " + TinhGiaiThua.tinhGiaiThua(a));
		System.out.println("Giai thừa của " + b + " là: " + TinhGiaiThua.tinhGiaiThua(b));
		System.out.println("Giai thừa của " + c + " là: " + TinhGiaiThua.tinhGiaiThua1(c));
	}

	// đệ quy
	public static long tinhGiaiThua(int n) {
		if (n > 0) {
			return n * tinhGiaiThua(n - 1);
		} else {
			return 1;
		}
	}
	// không đệ quy
	public static long tinhGiaiThua1(int n) {
		long giaiThua = 1;
		if(n==1 || n==0) {
			return giaiThua;
		}else {
			for(int i =2 ;i<= n ; i++) {
				 giaiThua *= i;
			}
			return giaiThua;
		}
		
	}
}
