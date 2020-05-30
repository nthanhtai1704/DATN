package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TestClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost",3443);
		DataInputStream din = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Nhap n: ");
			String n = sc.nextLine();
			dos.writeUTF(n);
			
			String kq = din.readUTF();
			System.out.println(kq);
		}

	}

}
