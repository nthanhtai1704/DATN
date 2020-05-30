package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSoNguyenTo {

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
				String aStr = din.readUTF();
				int a = Integer.parseInt(aStr);
				if(isNguyenTo(a)==true) {
					dos.writeUTF(a + " la so nguyen to!");
				}else {
					dos.writeUTF(a + " khong phai la so nguyen to");
				}
				dos.flush();
			}
	 }
	
	public static boolean isNguyenTo(int n) {
		//so nguyen nho hon 2 khong phai la so nguyen to
		if(n<2) {
			return false;
		}
		//check so nguyen to khi lon hon 2
		int x = (int)Math.sqrt(n);
		for(int i = 2 ; i<=x ; i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
}
