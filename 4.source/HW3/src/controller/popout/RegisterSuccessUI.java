package controller.popout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginUI;

import javax.swing.JLabel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class RegisterSuccessUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterSuccessUI frame = new RegisterSuccessUI();
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
	public RegisterSuccessUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("歡迎加入!!");
		lblNewLabel_1.setForeground(new Color(102, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		lblNewLabel_1.setBounds(157, 323, 196, 66);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("歡迎加入!!");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 204));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		lblNewLabel_1_1.setBounds(159, 334, 196, 50);
		contentPane.add(lblNewLabel_1_1);
		
		//按鈕-重新登入
		JButton btnNewButton = new JButton("重新登入");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 *辦好會員，回到LoginUI 
				 */
				LoginUI order=new LoginUI();
				order.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(255, 204, 204));
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton.setBounds(190, 394, 101, 31);
		contentPane.add(btnNewButton);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 204, 204));
		lblNewLabel.setBounds(0, 0, 486, 449);
		contentPane.add(lblNewLabel);
	
		
		//BG放在先拉好的文字框框裡		
		ImageIcon img1= new ImageIcon(this.getClass().getResource("/welcome.PNG"));
		Image icon1=img1.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(icon1));
		

		

	}

}
