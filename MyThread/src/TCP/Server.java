package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(7000);
		System.out.println("Started is Server!");
		Socket socket = server.accept();
		DataInputStream din = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		while(true) {
			Server bt = new Server();
			String st = din.readUTF();
			//Dao chuoi
			String dao = bt.daoChuoi(st);
			dos.writeUTF("Dao chuoi:" + dao);
			//In hoa
			String inHoa = bt.inHoa1(st);
			dos.writeUTF("In hoa:" + inHoa);
			//IN thuong
			String inThuong = bt.inThuong(st);
			dos.writeUTF("In thuong: " + inThuong);
			//Vua thuong vua hoa
			String hoaThuong = bt.vuaHoaVuaThuong(st);
			dos.writeUTF("Vua thuong vua hoa: " + hoaThuong);
			// so tu co trong chuoi
			int n = bt.soTuCoTrongChuoi(st);
			dos.writeUTF("So tu co trong chuoi: "+n);
			//nguyen am
			String nguyenAm = bt.nguyenAm(st);
			dos.writeUTF(nguyenAm + "la nguyen am co trong chuoi!");
			dos.flush();
		}
		
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
	
	public String inHoa1(String st ) {
		char c;
		String st1 = "";
		for(int i=0; i < st.length(); i++) {
			if(st.charAt(i)>=97 && st.charAt(i)<122) {
				int a= st.charAt(i) - 32;
				c = (char) a;
				st1 +=c;
			}else {
				int a= st.charAt(i);
				c = (char) a;
				st1 +=c;
			}
		}
		return st1;
	}
	
	public String inThuong(String st ) {
		char c;
		String st1 = "";
		for(int i=0; i < st.length(); i++) {
			if(st.charAt(i)>=65 && st.charAt(i)<90) {
				int a= st.charAt(i) + 32;
				c = (char) a;
				st1 +=c;
			}else {
				int a= st.charAt(i);
				c = (char) a;
				st1 +=c;
			}
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
	
	//Nguyen am
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
	 public int soTuCoTrongChuoi(String st) {
			return st.length();
	}
}
