package com.travel.gui;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
public class HotelResult extends JFrame {
	String h_checkIn;
	String h_checkOut;
	String h_people;
	String days;
	
	private JPanel contentPane;
	private JTextField people;
	private JTable table;
	private JTextField out;
	public String selectedCity;
	public HotelEnd p1;
	private JTextField in;
	private JTextField textDays;
	public static void main(String[] args) 
	{
		EventQueue.invokeLater
		(new Runnable()
		{
			public void run()
			{
				try
				{
					HotelResult frame = new HotelResult();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public HotelResult() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 604);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(251, 255, 179));
		contentPane.setForeground(new Color(251, 255, 179));
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 128, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book Hotel");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setBounds(261, 10, 216, 66);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select City:-");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 71, 138, 38);
		contentPane.add(lblNewLabel_1);
		
		String[] messageStrings = {"Pune","Mumbai","Delhi","Chennai","Bangalore"};
		JComboBox comboBox = new JComboBox(messageStrings);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBounds(95, 79, 146, 21);
		contentPane.add(comboBox);
		
		
		JLabel lblNewLabel_2 = new JLabel("Check In:-");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 135, 122, 29);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Check Out:-");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(301, 135, 122, 29);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Number of people:-");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 184, 138, 29);
		contentPane.add(lblNewLabel_4);
		
		people = new JTextField();
		people.setBounds(149, 190, 130, 21);
		contentPane.add(people);
		people.setColumns(10);
		
		JButton showHotel = new JButton("Show Hotels");
		showHotel.setBackground(new Color(251, 192, 83));
		showHotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
					String query = "Select * from hotels where hotelcity=?";
					PreparedStatement st = con.prepareStatement(query);
				    selectedCity=(String) comboBox.getSelectedItem();
					st.setString(1, selectedCity);//setting the string value in first ?
					ResultSet rs = st.executeQuery();

					 DefaultTableModel model = (DefaultTableModel) table.getModel();
	                    model.setRowCount(0); // Clear existing table data
	                    
	                    String id,name,city,address,number,website,rating,price;
	                    while(rs.next())
	                    {
	                    	id = rs.getString("hotelid");
	                    	name=rs.getString("hotelname");
	                    	city=rs.getString("hotelcity");
	                    	address=rs.getString("hoteladdress");
	                    	number=rs.getString("hotelnumber");
	                    	website=rs.getString("hotelwebsite");
	                    	rating=rs.getString("hotelrating");
	                    	price=rs.getString("hotelprice");
	                    	Object[] row = {id,name,city,address,number,website,rating,price};
	                    	model.addRow(row);
	                    	
	                    }
//	                    rs.close();
//	                    st.close();
//	                    con.close();
				
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
		});
		showHotel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		showHotel.setBounds(272, 235, 116, 33);
		contentPane.add(showHotel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 313, 634, 177);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "City", "Address", "Number", "Website", "Rating", "Price"
			}
		));
		
		out = new JTextField();
		out.setBounds(382, 142, 146, 19);
		contentPane.add(out);
		out.setColumns(10);
		
		JButton btnNewButton = new JButton("Book");
		btnNewButton.setBackground(new Color(181, 254, 163));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				String id,name,city,address,number,website,rating,price;
				try
				{
			        Class.forName("oracle.jdbc.driver.OracleDriver");
			        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
				
				int[] selectedRows = table.getSelectedRows();//storing the values of selected rows into the variable
				
				for(int i=0;i<selectedRows.length;i++)
				{
					int row = selectedRows[i];//stores the currentvalue of selectedrow
					
					 id = table.getValueAt(row, 0).toString();
					 name = table.getValueAt(row, 1).toString();
					 city = table.getValueAt(row, 2).toString();
					 address = table.getValueAt(row, 3).toString();
					 number = table.getValueAt(row, 4).toString();
					 website = table.getValueAt(row, 5).toString();
					 rating = table.getValueAt(row, 6).toString();
					 price = table.getValueAt(row, 7).toString();

					 	int bookingid = (int)(Math.random()*12345);
					 	System.out.println("TEMP IS" +bookingid+"THIS THIS");
					String query = "insert into b_hotel values (?,?,?,?,?,?,?,?,?,?)";
					
					days = textDays.getText();
					System.out.println("Helllo we are displaying");
					
					
					PreparedStatement psmt = con.prepareStatement(query);
					psmt.setString(1,id);
					psmt.setString(2, name);
					psmt.setString(3, city);
					psmt.setString(4, address);
					psmt.setString(5, number);
					psmt.setString(6, website);
					psmt.setString(7, rating); 
					psmt.setString(8, price);
					psmt.setInt(9,bookingid);
					psmt.setString(10, days);
					
					psmt.execute();
					
//					String h_id = id; //stores the value of id
//					String h_name = name;
//					String h_city = selectedCity;//stores the value of selected city
					h_checkIn = in.getText();//stores the string of CHECK IN in n.
				    h_checkOut =out.getText();
				    h_people = people.getText();
					
//					p1 = new project1();
//					p1.setText(h_id,h_city,h_name,h_people,h_checkIn,h_checkOut);
//					p1 = new project1(bookingid);
//					p1.id.setText(h_id);
//					p1.city.setText(h_city);
//					p1.name.setText(h_name);
//					p1.people.setText(h_people);
//					p1.in.setText(h_checkIn);
//					p1.out.setText(h_checkOut);
					
					
				
					
					psmt.close();
					setVisible(false);
				    p1 = new HotelEnd(bookingid);
					p1.setVisible(true);
					dispose();
				System.out.println(id+"\t"+name+"\t"+city+"\t"+address+"\t"+number+"\t"+website+"\t"+rating+"\t"+price);
				}
				con.close();
				
				
//				
//				System.out.println("displayin");
//				System.out.println(h_checkIn);
//				System.out.println("People are" + h_people);
				p1.people.setText(h_people);
				p1.in.setText(h_checkIn);
				p1.out.setText(h_checkOut);
//				p1.day.setText(days);
//				p1.lblDays.setText(days);
			
//				System.out.println("Hello we are displayin" + days);
				}
				catch(Exception e2)
				{
					e2.printStackTrace();
				}
				}
			
			
			
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(261, 514, 149, 43);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("(Format:-DD/MM/YYYY)");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_5.setBounds(538, 145, 122, 13);
		contentPane.add(lblNewLabel_5);
		
		in = new JTextField();
		in.setBounds(85, 142, 141, 19);
		contentPane.add(in);

		
		
		in.setColumns(10);
		
		JLabel days = new JLabel("Number of days:-");
		days.setFont(new Font("Tahoma", Font.PLAIN, 15));
		days.setBounds(330, 184, 138, 29);
		contentPane.add(days);
		
		textDays = new JTextField();
		textDays.setBounds(455, 190, 96, 22);
		contentPane.add(textDays);
		textDays.setColumns(10);
		
		JLabel Icon = new JLabel("");
		ImageIcon img = new ImageIcon("D:/JavaaEclipse/Project/Image/Hotel.png");
		Icon.setIcon(img);
		Icon.setBounds(226, 10, 41, 66);
		contentPane.add(Icon);
		
		JLabel lblNewLabel_6 = new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		lblNewLabel_6.setBounds(10, 278, 695, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBackground(new Color(255, 203, 151));
		lblNewLabel_7.setBounds(10, 290, 665, 267);
		contentPane.add(lblNewLabel_7);
		ImageIcon img1 = new ImageIcon("D:/JavaaEclipse/Project/Image/booking.png");
		
	
		table.getColumnModel().getColumn(0).setPreferredWidth(27);
		table.getColumnModel().getColumn(1).setPreferredWidth(210);
		table.getColumnModel().getColumn(3).setPreferredWidth(210);
		table.getColumnModel().getColumn(4).setPreferredWidth(159);
		table.getColumnModel().getColumn(5).setPreferredWidth(200);
		
		
		
	}
	public void setVisible(boolean visible) {
		super.setVisible(true);
	}
}
