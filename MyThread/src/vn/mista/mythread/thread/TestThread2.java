package vn.mista.mythread.thread;

public class TestThread2 extends Thread {
	@Override
	public void run() {
		for(int i = 0; i <5; i++) {
			try {
				TestThread2.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(this.getName() + " " + i);
		}
	}
	public static void main(String[] args) {
		TestThread2 t1 = new TestThread2();
		t1.setName("Thread1");
		
		TestThread2 t2 = new TestThread2();
		t2.setName("Thread2");
		
		TestThread2 t3 = new TestThread2();
		t3.setName("Thread3");
		
		t1.start();
		try {
			t1.join(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		t3.start();
		
		
	}
}
