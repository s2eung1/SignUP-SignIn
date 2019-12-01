import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SignIn extends JFrame{//로그인화면
	Image img = null;
	private Font f1;
	private Font f2;
	
	public SignIn()
	{        
        Container contentPane=getContentPane();  //배경 이미지
		JPanel p=new JPanel() {

			public void paintComponent(Graphics g) {

				Dimension d=getSize();
				ImageIcon image = new ImageIcon("C:\\Users\\jijki\\OneDrive\\바탕 화면\\1.jpg");
				g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
				setOpaque(false);
				super.paintComponent(g);
			}

		};

		contentPane.add(p);
		p.setLayout(null);


	
		f1 = new Font("한컴 윤고딕 240", Font.BOLD, 25);
		f2 = new Font("한컴 윤고딕 240", Font.BOLD, 15);
		JLabel b2= new JLabel("학번");
		b2.setForeground(Color.white);
		b2.setFont(f1);
		add(b2);
		JLabel b3= new JLabel("비밀번호");
		b3.setForeground(Color.white);
		b3.setFont(f1);		
		add(b3);
		TextField b4 = new TextField();
		add(b4);
		TextField b5 = new TextField();
		add(b5);
		b5.setEchoChar('*');//암호화
		
		JButton b6 = new JButton("로그인");
		b6.setFont(new Font("한컴 윤고딕 240", Font.BOLD, 17));
		b6.setBackground (new Color(62, 60,61));	
		b6.setForeground(Color.white);
		add(b6);
		JButton b7 = new JButton("회원가입");
		b7.setFont(new Font("한컴 윤고딕 240", Font.BOLD, 17));
		b7.setBackground (new Color(62, 60,61));	
		b7.setForeground(Color.white);
		add(b7);
		
		//label.setBounds(0, 5, 350, 255);
		/*t1.setBounds(350, 5, 70, 40);
		t2.setBounds(350,35, 280, 40);
		t3.setBounds(350, 65,150, 40);
		t4.setBounds(350,95,250, 40);*/
		b2.setBounds(510, 155, 60, 60);
		b3.setBounds(480, 230, 120, 40);
		b4.setBounds(600, 165, 220, 40);
		b5.setBounds(600, 229, 220, 40);
		b6.setBounds(500, 330, 120, 40);
		b7.setBounds(680, 330, 120, 40);
		add(p);
		setSize(900, 567);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x누르면 창꺼지는거
		setTitle("SOFTWARE INFOORMATION ");
		setVisible(true); //보이게
		setLocationRelativeTo(null); //창 가운데로
		b7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {//회원가입창으로 이동
				// TODO Auto-generated method stub
				new SignUp();
				
			}
		});;
		b6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e2) {//로그인 할때 
				SignUpDTO inform = new SignInDAO().isSignIn(b4.getText(), b5.getText());
					if(inform != null)
					{
						JOptionPane.showMessageDialog(null, "로그인이 되었습니다!!");
						//ex3 f3 = new ex3();
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "로그인이 실패하였습니다.");
					}

			}
		});
	}
}

