//package com.travel.gui;
//
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JLabel;
//import java.awt.Font;
//import java.awt.GraphicsConfiguration;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//public class HotelFinal extends JFrame {
//
//	private JPanel contentPane;
//	public JLabel id;
//	public JLabel city;
//	public JLabel name;
//	public JLabel people;
//	public JLabel in;
//	public JLabel out;
//	public JLabel lblDays;
//	public String id1;
//	public String city1;
//	public String name1;
//	public String people1;
//	public String in1;
//	public String out1;
//	public JLabel day;
//	private JLabel lblNewLabel_3;
//	private JLabel tamount;
//	private JLabel lblTaxes;
//	private JLabel lblNewLabel_4;
//	private JLabel lblNewLabel_5;
//	private JLabel lblNewLabel_6;
//	private JLabel amount;
//	private JLabel tax;
//	private JLabel finalamt;
//	int min = 100;
//	int max = 700;
//	private JLabel lblTotal;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args)
//	{
//		
//	
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					project1 frame = new project1(int.class);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
////	public void setLabelText(String id,String city,String name,String people,String in,String out)
////	{
////		id1 = id;
////		city1 = city;
////		name1 = name;
////		people1 = people;
////		in1 = in;
////		out1 = out;
////		
////		System.out.println(id1);
////	}
//	
//	
//	/**
//	 * @wbp.parser.constructor
//	 */
//	public HotelFinal(int bookingid) 
//	{
//		System.out.println("this is 2nd window: ");
//		System.out.println(bookingid);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 689, 561);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JLabel lblNewLabel = new JLabel("Booking Details");
//		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
//		lblNewLabel.setBounds(10, 10, 354, 84);
//		contentPane.add(lblNewLabel);
//		
//		JLabel lblNewLabel_1 = new JLabel("HotelID:-\r\n");
//		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		lblNewLabel_1.setBounds(30, 91, 115, 33);
//		contentPane.add(lblNewLabel_1);
//		
//		JLabel lblNewLabel_2 = new JLabel("Hotel Name:-\r\n");
//		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		lblNewLabel_2.setBounds(30, 123, 115, 45);
//		contentPane.add(lblNewLabel_2);
//		
//		JLabel lblNewLabel_2_1 = new JLabel("Number of people:-");
//		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		lblNewLabel_2_1.setBounds(30, 166, 147, 45);
//		contentPane.add(lblNewLabel_2_1);
//		
//		JLabel lblNewLabel_2_1_1 = new JLabel("Check In:-\r\n");
//		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		lblNewLabel_2_1_1.setBounds(30, 218, 147, 45);
//		contentPane.add(lblNewLabel_2_1_1);
//		
//		JLabel lblNewLabel_2_1_1_1 = new JLabel("Check Out:-\r\n");
//		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		lblNewLabel_2_1_1_1.setBounds(366, 218, 147, 45);
//		contentPane.add(lblNewLabel_2_1_1_1);
//		
//		JLabel lblNewLabel_1_1 = new JLabel("City:-\r\n");
//		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		lblNewLabel_1_1.setBounds(364, 91, 115, 33);
//		contentPane.add(lblNewLabel_1_1);
//		
//		id = new JLabel("");
//		id.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		id.setBounds(106, 91, 115, 33);
//		contentPane.add(id);
//		
//	    city = new JLabel("");
//		city.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		city.setBounds(415, 91, 115, 33);
//		contentPane.add(city);
//		
//		name = new JLabel("");
//		name.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		name.setBounds(136, 123, 449, 44);
//		contentPane.add(name);
//		
//		people = new JLabel("");
//		people.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		people.setBounds(183, 166, 296, 45);
//		contentPane.add(people);
//		
//		in = new JLabel("");
//		in.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		in.setBounds(115, 219, 161, 42);
//		contentPane.add(in);
//		
//	    out = new JLabel("");
//		out.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		out.setBounds(461, 218, 161, 42);
//		contentPane.add(out);
//		
//	    day = new JLabel("");
//		day.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		day.setBounds(252, 367, 167, 33);
//		contentPane.add(day);
//		
//		lblNewLabel_3 = new JLabel("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
//		lblNewLabel_3.setBounds(0, 260, 688, 13);
//		contentPane.add(lblNewLabel_3);
//		
//		tamount = new JLabel("Amount:-");
//		tamount.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		tamount.setBounds(61, 340, 139, 33);
//		contentPane.add(tamount);
//		
//		lblTaxes = new JLabel("Taxes:-");
//		lblTaxes.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		lblTaxes.setBounds(61, 383, 139, 33);
//		contentPane.add(lblTaxes);
//		
//		lblNewLabel_4 = new JLabel("+");
//		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
//		lblNewLabel_4.setBounds(30, 358, 91, 33);
//		contentPane.add(lblNewLabel_4);
//		
//		lblNewLabel_5 = new JLabel("______________________");
//		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
//		lblNewLabel_5.setBounds(61, 395, 316, 33);
//		contentPane.add(lblNewLabel_5);
//		
//		lblNewLabel_6 = new JLabel("Bill");
//		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 24));
//		lblNewLabel_6.setBounds(10, 273, 167, 57);
//		contentPane.add(lblNewLabel_6);
//		
//		amount = new JLabel("");
//		amount.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		amount.setBounds(136, 340, 123, 33);
//		contentPane.add(amount);
//		
//		tax = new JLabel("");
//		tax.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		tax.setBounds(136, 383, 123, 33);
//		contentPane.add(tax);
//		
//		finalamt = new JLabel("");
//		finalamt.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		finalamt.setBounds(144, 415, 115, 44);
//		contentPane.add(finalamt);
//		
//		lblTotal = new JLabel("Total:-");
//		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		lblTotal.setBounds(71, 421, 139, 33);
//		contentPane.add(lblTotal);
//		
//		
//		try 
//		{
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
//			
//			Statement smt = con.createStatement();
//			ResultSet rs = smt.executeQuery("select * from b_hotel where bookingid =" + bookingid);
//			
//			while(rs.next())
//			{
//				String id1 = rs.getString(1);
//				String name1= rs.getString(2);
//				String city1 = rs.getString(3);
//				String address1 = rs.getString(4);
//				String number1 = rs.getString(5);
//				String website1 = rs.getString(6);
//				String rating1 = rs.getString(7);
//				int price1 = Integer.parseInt(rs.getString(8));
//				int days = Integer.parseInt(rs.getString(10));
//				
//				int amt = (price1 * days);
//				String result = String.valueOf(amt);
//				
//				int tax1 = (int) (Math.random() * (max - min + 1)) + min;
//				String result1 = String.valueOf(tax1);
//				
//				int finalr = amt + tax1;
//				String result2 = String.valueOf(finalr);
////				System.out.println("Id is\t" + id1);
////				System.out.println("Name is\t" + name1);
////				System.out.println("City is\t" + city1);
////				System.out.println("Address is\t" + address1);
////				System.out.println("Number is\t" + number1);
////				System.out.println("Website is\t" + website1);
////				System.out.println("Rating is\t" + rating1);
////				System.out.println("Price is\t" + price1);
////				System.out.println("Other Id is\t" + id2);
//				
//				id.setText(id1);
//				city.setText(city1);
//				name.setText(name1);
//				amount.setText(result);
//				tax.setText(result1);
//				finalamt.setText(result2);
//			
//				
//				
//			}
//			
//		}
//		catch(Exception e2)
//		{
//			e2.printStackTrace();
//		}
//		
//		
//	}
//
//	public HotelFinal(Class<Integer> class1) {
//		// TODO Auto-generated constructor stub
//	}
//}