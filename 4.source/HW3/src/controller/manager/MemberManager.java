package controller.manager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginSuccessUI;
import dao.impl.CheckAllDaoImpl;
import dao.impl.MemberDaoImpl;
import model.CheckAll;
import model.Member;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JScrollPane;

public class MemberManager extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField phone;
	private JTextField address;
	private JTextField u_id;
	private JTextField u_name;
	private JTextField u_password;
	private JTextField u_phone;
	private JTextField u_address;
	private JTextField did;
	private JTextField id2;
	private JTextField name2;
	private JTextField date2;
	private JTextField inhr;
	private JTextField outhr;
	private JTextField id3;
	private JTextField inmin;
	private JTextField outmin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberManager frame = new MemberManager();
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
	public MemberManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 806, 780);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("員工管理系統");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		lblNewLabel.setBackground(new Color(128, 255, 128));
		lblNewLabel.setBounds(20, 10, 656, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("名字");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1.setBounds(20, 65, 29, 20);
		contentPane.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(59, 65, 96, 21);
		contentPane.add(name);
		
		JLabel lblNewLabel_1_3 = new JLabel("帳號");
		lblNewLabel_1_3.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(20, 95, 29, 20);
		contentPane.add(lblNewLabel_1_3);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(59, 95, 96, 21);
		contentPane.add(username);
		
		JLabel lblNewLabel_1_4 = new JLabel("密碼");
		lblNewLabel_1_4.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(20, 125, 29, 20);
		contentPane.add(lblNewLabel_1_4);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(59, 128, 96, 21);
		contentPane.add(password);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("電話");
		lblNewLabel_1_3_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_3_1.setBounds(20, 156, 29, 20);
		contentPane.add(lblNewLabel_1_3_1);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(59, 159, 96, 21);
		contentPane.add(phone);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("地址");
		lblNewLabel_1_4_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_4_1.setBounds(20, 187, 29, 20);
		contentPane.add(lblNewLabel_1_4_1);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(59, 190, 96, 21);
		contentPane.add(address);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(310, 65, 29, 20);
		contentPane.add(lblNewLabel_1_1);
		
		u_id = new JTextField();
		u_id.setColumns(10);
		u_id.setBounds(349, 65, 96, 21);
		contentPane.add(u_id);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("名字");
		lblNewLabel_1_3_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_3_2.setBounds(310, 95, 29, 20);
		contentPane.add(lblNewLabel_1_3_2);
		
		u_name = new JTextField();
		u_name.setColumns(10);
		u_name.setBounds(349, 95, 96, 21);
		contentPane.add(u_name);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("密碼");
		lblNewLabel_1_4_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_4_2.setBounds(310, 125, 29, 20);
		contentPane.add(lblNewLabel_1_4_2);
		
		u_password = new JTextField();
		u_password.setColumns(10);
		u_password.setBounds(349, 128, 96, 21);
		contentPane.add(u_password);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("電話");
		lblNewLabel_1_3_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_3_1_1.setBounds(310, 156, 29, 20);
		contentPane.add(lblNewLabel_1_3_1_1);
		
		u_phone = new JTextField();
		u_phone.setColumns(10);
		u_phone.setBounds(349, 159, 96, 21);
		contentPane.add(u_phone);
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("地址");
		lblNewLabel_1_4_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_4_1_1.setBounds(310, 187, 29, 20);
		contentPane.add(lblNewLabel_1_4_1_1);
		
		u_address = new JTextField();
		u_address.setColumns(10);
		u_address.setBounds(349, 190, 96, 21);
		contentPane.add(u_address);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("ID");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(585, 145, 29, 20);
		contentPane.add(lblNewLabel_1_1_1);
		
		did = new JTextField();
		did.setColumns(10);
		did.setBounds(624, 145, 96, 21);
		contentPane.add(did);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("ID");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1_2.setBounds(310, 407, 29, 20);
		contentPane.add(lblNewLabel_1_1_2);
		
		id2 = new JTextField();
		id2.setColumns(10);
		id2.setBounds(349, 407, 96, 21);
		contentPane.add(id2);
		
		JLabel lblNewLabel_1_3_2_1 = new JLabel("名字");
		lblNewLabel_1_3_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_3_2_1.setBounds(310, 437, 29, 20);
		contentPane.add(lblNewLabel_1_3_2_1);
		
		name2 = new JTextField();
		name2.setColumns(10);
		name2.setBounds(349, 437, 96, 21);
		contentPane.add(name2);
		
		JLabel lblNewLabel_1_4_2_1 = new JLabel("日期");
		lblNewLabel_1_4_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_4_2_1.setBounds(310, 467, 29, 20);
		contentPane.add(lblNewLabel_1_4_2_1);
		
		date2 = new JTextField();
		date2.setColumns(10);
		date2.setBounds(349, 470, 96, 21);
		contentPane.add(date2);
		
		JLabel lblNewLabel_1_3_1_1_1 = new JLabel("上班");
		lblNewLabel_1_3_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_3_1_1_1.setBounds(310, 498, 29, 20);
		contentPane.add(lblNewLabel_1_3_1_1_1);
		
		inhr = new JTextField();
		inhr.setColumns(10);
		inhr.setBounds(349, 501, 37, 21);
		contentPane.add(inhr);
		
		JLabel lblNewLabel_1_3_1_1_1_1 = new JLabel("：");
		lblNewLabel_1_3_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_1_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_3_1_1_1_1.setBounds(386, 501, 21, 20);
		contentPane.add(lblNewLabel_1_3_1_1_1_1);
		
		inmin = new JTextField();
		inmin.setColumns(10);
		inmin.setBounds(408, 501, 37, 21);
		contentPane.add(inmin);
		
		JLabel lblNewLabel_1_4_1_1_1 = new JLabel("下班");
		lblNewLabel_1_4_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_4_1_1_1.setBounds(310, 529, 29, 20);
		contentPane.add(lblNewLabel_1_4_1_1_1);
		
		outhr = new JTextField();
		outhr.setColumns(10);
		outhr.setBounds(349, 532, 37, 21);
		contentPane.add(outhr);
		
		JLabel lblNewLabel_1_3_1_1_1_1_1 = new JLabel("：");
		lblNewLabel_1_3_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_3_1_1_1_1_1.setBounds(386, 532, 21, 20);
		contentPane.add(lblNewLabel_1_3_1_1_1_1_1);
		
		outmin = new JTextField();
		outmin.setColumns(10);
		outmin.setBounds(408, 532, 37, 21);
		contentPane.add(outmin);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("ID");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(585, 487, 29, 20);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		id3 = new JTextField();
		id3.setColumns(10);
		id3.setBounds(624, 487, 96, 21);
		contentPane.add(id3);

		//上面的TextArea
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 221, 727, 176);
		contentPane.add(scrollPane);
		
		JTextArea showAll = new JTextArea();
		showAll.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		scrollPane.setViewportView(showAll);
		showAll.setBackground(new Color(255, 255, 255));
		
		//下面的TextArea
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 557, 725, 174);
		contentPane.add(scrollPane_1);
		
		JTextArea showAll_1 = new JTextArea();
		showAll_1.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		scrollPane_1.setViewportView(showAll_1);
		showAll_1.setBackground(Color.WHITE);
		
		//提示文字
		JLabel note = new JLabel("");
		note.setForeground(Color.RED);
		note.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		note.setBounds(165, 145, 135, 31);
		contentPane.add(note);
		
		
		/*
		 * 員工相關按鈕
		 */
		
		//按鈕-新增員工
		JButton btnNewButton = new JButton("新增");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				
				if(name.getText().equals("") | username.getText().equals("") |  password.getText().equals("") | 
						address.getText().equals("") |  phone.getText().equals("") ) {
					note.setText("新增資料不可為空");
				}
				else {
					Member m=new Member(
							name.getText(),
							username.getText(),
							password.getText(),
							address.getText(),
							phone.getText());
					
					new MemberDaoImpl().addMember(m);
				}
				
				
				/*Member m=new Member(
						name.getText(),
						username.getText(),
						password.getText(),
						address.getText(),
						phone.getText());
				
				new MemberDaoImpl().addMember(m);*/
				}
			
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton.setBackground(new Color(128, 255, 128));
		btnNewButton.setBounds(165, 176, 85, 31);
		contentPane.add(btnNewButton);
		
		
		//按鈕-查詢員工
		JButton btnNewButton_1 = new JButton("全體員工資料");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showAll.setText(new MemberDaoImpl().queryAll2());
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(128, 255, 128));
		btnNewButton_1.setBounds(581, 60, 139, 31);
		contentPane.add(btnNewButton_1);
		
		
		//按鈕-修改員工
		JButton btnNewButton_2 = new JButton("修改");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ID=Integer.parseInt(u_id.getText());
				String Name=u_name.getText();
				String Password=u_password.getText();
				String Address=u_address.getText();
				String Phone=u_phone.getText();
				
				
				Member m=new MemberDaoImpl().queryMemberById(ID);
				m.setName(Name);
				m.setPassword(Password);
				m.setAddress(Address);
				m.setPhone(Phone);
				
				
				new MemberDaoImpl().updateMember(m);
				
				
				u_id.setText("");
				u_name.setText("");
				u_password.setText("");
				u_address.setText("");
				u_phone.setText("");
				
			}
		});
		btnNewButton_2.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton_2.setBackground(new Color(128, 255, 128));
		btnNewButton_2.setBounds(455, 176, 85, 31);
		contentPane.add(btnNewButton_2);
		
		
		//按鈕-刪除員工
		JButton btnNewButton_3 = new JButton("刪除");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ID=Integer.parseInt(did.getText());
				new MemberDaoImpl().deleteMember(ID);
				did.setText("");
			}
		});
		btnNewButton_3.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton_3.setBackground(new Color(128, 255, 128));
		btnNewButton_3.setBounds(635, 176, 85, 31);
		contentPane.add(btnNewButton_3);
		
		
		//按鈕-資料列印
				JButton btnNewButton_1_1_1 = new JButton("資料列印");
				btnNewButton_1_1_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							PrinterJob job=PrinterJob.getPrinterJob();
							job.setPrintable(showAll.getPrintable(null, null));
							if(job.printDialog()) {
								job.print();
							}
						}catch(PrinterException ee) {
							ee.printStackTrace();
						}
					}
				});
				btnNewButton_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
				btnNewButton_1_1_1.setBackground(new Color(255, 255, 204));
				btnNewButton_1_1_1.setBounds(20, 409, 96, 23);
				contentPane.add(btnNewButton_1_1_1);
				
		
		
		/*
		 * 紀錄相關按鈕
		 */
		
		//按鈕-全體紀錄
		JButton btnNewButton_2_1 = new JButton("全體打卡紀錄");
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showAll_1.setText(new CheckAllDaoImpl().queryAll2());
			}
		});
		btnNewButton_2_1.setBackground(new Color(204, 153, 255));
		btnNewButton_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton_2_1.setBounds(581, 421, 139, 31);
		contentPane.add(btnNewButton_2_1);
		
		
		//按鈕-紀錄修改
		JButton btnNewButton_2_2 = new JButton("修改");
		btnNewButton_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ID=Integer.parseInt(id2.getText());
				String Name=name2.getText();
				String Date=date2.getText();
				String Inhr=inhr.getText();
				String Inmin=inmin.getText();
				String Outhr=outhr.getText();
				String Outmin=outmin.getText();
	
				
				
				CheckAll c=new CheckAllDaoImpl().queryCheckAllById(ID);
				c.setName(Name);
				c.setDate(Date);
				c.setInhr(Inhr);
				c.setInmin(Inmin);
				c.setOuthr(Outhr);
				c.setOutmin(Outmin);
				
				
				new CheckAllDaoImpl().updateCheckAll(c);
				
				id2.setText("");
				name2.setText("");
				date2.setText("");
				inhr.setText("");
				inmin.setText("");
				outhr.setText("");
				outmin.setText("");
				
			}
		});
		btnNewButton_2_2.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton_2_2.setBackground(new Color(204, 153, 255));
		btnNewButton_2_2.setBounds(455, 518, 85, 31);
		contentPane.add(btnNewButton_2_2);
		
		
		//按鈕-紀錄刪除
		JButton btnNewButton_3_1 = new JButton("刪除");
		btnNewButton_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ID=Integer.parseInt(id3.getText());
				new CheckAllDaoImpl().deleteCheckAll(ID);
				id3.setText("");
			}
		});
		btnNewButton_3_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton_3_1.setBackground(new Color(204, 153, 255));
		btnNewButton_3_1.setBounds(635, 518, 85, 31);
		contentPane.add(btnNewButton_3_1);
		
		
		//按鈕-紀錄列印
		JButton btnNewButton_1_1_2 = new JButton("紀錄列印");
		btnNewButton_1_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					PrinterJob job=PrinterJob.getPrinterJob();
					job.setPrintable(showAll_1.getPrintable(null, null));
					if(job.printDialog()) {
						job.print();
					}
				}catch(PrinterException ee) {
					ee.printStackTrace();
				}
			}
		});
		btnNewButton_1_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton_1_1_2.setBackground(new Color(255, 255, 204));
		btnNewButton_1_1_2.setBounds(20, 529, 96, 23);
		contentPane.add(btnNewButton_1_1_2);
		
		
		
		//按鈕-返回
		JButton btnNewButton_1_1 = new JButton("返回");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/* 
				  * 回到LoginSuccessUI
				  * */
				LoginSuccessUI u=new LoginSuccessUI();
				u.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton_1_1.setBackground(new Color(255, 255, 204));
		btnNewButton_1_1.setBounds(693, 10, 87, 23);
		contentPane.add(btnNewButton_1_1);
			
				
		//BG放最下面
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(0, 0, 790, 741);
		contentPane.add(lblNewLabel_3);
		ImageIcon img1= new ImageIcon(this.getClass().getResource("/bgbg.PNG"));

		Image icon1=img1.getImage().getScaledInstance(lblNewLabel_3.getWidth(), lblNewLabel_3.getHeight(), Image.SCALE_SMOOTH);
		lblNewLabel_3.setIcon(new ImageIcon(icon1));
		



	}
}
