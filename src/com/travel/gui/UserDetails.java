package com.travel.gui;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Window;
import java.awt.Dialog;
import javax.swing.JDialog;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
public class UserDetails extends JFrame {

	/**
	 * 
	 */
	private ShowBooking nextWindow1;
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private Object[] rowData;
	private JTextField textField;
	private JTextField txtT;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private String fName;
	private String lName;
	private String phoneNo;
	//private int age;
	private String email;
	private int trvls;
	private String cClass;
	private String flexi;
	private String optFood;
	private String flFood;
	private int baseFare;
	private int total_cost=0;
	private String phoneInp;
	private String userPnr;
	private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.length() == 10;
    }
	private void validatePhoneNumber(String phoneNumber) {
        if (!phoneNumber.isEmpty()) {
            if (isValidPhoneNumber(phoneNumber)) {
            	phoneInp = phoneNumber;
                System.out.println("Phone number: " + phoneNumber);
            } else {
                showErrorDialog("Invalid phone number. Please enter a valid 10-digit number.");
            }
        }
    }
	
	public String getPhoneInp() {
        return phoneInp;
    }
	
	private void showErrorDialog(String errorMessage) {
		JOptionPane.showMessageDialog(frame, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Object[] rowData=new Object[7];
					UserDetails window = new UserDetails(rowData);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserDetails(Object[] rowData)throws ClassNotFoundException, SQLException {
		getContentPane().setBackground(new Color(153, 255, 255));
		getContentPane().setLayout(null);
		
//		ImageIcon icon = new ImageIcon("D://plane.png");
//        setIconImage(icon.getImage());
		
		//System.out.print(randomAlphaNumeric);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
		JLabel lblNewLabel = new JLabel("TRAVELLER DETAILS");
		lblNewLabel.setFont(new Font("Stencil", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(202, 10, 334, 42);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("FIRST NAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 81, 100, 24);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(120, 82, 149, 24);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("PHONE NO.   (+91)");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 131, 149, 24);
		getContentPane().add(lblNewLabel_2);
		
		txtT = new JTextField(20);
		txtT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtT.setHorizontalAlignment(SwingConstants.LEFT);
		txtT.setBounds(169, 131, 225, 27);
		getContentPane().add(txtT);
		txtT.setColumns(10);
		phoneInp=txtT.getText();
		txtT.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                // Do nothing
            }
            public void focusLost(FocusEvent e) {
            	validatePhoneNumber(txtT.getText());
            }
        });
		
		txtT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	validatePhoneNumber(txtT.getText());
            }
        });
		
		
		JLabel lblNewLabel_3 = new JLabel("EMAIL");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 181, 62, 24);
		getContentPane().add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setHorizontalAlignment(SwingConstants.LEFT);
		textField_2.setBounds(82, 181, 312, 24);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("LAST NAME");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(418, 81, 100, 24);
		getContentPane().add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setBounds(515, 81, 149, 24);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("TRAVELLERS");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(10, 237, 100, 24);
		getContentPane().add(lblNewLabel_5);
		Integer[] nums= {1,2,3,4,5};
		JComboBox comboBox = new JComboBox(nums);
		comboBox.setBackground(new Color(255, 204, 204));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setBounds(120, 237, 62, 25);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_6 = new JLabel("CABIN CLASS");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(10, 291, 109, 24);
		getContentPane().add(lblNewLabel_6);
		String[] cls= {"Economy","Business","First Class"};
		JComboBox comboBox_1 = new JComboBox(cls);
		comboBox_1.setBackground(new Color(255, 204, 204));
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_1.setBounds(120, 293, 109, 25);
		getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_7 = new JLabel("FLEXI TICKET");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(10, 346, 109, 24);
		getContentPane().add(lblNewLabel_7);
		String[] opt= {"YES","NO"};
		JComboBox comboBox_2 = new JComboBox(opt);
		comboBox_2.setBackground(new Color(255, 204, 204));
		comboBox_2.setSelectedIndex(1);
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_2.setBounds(129, 346, 62, 25);
		getContentPane().add(comboBox_2);
		
		JLabel lblNewLabel_8 = new JLabel("AGE");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(418, 131, 48, 24);
		getContentPane().add(lblNewLabel_8);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		//textField_4.setText();
		textField_4.setBounds(463, 131, 62, 24);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("IN-FLIGHT MEALS");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(10, 392, 142, 24);
		getContentPane().add(lblNewLabel_9);
		
		JComboBox comboBox_3 = new JComboBox(opt);
		comboBox_3.setBackground(new Color(255, 204, 204));
		comboBox_3.setSelectedIndex(1);
		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_3.setBounds(162, 392, 67, 25);
		getContentPane().add(comboBox_3);
		String[] food= {"Veg","Non-Veg","Vegan"};
		JComboBox comboBox_4 = new JComboBox(food);
		comboBox_4.setBackground(new Color(255, 204, 204));
		comboBox_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_4.setBounds(236, 392, 109, 25);
		getContentPane().add(comboBox_4);
		comboBox_4.setVisible(false);
		comboBox_3.addActionListener(e -> {
			String selectedOption = (String) comboBox_3.getSelectedItem();
			comboBox_4.setVisible(selectedOption.equals("YES"));
		});
		
		JButton btnNewButton = new JButton("Proceed to pay");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				userPnr = generateRandomAlphaNumeric(6);
				
				fName=textField.getText();
				lName=textField_3.getText();
				phoneNo = getPhoneInp();
				//age=Integer.parseInt(textField_4.getText());
				email=textField_2.getText();
				trvls=(int) comboBox.getSelectedItem();
				cClass=(String) comboBox_1.getSelectedItem();
				flexi=(String) comboBox_2.getSelectedItem();
				optFood=(String)comboBox_3.getSelectedItem();
				flFood=(String) comboBox_4.getSelectedItem();
				try {
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","password");
					String query = "insert into flight_user values(?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement st = con.prepareStatement(query);
					st.setString(1,fName);
					st.setString(2,lName);
					st.setString(3,phoneNo);
					st.setString(4,email);
//					st.setString(5,rowData[1].toString());
//					st.setString(6,rowData[2].toString());
//					st.setString(7,rowData[7].toString());
//					st.setString(8,rowData[4].toString());
//					st.setString(9,rowData[3].toString());
					st.setInt(5, trvls);
					st.setString(6,cClass);
					st.setString(7,flexi);
					if(optFood=="NO") {
						flFood="none";
					}
					st.setString(8,flFood);
					baseFare=(int)rowData[6]*trvls;
					if(cClass=="Business") {
						total_cost+=(2000*trvls);
						baseFare=(total_cost+(int)rowData[6])*trvls;
					}
					else if(cClass=="First Class"){
						total_cost+=(4000*trvls);
						baseFare=(total_cost+(int)rowData[6])*trvls;
					}
					if(flexi=="YES") {
						total_cost+=900;
					}
					if(optFood=="YES") {
						if(flFood=="Veg") {
							total_cost+=300;
						}
						else if(flFood=="Non-Veg") {
							total_cost+=500;
						}
						else if(flFood=="Vegan") {
							total_cost+=700;
						}
					}
					total_cost+=(int)rowData[6]*trvls;
					st.setInt(9, total_cost);
					st.setString(10, userPnr);
					st.executeUpdate();
					Object[] passDetails= {fName,lName,rowData[1],rowData[2],rowData[7],rowData[4],rowData[3],trvls,cClass,total_cost,rowData[0],flFood,userPnr,baseFare,flexi};
					try {
	                	nextWindow1 = new ShowBooking(passDetails);
                        nextWindow1.setVisible(true);
                        frame.setVisible(false);
                        dispose();
	                }catch (Exception e1) {
						e1.printStackTrace();
					}
					
					st.close();
					con.close();
				}catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 153, 102));
		btnNewButton.setFont(new Font("Stencil", Font.BOLD, 20));
		btnNewButton.setBounds(449, 475, 280, 48);
		getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 102));
		panel.setBounds(0, 10, 753, 36);
		getContentPane().add(panel);
		
		//System.out.print(rowData[0].toString());
		System.out.print(rowData[1].toString());//from
		System.out.print(rowData[2].toString());//to
		System.out.print(rowData[3].toString());//company
		System.out.print(rowData[4].toString());//deptime
		//System.out.print(rowData[5].toString());//arrtime
		System.out.print(rowData[6].toString());//price
		System.out.print(rowData[7].toString());//date
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(767, 570);
		
	}
	private static String generateRandomAlphaNumeric(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();
    }
	public void updateData(Object[] passData) {
		String flightNo = (String) passData[0];
        String departure = (String) passData[1];
        String arrival = (String) passData[2];
        String airline = (String) passData[3];
        String departureTime = (String) passData[4];
        String arrivalTime = (String) passData[5];
        int price = (int) passData[6];
        String date = (String) passData[7];
		
	}
}
