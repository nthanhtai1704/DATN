import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HinhChuNhat extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	public static double dienTichHCN(double cd, double cr) {
		return cd * cr;
	}

	public static double chuViCN(double cd, double cr) {
		return (cd + cr) * 2;
	}

	// tao cac text
	JTextField txt_canh_a, txt_canh_b;
	JButton btn_dthcn, btn_cvhcn;
	JLabel lb_canha, lb_canhb;
	JPanel panelMain;

	public HinhChuNhat() {
		super("Hình Chữ Nhật");

		txt_canh_a = new JTextField();
		txt_canh_b = new JTextField();
		btn_cvhcn = new JButton("Chu Vi HCN");
		btn_dthcn = new JButton("Diện tích HCN");
		lb_canha = new JLabel("Chiều dài: ");
		lb_canhb = new JLabel("Chiều rộng: ");
		// new form
		panelMain = new JPanel();
		// setform
		panelMain.setLayout(new GridLayout(3, 2));
		// add into form
		panelMain.add(lb_canha);
		panelMain.add(txt_canh_a);
		panelMain.add(lb_canhb);
		panelMain.add(txt_canh_b);
		panelMain.add(btn_cvhcn);
		panelMain.add(btn_dthcn);

		this.add(panelMain);

		btn_cvhcn.addActionListener(this);
		btn_dthcn.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == btn_cvhcn) {
				String canhaStr = txt_canh_a.getText().toString();
				String canhbStr = txt_canh_b.getText().toString();

				double cd = Double.parseDouble(canhaStr);
				double cr = Double.parseDouble(canhbStr);
				if (cd > cr) {
					JOptionPane.showMessageDialog(null, "Chu vi hình chữ nhật là : " + chuViCN(cd, cr) + "");
				} else {
					JOptionPane.showMessageDialog(null, "Không phải hình chữ nhật! Xin mời nhập lại");
				}
			}
			if (e.getSource() == btn_dthcn) {
				String canhaStr = txt_canh_a.getText().toString();
				String canhbStr = txt_canh_b.getText().toString();

				double cd = Double.parseDouble(canhaStr);
				double cr = Double.parseDouble(canhbStr);
				if (cd > cr) {
					JOptionPane.showMessageDialog(null, "Diện tích hình chữ nhật là : " + dienTichHCN(cd, cr) + "");
				} else {
					JOptionPane.showMessageDialog(null, "Không phải hình chữ nhật! Xin mời nhập lại");
				}
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Xin mời nhập giá trị!!!");
		}

	}
}