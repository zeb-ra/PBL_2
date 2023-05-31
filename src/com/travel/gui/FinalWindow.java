package com.travel.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class FinalWindow {
	protected static final String String = null;
	private String selectedTrainNumber;
    private JFrame frame;
    JLabel nextIconLabel;
    
    String trainName;
    String trainType;
    String coachClass;
    int foodCost;
    int seatCost;
    int fareCost;
    String waitingList;
    Time deptTime;
    Date deptDate;
    Time arrTime;
    Date arrDate;
    String deptStation;
    String arrStation;
    
    
    JLabel paidIconLabel;
    
    
    
    
    
    
    

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FinalWindow window = new FinalWindow(String);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the app
     * lication.
     */
    public FinalWindow(String selectedTrainNumber) throws Exception{
        this.selectedTrainNumber = selectedTrainNumber;
    	initialize();
    }

    /**
     * Initialize the contents of the frame.
     * @throws Exception 
     */
    private void initialize() throws Exception {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(251, 255, 179));
        frame.setBounds(100, 100, 451, 334);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
	    Image img = new ImageIcon(this.getClass().getResource("/card34.png")).getImage();
		
		
		
		
        String query = "SELECT * FROM RailwayTable WHERE trainno = ?";
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, selectedTrainNumber);
        ResultSet rs = st.executeQuery();


        while (rs.next()) {

            trainName = rs.getString("trainname");
            trainType = rs.getString("traintype");
            coachClass = rs.getString("coachclass");
            foodCost = rs.getInt("food");
            seatCost = rs.getInt("seat");
            fareCost = rs.getInt("fare");
            waitingList = rs.getString("waitinglist");
            deptTime = rs.getTime("depttime");
            deptDate = rs.getDate("deptdate"); 
            deptStation = rs.getString("deptStation");
            arrTime = rs.getTime("arrtime");
            arrDate = rs.getDate("arrdate");
            arrStation = rs.getString("arrStation");
            
        }

        st.close();
        rs.close();
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(194, 239, 239));
		panel_2_1.setLayout(null);
		panel_2_1.setForeground(Color.BLACK);
		panel_2_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Train Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1.setBounds(10, 29, 416, 94);
		frame.getContentPane().add(panel_2_1);
		
		JLabel trainNoDisp = new JLabel("31145");
		trainNoDisp.setBounds(140, 23, 48, 13);
		panel_2_1.add(trainNoDisp);
		trainNoDisp.setText(selectedTrainNumber);
		
		JLabel trainNameDisp = new JLabel("Train-18");
		trainNameDisp.setBounds(177, 23, 48, 13);
		panel_2_1.add(trainNameDisp);
		trainNameDisp.setText(trainName);
		
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBackground(new Color(194, 239, 239));
		panel_2_2.setLayout(null);
		panel_2_2.setForeground(Color.BLACK);
		panel_2_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Train Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_2.setBounds(10, 133, 173, 113);
		frame.getContentPane().add(panel_2_2);
		
		JLabel lblNewLabel_4 = new JLabel("Seat:");
		lblNewLabel_4.setBounds(66, 24, 45, 13);
		panel_2_2.add(lblNewLabel_4);
		
		
		JLabel lblNewLabel_5 = new JLabel("Fare:");
		lblNewLabel_5.setBounds(66, 52, 45, 13);
		panel_2_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Food:");
		lblNewLabel_6.setBounds(66, 38, 45, 13);
		panel_2_2.add(lblNewLabel_6);
				
				
				JLabel seatCostDisp = new JLabel("");
				seatCostDisp.setBounds(121, 24, 80, 13);
				panel_2_2.add(seatCostDisp);
						seatCostDisp.setText("₹"+seatCost);
						
						JLabel fareCostDisp = new JLabel("");
						fareCostDisp.setBounds(121, 52, 80, 13);
						panel_2_2.add(fareCostDisp);
						fareCostDisp.setText("₹"+fareCost);
								
								JLabel foodCostDisp = new JLabel("");
								foodCostDisp.setBounds(121, 38, 80, 13);
								panel_2_2.add(foodCostDisp);
								foodCostDisp.setText("₹"+foodCost);
								
								JLabel lblNewLabel_9 = new JLabel("----------------------");
								lblNewLabel_9.setBounds(66, 63, 101, 13);
								panel_2_2.add(lblNewLabel_9);
								
								JLabel lblNewLabel_10 = new JLabel("Total:");
								lblNewLabel_10.setBounds(66, 75, 70, 13);
								panel_2_2.add(lblNewLabel_10);
								
								int totalCost = fareCost+foodCost+seatCost;
								JLabel lblNewLabel_11 = new JLabel("");
								lblNewLabel_11.setBounds(121, 75, 45, 13);
								panel_2_2.add(lblNewLabel_11);
								lblNewLabel_11.setText("₹"+totalCost);

		
		
		
		
		
//		
//		
//        String trainName = rs.getString("trainname");
//        String trainType = rs.getString("traintype");
//        String coachClass = rs.getString("coachclass");
//        String foodCost = rs.getString("food");
//        String seatCost = rs.getString("seat");
//        String fareCost = rs.getString("fare");
//        String waitingList = rs.getString("waitinglist");
//        String deptTime = rs.getString("depttime");
//        String arrTime = rs.getString("arrtime");
		
		JLabel trainCoachDisp = new JLabel("");
		trainCoachDisp.setBounds(228, 23, 40, 13);
		panel_2_1.add(trainCoachDisp);
		trainCoachDisp.setText(coachClass);
		
		//arrival
		JLabel arrTimeDisp = new JLabel("");
		arrTimeDisp.setBounds(336, 46, 100, 13);
		panel_2_1.add(arrTimeDisp);
        SimpleDateFormat dateFormat_1 = new SimpleDateFormat("hh:mm:ss");
        String formattedArrTime = dateFormat_1.format(arrTime);
		arrTimeDisp.setText(formattedArrTime);
		
		JLabel arrDateDisp = new JLabel("");
		arrDateDisp.setBounds(336, 56,100, 13);
		panel_2_1.add(arrDateDisp);
        SimpleDateFormat dateFormat_2 = new SimpleDateFormat("dd-MM-yyyy");
        String formattedArrDate = dateFormat_2.format(arrDate);
		arrDateDisp.setText(formattedArrDate);

		
		JLabel arrStationDisp = new JLabel("");
		arrStationDisp.setBounds(336, 23, 100, 13);
		panel_2_1.add(arrStationDisp);
		arrStationDisp.setText(arrStation);
		
		
		//departure
		JLabel deptTimeDisp = new JLabel("");
		deptTimeDisp.setBounds(10,46, 100, 13);
		panel_2_1.add(deptTimeDisp);
        SimpleDateFormat dateFormat_3 = new SimpleDateFormat("hh:mm:ss");
        String formattedDeptTime = dateFormat_3.format(deptTime);
        deptTimeDisp.setText(formattedDeptTime);
		
		JLabel deptDateDisp = new JLabel("");
		deptDateDisp.setBounds(10, 56, 100, 13);
		panel_2_1.add(deptDateDisp);
        SimpleDateFormat dateFormat_4 = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDeptDate = dateFormat_4.format(deptDate);
		deptDateDisp.setText(formattedDeptDate);

		
		JLabel deptStationDisp = new JLabel("");
		deptStationDisp.setBounds(10, 23, 58, 13);
		panel_2_1.add(deptStationDisp);
		deptStationDisp.setText(deptStation);
		
		JLabel lblNewLabel_7 = new JLabel("<--------------");
		lblNewLabel_7.setBounds(72, 23, 92, 13);
		panel_2_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("-------------->");
		lblNewLabel_8.setBounds(263, 23, 86, 13);
		panel_2_1.add(lblNewLabel_8);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();		}
		});
		btnNewButton_1.setBounds(10, 256, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblReservation = new JLabel("Reservation");
		lblReservation.setHorizontalAlignment(SwingConstants.CENTER);
		lblReservation.setFont(new Font("Verdana", Font.BOLD, 20));
		lblReservation.setBounds(195, 133, 205, 75);
		frame.getContentPane().add(lblReservation);
		
		


     


		
		

		paidIconLabel = new JLabel("");

        System.setProperty("sun.java2d.uiScale", "1.0"); // to reduce blur

        Image paidImg = new ImageIcon(this.getClass().getResource("/paid.png")).getImage();

		paidIconLabel.setBounds(10, 26, 99, 111);
		panel_2_2.add(paidIconLabel);
		
		        paidIconLabel.setIcon(new ImageIcon(paidImg));  
		        
		        JPanel panel_4 = new JPanel();
		        panel_4.setBackground(new Color(255, 0, 128));
		        panel_4.setBounds(0, 0, 437, 17);
		        frame.getContentPane().add(panel_4);
		        
		        JPanel panel_1 = new JPanel();
		        panel_1.setBackground(new Color(0, 128, 255));
		        panel_1.setBounds(0, 280, 437, 17);
		        frame.getContentPane().add(panel_1);
		        
		        JLabel lblNewLabel = new JLabel("successful!");
		        lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		        lblNewLabel.setBounds(273, 183, 185, 28);
		        frame.getContentPane().add(lblNewLabel);

        


    }
    
    public void setVisible(boolean visible) {
        JLabel label=new JLabel("window");
        frame.getContentPane().add(label);
        frame.setVisible(visible);
    }
}
