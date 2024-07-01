package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.impl.CheckAllDaoImpl;
import dao.impl.CheckInDaoImpl;
import dao.impl.CheckNewDaoImpl;
import dao.impl.CheckOutDaoImpl;
import model.CheckAll;
import model.CheckNew;
import model.Member;
import controller.manager.MemberManager;
import controller.popout.CheckInSuccessUI;
import controller.popout.CheckOutSuccessUI;
import util.cal;

import javax.swing.JLabel;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginSuccessUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSuccessUI frame = new LoginSuccessUI();
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
	public LoginSuccessUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 421, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Label = new JLabel("會員");
		Label.setHorizontalAlignment(SwingConstants.CENTER);
		Label.setFont(new Font("微軟正黑體", Font.BOLD, 23));
		Label.setBounds(126, 25, 141, 31);
		contentPane.add(Label);
		
		JLabel lblXx = new JLabel("今天也是美好的一天!");
		lblXx.setHorizontalAlignment(SwingConstants.CENTER);
		lblXx.setFont(new Font("微軟正黑體", Font.BOLD, 23));
		lblXx.setBounds(83, 107, 236, 31);
		contentPane.add(lblXx);
		
		JLabel lblNewLabel_1 = new JLabel("你好啊～");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 23));
		lblNewLabel_1.setBounds(136, 66, 127, 31);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("(ﾉ>ω<)ﾉ");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 23));
		lblNewLabel_1_1.setBounds(263, 66, 141, 31);
		contentPane.add(lblNewLabel_1_1);
		
		//時間
		JLabel time = new JLabel("time");
		time.setForeground(new Color(255, 102, 0));
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		time.setBounds(93, 151, 236, 43);
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
		 * 放在Label後不然抓不到
		 */
		Object o=cal.readFile("member.txt");

		Member m=(Member) o;
				
		Label.setText(m.getName());
		

		/*
		 * 按鈕們
		 */
		
		/* 按鈕-打卡上班 */
		JButton GObtn_1 = new JButton("熱血上班");
		GObtn_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
				String Date=timeStamp.substring(0, 10);
				String Hour=timeStamp.substring(11, 13);
				String Minute=timeStamp.substring(14, 16);	
				String Name=m.getName();
				System.out.println(Name+Date+Hour+Minute);
				

			
				//按下按鈕時間即存進 checkin 表格
				//new CheckInDaoImpl().addCheckIn( Date, Hour, Minute);
				new CheckNewDaoImpl().addCheckNew(m.getName(), Date, Hour, Minute);
				
				//按下按鈕時間直接存進 checkall 表格 ，checkout等下班按鈕再以更新方式新增
				new CheckAllDaoImpl().addCheckAll( Name,Date, Hour, Minute);
				
				CheckAll c=new CheckAllDaoImpl().queryCheckAll(Name,Date);
				//cal.saveFile("checkall.txt", c);  //存來給下班按鈕確認同一人同一天的
				
				
				/*
				 * 去上班打卡成功UI
				 * */
				CheckInSuccessUI order=new CheckInSuccessUI();
				order.setVisible(true);
				dispose();
			}
		});
		GObtn_1.setFont(new Font("微軟正黑體", Font.BOLD, 26));
		GObtn_1.setBackground(new Color(255, 204, 102));
		GObtn_1.setBounds(126, 204, 141, 39);
		contentPane.add(GObtn_1);
		
		
		/* 按鈕-下班打卡 */
		JButton GObtn = new JButton("光速下班");
		GObtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
				String Date=timeStamp.substring(0, 10);
				String Hour=timeStamp.substring(11, 13);
				String Minute=timeStamp.substring(14, 16);	
				String Name=m.getName();
				System.out.println(Name+Date+Hour+Minute);
				
			
				//按下按鈕時間即存進 checkout 表格
				//new CheckOutDaoImpl().addCheckOut( Date, Hour, Minute);
				new CheckNewDaoImpl().addCheckNewOut(m.getName(), Date, Hour, Minute);
				
				//同時更新checkall的outhr&outmin
				CheckAll cc=new CheckAllDaoImpl().queryCheckAll(Name,Date); //確認是同一人同一天
				
				cc.setOuthr(Hour);
				cc.setOutmin(Minute);

				new CheckAllDaoImpl().updateCheckAll(cc); 
				
				//更新個人表格的下班資訊
				CheckNew nn=new CheckNewDaoImpl().queryCheckNew(Name,Date); //確認是同一人同一天
				
				/*nn.setOuthr(Hour);
				nn.setOutmin(Minute);
				
				new CheckNewDaoImpl().updateCheckNew(Name,nn); */

				
				/*
				 * 去下班打卡成功UI
				 * */
				CheckOutSuccessUI a=new CheckOutSuccessUI();
				a.setVisible(true);
				dispose();
			}
		});
		GObtn.setBackground(new Color(255, 204, 102));
		GObtn.setFont(new Font("微軟正黑體", Font.BOLD, 26));
		GObtn.setBounds(126, 271, 141, 39);
		contentPane.add(GObtn);
		
		
		/* 按鈕-紀錄 */
		JButton btnNewButton_1_1 = new JButton("紀錄");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 去紀錄UI
				 * */
				CheckUI a=new CheckUI();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton_1_1.setBackground(new Color(255, 255, 204));
		btnNewButton_1_1.setBounds(83, 342, 87, 23);
		contentPane.add(btnNewButton_1_1);
		
		
		/* 按鈕-員工管理 */
		JButton btnNewButton_1_1_1 = new JButton("員工管理");
		btnNewButton_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 去員工管理UI
				 * */
				MemberManager a=new MemberManager();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 12));
		btnNewButton_1_1_1.setBackground(new Color(255, 255, 204));
		btnNewButton_1_1_1.setBounds(232, 343, 87, 23);
		contentPane.add(btnNewButton_1_1_1);
		
		
		/* 按鈕-登出 */
		JButton btnNewButton_1 = new JButton("登出");
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
		btnNewButton_1.setBounds(317, 10, 87, 23);
		contentPane.add(btnNewButton_1);
		
		
		/* BG放最下面 */
		JLabel BG = new JLabel("New label");
		BG.setBounds(0, 0, 414, 413);
		contentPane.add(BG);
		ImageIcon img1= new ImageIcon(this.getClass().getResource("/BG2.jpg"));
		BG.setIcon(img1);
		


	}

}
