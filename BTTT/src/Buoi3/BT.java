package Buoi3;

import java.util.Scanner;

public class BT {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập n: ");
		int n = sc.nextInt();
		//int kq = tinhGiaiThua(n);
		//boolean kq = KTSoNguyenTo(n);
		//int kq = tinhTong(n);
		String chuoi = sc.nextLine();
		boolean kq = kTChuoiDoiXung(chuoi);
		System.out.println(kq);
		
		
	}

	public static int tinhGiaiThua(int n) {

		int giaithua = 1;
		for (int i = 1; i <= n; i++) {
				giaithua = giaithua * i;
		}
		return giaithua;
	}
	
	public static boolean KTSoNguyenTo(int x) {
		for(int i =2 ; i < x ; i++) {
			if(x % i == 0) {
				return false;
			} 
		}		
		return true;
	}

	public static int tinhTong(int n) {
		int kq = 0 , m;
		while(n > 0) {
			m = n % 10;
			kq = kq + m;
			n = n/10;	
		}
		return kq;
	}
	
	static boolean kTChuoiDoiXung(String chuoi) {
		int index = 0;
		if(chuoi.length() %2 == 0) {
			index = chuoi.length() /2 -1;
		}else {
			index = chuoi.length() /2;
		}
		
		for(int i = 0; i<index;i++) {
			for(int j=chuoi.length(); i > index;i--) {
				if (chuoi.charAt(i) == chuoi.charAt(j)) {
					return true;
				}
			}break;
		}return false;
	}
}
