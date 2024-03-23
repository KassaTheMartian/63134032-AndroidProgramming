package ntu_63134032;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import java.util.ArrayList;
import java.util.Collections;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;


public class TracNghiemFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private ArrayList<Quiz> listQuiz = new ArrayList<Quiz>();
	private int count = 0;
	private int countKq = 0;
	private int countKqMax = 0;
	private int size = 10;
	private Integer[] soCauHoi = {5 ,10, 15};

	
	private JButton btn_a;
	private JButton btn_b;
	private JButton btn_c;
	private JButton btn_d;
	private JButton bnt_new_game;
	
	private JTextArea txtr_cau_hoi;
	
	private JLabel lbl_cau_hoi;
	private JLabel lblFunQuiz;
	private JLabel lbl_diem;
	private JLabel lbl_diem_cao_nhat;
	
	private JComboBox so_cau_hoi;
	
	public TracNghiemFrame() {
		listQuiz.add(new Quiz("Đuôi thì chẳng thấy, mà có hai đầu?", "Cây cầu", "Cây tre", "Con giun", "Con ốc sên"));
		listQuiz.add(new Quiz("Cái gì không có chân, không có đuôi, không có cơ thể mà có nhiều đầu?", "Cầu truyền hình", "Cầu khỉ", "Rồng thần", "Con cá"));
		listQuiz.add(new Quiz("Lịch nào dài nhất?", "Lịch sử", "Lịch vạn niên", "Lịch người Maya", "Lịch sự"));
		listQuiz.add(new Quiz("Con gì đập thì sống, không đập thì chết?", "Con tim", "Con bò", "Con sông", "Con công"));
		listQuiz.add(new Quiz("Trong 1 cuộc thi chạy, nếu bạn vượt qua người thứ 2 bạn sẽ \nđứng thứ mấy?", "Thứ hai", "Thứ nhất", "Chủ nhật", "Thứ ba"));
		listQuiz.add(new Quiz("Cái gì dài như trái chuối, cầm 1 lúc thì nó chảy nước ra?", "Que kem", "Con giun", "Con ốc sên", "Trái chuối"));
		listQuiz.add(new Quiz("Con gì mang được cả miếng gỗ lớn nhưng không mang \nđược hòn sỏi?", "Con sông", "Con voi", "Con cá voi", "Con người"));
		listQuiz.add(new Quiz("Trò gì càng chơi càng ra nước", "Cờ vua", "Kéo co", "Chèo thuyền", "Bắn cung"));
		listQuiz.add(new Quiz("Hoa gì nuôi trẻ sớm khuya\r\n"
				+ "Tháng 10 em nở tỏa hương phố phường!", "Hoa sữa", "Hoa quỳnh", "Hoa ly", "Hoa kiều"));
		listQuiz.add(new Quiz("Con mèo nào cực kỳ sợ chuột?", "Doremon", "Mèo máy Kuro", "Linh miêu", "Pikachu"));
		listQuiz.add(new Quiz("Làm thế nào để con cua được chín chân?","Luộc","Nhờ Thủy Tinh bắt","Hấp","Nướng"));
		listQuiz.add(new Quiz("Có ba quả táo trên bàn và bạn lấy đi hai quả. Hỏi bạn còn \nbao nhiêu quả táo?","2 quả","3 quả","4 quả","1 quả"));
		listQuiz.add(new Quiz("Tôi có 4 cái chân, 1 cái lưng, nhưng không có cơ thể. Tôi là ai?","Cái ghế","Con bò","Con heo","Con voi"));
		listQuiz.add(new Quiz("Tại sao 30 người đàn ông và 2 người đàn bà đánh nhau tán loạn?","Đánh cờ","Đánh ghen","Chiến tranh","Cướp bóc"));
		listQuiz.add(new Quiz("Cái gì mà bạn có, khi bạn chia sẻ với tôi, nhưng khi bạn chia sẻ \nbạn sẽ không có nó?","Bí mật","Kiến thức","Hiểu biết","Tiền bạc"));

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 642);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btn_a = new JButton("A");
		btn_a.setBackground(new Color(153, 255, 255));
		btn_a.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_a.setBounds(25, 308, 400, 125);
		contentPane.add(btn_a);
		
		btn_b = new JButton("B");
		btn_b.setBackground(new Color(153, 255, 255));
		btn_b.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_b.setBounds(25, 458, 400, 125);
		contentPane.add(btn_b);

		btn_c = new JButton("C");
		btn_c.setBackground(new Color(153, 255, 255));
		btn_c.setForeground(new Color(0, 0, 0));
		btn_c.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_c.setBounds(449, 308, 400, 125);
		contentPane.add(btn_c);
		
		btn_d = new JButton("D");
		btn_d.setBackground(new Color(153, 255, 255));
		btn_d.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_d.setBounds(449, 458, 400, 125);
		contentPane.add(btn_d);
		
		txtr_cau_hoi = new JTextArea();
		txtr_cau_hoi.setColumns(5);
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
		lblFunQuiz.setFont(new Font("Bodoni MT Black", Font.BOLD | Font.ITALIC, 51));
		lblFunQuiz.setBounds(602, 10, 266, 57);
		contentPane.add(lblFunQuiz);
		
		lbl_diem = new JLabel("Điểm: ");
		lbl_diem.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_diem.setForeground(new Color(153, 0, 153));
		lbl_diem.setFont(new Font("Cascadia Code", Font.BOLD | Font.ITALIC, 26));
		lbl_diem.setBounds(25, 10, 132, 57);
		contentPane.add(lbl_diem); 
		
		bnt_new_game = new JButton("New Game");
		bnt_new_game.setBackground(new Color(255, 255, 204));
		bnt_new_game.setFont(new Font("Tahoma", Font.PLAIN, 12));

		bnt_new_game.setBounds(744, 233, 105, 25);
		contentPane.add(bnt_new_game);
		
		lbl_diem_cao_nhat = new JLabel("Điểm cao nhất: 0");
		lbl_diem_cao_nhat.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_diem_cao_nhat.setForeground(new Color(255, 0, 0));
		lbl_diem_cao_nhat.setFont(new Font("Cascadia Code", Font.BOLD | Font.ITALIC, 26));
		lbl_diem_cao_nhat.setBounds(194, 10, 290, 57);
		contentPane.add(lbl_diem_cao_nhat);
		
		so_cau_hoi = new JComboBox(soCauHoi);
		so_cau_hoi.setSelectedItem(10); 
		so_cau_hoi.setBounds(744, 202, 105, 25);
		contentPane.add(so_cau_hoi);
		

        
		newGame();
		
		btn_a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hienThiDapAn(btn_a);
			}
		});
		
		btn_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hienThiDapAn(btn_b);

			}
		});
		
		btn_c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hienThiDapAn(btn_c);

			}
		});
		
		btn_d.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hienThiDapAn(btn_d);

			}
		});
		
		bnt_new_game.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newGame();
			}
		});
		
		so_cau_hoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<Integer> cb = (JComboBox<Integer>) e.getSource();
                size = (Integer) cb.getSelectedItem();
            }
        });
	}
	
	// Hàm hiển thị đáp án và chuyển qua câu tiếp theo
	public void hienThiDapAn(JButton btn) {
		if (btn.getText().equals(listQuiz.get(count).getDapAnDung())){
			// Nếu đúng tăng kết quả lên 1, chuyển đáp án vừa chọn thành màu xanh lá trong 175ms
			countKq++;
			btn.setBackground(new Color(0x99FF00)); 
			btn.setForeground(Color.BLUE); 
			// Vô hiệu hóa các nút
			choPhepBam(false);          
			Timer timer = new Timer(175, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	// Chuyển qua câu hỏi mới
                    newQues();
                    // Bỏ vô hiệu hóa
                    choPhepBam(true);               
                    // Chuyển màu thành mặc định
        			btn.setBackground(new Color(0x99FFFF)); 
                    btn.setForeground(Color.BLACK);
                    ((Timer)e.getSource()).stop(); // Dừng timer sau khi đã chuyển câu hỏi mới
                }
            });
            timer.setRepeats(false); // Chỉ chạy một lần
            timer.start(); // Bắt đầu timer
		}else {
			// Nếu sai chuyển đáp án vừa chọn thành màu đỏ trong 175ms
			btn.setBackground(Color.RED); 
			btn.setForeground(Color.WHITE);
			
			// Vô hiệu hóa các nút
			choPhepBam(false);
            Timer timer = new Timer(175, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	// Chuyển qua câu hỏi mới
                    newQues();
                    // Bỏ vô hiệu hóa
                    choPhepBam(true);        
                    // Chuyển màu thành mặc định
        			btn.setBackground(new Color(0x99FFFF)); // Đặt lại màu nền về mặc định
        			btn.setForeground(Color.BLACK);
                    ((Timer)e.getSource()).stop(); // Dừng timer sau khi đã chuyển câu hỏi mới
                }
            });
            timer.setRepeats(false); // Chỉ chạy một lần
            timer.start(); // Bắt đầu timer		
            }
	}

	// Hàm dùng để vô hiệu hóa nút bấm khi đang hiện câu hỏi
	public void choPhepBam(boolean b) {
		btn_a.setEnabled(b); 
		btn_b.setEnabled(b); 
		btn_c.setEnabled(b); 
		btn_d.setEnabled(b); 
	}
	
	// Hàm trộn các câu hỏi
	public void mergeQuiz() {
        Collections.shuffle(listQuiz);
	}
	
	// Hàm trộn và hiển thị các câu trả lời
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
	
	// Hàm tạo mới game
	public void newGame() {
		mergeQuiz();
		count = 0;
		countKq = 0;
		lbl_cau_hoi.setText("Câu: " + String.valueOf(count+1) +"\\"+ size);
		lbl_diem.setText("Điểm: " + String.valueOf(countKq));
		txtr_cau_hoi.setText(listQuiz.get(count).getDe());
		setAns(listQuiz.get(count));
	}
	
	// Hàm chuyển qua câu hỏi tiếp theo
	public void newQues() {
		lbl_diem.setText("Điểm: " + String.valueOf(countKq));
		if (countKqMax <= countKq) 	
			lbl_diem_cao_nhat.setText("Điểm cao nhất: " + String.valueOf(countKq));

		count++;
		if(count == size) {
			if (count == countKq) {
				JOptionPane hopThoai = new JOptionPane();
				hopThoai.showMessageDialog(this, "Bạn thật xuất sắc trả lời đúng hết " + countKq +"\\"+count+" câu hỏi!!\n Bấm OK để tiếp tục chơi tiếp");
			}else if (countKq > (count/2)) {
				JOptionPane hopThoai = new JOptionPane();
				hopThoai.showMessageDialog(this, "Bạn trả lời đúng " + countKq +"\\"+count+" câu hỏi!!\n Bấm OK để tiếp tục chơi tiếp");
			}else {
				JOptionPane hopThoai = new JOptionPane();
				hopThoai.showMessageDialog(this, "Thật tiếc bạn chỉ trả lời đúng " + countKq +"\\"+count+" câu hỏi!!\n Bấm OK để tiếp tục chơi tiếp");
			}
			newGame();
		}
		lbl_cau_hoi.setText("Câu: " + String.valueOf(count+1) +"\\"+ size );
		txtr_cau_hoi.setText(listQuiz.get(count).getDe());
		setAns(listQuiz.get(count));
	}
}
