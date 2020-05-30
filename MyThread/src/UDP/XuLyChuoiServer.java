package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class XuLyChuoiServer {

	public static void main(String[] args) throws IOException {
		DatagramSocket serverSocket = new DatagramSocket(3443);
		System.out.println("Server is started");
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		byte[] sendData1 = new byte[1024];
		byte[] sendData2 = new byte[1024];
		byte[] sendData3 = new byte[1024];
		byte[] sendData4 = new byte[1024];
		byte[] sendData5 = new byte[1024];
		while (true) {
			// Tao goi rong de nhan du lieu
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			// Nhan du lieu tu client
			serverSocket.receive(receivePacket);
			// Lay dia chi IP cua may client
			InetAddress IPAddress = receivePacket.getAddress();
			// Lay port cua chuong trinh client
			int port = receivePacket.getPort();
			XuLyChuoiServer bt = new XuLyChuoiServer();
			String request = new String(receivePacket.getData());
			sendData = XuLyChuoiServer.thuongHoa(request).getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
			sendData1 = XuLyChuoiServer.inThuong(request).getBytes();
			DatagramPacket senPacket1 = new DatagramPacket(sendData1, sendData1.length, IPAddress, port);
			sendData2 = XuLyChuoiServer.vuaHoaVuaThuong(request).getBytes();
			DatagramPacket senPacket2 = new DatagramPacket(sendData2, sendData2.length, IPAddress, port);
			sendData3 = XuLyChuoiServer.daoChuoi(request).getBytes();
			DatagramPacket senPacket3 = new DatagramPacket(sendData3, sendData3.length, IPAddress, port);
			sendData4 = XuLyChuoiServer.nguyenAm(request).getBytes();
			DatagramPacket senPacket4 = new DatagramPacket(sendData4, sendData4.length, IPAddress, port);
			
			int n = XuLyChuoiServer.soTuCoTrongChuoi(request);
			String nStr = String.valueOf(n);
			sendData5 = nStr.getBytes();
			DatagramPacket senPacket5 = new DatagramPacket(sendData5, sendData5.length, IPAddress, port);
			// Gui du lieu cho client
			serverSocket.send(sendPacket);
			serverSocket.send(senPacket1);
			serverSocket.send(senPacket2);
			serverSocket.send(senPacket3);
			serverSocket.send(senPacket4);
			serverSocket.send(senPacket5);
		}
	}

	public static String daoChuoi(String st){
		char c;
		String st1 = "";
		for(int i = st.length()-1; i >= 0 ; i--) {
			c = st.charAt(i);
			if(c >='A'&& c <='Z') {
				st1 = st1+c;
			}else if(c >='a' && c <='z') {
				st1= st1+c;
			}
		}
		return st1;
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

	public static String inThuong(String st) {
		String temp = "";
		for (int i = 0; i < st.length(); i++) {
			char c = st.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				c = (char) (c + 32);
			}
			temp += c;
		}
		return temp;
	}

	public static String inHoa(String st) {
		char c;
		String st1 = "";
		for (int i = 0; i < st.length(); i++) {
			if (st.charAt(i) >= 97 && st.charAt(i) < 122) {
				int a = st.charAt(i) - 32;
				c = (char) a;
				st1 += c;
			} else {
				int a = st.charAt(i);
				c = (char) a;
				st1 += c;
			}
		}
		return st1;
	}

	public static String vuaHoaVuaThuong(String st) {
		char c;
		String st1 = "";
		for (int i = 0; i < st.length(); i++) {
			if (st.charAt(i) >= 65 && st.charAt(i) < 90) {
				int a = st.charAt(i) + 32;
				c = (char) a;
				st1 += c;
			} else if (st.charAt(i) >= 97 && st.charAt(i) < 122) {
				int a = st.charAt(i) - 32;
				c = (char) a;
				st1 += c;
			}
		}
		return st1;

	}

	// Nguyen am
	public static String nguyenAm(String st) {
		char c;
		String st1 = "";
		for (int i = 0; i <= st.length() - 1; i++) {
			if (st.charAt(i) == 'a' || st.charAt(i) == 'o' || st.charAt(i) == 'e' || st.charAt(i) == 'u'
					|| st.charAt(i) == 'y' || st.charAt(i) == 'i') {
				c = st.charAt(i);
				st1 = st1 + c + " ";
			}
		}
		return st1;
	}
	//so tu co trong chuoi
	public static int soTuCoTrongChuoi(String st) {
		return st.length();
	}

}
