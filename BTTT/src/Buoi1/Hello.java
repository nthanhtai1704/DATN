package Buoi1;

import java.util.*;

public class Hello {

	public static void main(String[] args) {
		/*int x= 1;
		Scanner sc =new  Scanner (System.in);
		System.out.println("Nhập y: ");
		int y = sc.nextInt();
		while(x<=y) {
			if (x%2==0) {
				System.out.println(x);
			}
			x++;
		}*/
			
		boolean x = true;
		String[] cars = {"aa", "bmw", "a"};
		for(int i = 0; i < cars.length;i++) {
			if(cars[i]== "bmw" ) {
				x = true;				
			}
		}if(x) {
			System.out.println("yes");
		}else {
			System.out.println("no");
		}
		
		
	}

}