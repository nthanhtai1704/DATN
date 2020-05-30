package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerInHoaInThuong {

	public static void main(String[] args) throws IOException {

		xuLy();
	}

	public static void xuLy() throws IOException {
		 ServerSocket server = new ServerSocket(2222);
			System.out.println("Server đã bắt đầu!");
			Socket socket = server.accept();
			DataInputStream din = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			while(true){
				String st = din.readUTF();
				String inHoa = inHoa(st);
				dos.writeUTF("In hoa: " + inHoa);
				String inThuong = inThuong(st);
				dos.writeUTF("In thuong: "+inThuong);
				dos.flush();
			}
	 }
	public static String inHoa(String st ) {
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
	
	public static String inThuong(String st ) {
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
	
}
