package com.travel.gui;

import java.awt.EventQueue;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Button;
import java.awt.Font;






public class MainFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField textField_4;
	private JTextField textField_5;
	private JPasswordField textField_6;
	private Connection con;
	JLabel lblNewLabel_7;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame() throws Exception {
		initialize();
	}

	private void initialize() throws Exception {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(251, 255, 179));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBackground(new Color(0, 64, 128));
		panel_4_1.setBounds(0, 50, 17, 181);
		frame.getContentPane().add(panel_4_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 0, 128));
		panel_4.setBounds(419, 50, 17, 181);
		frame.getContentPane().add(panel_4);

		// SIGN UP

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(194, 239, 239));
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
				new Color(160, 160, 160)), "SignUp", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_1.setBounds(10, 50, 200, 181);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(0, 128, 255));
		panel_1_2.setBounds(0, 164, 212, 17);
		panel_1.add(panel_1_2);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(10, 25, 45, 13);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Phone");
		lblNewLabel_1.setBounds(10, 48, 45, 13);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("E-mail");
		lblNewLabel_2.setBounds(10, 71, 45, 13);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("UserID");
		lblNewLabel_3.setBounds(10, 94, 45, 13);
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Pass");
		lblNewLabel_4.setBounds(10, 118, 45, 13);
		panel_1.add(lblNewLabel_4);

		textField = new JTextField();
		textField.setBounds(77, 22, 96, 19);
		panel_1.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(77, 45, 96, 19);
		panel_1.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(77, 68, 96, 19);
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(77, 91, 96, 19);
		panel_1.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JPasswordField();
		textField_4.setBounds(77, 115, 96, 19);
		panel_1.add(textField_4);
		textField_4.setColumns(10);

		Button button_1 = new Button("Register");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = textField.getText();
				String userPhone = textField_1.getText();
				String userEmail = textField_2.getText();
				String userId = textField_3.getText();
				String userPass = textField_4.getText();

				try {
					String query = "insert into CustomerDetails values(?,?,?,?,?)";
					PreparedStatement statement = con.prepareStatement(query);
					statement.setString(1, userName);
					statement.setString(2, userPhone);
					statement.setString(3, userEmail);
					statement.setString(4, userId);
					statement.setString(5, userPass);
					statement.execute();
					lblNewLabel_7.setVisible(true);

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		button_1.setBounds(107, 140, 66, 21);
		panel_1.add(button_1);
		
		lblNewLabel_7 = new JLabel("REGISTERED!");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.ITALIC, 9));
		lblNewLabel_7.setBounds(20, 141, 91, 13);
		panel_1.add(lblNewLabel_7);
		lblNewLabel_7.setVisible(false);

		// LOG IN

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(194, 239, 239));
		panel_2.setLayout(null);
		panel_2.setForeground(Color.BLACK);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
				new Color(160, 160, 160)), "LogIn", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_2.setBounds(230, 50, 200, 181);
		frame.getContentPane().add(panel_2);

		JLabel lblNewLabel_3_1 = new JLabel("UserID");
		lblNewLabel_3_1.setBounds(10, 25, 45, 13);
		panel_2.add(lblNewLabel_3_1);

		JLabel lblNewLabel_4_1 = new JLabel("Pass");
		lblNewLabel_4_1.setBounds(10, 48, 45, 13);
		panel_2.add(lblNewLabel_4_1);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(77, 22, 96, 19);
		panel_2.add(textField_5);

		textField_6 = new JPasswordField();
		textField_6.setColumns(10);
		textField_6.setBounds(77, 45, 96, 19);
		panel_2.add(textField_6);

		Button button_2 = new Button("LogIn");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String logInId = textField_5.getText();
				String logInPass = textField_6.getText();

				try {
					String query = "select * from CustomerDetails where userid = ? and pass = ? ";
					PreparedStatement st = con.prepareStatement(query);
					st.setString(1, logInId);
					st.setString(2, logInPass);
					ResultSet rs = st.executeQuery();

					String tempId = "";
					String tempPass = "";
					while (rs.next()) {
						tempId = rs.getString("userid");
						tempPass = rs.getString("pass");
					}

					if (tempId.equals(logInId) && tempPass.equals(logInPass) && !logInId.isBlank()
							&& !logInPass.isBlank()) {
						// GETTING TO NEXT WINDOW
						SecondWindow nextWindow = new SecondWindow(logInId);
						nextWindow.setVisible(true);
						frame.dispose();
					} else {
						JLabel lblNewLabel_5 = new JLabel("");
						lblNewLabel_5.setBounds(30, 50, 150, 100);
						panel_2.add(lblNewLabel_5);
						lblNewLabel_5.setText("Wrong ID or Password");
					}

				} catch (Exception ex1) {
					ex1.printStackTrace();
				}
			}
		});
		button_2.setBounds(107, 137, 66, 21);
		panel_2.add(button_2);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(255, 128, 64));
		panel_1_1.setBounds(0, 164, 190, 17);
		panel_2.add(panel_1_1);
		
		JLabel lblNewLabel_6 = new JLabel("BMT TRAVEL MANAGEMENT");
		lblNewLabel_6.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_6.setBounds(66, 0, 338, 50);
		frame.getContentPane().add(lblNewLabel_6);
	}

	private void setDefaultCloseOperation(int exitOnClose) {
		frame.setDefaultCloseOperation(exitOnClose);
	}

	private void setBounds(int x, int y, int width, int height) {
		frame.setBounds(x, y, width, height);
	}

	private Container getContentPane() {
		return frame.getContentPane();
	}
}
