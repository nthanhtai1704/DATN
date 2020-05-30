
package vn.mista.mythread.javacore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InHoaThuongChuoi {

	public String nhapChuoi() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		return s;
		
	}
	
	public String inHoa(String st ) {
		char c;
		String st1 = "";
		for(int i=0; i < st.length(); i++) {
			int a= st.charAt(i) - 32;
			c = (char) a;
			st1 +=c;
			}
		return st1;
		}
		
	public String inThuong(String st ) {
		char c;
		String st1 = "";
		for(int i=0; i < st.length(); i++) {
			int a= st.charAt(i) + 32;
			c = (char) a;
			st1 +=c;
			}
		return st1;
		}
	
	public String vuaHoaVuaThuong(String st) {
		char c;
		String st1 = "";
		for(int i=0; i < st.length(); i++) {
			if(st.charAt(i)>=65 && st.charAt(i)<90) {
				int a= st.charAt(i) + 32;
				c = (char) a;
				st1 +=c;
			}else if(st.charAt(i)>=97 && st.charAt(i)<122) {
				int a= st.charAt(i) - 32;
				c = (char) a;
				st1 +=c;
			}
		}
		return st1;
	
	}
	public static void main(String[] args) {
		InHoaThuongChuoi bt = new InHoaThuongChuoi();
		String a;
		try {
			System.out.println("Nhap chuoi: ");
			a = bt.nhapChuoi();
			String st = bt.vuaHoaVuaThuong(a);
			System.out.println(st);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
