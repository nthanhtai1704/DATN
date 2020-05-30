import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GiaoDien  extends JFrame implements ActionListener{

	
	private static final long serialVersionUID = 1L;
		//tao cac text
		JButton	btn_hv,btn_hcn,btn_thoat,btn_htron,btn_hthoi;
		JLabel lb_bt;
		JPanel panelMain;
		public GiaoDien() {
			super("BÀI TẬP VỀ NHÀ");
			
			btn_hv = new JButton("Hình vuông");
			btn_hcn = new JButton("Hình chữ nhật");
			btn_htron = new JButton("Hình tròn");
			btn_hthoi = new JButton("Hình thoi");
			btn_thoat = new JButton("Exit");
			lb_bt = new JLabel("                                BÀI TẬP VỀ NHÀ");
			//new form
			panelMain = new JPanel();
			//setform
			panelMain.setLayout(new GridLayout(6, 1));
			//add into form
			panelMain.add(lb_bt);
			panelMain.add(btn_hv);
			panelMain.add(btn_hcn);
			panelMain.add(btn_htron);
			panelMain.add(btn_hthoi);
			panelMain.add(btn_thoat);
			
			this.add(panelMain);
			
			btn_hcn.addActionListener(this);
			btn_hv.addActionListener(this);
			btn_htron.addActionListener(this);
			btn_hthoi.addActionListener(this);
			btn_thoat.addActionListener(this);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btn_hv) {
				HinhVuong giaodien = new HinhVuong();
				giaodien.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				giaodien.setVisible(true);
				giaodien.setSize(500,300);
			}
			if(e.getSource() == btn_hcn) {
				HinhChuNhat giaodien = new HinhChuNhat();
				giaodien.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				giaodien.setVisible(true);
				giaodien.setSize(500,300);
			}
			if(e.getSource() == btn_htron) {
				HinhTron giaodien = new HinhTron();
				giaodien.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				giaodien.setVisible(true);
				giaodien.setSize(500,300);
			}
			if(e.getSource() == btn_hthoi) {
				HinhThoi giaodien = new HinhThoi();
				giaodien.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				giaodien.setVisible(true);
				giaodien.setSize(500,300);
			}
			if(e.getSource() == btn_thoat) {
				System.exit(0);
			}
			
		}
		
}