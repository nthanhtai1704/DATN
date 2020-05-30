package vn.mista.mythread.javacore;

import java.util.Scanner;

public class SoNguyenTo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap n: ");
		int n = sc.nextInt();
		System.out.printf("Tat ca so nguyen nho hon %d la: " , n);
		System.out.println("Tat ca so nguyen nho hon n la ");
		if(n>=2) {
			System.out.print(2);
		}
		for(int i = 3; i<n ; i+=2) {
			if(isNguyenTo(i)) {
				System.out.print(" "+ i);
			}
		}
	}
	
	public static boolean isNguyenTo(int n) {
		//so nguyen nho hon 2 khong phai la so nguyen to
		if(n<2) {
			return false;
		}
		//check so nguyen to khi lon hon 2
		int x = (int)Math.sqrt(n);
		for(int i = 3 ; i<=x ; i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
}
