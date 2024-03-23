package ntu_63134032;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.Collections;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;


public class TracNghiemFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	ArrayList<Quiz> listQuiz = new ArrayList<Quiz>();
	int count = 0;
	int countKq = 0;
	
	JButton btn_a;
	JButton btn_b;
	JButton btn_c;
	JButton btn_d;
	
	JTextArea txtr_cau_hoi;
	
	JLabel lbl_cau_hoi;
	JLabel lblFunQuiz;
	JLabel lbl_diem;
	
	public TracNghiemFrame() {
		listQuiz.add(new Quiz("Đuôi thì chẳng thấy, mà có hai đầu?", "Cây cầu", "Cây tre", "Con giun", "Con ốc sên"));
		listQuiz.add(new Quiz("Cái gì không có chân, không có đuôi, không có cơ thể mà có nhiều đầu?", "Cầu truyền hình", "Cầu khỉ", "Rồng thần", "Con cá"));
		listQuiz.add(new Quiz("Lịch nào dài nhất?", "Lịch sử", "Lịch vạn niên", "Lịch người Maya", "Lịch sự"));
		listQuiz.add(new Quiz("Con gì đập thì sống, không đập thì chết?", "Con tim", "Con bò", "Con sông", "Con công"));
		listQuiz.add(new Quiz("Trong 1 cuộc thi chạy, nếu bạn vượt qua người thứ 2 bạn sẽ đứng thứ mấy?", "Thứ hai", "Thứ nhất", "Chủ nhật", "Thứ ba"));
		listQuiz.add(new Quiz("Cái gì dài như trái chuối, cầm 1 lúc thì nó chảy nước ra?", "Que kem", "Con giun", "Con ốc sên", "Trái chuối"));
		listQuiz.add(new Quiz("Con gì mang được cả miếng gỗ lớn nhưng không mang được hòn sỏi?", "Con sông", "Con voi", "Con cá voi", "Con người"));
	
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btn_a = new JButton("A");
		btn_a.setBackground(new Color(204, 255, 255));
		btn_a.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_a.setBounds(25, 308, 400, 125);
		contentPane.add(btn_a);
		
		btn_b = new JButton("B");
		btn_b.setBackground(new Color(51, 255, 204));
		btn_b.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_b.setBounds(25, 458, 400, 125);
		contentPane.add(btn_b);

		btn_c = new JButton("C");
		btn_c.setBackground(new Color(255, 255, 153));
		btn_c.setForeground(new Color(0, 0, 0));
		btn_c.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_c.setBounds(449, 308, 400, 125);
		contentPane.add(btn_c);
		
		btn_d = new JButton("D");
		btn_d.setBackground(new Color(51, 255, 0));
		btn_d.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_d.setBounds(449, 458, 400, 125);
		contentPane.add(btn_d);
		
		txtr_cau_hoi = new JTextArea();
		txtr_cau_hoi.setRows(10);
		txtr_cau_hoi.setLineWrap(true);
		txtr_cau_hoi.setBackground(new Color(255, 255, 255));
		txtr_cau_hoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtr_cau_hoi.setText("Câu hỏi");
		txtr_cau_hoi.setEditable(false);
		txtr_cau_hoi.setBounds(126, 86, 608, 172);
		contentPane.add(txtr_cau_hoi);
		
		lbl_cau_hoi = new JLabel("Câu số 1:");
		lbl_cau_hoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_cau_hoi.setBounds(25, 86, 118, 37);
		contentPane.add(lbl_cau_hoi);
		
		lblFunQuiz = new JLabel("Fun Quiz");
		lblFunQuiz.setForeground(new Color(153, 0, 153));
		lblFunQuiz.setHorizontalAlignment(SwingConstants.CENTER);
		lblFunQuiz.setFont(new Font("Bodoni MT Black", Font.BOLD | Font.ITALIC, 26));
		lblFunQuiz.setBounds(685, 10, 183, 57);
		contentPane.add(lblFunQuiz);
		
		lbl_diem = new JLabel("Điểm: ");
		lbl_diem.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_diem.setForeground(new Color(153, 0, 153));
		lbl_diem.setFont(new Font("Cascadia Code", Font.BOLD | Font.ITALIC, 26));
		lbl_diem.setBounds(25, 10, 132, 57);
		contentPane.add(lbl_diem);
		
		JButton bnt_new_game = new JButton("New Game");
		bnt_new_game.setBackground(new Color(255, 255, 204));
		bnt_new_game.setFont(new Font("Tahoma", Font.PLAIN, 12));

		bnt_new_game.setBounds(744, 237, 105, 21);
		contentPane.add(bnt_new_game);
		
		newGame();

		
		btn_a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btn_a.getText().equals(listQuiz.get(count).getDapAnDung())){
					countKq++;
				}
				
				newQues();
			}
		});
		
		btn_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btn_b.getText().equals(listQuiz.get(count).getDapAnDung())){
					countKq++;
				}
				
				newQues();
			}
		});
		
		btn_c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btn_c.getText().equals(listQuiz.get(count).getDapAnDung())){
					countKq++;
				}
				
				newQues();
			}
		});
		
		btn_d.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btn_d.getText().equals(listQuiz.get(count).getDapAnDung())){
					countKq++;
				}
				
				newQues();
			}
		});
		
		bnt_new_game.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newGame();
			}
		});
	}
	
	public void mergeQuiz() {
        Collections.shuffle(listQuiz);
	}
	
	public void setAns(Quiz quiz) {
        ArrayList<String> options = new ArrayList<>();
        options.add(quiz.getDapAnDung());
        options.add(quiz.getDapAnSai1());
        options.add(quiz.getDapAnSai2());
        options.add(quiz.getDapAnSai3());
        Collections.shuffle(options); // Trộn thứ tự các lựa chọn
		btn_a.setText(options.get(0));
		btn_b.setText(options.get(1));
		btn_c.setText(options.get(2));
		btn_d.setText(options.get(3));
	}
	
	public void newGame() {
		mergeQuiz();
		count = 0;
		countKq = 0;
		lbl_cau_hoi.setText("Câu: " + String.valueOf(count+1));
		lbl_diem.setText("Điểm: " + String.valueOf(countKq));
		txtr_cau_hoi.setText(listQuiz.get(count).getDe());
		setAns(listQuiz.get(count));
	}
	
	public void newQues() {
		lbl_diem.setText("Điểm: " + String.valueOf(countKq));
		
		count++;
		if(count >= listQuiz.size()) {
			JOptionPane hopThoai = new JOptionPane();
			hopThoai.showMessageDialog(this, "Bạn trả lời đúng " + countKq + " câu hỏi!!\n Bấm OK để tiếp tục chơi tiếp");
			newGame();
		}
		lbl_cau_hoi.setText("Câu: " + String.valueOf(count+1));
		txtr_cau_hoi.setText(listQuiz.get(count).getDe());
		setAns(listQuiz.get(count));
	}
}
