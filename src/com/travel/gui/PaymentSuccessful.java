package com.travel.gui;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class PaymentSuccessful extends JFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentSuccessful window = new PaymentSuccessful();
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
	public PaymentSuccessful() {
		getContentPane().setBackground(new Color(153, 255, 255));
		getContentPane().setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
		JLabel lblNewLabel = new JLabel("Payment Successful!!");
		lblNewLabel.setFont(new Font("Stencil", Font.BOLD, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 85, 266, 66);
		getContentPane().add(lblNewLabel);
		lblNewLabel.setBorder(border);
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		}
}
