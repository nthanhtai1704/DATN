package udn.ute.bt.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DocFile {

	public static void main(String[] args) throws IOException {
		File file = new File("test.txt");
		FileInputStream fileInputStream = new FileInputStream(file);
		
		int c = fileInputStream.read();
		while(c!=-1) {
			System.out.print((char)c);
			c=fileInputStream.read();
		}
		fileInputStream.close();
	}
}
