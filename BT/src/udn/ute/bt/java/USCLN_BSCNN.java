package udn.ute.bt.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class USCLN_BSCNN {

	public static void main(String[] args) {
		String a = null;
		String b = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Nhap a: ");
			a = br.readLine();
			System.out.print("Nhap b: ");
			b = br.readLine();
			int x1 = Integer.parseInt(a);
			int x2 = Integer.parseInt(b);
			System.out.println("USCLN cua " + x1 + "va " + x2+ " la " + USCLN(x1, x2));
			System.out.println("BSCNN cua " + x1 + "va " + x2+ " la " + BSCNN(x1, x2));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int USCLN(int a, int b) {
		if(b==0) {
			return a;
		}
		return USCLN(b, a%b);
	}
	
	public static int BSCNN(int a, int b) {
		return (a*b)/(USCLN(a, b));
	}

}
