package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.xml.crypto.Data;

public class ClientBCNN {

	public static void main(String[] args) throws UnknownHostException, IOException {
		xuLy();
	}

	public static void xuLy() throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost",2222);
		System.out.println("Client đã kết nối!");
		DataInputStream din =  new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("Nhap a: ");
			String a = sc.nextLine();
			System.out.print("Nhap b: ");
			String b = sc.nextLine();
			dos.writeUTF(a);
			dos.flush();
			dos.writeUTF(b);
			dos.flush();
			String kq = din.readUTF();
			System.out.println(kq);
		}
	}
}
