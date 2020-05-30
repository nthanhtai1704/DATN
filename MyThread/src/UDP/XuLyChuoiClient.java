package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class XuLyChuoiClient {

	public static void main(String[] args) throws IOException {
		DatagramSocket clientSocket = new DatagramSocket();//gan cong
		InetAddress IPAddress = InetAddress.getByName("localhost");
		byte[] receiveData = new byte[1024];
		byte[] receiveData1 = new byte[1024];
		byte[] receiveData2 = new byte[1024];
		byte[] receiveData3 = new byte[1024];
		byte[] receiveData4 = new byte[1024];
		byte[] receiveData5 = new byte[1024];
		byte[] sendData = new byte[1024];
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap chuoi: ");
		String st1 = sc.nextLine();
		sendData = st1.getBytes();
		//tao datagram co noi dung yeu cau loai du lieu de gui cho server
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress,3443);
		clientSocket.send(sendPacket);//gui du lieu cho server
		//tao datagram rong de nhan du lieu
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		DatagramPacket receivePacket1 = new DatagramPacket(receiveData1, receiveData1.length);
		DatagramPacket receivePacket2 = new DatagramPacket(receiveData2, receiveData2.length);
		DatagramPacket receivePacket3 = new DatagramPacket(receiveData3, receiveData3.length);
		DatagramPacket receivePacket4 = new DatagramPacket(receiveData4, receiveData4.length);
		DatagramPacket receivePacket5 = new DatagramPacket(receiveData5, receiveData5.length);
		//nhan du lieu tu server
		clientSocket.receive(receivePacket);
		clientSocket.receive(receivePacket1);
		clientSocket.receive(receivePacket2);
		clientSocket.receive(receivePacket3);
		clientSocket.receive(receivePacket4);
		clientSocket.receive(receivePacket5);
		//lay du lieu tu server nhan duoc
		String inHoa = new String(receivePacket.getData());
		System.out.println("In hoa:" +inHoa);
		String inThuong = new String(receivePacket1.getData());
		System.out.println("In thuong: "+inThuong);
		String vuaHoaVuaThuong = new String(receivePacket2.getData());
		System.out.println("Vua hoa vua thuong: "+vuaHoaVuaThuong);
		String daoChuoi = new String(receivePacket3.getData());
		System.out.println("Dao chuoi: "+daoChuoi);
		String nguyenAm = new String(receivePacket4.getData());
		System.out.println("Nguyen am: "+nguyenAm);
	}
}
