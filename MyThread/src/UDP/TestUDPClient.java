package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TestUDPClient {

	public static void main(String[] args) throws IOException {
		DatagramSocket clientSocket =new DatagramSocket();
		InetAddress iPAddress = InetAddress.getByName("localhost");
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap chuoi");
		String st = sc.nextLine();
		sendData = st.getBytes();
		DatagramPacket senPacket = new DatagramPacket(sendData, sendData.length, iPAddress, 3443);
		clientSocket.send(senPacket);
		//tao goi rong nhan du lieu tu server
		
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		clientSocket.receive(receivePacket);
		
		//lay du lieu
		String inHoa = new String(receivePacket.getData());
		System.out.println(inHoa);
	}

}
