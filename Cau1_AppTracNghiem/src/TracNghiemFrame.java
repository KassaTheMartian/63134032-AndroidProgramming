import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Canvas;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TracNghiemFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	JButton btn_a;
	JButton btn_b;
	JButton btn_c;
	JButton btn_d;
	
	JTextArea txtr_cau_hoi;
	
	JLabel lbl_cau_hoi;
	JLabel lblFunQuiz;
	
	public TracNghiemFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 864, 644);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btn_a = new JButton("A");
		btn_a.setBackground(new Color(0, 0, 255));
		btn_a.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_a.setBounds(10, 308, 400, 125);
		contentPane.add(btn_a);
		
		btn_b = new JButton("B");
		btn_b.setBackground(new Color(102, 102, 0));
		btn_b.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_b.setBounds(10, 472, 400, 125);
		contentPane.add(btn_b);

		btn_c = new JButton("C");
		btn_c.setBackground(new Color(153, 255, 0));
		btn_c.setForeground(new Color(0, 0, 0));
		btn_c.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_c.setBounds(434, 308, 400, 125);
		contentPane.add(btn_c);
		
		btn_d = new JButton("D");
		btn_d.setBackground(new Color(255, 102, 0));
		btn_d.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_d.setBounds(434, 472, 400, 125);
		contentPane.add(btn_d);
		
		txtr_cau_hoi = new JTextArea();
		txtr_cau_hoi.setRows(10);
		txtr_cau_hoi.setLineWrap(true);
		txtr_cau_hoi.setBackground(new Color(255, 255, 255));
		txtr_cau_hoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtr_cau_hoi.setText("Câu hỏi");
		txtr_cau_hoi.setEnabled(false);
		txtr_cau_hoi.setEditable(false);
		txtr_cau_hoi.setBounds(117, 86, 623, 172);
		contentPane.add(txtr_cau_hoi);
		
		lbl_cau_hoi = new JLabel("Câu số 1:");
		lbl_cau_hoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_cau_hoi.setBounds(10, 86, 118, 57);
		contentPane.add(lbl_cau_hoi);
		
		lblFunQuiz = new JLabel("Fun Quiz");
		lblFunQuiz.setForeground(new Color(153, 0, 153));
		lblFunQuiz.setHorizontalAlignment(SwingConstants.CENTER);
		lblFunQuiz.setFont(new Font("Bodoni MT Black", Font.BOLD | Font.ITALIC, 26));
		lblFunQuiz.setBounds(268, 10, 315, 57);
		contentPane.add(lblFunQuiz);
		
	}
}
