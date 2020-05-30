package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThiServer {
	public static final String BASE = "0123456789ABCDEFGHIJKLMOPQRSTUVXYZW";

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(7000);
		System.out.println("Started is Server!");
		Socket socket = server.accept();
		DataInputStream din = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		while(true) {
			String st = din.readUTF();
			int n = Integer.parseInt(st);
			String kq = result(n, 2);
			int a = Integer.parseInt(kq);
			if(soDoiXung(a) ==true) {
				dos.writeUTF(n+" = "+a + " la so doi xung");
				dos.writeUTF("Chuong trinh dung!!!");
				socket.close();
				break;
			}else {
				dos.writeUTF(n+" = " +a + " khong phai la so doi xung");
			}
		}

	}
	
	public static boolean soDoiXung(int n) {
	 	int dao =0, tam = n;
	 	while(tam>0) {
	 		dao = dao*10 + tam%10;
	 		tam/=10;
	 	}
	 	if(dao==n) {
	 		return true;
	 	}else {
	 		return false;
	 	}
	}
	public static String result(int n, int b) {
		StringBuilder builder =  new StringBuilder();
		int x = 0 ;
		while(n>0) {
			x = n%b;
			n/= b;
			builder.append(BASE.charAt(x));
		}
		return builder.reverse().toString();
	}
}
