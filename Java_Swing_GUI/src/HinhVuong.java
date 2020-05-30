import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HinhVuong extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static double dienTichHV(double canh) {
		return canh * canh;
	}

	public static double chuViHV(double canh) {
		return canh * 4;
	}

	// tao cac text
	JTextField txt_canh_a;
	JButton btn_dthv, btn_cvhv, btn_thoat;
	JLabel lb_canha;
	JPanel panelMain;

	public HinhVuong() {
		super("Hình Vuông");

		txt_canh_a = new JTextField();
		btn_cvhv = new JButton("Chu vi H.Vuông");
		btn_dthv = new JButton("Diện Tích H.Vuông");
		lb_canha = new JLabel("Cạnh hình vuông : ");
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
				JOptionPane.showMessageDialog(null, "Diện tích hình vuông là : " + chuViHV(a) + "");
			}
			if (e.getSource() == btn_dthv) {
				String canhaStr = txt_canh_a.getText().toString();

				double a = Double.parseDouble(canhaStr);
				JOptionPane.showMessageDialog(null, "Diện tích hình vuông là : " + dienTichHV(a) + "");
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Xin mời nhập giá trị!!!");
		}

	}
}