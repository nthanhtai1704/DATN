package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientSum2So {

	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket socket = new Socket("localhost",1234);
		DataInputStream din = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new  DataOutputStream(socket.getOutputStream());
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Nhập số thứ 1: ");
			String a = sc.nextLine();
			System.out.println("Nhập số thứ 2: ");
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
