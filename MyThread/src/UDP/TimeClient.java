package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class TimeClient {

	public static void main(String[] args) throws IOException {
		DatagramSocket clientSocket = new DatagramSocket();//gan cong
		InetAddress IPAddress = InetAddress.getByName("localhost");
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		sendData = "getDate".getBytes();
		//tao datagram co noi dung yeu cau loai du lieu de fui cho server
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress,9876);
		clientSocket.send(sendPacket);//gui du lieu cho server
		//tao datagram rong de nhan du lieu
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		//nhan du lieu tu server
		clientSocket.receive(receivePacket);
		//lay du lieu tu server nhan duoc
		String st = new String(receivePacket.getData());
		System.out.println(st);
		clientSocket.close();
		
	}

}
