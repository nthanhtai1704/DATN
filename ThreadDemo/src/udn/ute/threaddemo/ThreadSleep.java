package udn.ute.threaddemo;

public class ThreadSleep extends Thread {

	@Override
	public void run() {
		for(int i =1; i<5 ; i ++) {
			try {
				// Sleep 1000 mili giây
				ThreadSleep.sleep(1000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//in ra màn hình
			System.out.println(this.getName() + " " + i);
		}
	}
	public static void main(String[] args) {
		ThreadSleep t1 = new ThreadSleep();
		//set tên cho thread
		t1.setName("Lập trình mạng");
		t1.start();
	}
}
