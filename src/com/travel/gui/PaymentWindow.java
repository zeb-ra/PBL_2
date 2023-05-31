package com.travel.gui;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import java.lang.*;
import java.lang.*;
public class PaymentWindow extends JFrame{
	protected static final String String = null;

    JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    JLabel lblNewLabel_5;
    JLabel lblNewLabel_7;
    JPanel panel_3;
    Timer timer;
    int pnr;
    int txnId;
    String selectedMode;
    String selectedTrainNumber;
    String logInId;
    int paxId;
    Timer timer1;
    JLabel countdownLabel;
    private JProgressBar progressBar;
    ActionEvent e;
  
    private int progress;
    private static final int Countdown_Duration = 5;
    private static final int Timer_Delay = 1000;

	protected static final Integer Integer = null;
    String viaSelectedTrainNumber;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
        	public void run() {
            try {
                PaymentWindow window = new PaymentWindow(String, String, Integer);
      
                window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            }
        });
    }


    public PaymentWindow(String selectedTrainNumber, String logInId, Integer paxId) throws ClassNotFoundException, SQLException {
    	this.selectedTrainNumber = selectedTrainNumber;
    	
    	this.logInId = logInId;
    	System.out.println("THIS IS: " + logInId);
    	System.out.println("\n");
    	this.paxId = paxId;
    	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
         
//    	viaSelectedTrainNumber = selectedMode;
        frame = new JFrame("Train Reservation System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(251, 255, 179));
        panel.setLayout(null);

        frame.getContentPane().add(panel);
        
        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(255, 0, 128));
        panel_4.setBounds(0, 0, 543, 17);
        panel.add(panel_4);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(194, 239, 239));
        panel_2.setLayout(null);
        panel_2.setForeground(Color.BLACK);
        panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Cards", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel_2.setBounds(10, 57, 227, 212);
        panel.add(panel_2);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 128, 255));
        panel_1.setBounds(0, 195, 227, 17);
        panel_2.add(panel_1);
        
        JLabel lblNewLabel = new JLabel("Card No:");
        lblNewLabel.setBounds(10, 53, 86, 13);
        panel_2.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Exp Date:");
        lblNewLabel_1.setBounds(10, 76, 86, 13);
        panel_2.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("CVV:");
        lblNewLabel_2.setBounds(10, 99, 45, 13);
        panel_2.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Name");
        lblNewLabel_3.setBounds(10, 30, 45, 13);
        panel_2.add(lblNewLabel_3);
        
        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(95, 27, 96, 19);
        panel_2.add(textField);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(95, 50, 96, 19);
        panel_2.add(textField_1);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(95, 73, 96, 19);
        panel_2.add(textField_2);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(95, 96, 96, 19);
        panel_2.add(textField_3);
        
        JButton payButton = new JButton("Pay");
        payButton.addActionListener(new ActionListener() {
        	@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
        		
    			
    			

    			
    			try {                           
    				String query = "insert into bookingdetails values(?,?,?,?,?,?)";
    				int pnr = (int)(Math.random()*1234);
        			PreparedStatement statement = con.prepareStatement(query);
					statement.setString(1, logInId);
	    			statement.setInt(2, pnr);
	    			statement.setInt(3, Integer.parseInt(selectedTrainNumber));
	    			statement.setString(4, selectedMode);
	    			statement.setInt(5, paxId);
	    			statement.setInt(6, txnId);
	    			statement.execute();
	    			statement.close();
	    			
	    		
	            	
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
        	
        		
        		
                try {
//					FinalWindow nextWindow = new FinalWindow(viaSelectedTrainNumber);
                	FinalWindow nextWindow = new FinalWindow(selectedTrainNumber);
					nextWindow.setVisible(true);
					frame.dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
        		
        	}
        });
        
        

        

        
        
        
        payButton.setBounds(80, 125, 96, 30);
        panel_2.add(payButton);
        
        JLabel lblNewLabel_12 = new JLabel("");
        lblNewLabel_12.setBounds(10, 122, 52, 72);
        panel_2.add(lblNewLabel_12);
        
         

        
        
        
        panel_3 = new JPanel();
        panel_3.setBackground(new Color(194, 239, 239));
        panel_3.setLayout(null);
        panel_3.setForeground(Color.BLACK);
        panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "UPI", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel_3.setBounds(292, 57, 241, 212);
        panel.add(panel_3);
        
        JLabel lblNewLabel_3_1 = new JLabel("Scan QR Code");
        lblNewLabel_3_1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 10));
        lblNewLabel_3_1.setBounds(78, 0, 67, 34);
        panel_3.add(lblNewLabel_3_1);
        
      
        
        
        System.setProperty("sun.java2d.uiScale", "1.0"); // to reduce blur
        JLabel lblNewLabel_4 = new JLabel("");
        
        Image img = new ImageIcon(this.getClass().getResource("/qrcode.png")).getImage();

        lblNewLabel_4.setIcon(new ImageIcon(img));

        lblNewLabel_4.setBounds(67, 19, 111, 114);
    
 
        panel_3.add(lblNewLabel_4);
        
                JButton nextButton = new JButton("Next");
                nextButton.setBounds(67, 129, 101, 21);
                panel_3.add(nextButton);
                
                JPanel panel_1_1 = new JPanel();
                panel_1_1.setBackground(new Color(255, 128, 64));
                panel_1_1.setBounds(0, 195, 241, 17);
                panel_3.add(panel_1_1);
                

                

                nextButton.addActionListener(new ActionListener() {
                    @SuppressWarnings("static-access")
					public void actionPerformed(ActionEvent e) {
            			
            			

            			
            			try {                           
            				String query = "insert into bookingdetails values(?,?,?,?,?,?)";
            				int pnr = (int)(Math.random()*1234);
                			PreparedStatement statement = con.prepareStatement(query);
        					statement.setString(1, logInId);
        	    			statement.setInt(2, pnr);
        	    			statement.setInt(3, Integer.parseInt(selectedTrainNumber));
        	    			statement.setString(4, selectedMode);
        	    			statement.setInt(5, paxId);
        	    			statement.setInt(6, txnId);
        	    			statement.execute();
        	    			statement.close();
        	    			
        	    		
        	            	
        				} catch (Exception e1) {
        					// TODO Auto-generated catch block
        					e1.printStackTrace();
        				}
                		
                	
                		
                		
                        try {
//        					FinalWindow nextWindow = new FinalWindow(viaSelectedTrainNumber);
                        	FinalWindow nextWindow = new FinalWindow(selectedTrainNumber);
        					nextWindow.setVisible(true);
        					frame.dispose();
        				} catch (Exception e1) {
        					// TODO Auto-generated catch block
        					e1.printStackTrace();
        				}
                		
                		
                	}
                });                    	



        
        JComboBox<String> paymentComboBox = new JComboBox<String>();        
        
        
        frame.setSize(557, 316);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        
        paymentComboBox.addItem("Select");
        paymentComboBox.addItem("Card");
        paymentComboBox.addItem("UPI");
		panel_2.setVisible(false);
		panel_3.setVisible(false);
        paymentComboBox.addActionListener(new ActionListener() {
        	@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
//        		retryButton.setVisible(false);
        		panel_2.setVisible(false);
        		panel_3.setVisible(false);
        		selectedMode = paymentComboBox.getSelectedItem().toString();
        		if(selectedMode == "Card") {
//        			timer.stop();
        			panel_2.setVisible(true);
        			if(lblNewLabel_7 == null) {
        				
        			}
        			else {
        				lblNewLabel_7.hide();	
        			}
        			
        			
        			
        		
        			
        	         txnId =(int)(Math.random()*1000000);
        	         System.out.println(txnId);
        	         lblNewLabel_5 = new JLabel("Transaction ID: " + Integer.toString(txnId));
        	         lblNewLabel_5.setBounds(10, 151, 209, 20);
        	         panel_2.add(lblNewLabel_5);
        	         lblNewLabel_5.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        	         
        	         countdownLabel.hide();
        	        
        	         
        	         timer.restart();
        	         ((Timer) e.getSource()).stop();
        	         panel_3.setVisible(false);
        	         
        		}
        		else if (selectedMode == "UPI"){
        			

     		       	
//     		       	timer.restart();
        		
        			panel_3.setVisible(true);
        			if(lblNewLabel_5 == null) {
        				
        			}
        			else {
        				lblNewLabel_5.hide();	
        			}

        			
        			
        	         int txnId =(int)(Math.random()*1000000);
        	         System.out.println(txnId);
                     lblNewLabel_7 = new JLabel("Transaction ID: " + Integer.toString(txnId));
                     lblNewLabel_7.setBounds(10, 151, 209, 13);
                     panel_3.add(lblNewLabel_7);
        	         lblNewLabel_7.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        	         panel_2.setVisible(false);
        	       
         		    countdownLabel = new JLabel("");
     		       	countdownLabel.setBounds(325, 37, 300, 18);
     		       countdownLabel.setFont(new Font("Segoe UI", Font.PLAIN, 10));
     		       	panel.add(countdownLabel);
        	         timer = new Timer(Timer_Delay, new ActionListener() {
        	            	int countdown = Countdown_Duration;
        	            	
        	            	
        	            	@Override
        	                public void actionPerformed(ActionEvent e) {
        	                    countdownLabel.setText("Complete Transaction in: " + countdown + " seconds");
        	                    
        	                    if (countdown == 0) {

        	                    	panel_3.setVisible(false);
        	                        ((Timer) e.getSource()).stop();
//        	                        retryButton.setVisible(true);
        	                        	
        	                        
        	                        
        	               
        	                    } else {
        	                        countdown--;
        	                    }
        	                }
        	            });
        	         
        	         timer.start();
        			 
        	      
   		        
        		        

        		        
        		        
        		  
        		}
        		
        		
        	}
        });
        paymentComboBox.setEditable(true);
        paymentComboBox.setBounds(125, 32, 112, 21);
        panel.add(paymentComboBox);
        

        
        JLabel lblNewLabel_6 = new JLabel("Payment Mode:");
        lblNewLabel_6.setFont(new Font("Verdana", Font.PLAIN, 13));
        lblNewLabel_6.setBounds(10, 34, 193, 13);
        panel.add(lblNewLabel_6);
        

        

        
        
        
        
       
               
        
    }






    public void AddToTable() {

    	 
    }




	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}























































