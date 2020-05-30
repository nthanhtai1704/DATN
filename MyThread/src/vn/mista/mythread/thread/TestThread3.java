package vn.mista.mythread.thread;

public class TestThread3 extends Thread{
	
	@Override
	public void run() {
		for(int i =0; i< 5; i++) {
			System.out.println(this.getName() + " " + i);
		}
	}
	public static void main(String[] args) {
		TestThread3 t1 = new TestThread3();
		TestThread3 t2 = new TestThread3();
		TestThread3 t3 = new TestThread3();
		
		t1.setName("A");
		t2.setName("B");
		t3.setName("C");
		
		t1.setPriority(1); //Priority : xét độ ưu tiên
		t2.setPriority(10);
		t3.setPriority(5);
		
		/*t1.start();
		t2.start();
		t3.start();*/
		
		//deamon thread : chạy ngầm
		t1.setDaemon(true);
		System.out.println(t1.isDaemon());
	}
}
