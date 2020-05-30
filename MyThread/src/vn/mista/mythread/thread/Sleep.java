package vn.mista.mythread.thread;


class A extends Thread{
		@Override
		public void run() {
			for(int i = 0 ; i<10;i++) {
				System.out.println(i+" ");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
class B extends Thread{
		@Override
		public void run() {
			for(int i = 0; i<10; i++) {
				System.out.println((char)(i+65));
				try {
					Thread.sleep(2500);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
class C {
		public static void main(String a[]) {
			new A().start();
			new B().start();
	}
}


