package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class XuLySoServer {

	public static final String BASE = "0123456789ABCDEFGHIJKLMOPQRSTUVXYZW";
	public static void main(String[] args) throws IOException {
		DatagramSocket serverSocket = new DatagramSocket(4567);
		System.out.println("Server is started");
		byte[] receiveData = new byte[1024];
		byte[] receiveData1 = new byte[1024];
		byte[] sendData = new byte[1024];
		while (true) {
			// Tao goi rong de nhan du lieu
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			DatagramPacket receivePacket1 = new DatagramPacket(receiveData1, receiveData1.length);
			// Nhan du lieu tu client
			serverSocket.receive(receivePacket);
			serverSocket.receive(receivePacket1);
			// Lay dia chi IP cua may client
			InetAddress IPAddress = receivePacket.getAddress();
			// Lay port cua chuong trinh client
			int port = receivePacket.getPort();
			String soStr = new String(receivePacket.getData());
			int so = Integer.parseInt(soStr.trim());
			
			String bStr = new String(receivePacket1.getData());
			int heSo = Integer.parseInt(bStr.trim());
			
			
			
			String kqStr = result(so, heSo);
			sendData = kqStr.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,IPAddress,port);
			serverSocket.send(sendPacket);
			
		}
	}

	public static String result(int n, int b) {
		StringBuilder builder =  new StringBuilder();
		int x = 0 ;
		while(n>0) {
			x = n%b;
			n/= b;
			builder.append(BASE.charAt(x));
		}
		
		return builder.reverse().toString();
		
	}

}
