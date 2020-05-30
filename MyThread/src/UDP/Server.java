package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {

	public static void main(String[] args) throws IOException {
		DatagramSocket serverSocket = new DatagramSocket(4567);
		System.out.println("Server is started");
		byte[] receiveData = new byte[1024];
		byte[] receiveData1 = new byte[1024];
		byte[] receiveData2 = new byte[1024];
		byte[] sendData = new byte[1024];
		while (true) {
			// Tao goi rong de nhan du lieu
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			DatagramPacket receivePacket1 = new DatagramPacket(receiveData1, receiveData1.length);
			DatagramPacket receivePacket2 = new DatagramPacket(receiveData2, receiveData2.length);
			// Nhan du lieu tu client
			serverSocket.receive(receivePacket);
			serverSocket.receive(receivePacket1);
			serverSocket.receive(receivePacket2);
			// Lay dia chi IP cua may client
			InetAddress IPAddress = receivePacket.getAddress();
			// Lay port cua chuong trinh client
			int port = receivePacket.getPort();
			String aStr = new String(receivePacket.getData());
			int a = Integer.parseInt(aStr.trim());
			
			String bStr = new String(receivePacket1.getData());
			int b = Integer.parseInt(bStr.trim());
			String cStr = new String(receivePacket2.getData());
			int kq =0;
			switch (cStr.trim()) {
			case "-":
				kq = a-b;
				break;
			case "+":
				kq = a+b;
				break;
			case "*":
				kq = a*b;
				break;
			case "/":
				kq = a/b;
				break;
			}
			String kqStr = String.valueOf(kq);
			sendData = kqStr.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,IPAddress,port);
			serverSocket.send(sendPacket);
			
		}
	}
}