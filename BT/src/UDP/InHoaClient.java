package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class InHoaClient {

	public static void main(String[] args) throws Exception {
		DatagramSocket clientSocket = new DatagramSocket();
		System.out.println("Client is connected!");
		InetAddress IPAddress = InetAddress.getByName("localhost");
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap chuoi: ");
		String st = sc.nextLine();
		sendData = st.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress,3443);
		clientSocket.send(sendPacket);
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		//nhan du lieu tu server
		clientSocket.receive(receivePacket);
		String st1 = new String(receivePacket.getData());
		System.out.println(st1);
	}

}
