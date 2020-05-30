package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerBCNN {

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
				String bStr = din.readUTF();
				int b = Integer.parseInt(bStr);
				int kq = BCNN(a, b);
				dos.writeUTF("BCNN: " + kq);
				dos.flush();
			}
	 }

	public static int BCNN(int a, int b) {
		while(a!=b) {
			if(a>b) {
				a = a-b;
			}else {
				b = b-a;
			}
		}
		return (a*b)/a;
	}
}
