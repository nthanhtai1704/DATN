package udn.ute.bt.java;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public void ketNoi() throws IOException {
		ServerSocket server = new ServerSocket(6969);
		System.out.println("Server started! ");
		Socket socket = server.accept();
		DataInputStream din = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		while(true) {
			Server bt = new Server();
			String st = din.readUTF();
			String inHoa = bt.inHoa(st);
			dos.writeUTF("In hoa cua chuoi: "+ inHoa);
			dos.flush();
			server.close();
		}
	}
	public static void main(String[] args) throws IOException {
		Server server = new Server();
		server.ketNoi();
	}
	public String inHoa(String st) {
		return st.toUpperCase();
	}
}
