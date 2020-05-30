package vn.mista.mythread.javacore;

import java.util.Scanner;

public class CacSoNguyenToDauTien {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap n: ");
		int n = sc.nextInt();
		int dem = 0;
		int i =2;
		while(dem<n) {
			if(isNguyenTo(i)==true) {
				System.out.print(i + " ");
				dem++;
			}
			i++;
		}
	}

	public static boolean isNguyenTo(int n) {
		if(n<2) {
			return false;
		}
		int x = (int) Math.sqrt(n);
		for(int i =2; i<=x; i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
}
