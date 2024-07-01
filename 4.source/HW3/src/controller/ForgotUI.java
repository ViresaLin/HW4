package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.impl.MemberDaoImpl;
import model.Member;

import javax.swing.JLabel;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ForgotUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	private JTextField password_1;
	private JTextField phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotUI frame = new ForgotUI();
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
	public ForgotUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("重設密碼");
		lblNewLabel.setForeground(new Color(255, 204, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 26));
		lblNewLabel.setBounds(132, 41, 147, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("帳號：");
		lblNewLabel_1_1.setForeground(new Color(255, 204, 255));
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(103, 117, 67, 25);
		contentPane.add(lblNewLabel_1_1);
		
		username = new JTextField();
		username.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		username.setColumns(10);
		username.setBounds(157, 117, 149, 25);
		contentPane.add(username);
		
		JLabel lblNewLabel_1_4 = new JLabel("新密碼：");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setForeground(new Color(255, 204, 255));
		lblNewLabel_1_4.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_4.setBounds(55, 217, 103, 25);
		contentPane.add(lblNewLabel_1_4);
		
		password = new JTextField();
		password.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		password.setColumns(10);
		password.setBounds(157, 217, 149, 25);
		contentPane.add(password);
		
		JLabel lblNewLabel_1_3 = new JLabel("再次輸入：");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setForeground(new Color(255, 204, 255));
		lblNewLabel_1_3.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(34, 268, 124, 25);
		contentPane.add(lblNewLabel_1_3);
		
		password_1 = new JTextField();
		password_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		password_1.setColumns(10);
		password_1.setBounds(157, 268, 149, 25);
		contentPane.add(password_1);
		
		JLabel note1 = new JLabel("");
		note1.setHorizontalAlignment(SwingConstants.CENTER);
		note1.setForeground(new Color(255, 255, 0));
		note1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		note1.setBounds(65, 143, 319, 25);
		contentPane.add(note1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("電話：");
		lblNewLabel_1_1_1.setForeground(new Color(255, 204, 255));
		lblNewLabel_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(103, 167, 67, 25);
		contentPane.add(lblNewLabel_1_1_1);
		
		phone = new JTextField();
		phone.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		phone.setColumns(10);
		phone.setBounds(157, 167, 149, 25);
		contentPane.add(phone);
		
		JLabel note3 = new JLabel("");
		note3.setHorizontalAlignment(SwingConstants.CENTER);
		note3.setForeground(Color.YELLOW);
		note3.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		note3.setBounds(65, 241, 319, 25);
		contentPane.add(note3);
		
		JLabel note2 = new JLabel("");
		note2.setHorizontalAlignment(SwingConstants.CENTER);
		note2.setForeground(Color.YELLOW);
		note2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		note2.setBounds(76, 192, 319, 25);
		contentPane.add(note2);
		
		
		 /* 時間 */
		JLabel time = new JLabel("2024/06/06 00:16:06");
		time.setHorizontalAlignment(SwingConstants.RIGHT);
		time.setForeground(new Color(255, 255, 204));
		time.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		time.setBounds(292, 399, 141, 25);
		contentPane.add(time);
		Timer timer=new Timer(1000,new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
				time.setText(timeStamp);
			}
		});	
		timer.start();
		
		
		/*
		 * 按鈕們
		 */
		
		 /* 按鈕-重設密碼 */
		JButton btnNewButton = new JButton("重設");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.確認帳號有存在 ，if不存在=>顯示請註冊
				 * 2.確認兩個密碼一樣 ，if不一樣 =>輸入密碼不同 重新輸入
				 * 3.成功=>跳至LoginUI
				 * */
				//String ID=id.getText();
				//Integer IDD=new Integer(ID);
				String Username=username.getText();
				String Password=password.getText();
				String Password2=password_1.getText();
				String Phone=phone.getText();
				
				Member mm=new MemberDaoImpl().queryUsername(Username);
				System.out.println(mm);	
				
				//重置提示文字
				note1.setText("");	//提示字語清空
				note2.setText("");
				note3.setText("");
				
				if(mm!=null) {  //有此帳號
					if(Phone.equals(mm.getPhone())) {	//使用手機號碼確認本人
						if(Password.equals(Password2)) {	//兩次密碼輸入一致
							
							mm.setPassword(Password);	//=>可重設密碼
							new MemberDaoImpl().updateMember(mm);	//更新
					
							LoginUI login=new LoginUI();	//回登入畫面
							login.setVisible(true);
							dispose();
						}
						else
						{
							note3.setText("密碼不一致，請重新輸入!!");
						}
					}
					else {
						note2.setText("手機號碼錯誤!!");
					}
				}
				else {
					note1.setText("無此帳號，請註冊!!");
				}
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(204, 204, 255));
		btnNewButton.setBounds(157, 331, 87, 37);
		contentPane.add(btnNewButton);
		
		
		 /* 按鈕-返回 */
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.setBackground(new Color(255, 255, 204));
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 /* 
				  * 回到LoginUI
				  * */
				LoginUI login=new LoginUI();
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(346, 10, 87, 23);
		contentPane.add(btnNewButton_1);
		
		
		 /* BG放最下面 */
		JLabel BG4 = new JLabel("");
		BG4.setBounds(0, 0, 443, 434);
		contentPane.add(BG4);
		ImageIcon img1= new ImageIcon(this.getClass().getResource("/BG3.jpg"));
		BG4.setIcon(img1);			

	}
}
