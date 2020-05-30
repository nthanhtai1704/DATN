package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;
import java.util.Scanner;

public class ChatServerUDP {

	public static void main(String[] args) throws IOException {
		//Gan cong cho chuong trinh
		DatagramSocket serverSocket = new DatagramSocket(9876);
		System.out.println("Server is started");
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		while(true) {
			//Tao goi rong de nhan du lieu
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			//Nhan du lieu tu client
			serverSocket.receive(receivePacket);
			//Lay dia chi IP cua may client
			InetAddress IPAddress = receivePacket.getAddress();
			// Lay port cua chuong trinh client
			int port = receivePacket.getPort();
			//Lay ngay gio de gui lai cho client
			Scanner sc = new Scanner(System.in);
			String request = sc.nextLine();
			sendData= request.getBytes();
			
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,IPAddress,port); 
			//Gui du lieu cho client
			serverSocket.send(sendPacket);
			
		}
	}
}
