package udn.ute.bt.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InHoa {
	public static void main(String[] args) {
		String input = null;
		System.out.println("Enter the input string: ");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			input = br.readLine();
			String kq = input.toUpperCase();
			System.out.println("Chuoi sau khi in hoa la: ");
			System.out.println(kq);
			String kq1 = input.toLowerCase();
			System.out.println("Chuoi sau khi in thuong la: ");
			System.out.println(kq1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
