package controller;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.impl.MemberDaoImpl;
import model.Member;
import util.cal;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginUI() {
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 411, 441);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel lblNewLabel = new JLabel("登入");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 26));
		lblNewLabel.setBounds(159, 37, 57, 68);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號：");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1.setBounds(67, 155, 57, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("密碼：");
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(67, 208, 57, 25);
		contentPane.add(lblNewLabel_1_1);

			
		username = new JTextField();
		username.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		username.setBackground(new Color(255, 255, 255));
		username.setBounds(134, 155, 186, 28);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel note = new JLabel("");
		note.setForeground(new Color(255, 0, 0));
		note.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		note.setHorizontalAlignment(SwingConstants.CENTER);
		note.setBounds(50, 183, 319, 25);
		contentPane.add(note);
		
		
		/* 密碼使用JPasswordField */
		password = new JPasswordField();
		password.setEchoChar('*');
		password.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		password.setBounds(134, 205, 186, 28);
		contentPane.add(password);
		
		
		/* checkbox選擇是否隱藏密碼 */
		JCheckBox chckbxNewCheckBox = new JCheckBox("顯示密碼");
		chckbxNewCheckBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (chckbxNewCheckBox.isSelected()) {
					password.setEchoChar((char)0);  //顯示密碼

				        }
				else {
					password.setEchoChar('*');  //隱藏密碼

				}
			}
		});
		chckbxNewCheckBox.setBackground(new Color(255, 255, 204));
		chckbxNewCheckBox.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		chckbxNewCheckBox.setBounds(241, 239, 97, 23);
		contentPane.add(chckbxNewCheckBox);

		
		/* 時間 */
		JLabel lblNewLabel_2 = new JLabel("Time");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		lblNewLabel_2.setBounds(159, 366, 226, 26);
		contentPane.add(lblNewLabel_2);
		//Date d=new Date();
		//String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		//lblNewLabel_2.setText(timeStamp);
				
		Timer timer = new Timer(1000,new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
				lblNewLabel_2.setText(timeStamp);
			}
			
		});
		timer.start();
		
		
		/*
		 * 按鈕們
		 */
		
		/* 按鈕-OK */
		JButton OKbtn = new JButton("OK");
		OKbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.帳密正確=>LoginSuccessUI
				 * 2.密碼錯誤=>顯示密碼錯誤 
				 * 3.沒有帳號=>顯示請註冊
				 * */
							
				String Username=username.getText();
				String Password=password.getText();
				Member m = new MemberDaoImpl().queryMember(Username,Password);
				Member mm=new MemberDaoImpl().queryUsername(Username);
				
				//重置提示文字
				note.setText("");
							
				if(m!=null) {  //帳密正確=>存檔=>LoginSuccessUI
								
					cal.saveFile("member.txt", m);  //成功登入=>member.txt
					
					/*
					 * 去LoginSuccessUI 
					 * */	
					LoginSuccessUI l=new LoginSuccessUI();   //成功登入=>LoginSuccessUI
					l.setVisible(true);
					dispose();
				}
				else  {  //帳密不正確
					if(mm!=null) {   
						////帳密不正確但有帳號
						note.setText("帳號已存在，請重設密碼or註冊新帳號");
					}
					else {
						////帳密不正確且沒有帳號
						note.setText("請先註冊 !!!");}
			}
		}
		});
		OKbtn.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		OKbtn.setBackground(new Color(255, 153, 255));
		OKbtn.setBounds(148, 261, 68, 43);
		contentPane.add(OKbtn);
		
		
		/* 按鈕-註冊 */
		JButton RIGbtn = new JButton("註冊");
		RIGbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 去RegisterUI 
				 * */
				RegisterUI register=new RegisterUI();
				register.setVisible(true);
				dispose();
			}
		});
		RIGbtn.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		RIGbtn.setBackground(new Color(204, 204, 255));
		RIGbtn.setBounds(67, 333, 87, 23);
		contentPane.add(RIGbtn);
		
		
		/* 按鈕-忘記密碼 */
		JButton FORbtn = new JButton("忘記密碼");
		FORbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 去ForgotUI
				 * */
				ForgotUI forgot=new ForgotUI();
				forgot.setVisible(true);
				dispose();
			}
		});
		FORbtn.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		FORbtn.setBackground(new Color(204, 204, 255));
		FORbtn.setBounds(218, 333, 102, 23);
		contentPane.add(FORbtn);
		

		/* BG放最下面 */
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(0, 0, 395, 402);
		contentPane.add(lblNewLabel_3);
		ImageIcon img1= new ImageIcon(this.getClass().getResource("/BG.jpg"));
		lblNewLabel_3.setIcon(img1);
		
	}
}
