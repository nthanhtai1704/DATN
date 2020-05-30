package udn.ute.bt.java;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket socket = new Socket("localhost",6969);
		DataInputStream din = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap chuoi: ");
		while(true) {
			String st = sc.nextLine();
			dos.writeUTF(st);
			dos.flush();
			String kq = din.readUTF();
			System.out.println(kq);
			socket.close();
		}
	}

}
