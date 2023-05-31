package com.travel.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;

public class SecondWindow extends JFrame {
	protected static final String String = null;
	String logInId;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SecondWindow window = new SecondWindow(String);
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public SecondWindow(String logInId) {
    	getContentPane().setBackground(new Color(251, 255, 179));
    	this.logInId = logInId;
    	System.out.println("THIS IS: " + logInId);
    	System.out.println("\n");
        getContentPane().setLayout(null);

        JButton btnBookFlight = new JButton("Book Flight");
        btnBookFlight.setForeground(new Color(29, 187, 226));
        btnBookFlight.setBackground(new Color(255, 255, 255));
        btnBookFlight.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        		Searching nextWindow= new Searching();
        		nextWindow.setVisible(true);
        		SecondWindow.this.dispose();
        		
            
        		
        		
        		}
        		catch(Exception e3) {
        			e3.printStackTrace();
        		}
        		
        	}
        });
        btnBookFlight.setFont(new Font("Arial Black", Font.PLAIN, 16));
        btnBookFlight.setBounds(27, 49, 379, 55);
        getContentPane().add(btnBookFlight);

        JButton btnBookTrain = new JButton("Book Train");
        btnBookTrain.setForeground(new Color(66, 149, 45));
        btnBookTrain.setBackground(new Color(255, 255, 255));
        btnBookTrain.setFont(new Font("Arial Black", Font.PLAIN, 16));
        btnBookTrain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RailwayWindow nextWindow;
                try {
                    nextWindow = new RailwayWindow(logInId);
                    nextWindow.setVisible(true);
                    SecondWindow.this.dispose();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }
        });
        btnBookTrain.setBounds(27, 114, 379, 55);
        getContentPane().add(btnBookTrain);

        JButton btnNewButton_1_1 = new JButton("Book Hotel");
        btnNewButton_1_1.setForeground(new Color(183, 105, 72));
        btnNewButton_1_1.setBackground(new Color(255, 255, 255));
        btnNewButton_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		try {
        		HotelResult nextWindow = new HotelResult();
        		nextWindow.setVisible(true);
        		SecondWindow.this.dispose();
        		}
        		
        		catch(Exception e2){
        			e2.printStackTrace();
        			
        		}
        		
        	}
        });
        btnNewButton_1_1.setFont(new Font("Arial Black", Font.PLAIN, 16));
        btnNewButton_1_1.setBounds(27, 179, 379, 55);
        getContentPane().add(btnNewButton_1_1);

        JLabel lblNewLabel_1 = new JLabel("BMT TRAVEL MANAGEMENT");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 23));
        lblNewLabel_1.setBounds(57, 0, 379, 55);
        getContentPane().add(lblNewLabel_1);
        
        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(255, 0, 128));
        panel_4.setBounds(419, 0, 17, 263);
        getContentPane().add(panel_4);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(194, 239, 239));
        panel_1.setBounds(0, 0, 17, 263);
        getContentPane().add(panel_1);

        setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
