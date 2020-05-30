package udn.ute.bt.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TongTichCacSo {

	public static void main(String[] args) throws IOException {
		String input = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the numbers to add:");
		input = br.readLine();
		int n = Integer.parseInt(input);
		int sum = 0, tich = 1, tmp;
		while (n > 0) {
			tmp = n % 10;
			sum += tmp;
			tich *= tmp;
			n = n / 10;
		}
		System.out.println("Sum = "+sum);
		System.out.println("Tich = "+tich);
	}
}
