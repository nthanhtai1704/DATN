import javax.swing.JFrame;

public class Main extends Thread {
	public static void main(String[] args) {
		Main rucomponent = new Main();
		rucomponent.start();
	}

	@Override
	public void run() {
		GiaoDien giaodien = new GiaoDien();
		giaodien.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		giaodien.setVisible(true);
		giaodien.setSize(300,300);
	}
}