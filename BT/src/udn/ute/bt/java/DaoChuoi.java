package udn.ute.bt.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DaoChuoi {

	public static void main(String[] args) {
		String input = null;
		System.out.println("Enter the input string: ");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			input = br.readLine();
			char[] x = input.toCharArray();
			for(int i = x.length-1;i>=0;i--) {
				System.out.print(x[i]);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
 