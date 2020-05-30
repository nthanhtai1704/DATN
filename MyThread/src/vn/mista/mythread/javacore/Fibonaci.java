package vn.mista.mythread.javacore;

import java.util.Scanner;

public class Fibonaci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập n: ");
		int n = sc.nextInt();
		for(int i =1 ; i<n ; i++) {
			System.out.print(fibonaci(i) + " ");
		}

	}
	public static int fibonaci(int n) {
		if(n<0) {
			return -1;
		}else if(n==0 || n==1){
				return n;
			}else {
				return fibonaci(n-1)+ fibonaci(n-2);
			}
		}
	}

