package vn.mista.mythread.javacore;

import java.util.Scanner;

public class CongDaySo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so thu nhat: ");
		int x1 = sc.nextInt();
		System.out.println("Nhap so thu hai: ");
		int x2 = sc.nextInt();
		int sum = 0;
		for(int i = x1; i<=x2;i++) {
				System.out.print(i + " ");
				sum+=i;
		}
		System.out.println("Sum = "+sum);
	}
}
