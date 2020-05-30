package TCP;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TCPTimeServer {

	public static void main(String[] args) throws IOException {
		ServerSocket server =  new ServerSocket(8977);
		System.out.println("Server is started");
		while(true) {
		Socket socket = server.accept();
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		String time = new Date().toString();
		dos.writeUTF ( "Server tra lai ngay gio: " + time);
		socket.close();
		}
	}
}
