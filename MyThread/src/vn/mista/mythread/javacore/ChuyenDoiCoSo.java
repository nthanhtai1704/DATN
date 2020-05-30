package vn.mista.mythread.javacore;

import java.util.Scanner;

public class ChuyenDoiCoSo {

	public static final String BASE = "0123456789ABCDEFGHIJKLMOPQRSTUVXYZW";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so can chuyen: ");
		int n = sc.nextInt();
		System.out.println("Nhap co so: ");
		int b = sc.nextInt();
		System.out.println("Ket qua: " + result(n, b) );
	}
	public static String result(int n, int b) {
		StringBuilder builder =  new StringBuilder();
		int x = 0 ;
		while(n>0) {
			x = n%b;
			n/= b;
			builder.append(BASE.charAt(x));
		}
		
		return builder.reverse().toString();
		
	}

}
