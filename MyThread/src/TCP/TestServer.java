package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(3443);
		System.out.println("Server is started");
		Socket socket = server.accept();
		DataInputStream din = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		while(true) {
			String nStr = din.readUTF();
			int n = Integer.parseInt(nStr);
			boolean a = TestServer.soDoiXng(n);
			if(a == true) {
				dos.writeUTF(n + "la so doi xung");
			}else {
				dos.writeUTF(n + "khong la so doi xung");
			}
			dos.flush();
		}

	}
	
	public static boolean soDoiXng(int n) {
		int dao = 0, tam = n;
		while(tam > 0) {
			dao = dao*10 + tam%10;
			tam/=10;
		}
		if(dao == n) {
			return true;
		}else {
			return false;
		}
	}

}
