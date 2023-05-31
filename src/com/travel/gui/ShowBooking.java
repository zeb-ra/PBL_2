package com.travel.gui;
import java.awt.*;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowBooking extends JFrame {
	private PaymentSuccessful nextWindow1;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private Object[] rowData2;
	
	private String fullName;
	private String fromAir;
	private String toAir;
	private String flDate;
	private String depTime;
	private String company;
	private int psngrs; 
	private String cabClass;
	private int tCost;
	private String flightNo;
	private String food;
	private String prn;
	private int baseFareS;
	private int foodFare;
	private int flx=0;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Object[] rowData2=new Object[14];
					ShowBooking window = new ShowBooking(rowData2);
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
	public ShowBooking(Object[] rowData2) throws ClassNotFoundException, SQLException{
		getContentPane().setBackground(new Color(153, 255, 255));
		getContentPane().setLayout(null);
		fullName=rowData2[0].toString()+' '+rowData2[1].toString();
		fromAir=rowData2[2].toString();
		toAir=rowData2[3].toString();
		flDate=rowData2[4].toString();
		depTime=rowData2[5].toString();
		company=rowData2[6].toString();
		psngrs=(int)rowData2[7];
		cabClass=rowData2[8].toString();
		tCost=(int)rowData2[9]+980;
		flightNo=rowData2[10].toString();
		food=rowData2[11].toString();
		prn=rowData2[12].toString();
		baseFareS=(int)rowData2[13];
		if(food=="Veg") {
			foodFare=300;
		}
		else if(food=="Non-Veg") {
			foodFare=500;
		}
		else if(food=="Vegan") {
			foodFare=700;
		}
		else {
			foodFare=0;
		}
		if(rowData2[14]=="YES") {
			flx=900;
		}
		JLabel lblNewLabel = new JLabel("Booking Details");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Stencil", Font.BOLD, 30));
		lblNewLabel.setBounds(272, 10, 438, 36);
		getContentPane().add(lblNewLabel);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
		
		JLabel lblNewLabel_1 = new JLabel("--------------------------------------------------------"
				+ "---------------------------------------------------------------------------------"
				+ "---------------------------");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 43, 966, 13);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name: "+fullName.toUpperCase());
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(24, 170, 297, 26);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Class: "+cabClass.toUpperCase());
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(24, 206, 241, 26);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("From: "+fromAir.toUpperCase());
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(272, 112, 117, 36);
		getContentPane().add(lblNewLabel_4);
		lblNewLabel_4.setBorder(border);
		
		JLabel lblNewLabel_5 = new JLabel("To: "+toAir.toUpperCase());
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(610, 112, 100, 36);
		getContentPane().add(lblNewLabel_5);
		lblNewLabel_5.setBorder(border);
		
		JLabel lblNewLabel_6 = new JLabel("Date: "+flDate);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(365, 242, 159, 26);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Time: "+depTime+" HRS");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(677, 242, 171, 26);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(company.toUpperCase());
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Stencil", Font.PLAIN, 24));
		lblNewLabel_8.setBounds(390, 66, 199, 36);
		getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Flight No: "+flightNo);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_9.setBounds(24, 242, 189, 26);
		getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_11 = new JLabel("Passengers: "+psngrs);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_11.setBounds(365, 206, 159, 26);
		getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setBackground(new Color(255, 255, 255));
		lblNewLabel_12.setBounds(10, 56, 966, 268);
		getContentPane().add(lblNewLabel_12);
		lblNewLabel_12.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		
		JLabel lblNewLabel_13 = new JLabel("In-Flight Meals: "+food.toUpperCase());
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_13.setBounds(23, 278, 242, 26);
		getContentPane().add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("---------------------------------------------------------------"
				+ "------------------------------------------------------------------------"
				+ "-----------------------------");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_14.setBounds(0, 324, 976, 13);
		getContentPane().add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("PNR: "+prn);
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_15.setBounds(365, 278, 159, 26);
		getContentPane().add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("FARE SUMMARY");
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16.setFont(new Font("Stencil", Font.BOLD, 20));
		lblNewLabel_16.setBounds(10, 347, 203, 36);
		getContentPane().add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Base Fare: ");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_17.setBounds(24, 391, 81, 26);
		getContentPane().add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel(""+baseFareS);
		lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_18.setBounds(132, 391, 81, 26);
		getContentPane().add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("Flexi Ticket: ");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_19.setBounds(24, 427, 102, 26);
		getContentPane().add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel(""+flx);
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_20.setBounds(132, 427, 81, 26);
		getContentPane().add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("In-Flight Meals: ");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_21.setBounds(24, 463, 122, 26);
		getContentPane().add(lblNewLabel_21);
		
		JLabel lblNewLabel_22 = new JLabel(""+foodFare);
		lblNewLabel_22.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_22.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_22.setBounds(129, 463, 84, 26);
		getContentPane().add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("----------------------------------");
		lblNewLabel_23.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_23.setBounds(14, 516, 209, 13);
		getContentPane().add(lblNewLabel_23);
		
		JLabel lblNewLabel_24 = new JLabel("Surcharges: ");
		lblNewLabel_24.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_24.setBounds(24, 495, 102, 26);
		getContentPane().add(lblNewLabel_24);
		
		JLabel lblNewLabel_25 = new JLabel("980");
		lblNewLabel_25.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_25.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_25.setBounds(129, 495, 84, 26);
		getContentPane().add(lblNewLabel_25);
		
		JLabel lblNewLabel_26 = new JLabel("Total Fare: ");
		lblNewLabel_26.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_26.setBounds(24, 530, 110, 26);
		getContentPane().add(lblNewLabel_26);
		
		JLabel lblNewLabel_27 = new JLabel(""+tCost);
		lblNewLabel_27.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_27.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_27.setBounds(132, 530, 84, 26);
		getContentPane().add(lblNewLabel_27);
		
		JLabel lblNewLabel_28 = new JLabel("");
		lblNewLabel_28.setBounds(10, 341, 203, 232);
		getContentPane().add(lblNewLabel_28);
		lblNewLabel_28.setBorder(border);
		
		JLabel lblNewLabel_29 = new JLabel("Card No");
		lblNewLabel_29.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_29.setBounds(233, 391, 67, 26);
		getContentPane().add(lblNewLabel_29);
		lblNewLabel_29.setVisible(false);
		
		textField = new JTextField();
		textField.setBounds(305, 391, 203, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		textField.setVisible(false);
		
		JLabel lblNewLabel_30 = new JLabel("Valid thru: ");
		lblNewLabel_30.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_30.setBounds(233, 438, 81, 26);
		getContentPane().add(lblNewLabel_30);
		lblNewLabel_30.setVisible(false);
		
		JLabel lblNewLabel_32 = new JLabel("MM");
		lblNewLabel_32.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_32.setBounds(314, 438, 32, 26);
		getContentPane().add(lblNewLabel_32);
		lblNewLabel_32.setVisible(false);
		
		textField_1 = new JTextField();
		textField_1.setBounds(345, 442, 52, 22);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setVisible(false);
		
		JLabel lblNewLabel_33 = new JLabel("YY");
		lblNewLabel_33.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_33.setBounds(422, 438, 32, 26);
		getContentPane().add(lblNewLabel_33);
		lblNewLabel_33.setVisible(false);
		
		textField_2 = new JTextField();
		textField_2.setBounds(456, 442, 52, 24);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		textField_2.setVisible(false);
		
		JLabel lblNewLabel_34 = new JLabel("CVV");
		lblNewLabel_34.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_34.setBounds(233, 472, 52, 36);
		getContentPane().add(lblNewLabel_34);
		lblNewLabel_34.setVisible(false);
		
		textField_3 = new JTextField();
		textField_3.setBounds(279, 474, 72, 34);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		textField_3.setVisible(false);
		
		JLabel lblNewLabel_35 = new JLabel("");
		lblNewLabel_35.setBounds(227, 343, 297, 178);
		getContentPane().add(lblNewLabel_35);
		lblNewLabel_35.setBorder(border);
		lblNewLabel_35.setVisible(false);
		
		JLabel lblNewLabel_36 = new JLabel("OR");
		lblNewLabel_36.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_36.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_36.setBounds(547, 343, 67, 178);
		getContentPane().add(lblNewLabel_36);
		
		JButton btnNewButton = new JButton("Pay Via Debit Card");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_35.setVisible(true);
				lblNewLabel_29.setVisible(true);
				textField.setVisible(true);
				lblNewLabel_30.setVisible(true);
				lblNewLabel_32.setVisible(true);
				textField_1.setVisible(true);
				lblNewLabel_33.setVisible(true);
				textField_2.setVisible(true);
				lblNewLabel_34.setVisible(true);
				textField_3.setVisible(true);
			}
		});
		
		JLabel lblNewLabel_31 = new JLabel("UPI ID:");
		lblNewLabel_31.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_31.setBounds(652, 400, 102, 26);
		getContentPane().add(lblNewLabel_31);
		lblNewLabel_31.setVisible(false);
		
		textField_4 = new JTextField();
		textField_4.setBounds(652, 433, 311, 31);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		textField_4.setVisible(false);
		
		JLabel lblNewLabel_37 = new JLabel("");
		lblNewLabel_37.setBounds(642, 343, 334, 178);
		getContentPane().add(lblNewLabel_37);
		lblNewLabel_37.setBorder(border);
		lblNewLabel_37.setVisible(false);
		
		btnNewButton.setBackground(new Color(255, 153, 102));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(233, 347, 275, 30);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Pay Via UPI");
		btnNewButton_2.setBackground(new Color(255, 153, 102));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_31.setVisible(true);
				textField_4.setVisible(true);
				lblNewLabel_37.setVisible(true);
			}
			
		});
		JLabel lblNewLabel_38 = new JLabel("Payment Successful!!");
		lblNewLabel_38.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_38.setFont(new Font("Stencil", Font.BOLD, 34));
		lblNewLabel_38.setBounds(223, 343, 753, 232);
		getContentPane().add(lblNewLabel_38);
		lblNewLabel_38.setVisible(false);
		lblNewLabel_38.setBorder(border);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 248, 220));
		panel.setBounds(10, 342, 203, 231);
		getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 204));
		panel_1.setBounds(223, 343, 753, 230);
		getContentPane().add(panel_1);
		panel_1.setVisible(false);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 248, 220));
		panel_2.setBounds(10, 56, 966, 268);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("- - - - - - - - - - - - - - - - - - - >");
		lblNewLabel_10.setBounds(373, 63, 231, 23);
		panel_2.add(lblNewLabel_10);
		lblNewLabel_10.setFont(new Font("Britannic Bold", Font.BOLD, 16));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.setBounds(652, 348, 311, 26);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("PAY");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","password");
					String query = "update flight_user set total_cost=? where user_pnr=?";
					PreparedStatement st = con.prepareStatement(query);
					st.setInt(1,tCost);
					st.setString(2, prn);
					st.executeUpdate();
					
					lblNewLabel_35.setVisible(false);
					lblNewLabel_29.setVisible(false);
					textField.setVisible(false);
					lblNewLabel_30.setVisible(false);
					lblNewLabel_32.setVisible(false);
					textField_1.setVisible(false);
					lblNewLabel_33.setVisible(false);
					textField_2.setVisible(false);
					lblNewLabel_34.setVisible(false);
					textField_3.setVisible(false);
					lblNewLabel_31.setVisible(false);
					textField_4.setVisible(false);
					lblNewLabel_37.setVisible(false);
					btnNewButton.setVisible(false);
					btnNewButton_2.setVisible(false);
					lblNewLabel_36.setVisible(false);
					btnNewButton_3.setVisible(false);
					lblNewLabel_38.setVisible(true);
					panel_1.setVisible(true);
					st.close();
					con.close();
				}catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBackground(new Color(255, 153, 102));
		btnNewButton_3.setFont(new Font("Stencil", Font.PLAIN, 30));
		btnNewButton_3.setBounds(226, 529, 750, 44);
		getContentPane().add(btnNewButton_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 204, 102));
		panel_3.setBounds(0, 10, 986, 36);
		getContentPane().add(panel_3);
		
		
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(153, 255, 255));
		frame.setBounds(100, 100, 906, 604);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		setSize(1000, 630);
		
	}
}
