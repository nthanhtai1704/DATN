package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws IOException {
		DatagramSocket clientSocket = new DatagramSocket();//gan cong
		InetAddress IPAddress = InetAddress.getByName("localhost");
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		byte[] sendData1 = new byte[1024];
		byte[] sendData2= new byte[1024];
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap a: ");
		String st1 = sc.nextLine();
		sendData = st1.getBytes();
		System.out.print("Nhap b: ");
		String st2 = sc.nextLine();
		sendData1 = st2.getBytes();
		System.out.print("Nhap phep toan: ");
		String st3 = sc.nextLine();
		sendData2 = st3.getBytes();
		//tao datagram co noi dung yeu cau loai du lieu de gui cho server
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress,4567);
		DatagramPacket sendPacket1 = new DatagramPacket(sendData1, sendData1.length, IPAddress,4567);
		DatagramPacket sendPacket2 = new DatagramPacket(sendData2, sendData2.length, IPAddress,4567);
		//gui du lieu cho server
		clientSocket.send(sendPacket);
		clientSocket.send(sendPacket1);
		clientSocket.send(sendPacket2);
		//tao datagram rong de nhan du lieu
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		//nhan du lieu tu server
		clientSocket.receive(receivePacket);
		//lay du lieu tu server nhan duoc
		String st = new String(receivePacket.getData());
		System.out.println(st);
		
	}

}
