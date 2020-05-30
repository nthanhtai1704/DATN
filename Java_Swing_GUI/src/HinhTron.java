import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HinhTron extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static double dienTichHTron(double r) {
		return Math.PI * r * r;
	}

	public static double chuViHTron(double r) {
		return 2 * Math.PI * r;
	}

	// tao cac text
	JTextField txt_canh_a;
	JButton btn_dthv, btn_cvhv, btn_thoat;
	JLabel lb_canha;
	JPanel panelMain;

	public HinhTron() {
		super("Hình Tròn");

		txt_canh_a = new JTextField();
		btn_cvhv = new JButton("Chu Vi H.Tròn");
		btn_dthv = new JButton("Diện Tích H.Tròn");
		lb_canha = new JLabel("Nhập bán kính : ");
		// tạo form
		panelMain = new JPanel();
		// setform
		panelMain.setLayout(new GridLayout(2, 2));
		// add vào form
		panelMain.add(lb_canha);
		panelMain.add(txt_canh_a);
		panelMain.add(btn_cvhv);
		panelMain.add(btn_dthv);

		this.add(panelMain);

		btn_cvhv.addActionListener(this);
		btn_dthv.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == btn_cvhv) {
				String canhaStr = txt_canh_a.getText().toString();

				double a = Double.parseDouble(canhaStr);
				JOptionPane.showMessageDialog(null, "Chu vi hình tròn là : " + chuViHTron(a) + "");

			}
			if (e.getSource() == btn_dthv) {
				String canhaStr = txt_canh_a.getText().toString();

				double a = Double.parseDouble(canhaStr);
				JOptionPane.showMessageDialog(null, "Diện tích hình tròn là : " + dienTichHTron(a) + "");

			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Xin mời nhập giá trị!!!");
		}
	}
}