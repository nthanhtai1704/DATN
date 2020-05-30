package vn.mista.mythread.javacore;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so: " );
		int n = sc.nextInt();
		//Test.tongTichCacSo(n);
		if(n >=2) {
			System.out.print(2);
		}
		for(int i =3 ; i<n;i+=2) {
			if(isNguyenTo(i)) {
				System.out.print(" "+i);
			}
		}
	}
	
	public static boolean isNguyenTo(int n) {
		if(n<2) {
			return false;
		}
		int x = (int) Math.sqrt(n);
		for(int i =2;i<=x; i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
	public static void tongTichCacSo(int n) {
		int dao = 0, tong =0, tich =1, dv =0 ;
		while(n!=0) {
			dv = n%10;
			dao=dao*10+dv;
			tong +=dv;
			tich*=dv;
			n/=10;
		}
		System.out.println("Dao: "+dao);
		System.out.println("Tong: "+tong);
		System.out.println("Tich: "+tich);
	}

}
