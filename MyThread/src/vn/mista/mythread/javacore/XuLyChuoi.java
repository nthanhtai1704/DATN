package vn.mista.mythread.javacore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class XuLyChuoi {
	public String nhapChuoi() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		return s;
	}

	public int nhapSo() throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(reader);
		String s = br.readLine();
		return Integer.parseInt(s);
	}
	
	public char[] inHoa(char[] c) {
		for(int i =0; i <c.length; i++) {
			if(c[i]>='A' && c[i] <'Z') {
				c[i]+=32;
			}else if(c[i]>='a' && c[i]<='z') {
				c[i]-=32;
			}
		}
		return c;
	}
	
	
	 public String inHoaThuong(String st) {
		 String st1 = "";
		 for(int i=0; i < st.length()-1; i++) {
			if(st.charAt(i)>=65 && st.charAt(i) <90) { 
				st1+= st.toUpperCase(); 
			}else if(st.charAt(i)>=97 && st.charAt(i) <122) {
				st1+= st.toLowerCase();
				}
			}
			 return st1;
	 }
	 
	 public int soTuCoTrongChuoi(String st) {
		return st.length();
	 }
	 
	 public boolean soDoiXung(int n) {
		 	int res =0, tmp = n;
		 	while(tmp>0) {
		 		res = res*10 + tmp%10;
		 		tmp/=10;
		 	}
		 	if(res ==n) {
		 		return true;
		 	}else {
		 		return false;
		 	}
		}
	 
	 public static String nguyenAm(String st) {
		 char c;
		 String st1 = "";
		 for(int i = 0; i<=st.length()-1;i++) {
			 if (st.charAt(i)=='a'|| st.charAt(i)=='o'||
					 st.charAt(i)=='e'||st.charAt(i)=='u'||st.charAt(i)=='y'
					 ||st.charAt(i)=='i') {
				 	c = st.charAt(i);
				 	st1= st1+c + " ";
			 }
		 }
		 return st1;
	 }
	public static void main(String[] args) throws IOException {
		XuLyChuoi bt = new XuLyChuoi();
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Nhap chuoi: ");
		 String st = sc.nextLine();
		 
		 String dao = bt.daoChuoi(st);
		 System.out.println(dao);
		/*
		 * System.out.println("Nhap so: "); int so
		 * = bt.nhapSo(); boolean dao; dao = bt.soDoiXung(so); if(dao==true) {
		 * System.out.println("So doi xung"); }else {
		 * System.out.println("So khong doi xung"); }
		 */
		
	}
	public String daoChuoi(String st){
		char c;
		String st1 = "";
		for(int i = st.length()-1; i >= 0 ; i--) {
			c = (char)st.charAt(i);
			st1 = st1+c;
		}
		return st1;
	}
	/*public static void main(String[] args) throws IOException {
		XuLyChuoi bt = new XuLyChuoi();
		System.out.println("Nhap chuoi: ");
		String s = bt.nhapChuoi();
		String chuoiDao = bt.daoChuoi(s);
		System.out.println(chuoiDao);

	}
*/
}
