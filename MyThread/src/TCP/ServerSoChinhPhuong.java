package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerSoChinhPhuong {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(6969);
		System.out.println("Server đã bắt đầu!");
		Socket socket = server.accept();
		DataInputStream din = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		
		while(true) {
			String st = din.readUTF();
			int n = Integer.parseInt(st);
			boolean soCP = soChinhPhuong(n);
			if(soCP) {
				dos.writeUTF(n+ " la so chinh phuong");
			}else {
				dos.writeUTF(n+ " khong phai la so chinh phuong");
			}
			dos.flush();
		}
		
	}
	
	public static boolean soChinhPhuong(int n) {
		int x = (int) Math.sqrt(n);
		if(x*x == n) {
			return true;
		}else {
			return false;
		}
	}
}
