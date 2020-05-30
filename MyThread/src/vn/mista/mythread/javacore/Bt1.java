package vn.mista.mythread.javacore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bt1 {

	public int nhapSo() throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(reader);
		String s = br.readLine();
		return Integer.parseInt(s);
	}

	public void tongTichCacSo(int m) {
		int S = 0, P = 1;
		while (m != 0) {
			S += m % 10;
			P *= m % 10;
			m /= 10;
		}
		System.out.println("Tong cac chu so la: " + S);
		System.out.println("Tich cac chu so la: " + P);
	}

	public static void main(String[] args) {
		Bt1 bt = new Bt1();
		int m = 0;
		try {
			do {
				System.out.println("Nhap so nguyen dương: ");
				m = bt.nhapSo();
			} while (m <= 0);
			System.out.println("So da nhap: " + m);
			bt.tongTichCacSo(m);
			System.out.println("So da nhap: " + m);
			bt.tongTichCacSo(m);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
