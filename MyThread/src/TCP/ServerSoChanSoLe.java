package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSoChanSoLe {

	public static void main(String[] args) throws IOException {
		xuLy();
	}
	
	public static void xuLy() throws IOException {
		ServerSocket server = new ServerSocket(4000);
		System.out.println("Server đã bắt đầu!");
		Socket socket = server.accept();
		DataInputStream din = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		while(true) {
			String nStr = din.readUTF();
			int n = Integer.parseInt(nStr);
			if(soChanSoLe(n)==true) {
				dos.writeUTF(n+" là số chẳn");
			}else {
				dos.writeUTF(n + " là số lẻ");
			}
		}
				
	}
	
	public static boolean soChanSoLe(int n) {
		if(n%2==0) {
			return true;
		}else {
			return false;
		}
	}

}
