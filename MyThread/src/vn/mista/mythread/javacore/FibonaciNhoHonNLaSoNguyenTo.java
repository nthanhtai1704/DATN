package vn.mista.mythread.javacore;

import java.util.Scanner;

public class FibonaciNhoHonNLaSoNguyenTo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap n:");
		int n = sc.nextInt();
		System.out.printf("Cac so fibonaci nho hon %d va la cac so nguyen to la: ", n);
		int i =0;
		while(fibonaci(i)< n) {
			int fi = fibonaci(i);
			if(isSoNguyenTo(fi)) {
				System.out.print(fi + " ");
			}
			i++;
		}
		
	}

	//fibonaci de quy
	public static int fibonaci(int n) {
		if(n<0) {
			return -1;
		}else if(n==0 || n==1){
			return n;
		}else {
			return fibonaci(n-1) + fibonaci(n-2);
		}
	}
	//so nguyen to
	public static boolean isSoNguyenTo(int n) {
		//n < 2 khong phai la so nguyen to
		if(n<2) {
			return false;
		}
		int x = (int) Math.sqrt(n);
		for(int i =2; i<=x; i++) {
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}
}
