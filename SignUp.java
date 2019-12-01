import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.*;
import java.awt.*;

public class SignUp extends JFrame {// 회원가입화면
	Image img = null;
	private Font f3;
	private Font f4;
	
	public SignUp() {
		 Container contentPane=getContentPane();  //배경 이미지
			JPanel p = new JPanel() {

				public void paintComponent(Graphics g) {

					Dimension d=getSize();
					ImageIcon image = new ImageIcon("C:\\Users\\jijki\\OneDrive\\바탕 화면\\2.jpg");
					g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
					setOpaque(false);
					super.paintComponent(g);
				}

			};

			contentPane.add(p);
			p.setLayout(null);
		
		f3 = new Font("한컴 윤고딕 240", Font.BOLD, 20);
		f4 = new Font("한컴 윤고딕 240", Font.BOLD, 32);
		JLabel l1 = new JLabel("이름");
		l1.setFont(f3);
		l1.setForeground(Color.white);
		JLabel l2 = new JLabel("학번");
		l2.setFont(f3);
		l2.setForeground(Color.white);
		JLabel l3 = new JLabel("비밀번호");
		l3.setFont(f3);
		l3.setForeground(Color.white);
		JLabel l4 = new JLabel("비밀번호 확인");
		l4.setFont(f3);
		l4.setForeground(Color.white);
		
		JLabel l5 = new JLabel("< 회원가입 >");
		l5.setFont(f4);
		l5.setForeground(Color.white);

		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		

		TextField t1 = new TextField();
		TextField t2 = new TextField();
		TextField t3 = new TextField();
		TextField t4 = new TextField();

		add(t1);
		add(t2);
		add(t3);
		add(t4);

		t3.setEchoChar('*');
		t4.setEchoChar('*');
		
		JButton j1 = new JButton("저장");
		j1.setFont(new Font("한컴 윤고딕 240", Font.BOLD, 18));
		j1.setBackground (new Color(62, 60, 61));	
		j1.setForeground(Color.white);
		JButton j2 = new JButton("취소");
		j2.setFont(new Font("한컴 윤고딕 240", Font.BOLD, 18));
		j2.setBackground (new Color(62, 60, 61));	
		j2.setForeground(Color.white);
		JButton j3 = new JButton("중복확인");
		j3.setFont(new Font("한컴 윤고딕 240", Font.BOLD, 15));
		j3.setBackground (new Color(62, 60, 61));	
		j3.setForeground(Color.white);
		add(j1);
		add(j2);
		add(j3);
		l1.setBounds(90, 150, 100, 40);
		l2.setBounds(90, 210, 100, 40);
		l3.setBounds(70, 270, 100, 40);
		l4.setBounds(52, 330, 130, 40);
		l5.setBounds(200, 50, 200, 40);

		t1.setBounds(210, 150, 230, 35);
		t2.setBounds(210, 210, 230, 35);
		j3.setBounds(460, 210, 100, 35);
		t3.setBounds(210, 270, 230, 35);
		t4.setBounds(210, 330, 230, 35);

		j1.setBounds(125, 430, 100, 40);
		j2.setBounds(365, 430, 100, 40);
		add(p);
		setSize(600, 700);
		setTitle("회원가입");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);//창 가운데로
		j1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent T) {// 회원가입 데이터 저장
					if(t3.getText().equals(t4.getText())) {
						new SignUpDAO().SignUpMember(new SignUpDTO(t2.getText(),t3.getText(),t1.getText()));
						JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
						dispose();
						
					}
					else {
						JOptionPane.showMessageDialog(null, "비밀번호 확인을 해주세요.");
					}
			}
		});
		j2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent T) {// 취소
					dispose();
			}
		});
		j3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent T) {// 중복확인
					boolean dup = new SignUpDAO().duplicationCheck(t2.getText());
					if(dup) {
						JOptionPane.showMessageDialog(null, "학번이 중복 되었습니다.");
					}
					else {
						JOptionPane.showMessageDialog(null, "사용 가능한 아이디입니다.");
						t2.setEditable(false);
					}
			}
		});
	}
}
