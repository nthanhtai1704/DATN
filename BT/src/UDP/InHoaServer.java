package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class InHoaServer {

	public static void main(String[] args) throws IOException {
		DatagramSocket serverSocket = new DatagramSocket(3443);
		System.out.println("Server is started");
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		byte[] sendData1 = new byte[1024];
		while(true) {
			//Tao goi de nhan du lieu
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			//nhan du lieu tu client
			serverSocket.receive(receivePacket);
			//Lay dia chi IP cua client
			InetAddress IPAddress = receivePacket.getAddress();
			//Lay port cua chhuong trinh client
			int port = receivePacket.getPort();
			String request = new String(receivePacket.getData());
			sendData = InHoaServer.inHoa(request).getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length , IPAddress,port);
			serverSocket.send(sendPacket);
			sendData1 = InHoaServer.inThuong(request).getBytes();
			DatagramPacket sendPacket1 = new DatagramPacket(sendData1, sendData1.length , IPAddress,port);
			serverSocket.send(sendPacket1);
		}
	}
	
	public static String inHoa(String st) {
		String temp = "";
		for(int i =0; i<st.length();i++) {
			char c = st.charAt(i);
			if(c >='a'&& c<='z') {
				c = (char)(c-32);
			}
			temp+=c;
		}
		return temp;
	}
	
	public static String inThuong(String st) {
		String temp="";
		for(int i =0; i<st.length();i++) {
			char c = st.charAt(i);
			if(c>='A' && c <='Z') {
				c=(char)(c+32);
			}
			temp+=c;
		}
		return temp;
	}

}
