package udn.ute.threaddemo;

public class MyThreadRunnable implements Runnable{
 
		@Override
		public void run() {

			for(int i = 1; i < 10; i++) {
				System.out.println("Runnable " + i);
			}
		}
}
