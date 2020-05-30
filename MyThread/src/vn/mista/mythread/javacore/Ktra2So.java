package vn.mista.mythread.javacore;

import java.util.Scanner;

public class Ktra2So {

	public static void main(String[] args) {
		/*Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so thu 1 = ");
		int x1 = sc.nextInt();
		System.out.println("Nhap so thu 2 = ");
		int x2 = sc.nextInt();*/
		int tmp;
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap so nguyen: ");
		int n = sc.nextInt();
	    int res = 0, sum =0, tich = 1;
	    while(n > 0){
	        tmp = n % 10;
	        res = res * 10 + tmp;
	        sum+=tmp;
	        tich*=tmp;
	        n = n / 10;
	    }
	    System.out.println("Dao: "+res);
	    System.out.println("Tong: "+sum);
	    System.out.println("Tich: "+tich);
	    System.out.println(res);
	    System.out.println(sum);
	    System.out.println(tich);
	}
	
}
