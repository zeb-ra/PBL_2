package com.travel.gui;

import java.awt.EventQueue;
import javax.swing.table.DefaultTableModel;

//import com.Project.Interfacep2;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.FlowLayout;
import java.util.Calendar;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Searching extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTable table;
	private String depr;
	private String arr;
	private UserDetails nextWindow;
	private int selectedRow;
	private static String concatenatedDate;
	
	public int getIntegerValue() {
	    return selectedRow;
	}
	private static void populateDayDropdown(JComboBox<Integer> dayDropdown, int daysInMonth) {
        dayDropdown.removeAllItems();
                for (int i = 1; i <= daysInMonth; i++) {
            dayDropdown.addItem(i);
        }
    }
	
	private static int getMonthIndex(String month) {
        String[] monthNames = new String[]{"Jan", "Feb", "Mar", "Apr",
                "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        for (int i = 0; i < monthNames.length; i++) {
            if (monthNames[i].equalsIgnoreCase(month)) {
                return i;
            }
        }

        return 0;
    }
	
	private static int getDaysInMonth(String month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, getMonthIndex(month));
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
	
	private static void updateConcatenatedDate(JComboBox dayDropdown,
            JComboBox monthDropdown,
            JComboBox yearDropdown) {
		int day = (int) dayDropdown.getSelectedItem();
		String month = (String) monthDropdown.getSelectedItem();
		String year = (String) yearDropdown.getSelectedItem();
		concatenatedDate = day + "-" + month + "-" + year; 
		//System.out.println(concatenatedDate);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Searching window = new Searching();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Searching() {
		initialize();
	}

	private void initialize() {
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(153, 255, 255));
		frame.setBounds(100, 100, 770, 555);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lblNewLabel_1 = new JLabel("FROM");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(107, 95, 63, 35);
		frame.getContentPane().add(lblNewLabel_1);
		
		String city[] = {"BOM", "BLR", "DEL", "MAA", "NAG", "PNQ"};
		JComboBox comboBox = new JComboBox(city);
		comboBox.setBackground(new Color(255, 204, 204));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setBounds(179, 95, 103, 35);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("TO");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(441, 95, 37, 35);
		frame.getContentPane().add(lblNewLabel_2);
		
		JComboBox comboBox_1 = new JComboBox(city);
		comboBox_1.setBackground(new Color(255, 204, 204));
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_1.setBounds(492, 95, 103, 35);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_3 = new JLabel("Day");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(35, 176, 37, 23);
		frame.getContentPane().add(lblNewLabel_3);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBackground(new Color(255, 204, 204));
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_2.setBounds(79, 177, 90, 23);
		frame.getContentPane().add(comboBox_2);
		
		JLabel lblNewLabel_4 = new JLabel("Month");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(275, 172, 63, 30);
		frame.getContentPane().add(lblNewLabel_4);
		JComboBox comboBox_3 = new JComboBox(new String[]{"Jan", "Feb", "Mar", "Apr",
                "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"});
		comboBox_3.setBackground(new Color(255, 204, 204));
		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_3.setBounds(348, 176, 90, 24);
		frame.getContentPane().add(comboBox_3);
		
		JLabel lblNewLabel_5 = new JLabel("Year");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(551, 172, 44, 30);
		frame.getContentPane().add(lblNewLabel_5);
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		String currentYearString = String.valueOf(currentYear);
		String nextYearString = String.valueOf(currentYear+1);
		String yrs[]= {currentYearString,nextYearString};
		JComboBox comboBox_4 = new JComboBox(yrs);
		comboBox_4.setBackground(new Color(255, 204, 204));
		comboBox_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_4.setBounds(605, 176, 103, 23);
		frame.getContentPane().add(comboBox_4);
		
		comboBox_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateConcatenatedDate(comboBox_2, comboBox_3, comboBox_4);
            }
        });
		
		comboBox_3.addActionListener(e -> {
            String selectedMonth = (String) comboBox_3.getSelectedItem();
            int daysInMonth = getDaysInMonth(selectedMonth);
            populateDayDropdown(comboBox_2, daysInMonth);
            updateConcatenatedDate(comboBox_2, comboBox_3, comboBox_4);
        });
		
		comboBox_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateConcatenatedDate(comboBox_2, comboBox_3, comboBox_4);
            }
        });
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setEnabled(false);
		comboBox_5.setVisible(false);
		comboBox_5.setBounds(348, 102, 29, 21);
		frame.getContentPane().add(comboBox_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 243, 736, 214);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 153));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				depr = (String) comboBox.getSelectedItem();
				arr = (String) comboBox_1.getSelectedItem();
				try {
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","password");
					String query = "select * from tour_flights where from_=? and to_=?";
					PreparedStatement st = con.prepareStatement(query);
					st.setString(1, depr);
					st.setString(2, arr);
					ResultSet rs = st.executeQuery();
					ResultSetMetaData rsmd = rs.getMetaData();
					int cols = rsmd.getColumnCount();
					String[] colName = new String[cols];
					DefaultTableModel model = new DefaultTableModel();
					table.setModel(model);
					for (int i = 0; i < cols; i++) {
						colName[i] = rsmd.getColumnName(i + 1);
						model.addColumn(colName[i]);
					}
					model.setRowCount(0);
					while(rs.next()) {
						String fl_no = rs.getString("flight_no");
						String company= rs.getString("airlines");
						String dept= rs.getString("depr_time");
						String arv=rs.getString("arvl_time");
						int cost=rs.getInt("t_price");
						Object[] row = {fl_no,depr,arr,company,dept,arv,cost};
						model.addRow(row);
					}
					table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					    public void valueChanged(ListSelectionEvent event) {
					        if (!event.getValueIsAdjusting()) {
					            selectedRow = table.getSelectedRow();
					            if (selectedRow != -1) {
					                String colFno=table.getValueAt(selectedRow, 0).toString();
					                String colDep=table.getValueAt(selectedRow, 1).toString();
					                String colAr=table.getValueAt(selectedRow, 2).toString();
					                String colCmp=table.getValueAt(selectedRow, 3).toString();
					                String colDpt=table.getValueAt(selectedRow, 4).toString();
					                String colArv=table.getValueAt(selectedRow, 5).toString();
					                int colPrc=(int) table.getValueAt(selectedRow,6 );
				                	Object[] passData= {colFno,colDep,colAr,colCmp,colDpt,colArv,colPrc,concatenatedDate};
					                try {
					                	if (nextWindow == null) {
					                        nextWindow = new UserDetails(passData);
					                    } else {
					                        nextWindow.updateData(passData);
					                    }
		                                nextWindow.setVisible(true);
		                                frame.setVisible(false);
		                                dispose();
					                }catch (Exception e1) {
										e1.printStackTrace();
									}
					            }
					        }
					    }
					});
				}catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 153, 102));
		btnNewButton.setFont(new Font("Stencil", Font.PLAIN, 20));
		btnNewButton.setBounds(315, 467, 129, 41);
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(255, 204, 102));
		panel.setBounds(0, 10, 756, 41);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Flight Booking");
		panel.add(lblNewLabel);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setBackground(new Color(102, 153, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Stencil", Font.BOLD, 32));
		frame.setLocationRelativeTo(null);
	}


public void setVisible(boolean visible) {
    frame.setVisible(true);
}
}
