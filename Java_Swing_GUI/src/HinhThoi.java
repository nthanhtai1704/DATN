import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HinhThoi extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static double dienTichThoi(double d1, double d2) {
		return (d1 * d2) / 2;
	}

	public static double chuViThoi(double canh) {
		return canh * 4;
	}

	// tao cac text
	JTextField txt_canh_a, txt_canh_b, txt_canh_c;
	JButton btn_dthcn, btn_cvhcn;
	JLabel lb_canha, lb_canhb, lb_canhc, lb_thongbao,lb_thongbao1;
	JPanel panelMain;

	public HinhThoi() {
		super("Hình Thoi");

		txt_canh_a = new JTextField();
		txt_canh_b = new JTextField();
		txt_canh_c = new JTextField();
		btn_cvhcn = new JButton("CV Hình thoi");
		btn_dthcn = new JButton("DT Hình Thoi");
		lb_canha = new JLabel("Đường chéo 1: ");
		lb_canhb = new JLabel("Đường chéo 2: ");
		lb_canhc = new JLabel("Cạnh: ");
		lb_thongbao = new JLabel("Nhập đường chéo để tính diện tích");
		lb_thongbao1 = new JLabel("Nhập cạnh để tính chu vi");
		// tạo form
		panelMain = new JPanel();
		// setform
		panelMain.setLayout(new GridLayout(5, 2));
		// add vào form
		panelMain.add(lb_thongbao);
		panelMain.add(lb_thongbao1);
		panelMain.add(lb_canha);
		panelMain.add(txt_canh_a);
		panelMain.add(lb_canhb);
		panelMain.add(txt_canh_b);
		panelMain.add(lb_canhc);
		panelMain.add(txt_canh_c);
		panelMain.add(btn_cvhcn);
		panelMain.add(btn_dthcn);

		this.add(panelMain);

		btn_cvhcn.addActionListener(this);
		btn_dthcn.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == btn_dthcn) {
				String canhaStr = txt_canh_a.getText().toString();
				String canhbStr = txt_canh_b.getText().toString();

				double d1 = Double.parseDouble(canhaStr);
				double d2 = Double.parseDouble(canhbStr);
				if (d1 != d2) {
					JOptionPane.showMessageDialog(null, "Diện tích hình thoi là : " + dienTichThoi(d1, d2) + "");
				} else {
					JOptionPane.showMessageDialog(null, "Không phải hình thoi! Xin mời nhập lại");
				}
			}
			if (e.getSource() == btn_cvhcn) {
				String canhStr = txt_canh_c.getText().toString();

				double canh = Double.parseDouble(canhStr);
				JOptionPane.showMessageDialog(null, "Chu vi hình thoi là : " + chuViThoi(canh) + "");
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Xin mời nhập giá trị!!!");
		}

	}
}