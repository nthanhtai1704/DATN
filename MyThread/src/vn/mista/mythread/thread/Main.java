package vn.mista.mythread.thread;

public class Main {
	public static void main(String[] args) {
		//implements Runnable
		//MyThread1 thread1 = new MyThread1();
		Thread thread1 = new Thread(new MyThread1());
		
		//extends Thread
		MyThread2 thread2 = new MyThread2(); 
		
		thread1.start();
		thread2.start();
	}
}
