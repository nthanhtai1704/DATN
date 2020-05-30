package vn.mista.mythread.thread;

public class TestThread4 implements Runnable{
	public int tong;
	
	public TestThread4() {
		this.tong = 2000;
	}

	//synchronized đồng bộ hóa, nếu t1 truy xuất vào trước thì t2 phải 
	//đợi đến khi nào t1 làm việc xong thì t2 mới được vào làm việc
	public synchronized void rutTien() throws InterruptedException {
		if(tong > 0) {
			Thread.sleep(1000);
			tong = tong - 1000;
			System.out.println(tong);
		}else {
			System.out.println("Khong con tien");
		}
	}
	
	 @Override
	public void run() {
		 try {
			rutTien();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 public static void main(String[] args) {
		TestThread4 t = new TestThread4();
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		
		t1.start();
		t2.start();
	}
}
