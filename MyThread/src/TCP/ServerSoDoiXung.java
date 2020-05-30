package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSoDoiXung {

	public static void main(String[] args) throws IOException {

		ServerSocket server = new ServerSocket(7000);
		System.out.println("Server started!");
		Socket socket = server.accept();
		DataInputStream din = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		while(true) {
				ServerSoDoiXung bt = new ServerSoDoiXung();
				String so = din.readUTF();
				int n = Integer.parseInt(so);
				boolean dao = bt.soDoiXung(n);
				if(dao == true) {
					dos.writeUTF(n + " la so doi xung");
					dos.writeUTF("Chuong trinh ket thuc!!");
					break;
				}else {
					dos.writeUTF(n + " khong phai la so doi xung");
				}
				dos.flush();
			}
	}
	
	public boolean soDoiXung(int n) {
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
}
