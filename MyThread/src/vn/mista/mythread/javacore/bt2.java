package vn.mista.mythread.javacore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bt2 {
//nhap 2 so nguyen a va b sau do in ra USCLN và BCNN cua 2 so 

	public void USCLN(int a, int b) {
		int x = a; int y = b;
		while(a!=b) {
			if(a>b) {
				a = a-b;
			}else {
				b=b-a;
			}
		}
		System.out.println("USCLN: " + a);
		System.out.println("BCNN: " + (x*y)/a);
	}

	public int nhapSo() throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(reader);
		String s = br.readLine();
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		bt2 bt = new bt2();
		int a = 0, b = 0;
		try {
			do {
				System.out.print("nhap a = ");
				a = bt.nhapSo();
				System.out.print("nhap b = ");
				b = bt.nhapSo();
			} while (a <= 0 || b <= 0);
			bt.USCLN(a, b);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("nhap a = ");
			a = bt.nhapSo();
			System.out.println("nhap b = ");
			b = bt.nhapSo();
			bt.USCLN(a, b);
		}
		while (a <= 0 || b <= 0)
			;
	}

}
