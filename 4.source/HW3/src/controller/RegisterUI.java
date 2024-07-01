package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.impl.MemberDaoImpl;
import model.Member;
import util.cal;
import util.createTable;
import controller.popout.RegisterSuccessUI;

import javax.swing.JLabel;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField phone;
	private JTextField address;
	private JTextField password_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterUI frame = new RegisterUI();
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
	public RegisterUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("註冊資料");
		lblNewLabel.setForeground(new Color(255, 204, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 26));
		lblNewLabel.setBounds(158, 44, 141, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("姓名：");
		lblNewLabel_1.setForeground(new Color(255, 204, 255));
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1.setBounds(127, 105, 67, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("帳號：");
		lblNewLabel_1_1.setForeground(new Color(255, 204, 255));
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(127, 155, 67, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("地址：");
		lblNewLabel_1_2.setForeground(new Color(255, 204, 255));
		lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(45, 355, 67, 25);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("手機：");
		lblNewLabel_1_3.setForeground(new Color(255, 204, 255));
		lblNewLabel_1_3.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(127, 305, 67, 25);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("密碼：");
		lblNewLabel_1_4.setForeground(new Color(255, 204, 255));
		lblNewLabel_1_4.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_4.setBounds(127, 205, 67, 25);
		contentPane.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_4_1 = new JLabel("再次確認密碼：");
		lblNewLabel_1_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4_1.setForeground(new Color(255, 204, 255));
		lblNewLabel_1_4_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_4_1.setBounds(33, 254, 149, 25);
		contentPane.add(lblNewLabel_1_4_1);
		
		name = new JTextField();
		name.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		name.setBounds(181, 105, 149, 25);
		contentPane.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		username.setColumns(10);
		username.setBounds(181, 155, 149, 25);
		contentPane.add(username);
		
		password = new JTextField();
		password.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		password.setColumns(10);
		password.setBounds(181, 205, 149, 25);
		contentPane.add(password);
		
		password_2 = new JTextField();
		password_2.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		password_2.setColumns(10);
		password_2.setBounds(181, 255, 149, 25);
		contentPane.add(password_2);
		
		phone = new JTextField();
		phone.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		phone.setColumns(10);
		phone.setBounds(181, 305, 149, 25);
		contentPane.add(phone);
		
		address = new JTextField();
		address.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		address.setColumns(10);
		address.setBounds(99, 355, 297, 25);
		contentPane.add(address);
		
		JLabel note = new JLabel("");
		note.setHorizontalAlignment(SwingConstants.CENTER);
		note.setForeground(new Color(255, 255, 0));
		note.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		note.setBounds(77, 181, 319, 25);
		contentPane.add(note);
		
		JLabel note2 = new JLabel("");
		note2.setHorizontalAlignment(SwingConstants.CENTER);
		note2.setForeground(new Color(255, 255, 0));
		note2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		note2.setBounds(77, 231, 319, 25);
		contentPane.add(note2);
		
		/*
		 * 按鈕們
		 */
		
		/* 按鈕-註冊 */
		JButton btnNewButton = new JButton("註冊");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 帳號重複=>失敗=>顯示已有帳號，請按忘記密碼
				 * 無重複=>成功
				 * */			
				
				//提示文字重置
				note.setText("");
				note2.setText("");
				
				
				String Username=username.getText();
				Member m=new MemberDaoImpl().queryUsername(Username);
				
				if(m!=null) {
					note.setText("帳號已存在，請重設密碼or重選帳號");
				}
				else {
					String Name=name.getText();
					String Password=password.getText();
					String Password2=password_2.getText();
					String Phone=phone.getText();
					String Address=address.getText();

					//兩次密碼相同=>註冊成功
					if(Password.equals(Password2)) {  
						Member m2=new Member(Name,Username,Password,Address,Phone);
						new MemberDaoImpl().addMember(m2);
						
						//cal.saveFile("newtable.txt", "check_"+m.getUsername());  //存來新建表格的
						createTable.create("checkin_"+Name);  //新建表格一個"checkin_名字"的table
						createTable.create("checkout_"+Name);  //新建表格一個"checkout_名字"的table
						
						 /* 
						  * 回到RegisterSuccessUI
						  * */
						RegisterSuccessUI login=new RegisterSuccessUI();
						login.setVisible(true);
						dispose();
					}
					//密碼不一致=>顯示提醒文字
					else {
						note2.setText("密碼不一致 請重新輸入");
					}
				
			}}
		});
		btnNewButton.setBackground(new Color(204, 204, 255));
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton.setBounds(197, 414, 87, 37);
		contentPane.add(btnNewButton);
		
		
		/* 按鈕-返回 */
		JButton btnNewButton_1 = new JButton("返回");
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
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(255, 255, 204));
		btnNewButton_1.setBounds(385, 10, 87, 23);
		contentPane.add(btnNewButton_1);
		
		
		/* 時間 */
		JLabel time = new JLabel("New label");
		time.setForeground(new Color(255, 255, 204));
		time.setHorizontalAlignment(SwingConstants.RIGHT);
		time.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		time.setBounds(331, 483, 141, 25);
		contentPane.add(time);
		
		Timer timer=new Timer(1000,new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
				time.setText(timeStamp);
			}
		});
		timer.start();
		
		
		/* BG放最下面 */ 
		JLabel BG3 = new JLabel("");
		BG3.setBounds(0, 0, 482, 518);
		contentPane.add(BG3);
		ImageIcon img1= new ImageIcon(this.getClass().getResource("/BG3.jpg"));
		BG3.setIcon(img1);

	}
}
