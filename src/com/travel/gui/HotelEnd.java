package com.travel.gui;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;

public class HotelEnd extends JFrame {
	
	private JPanel contentPane;
	public JLabel id;
	public JLabel city;
	public JLabel name;
	public JLabel people;
	public JLabel in;
	public JLabel out;
	public JLabel lblDays;
	public String id1;
	public String city1;
	public String name1;
	public String people1;
	public String in1;
	public String out1;
	private JLabel lblNewLabel_3;
	private JLabel tamount;
	private JLabel lblTaxes;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel amount;
	private JLabel tax;
	private JLabel finalamt;
	int min = 100;
	int max = 700;
	private JLabel lblTotal;
	private JLabel Booked;
	private JLabel lblNewLabel_7;
	private JLabel username;
	private JTextField tusername;
	private JLabel card;
	private JTextField tcardno;
	private JLabel exp;
	private JTextField texpiry;
	private JLabel upi_id;
	private JTextField tupi_id;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					HotelEnd frame = new HotelEnd(int.class);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//	public void setLabelText(String id,String city,String name,String people,String in,String out)
//	{
//		id1 = id;
//		city1 = city;
//		name1 = name;
//		people1 = people;
//		in1 = in;
//		out1 = out;
//		
//		System.out.println(id1);
//	}
	
	
	/**
	 * @wbp.parser.constructor
	 */
	public HotelEnd(int bookingid) 
	{
		System.out.println("this is 2nd window: ");
		System.out.println(bookingid);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 577);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(251, 255, 179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Booking Details");
		lblNewLabel.setBounds(183, -22, 354, 84);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("HotelID:-\r\n");
		lblNewLabel_1.setBounds(20, 56, 115, 33);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Hotel Name:-\r\n");
		lblNewLabel_2.setBounds(20, 85, 115, 45);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Number of people:-");
		lblNewLabel_2_1.setBounds(20, 123, 147, 45);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Check In:-\r\n");
		lblNewLabel_2_1_1.setBounds(20, 166, 147, 45);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Check Out:-\r\n");
		lblNewLabel_2_1_1_1.setBounds(320, 161, 147, 45);
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("City:-\r\n");
		lblNewLabel_1_1.setBounds(332, 56, 115, 33);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(lblNewLabel_1_1);
		
		id = new JLabel("");
		id.setBounds(98, 56, 115, 33);
		id.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(id);
		
	    city = new JLabel("");
	    city.setBounds(380, 56, 115, 33);
		city.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(city);
		
		name = new JLabel("");
		name.setBounds(123, 85, 449, 44);
		name.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(name);
		
		people = new JLabel("");
		people.setBounds(172, 123, 296, 45);
		people.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(people);
		
		in = new JLabel("");
		in.setBounds(108, 167, 161, 42);
		in.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(in);
		
	    out = new JLabel("");
	    out.setBounds(413, 161, 161, 42);
		out.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(out);
		
		lblNewLabel_3 = new JLabel("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		lblNewLabel_3.setBounds(0, 219, 688, 13);
		contentPane.add(lblNewLabel_3);
		
		tamount = new JLabel("Amount:-");
		tamount.setBounds(30, 275, 189, 33);
		tamount.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(tamount);
		
		lblTaxes = new JLabel("Taxes:-");
		lblTaxes.setBounds(30, 314, 303, 33);
		lblTaxes.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(lblTaxes);
		
		lblNewLabel_4 = new JLabel("+");
		lblNewLabel_4.setBounds(10, 299, 323, 33);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("______________________");
		lblNewLabel_5.setBounds(10, 318, 323, 42);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Bill Summary");
		lblNewLabel_6.setBounds(20, 221, 167, 57);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 22));
		contentPane.add(lblNewLabel_6);
		
		amount = new JLabel("");
		amount.setBounds(108, 275, 225, 33);
		amount.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(amount);
		
		tax = new JLabel("");
		tax.setBounds(108, 296, 225, 69);
		tax.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(tax);
		
		finalamt = new JLabel("");
		finalamt.setBounds(106, 336, 227, 44);
		finalamt.setFont(new Font("Tahoma", Font.BOLD, 17));
		contentPane.add(finalamt);
		
		lblTotal = new JLabel("Total:-");
		lblTotal.setBounds(30, 342, 303, 33);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 17));
		contentPane.add(lblTotal);
		ImageIcon img = new ImageIcon("D:/JavaaEclipse/Project/Image/Tick.png");
		ImageIcon img1 = new ImageIcon("D:/JavaaEclipse/Project/Image/Box.png");
		
		Booked = new JLabel("Booked Successfully");
		Booked.setBounds(172, 456, 217, 84);
		Booked.setForeground(new Color(0, 255, 0));
		Booked.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(Booked);
		Booked.setVisible(false);
		
		lblNewLabel_7 = new JLabel("Payment Mode:-");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7.setBounds(250, 219, 147, 67);
		contentPane.add(lblNewLabel_7);
		
		String[] messageStrings = {"Select payment method","Card","UPI"};
		JComboBox comboBox = new JComboBox(messageStrings);
		comboBox.setBounds(372, 242, 155, 21);
		contentPane.add(comboBox);
		
		username = new JLabel("Name:-");
		username.setEnabled(false);
		username.setFont(new Font("Tahoma", Font.PLAIN, 15));
		username.setBounds(303, 276, 94, 33);
		contentPane.add(username);
		
		tusername = new JTextField();
		tusername.setEnabled(false);
		tusername.setBounds(368, 284, 127, 21);
		contentPane.add(tusername);
		tusername.setColumns(10);
		
		card = new JLabel("Card No:-");
		card.setEnabled(false);
		card.setFont(new Font("Tahoma", Font.PLAIN, 15));
		card.setBounds(303, 318, 66, 29);
		contentPane.add(card);
		
		tcardno = new JTextField();
		tcardno.setEnabled(false);
		tcardno.setBounds(371, 324, 124, 19);
		contentPane.add(tcardno);
		tcardno.setColumns(10);
		
		exp = new JLabel("Expiry:-");
		exp.setEnabled(false);
		exp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		exp.setBounds(303, 357, 63, 29);
		contentPane.add(exp);
		
		texpiry = new JTextField();
		texpiry.setEnabled(false);
		texpiry.setBounds(372, 361, 123, 19);
		contentPane.add(texpiry);
		texpiry.setColumns(10);
		
		
		username.setVisible(false);
        tusername.setVisible(false);
        card.setVisible(false);
        tcardno.setVisible(false);
        exp.setVisible(false);
        texpiry.setVisible(false);
		
		JButton Pay = new JButton("PAY");
		Pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Booked.setVisible(true);
			}
			
		});
		Pay.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Pay.setBounds(372, 419, 115, 33);
		contentPane.add(Pay);
		Pay.setVisible(false);
		
		upi_id = new JLabel("UPI ID:-");
		upi_id.setEnabled(false);
		upi_id.setFont(new Font("Tahoma", Font.PLAIN, 17));
		upi_id.setBounds(285, 310, 98, 41);
		contentPane.add(upi_id);
		
		tupi_id = new JTextField("@"+"");
		tupi_id.setEnabled(false);
		tupi_id.setBounds(351, 324, 144, 19);
		contentPane.add(tupi_id);
		tupi_id.setColumns(10);
		
		upi_id.setVisible(false);
		tupi_id.setVisible(false);
		// After creating and adding the comboBox to the contentPane
		comboBox.addItemListener(new ItemListener() {
		    public void itemStateChanged(ItemEvent e) {
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		            String selectedOption = comboBox.getSelectedItem().toString();
		           if(selectedOption.equals("Select payment method"))
		           {
		        	   username.setVisible(false);
		                tusername.setVisible(false);
		                card.setVisible(false);
		                tcardno.setVisible(false);
		                exp.setVisible(false);
		                texpiry.setVisible(false);
		                tusername.setText("");
		                tcardno.setText("");
		                texpiry.setText("");
		                upi_id.setVisible(false);
		                tupi_id.setVisible(false);
		                tupi_id.setText("");
		                Pay.setVisible(false);
		           }
		           else if (selectedOption.equals("Card")) 
		            {
		                // Display a message for Card option
		                JOptionPane.showMessageDialog(contentPane, "Payment selected: Card");
		                upi_id.setVisible(false);
		                tupi_id.setVisible(false);
		                tupi_id.setText("");
		                username.setVisible(true);
		                tusername.setVisible(true);
		                card.setVisible(true);
		                tcardno.setVisible(true);
		                exp.setVisible(true);
		                texpiry.setVisible(true);
		                username.setEnabled(true);
		                tusername.setEnabled(true);
		                card.setEnabled(true);
		                tcardno.setEnabled(true);
		                exp.setEnabled(true);
		                texpiry.setEnabled(true);
		                Pay.setVisible(true);
		            } 
		            else if (selectedOption.equals("UPI"))
		            {
		                // Display a message for UPI option
		                JOptionPane.showMessageDialog(contentPane, "Payment selected: UPI");
		                username.setVisible(false);
		                tusername.setVisible(false);
		                card.setVisible(false);
		                tcardno.setVisible(false);
		                exp.setVisible(false);
		                texpiry.setVisible(false);
		                tusername.setText("");
		                tcardno.setText("");
		                texpiry.setText("");
		                upi_id.setVisible(true);
		                tupi_id.setVisible(true);
		                upi_id.setEnabled(true);
		                tupi_id.setEnabled(true);
		                Pay.setVisible(true);
		            }
		        }
		    }
		});

		
	

		
		
		try 
		{
	        Class.forName("oracle.jdbc.driver.OracleDriver");
	        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
			
			Statement smt = con.createStatement();
			ResultSet rs = smt.executeQuery("select * from b_hotel where bookingid =" + bookingid);
			
			while(rs.next())
			{
				String id1 = rs.getString(1);
				String name1= rs.getString(2);
				String city1 = rs.getString(3);
				String address1 = rs.getString(4);
				String number1 = rs.getString(5);
				String website1 = rs.getString(6);
				String rating1 = rs.getString(7);
				int price1 = Integer.parseInt(rs.getString(8));
				int days = Integer.parseInt(rs.getString(10));
				
				int amt = (price1 * days);
				String result = String.valueOf(amt);
				
				int tax1 = (int) (Math.random() * (max - min + 1)) + min;
				String result1 = String.valueOf(tax1);
				
				int finalr = amt + tax1;
				String result2 = String.valueOf(finalr);
//				System.out.println("Id is\t" + id1);
//				System.out.println("Name is\t" + name1);
//				System.out.println("City is\t" + city1);
//				System.out.println("Address is\t" + address1);
//				System.out.println("Number is\t" + number1);
//				System.out.println("Website is\t" + website1);
//				System.out.println("Rating is\t" + rating1);
//				System.out.println("Price is\t" + price1);
//				System.out.println("Other Id is\t" + id2);
				
				id.setText(id1);
				city.setText(city1);
				name.setText(name1);
				amount.setText(result);
				tax.setText(result1);
				finalamt.setText(result2);
			
				
				
			}
			
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		
		
	}

	public HotelEnd(Class<Integer> class1) {
		// TODO Auto-generated constructor stub
	}
//    public void setVisible(boolean visible) {
//        this.setVisible(visible);
//    }
}