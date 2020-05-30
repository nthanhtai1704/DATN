package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class TestUDPServer {

	public static void main(String[] args) throws IOException {
		DatagramSocket serverSocket = new DatagramSocket(3443);
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		while(true) {
			//tao goi rong de nhan du lieu
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			//nhan du lieu tu client
			serverSocket.receive(receivePacket);
			
			//Lay dia chi IP cua client
			InetAddress IPAddress = receivePacket.getAddress();
			//lay port cua client
			int port = receivePacket.getPort();
			String request = new String(receivePacket.getData());
			sendData = TestUDPServer.thuongHoa(request).getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
			//gui du lieu den client
			serverSocket.send(sendPacket);
		}

	}

	public static String thuongHoa(String st) {
		String temp = "";
		for (int i = 0; i < st.length(); i++) {
			char c = st.charAt(i);
			if (c >= 'a' && c <= 'z') {
				c = (char) (c - 32);
			}
			temp += c;
		}
		return temp;
	}

}
