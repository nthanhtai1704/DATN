package udn.ute.threaddemo;

public class Main {
	public static void main(String[] args) {
		MyThreadRunnable runnable = new MyThreadRunnable();
		Thread t1 = new Thread(runnable);
		
		MyThreadThread t2 = new MyThreadThread();
		
		t1.start();
		t2.start();
	}
}
