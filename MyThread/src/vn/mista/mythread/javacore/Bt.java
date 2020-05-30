package vn.mista.mythread.javacore;

import java.util.Scanner;

public class Bt {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap n = ");
		int n = sc.nextInt();
		for(int i=1; i <=n; i++) {
			if(n%2==1) {
			System.out.print(i + " ");
			i= i *2;
			}else{
				System.out.println("Mời nhập lại!!");
			}
		}
	}
	
}
