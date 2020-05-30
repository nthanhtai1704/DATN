package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSum2So {

	public static void main(String[] args) throws IOException {

		ServerSocket server = new ServerSocket(1234);
		System.out.println("Server đã bắt đầu!");
		Socket socket = server.accept();
		DataInputStream din = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		while(true) {
			String aStr = din.readUTF();
			int a = Integer.parseInt(aStr);
			String bStr = din.readUTF();
			int b = Integer.parseInt(bStr);
			int kq = sum2So(a, b);
			dos.writeUTF("Tổng 2 số: "+ kq);
			dos.flush();
		}
	}

	
	public static int sum2So(int a, int b) {
		return a +b;
	}
}
