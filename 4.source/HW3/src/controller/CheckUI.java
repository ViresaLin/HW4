package controller;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.impl.CheckAllDaoImpl;
import dao.impl.CheckInDaoImpl;
import dao.impl.CheckNewDaoImpl;
import dao.impl.CheckOutDaoImpl;
import model.Member;
import util.cal;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class CheckUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckUI frame = new CheckUI();
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
	public CheckUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 516);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 83, 445, 294);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel = new JLabel("我的紀錄");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 26));
		lblNewLabel.setBounds(125, 31, 198, 42);
		contentPane.add(lblNewLabel);
		
		/*
		 * 放在Label後不然抓不到
		 */
		Object o=cal.readFile("member.txt");

		Member m=(Member) o;
				
		//Label.setText(m.getName());
		
		
		/*
		 * 按鈕們
		 */
		
		/* 按鈕-返回 */
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
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
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(255, 255, 204));
		btnNewButton_1.setBounds(368, 10, 87, 23);
		contentPane.add(btnNewButton_1);
		
		
		/* 按鈕-上班紀錄 */
		JButton RIGbtn = new JButton("上班");
		RIGbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//textArea.setText(new CheckInDaoImpl().queryAll2());
				//textArea.setText(new CheckInDaoImpl().queryCheckin());
				textArea.setText(new CheckNewDaoImpl().queryIn(m.getName()));
			}
		});
		RIGbtn.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		RIGbtn.setBackground(new Color(204, 204, 255));
		RIGbtn.setBounds(20, 432, 87, 29);
		contentPane.add(RIGbtn);
		
		
		/* 按鈕-下班紀錄 */
		JButton RIGbtn_1 = new JButton("下班");
		RIGbtn_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//textArea.setText(new CheckOutDaoImpl().queryAll2());
				textArea.setText(new CheckNewDaoImpl().queryOut(m.getName()));
			}
		});
		RIGbtn_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		RIGbtn_1.setBackground(new Color(204, 204, 255));
		RIGbtn_1.setBounds(130, 432, 87, 29);
		contentPane.add(RIGbtn_1);
		
		
		/* 按鈕-儲存/列印 */
		JButton RIGbtn_1_1 = new JButton("儲存/列印");
		RIGbtn_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					PrinterJob job=PrinterJob.getPrinterJob();
					job.setPrintable(textArea.getPrintable(null, null));
					if(job.printDialog()) {
						job.print();
					}
				}catch(PrinterException ee) {
					ee.printStackTrace();
				}
			}
		});
		RIGbtn_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		RIGbtn_1_1.setBackground(new Color(204, 204, 255));
		RIGbtn_1_1.setBounds(350, 432, 105, 29);
		contentPane.add(RIGbtn_1_1);
		
		
		/*暫時先放在這確認用=>MemberManager
				JButton btnNewButton_2 = new JButton("全體紀錄");
				btnNewButton_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						textArea.setText(new CheckAllDaoImpl().queryAll2());
					}
				});
				btnNewButton_2.setBounds(42, 46, 85, 23);
				contentPane.add(btnNewButton_2);*/
		
		
		//BG放最下面
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(0, 0, 465, 477);
		contentPane.add(lblNewLabel_3);
		ImageIcon img1= new ImageIcon(this.getClass().getResource("/green.PNG"));
		lblNewLabel_3.setIcon(img1);
		

	}
}
