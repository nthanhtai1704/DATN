package vn.mista.mythread.javacore;

import java.util.Scanner;

public class USCLN_BSCNN {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap so thu 1= ");
		int a = sc.nextInt();
		System.out.print("Nhap so thu 2= ");
		int b = sc.nextInt();
		System.out.println("USCLN cua " + a + " va " + b +" la " + USCLN(a, b));
		System.out.println("BSCNN cua " + a + " va " + b +" la " + BSCNN(a, b));
		
	}
	
	public static int USCLN(int a, int b) {
		if(b==0) {
			return a;
		}
		return USCLN(b, a%b);
	}
	
	public static int BSCNN(int a, int b) {
		return (a*b)/USCLN(a, b);
	}
}
