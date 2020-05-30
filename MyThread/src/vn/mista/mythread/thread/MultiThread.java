package vn.mista.mythread.thread;

class Sys {
	public void display() {
		for (int i = 1; i < 10; i += 2) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}
		}
	}
}

class MultiThread extends Thread {
	static Sys a = new Sys();

	@Override
	public void run() {
		synchronized (a) {
			a.display();
		}
	}


		public static void main(String[] args) {
			MultiThread m = new MultiThread();
			MultiThread n = new MultiThread();
			m.start();
			n.start();
		}
	}
