package vn.mista.mythread.javacore;

public class test1 {

	public static void main(String[] args) {
		String phone = "012-3456789";
		String[] output = phone.split("-");
		System.out.println(output[0]);
		System.out.println(output[1]);
	}

}
