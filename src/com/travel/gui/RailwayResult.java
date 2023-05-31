package com.travel.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.sql.*;
import java.util.*;
import java.lang.*;
import java.awt.Color;
import javax.swing.JPanel;

public class RailwayResult extends JFrame {
    protected static final String String = null;
	private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private String idType;
    private JTextField textField_3;
    private JTextField textField_4;
    JLabel nextIconLabel;
    private JFrame frame;
    String selectedTrainNumber;
    String logInId;
    //SETTING VARIABLES FOR PASSENGER //ONLY 1 PASSENGER ALLOWED FOR THE TIMEBEING
    private String paxName;
    private String paxGender;
    private int paxAge;
    private String paxIdType;
    private int paxIdNo;
    private String paxFood;
    private int paxPhone;
    private String paxEmail;
    int paxId;
    

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RailwayResult window = new RailwayResult(String, String);
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    public RailwayResult(String selectedTrainNumber, String logInId) throws ClassNotFoundException, SQLException {
    	getContentPane().setBackground(new Color(251, 255, 179));
    	this.selectedTrainNumber = selectedTrainNumber;
    	this.logInId = logInId;
    	System.out.println("THIS IS: " + logInId);
    	System.out.println("\n");
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     * @throws ClassNotFoundException 
     * @throws SQLException 
     */
    private void initialize() throws ClassNotFoundException, SQLException 
    {
//    	System.out.println("RAILWAY RESULT"+selectedTrainNumber);
 
    	
        frame = this;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 450, 300);
        frame.getContentPane().setLayout(null);
        
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 0, 128));
        panel.setBounds(0, 0, 878, 17);
        getContentPane().add(panel);

        JLabel lblNewLabel = new JLabel("Passenger Details");
        lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 19));
        lblNewLabel.setBounds(10, 13, 218, 35);
        getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Name:");
        lblNewLabel_1.setBounds(10, 58, 45, 13);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Age:");
        lblNewLabel_2.setBounds(10, 93, 45, 13);
        frame.getContentPane().add(lblNewLabel_2);

        textField = new JTextField();
        textField.setBounds(57, 55, 96, 19);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(57, 90, 45, 19);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(197, 120, 96, 19);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);


        System.setProperty("sun.java2d.uiScale", "1.0"); // to reduce blur
        nextIconLabel = new JLabel("");
        Image img = new ImageIcon(this.getClass().getResource("/next.png")).getImage();

        nextIconLabel.setIcon(new ImageIcon(img));

        nextIconLabel.setBounds(383, 208, img.getHeight(nextIconLabel), img.getWidth(nextIconLabel));
        frame.getContentPane().add(nextIconLabel);


        JComboBox<String> idTypeComboBox = new JComboBox<String>();
        idTypeComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                idType = idTypeComboBox.getSelectedItem().toString();
                System.out.println(idType);


            }
        });

        idTypeComboBox.addItem("Aadhaar Card");
        idTypeComboBox.addItem("PAN Card");
        idTypeComboBox.addItem("Driving Licence");
        idTypeComboBox.addItem("Ration Card");

        idTypeComboBox.setEditable(true);
        idTypeComboBox.setBounds(57, 119, 130, 21);
        frame.getContentPane().add(idTypeComboBox);

        JLabel lblNewLabel_4 = new JLabel("ID:");
        lblNewLabel_4.setBounds(10, 123, 45, 19);
        frame.getContentPane().add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Food:");
        lblNewLabel_5.setBounds(10, 154, 38, 13);
        frame.getContentPane().add(lblNewLabel_5);

        JComboBox<String> foodTypeComboBox = new JComboBox<String>();
        foodTypeComboBox.setEditable(true);
        foodTypeComboBox.setBounds(57, 150, 78, 21);
        frame.getContentPane().add(foodTypeComboBox);
        foodTypeComboBox.addItem("Veg");
        foodTypeComboBox.addItem("Non-Veg");
        foodTypeComboBox.addItem("None");

        JComboBox<String> genderComboBox = new JComboBox<String>();
        genderComboBox.setEditable(true);
        genderComboBox.setBounds(165, 54, 68, 21);
        frame.getContentPane().add(genderComboBox);

        textField_3 = new JTextField();
        textField_3.setBounds(57, 186, 96, 19);
        frame.getContentPane().add(textField_3);
        textField_3.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Phone:");
        lblNewLabel_3.setBounds(10, 189, 45, 13);
        frame.getContentPane().add(lblNewLabel_3);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(57, 219, 96, 19);
        frame.getContentPane().add(textField_4);

        JLabel lblNewLabel_6 = new JLabel("E-mail:");
        lblNewLabel_6.setBounds(10, 222, 45, 13);
        frame.getContentPane().add(lblNewLabel_6);

        JButton btnNewButton = new JButton("Payment");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	
            	paxName = textField.getText();
                paxGender = genderComboBox.getSelectedItem().toString();
                paxAge = Integer.parseInt(textField_1.getText());
                paxIdType = idTypeComboBox.getSelectedItem().toString();
                paxIdNo = Integer.parseInt(textField_2.getText());
                paxFood = foodTypeComboBox.getSelectedItem().toString();
                paxPhone = Integer.parseInt(textField_3.getText());
                paxEmail = textField_4.getText();
                
                
                
//                System.out.println(paxName+paxGender+paxAge+paxIdType+paxIdNo+paxFood+paxPhone+paxEmail);
            	
    			String query = "insert into passengerdetails values(?,?,?,?,?,?,?,?,?)";
    			

    			
    			try {
    				paxId = (int)(Math.random()*1234);
        			PreparedStatement statement = con.prepareStatement(query);
					statement.setString(1, paxName);
	    			statement.setString(2, paxGender);
	    			statement.setInt(3, paxAge);
	    			statement.setString(4, paxIdType);
	    			statement.setInt(5, paxIdNo);
	    			statement.setString(6, paxFood);
	    			statement.setInt(7, paxPhone);
	    			statement.setString(8, paxEmail);
	    			statement.setInt(9, paxId);
	    			statement.execute();
	            	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
  	   	
            	
                try {
                    PaymentWindow nextWindow = new PaymentWindow(selectedTrainNumber, logInId, paxId);
                    nextWindow.setVisible(true);
                    frame.dispose();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }
        });
        btnNewButton.setBounds(243, 203, 130, 35);
        frame.getContentPane().add(btnNewButton);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(194, 239, 239));
        panel_1.setBounds(0, 246, 834, 17);
        getContentPane().add(panel_1);
        genderComboBox.addItem("Male");
        genderComboBox.addItem("Female");
    }
    
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
    }
}
