package udn.ute.bt.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TongCacSo {

	  public static void main(String[] args) throws IOException {

		  String input = null;
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  System.out.println("Enter the numbers to add:");
		  input = br.readLine();
		  int sum = 0;
		  for(String p : input.split(" ")) {
			  int i = Integer.parseInt(p);
			  sum+=i;
		  }
		  System.out.println("Sum= "+sum);
		 }

	}



