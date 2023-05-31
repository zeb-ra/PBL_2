package com.travel.gui;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JMonthChooser;
import java.awt.Font;
import java.awt.Image;

import com.toedter.calendar.JCalendar;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JPanel;

public class RailwayWindow extends JFrame {
	protected static final String String = null;
    private JComboBox<String> fromComboBox;
    private JComboBox<String> toComboBox;
    private JTextField fromTextField;
    private JTextField toTextField;
    String logInId;
    private List<String> stations;
    private String selectedStation_from;
    private String selectedStation_to;
    private int selectMonth;
    private int selectDate;
    private int selectYear;
    private Date selectedDate;
    private Connection con;
    JLabel lblNewLabel_4;
    private JFrame frame;
    
    private JTable table;
    private DefaultTableModel tableModel;
    private String selectedTrainNumber;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RailwayWindow window = new RailwayWindow(String);
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     * @throws Exception 
     */
    public RailwayWindow(String logInId) throws Exception {
    	getContentPane().setBackground(new Color(251, 255, 179));
    	this.logInId = logInId;
    	System.out.println("THIS IS: " + logInId);
    	System.out.println("\n");
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
   
    private void initialize() throws Exception {
    	
    	frame=new JFrame();
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 848, 400);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("From");
        lblNewLabel.setBackground(new Color(255, 0, 128));
        lblNewLabel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
        lblNewLabel.setBounds(20, 76, 77, 17);
        getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("To");
        lblNewLabel_1.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(218, 66, 53, 37);
        getContentPane().add(lblNewLabel_1);

        stations = new ArrayList<>();
        stations.add("PNQ");
        stations.add("DEL");
        stations.add("JAT");
        stations.add("NDLS");
//        stations.add("Bengaluru");

        fromComboBox = new JComboBox<>();
        fromComboBox.setModel(new DefaultComboBoxModel<>(stations.toArray(new String[0])));
        fromComboBox.setEditable(true);
        fromTextField = (JTextField) fromComboBox.getEditor().getEditorComponent();
        fromTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                filterStations(fromTextField.getText(), fromComboBox);
            }
        });
        fromComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedStation_from = fromComboBox.getSelectedItem().toString();
                System.out.println("FROM" + selectedStation_from);
            }
        });
        fromComboBox.setBounds(63, 77, 86, 21);
        getContentPane().add(fromComboBox);

        toComboBox = new JComboBox<>();
        toComboBox.setModel(new DefaultComboBoxModel<>(stations.toArray(new String[0])));
        toComboBox.setEditable(true);
        toTextField = (JTextField) toComboBox.getEditor().getEditorComponent();
        toTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                filterStations(toTextField.getText(), toComboBox);
            }
        });

        toComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedStation_to = toComboBox.getSelectedItem().toString();
                System.out.println("TO" + selectedStation_to);
            }
        });

        toComboBox.setBounds(242, 77, 86, 21);
        getContentPane().add(toComboBox);

        JLabel lblNewLabel_2 = new JLabel("Date");
        lblNewLabel_2.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(455, 48, 43, 30);
        getContentPane().add(lblNewLabel_2);

        JCalendar calendar = new JCalendar();
        calendar.setBounds(500, 48, 206, 152);
        getContentPane().add(calendar);

        calendar.addPropertyChangeListener("calendar", evt -> {
            selectedDate = calendar.getDate();
            Calendar cal = Calendar.getInstance();
            cal.setTime(selectedDate);
            selectMonth = cal.get(Calendar.MONTH) + 1;
            selectDate = cal.get(Calendar.DAY_OF_MONTH);
            selectYear = cal.get(Calendar.YEAR);
        });
        
        JButton btnNewButton = new JButton("Find Trains");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (selectedDate != null) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    String formattedDate = dateFormat.format(selectedDate);

                    try {
                        String query = "SELECT * FROM RailwayTable WHERE deptdate = ? AND deptstation = ? AND arrstation = ?";
                        PreparedStatement st = con.prepareStatement(query);
                        st.setString(1, formattedDate);
                        st.setString(2, selectedStation_from);
                        st.setString(3, selectedStation_to);
                        ResultSet rs = st.executeQuery();

                        tableModel.setRowCount(0); // Clear previous table data

                        while (rs.next()) {
                            String trainNo = rs.getString("trainno");
                            String trainName = rs.getString("trainname");
                            String trainType = rs.getString("traintype");
                            String coachClass = rs.getString("coachclass");
                            String foodCost = rs.getString("food");
                            String seatCost = rs.getString("seat");
                            String fareCost = rs.getString("fare");
                            String waitingList = rs.getString("waitinglist");
                            String deptTime = rs.getString("depttime");
                            String arrTime = rs.getString("arrtime");
                          

                            // Add data to the table
                            Object[] rowData = {trainNo, trainType, trainName, coachClass, foodCost, seatCost, fareCost, waitingList, deptTime, arrTime};
                            tableModel.addRow(rowData);
                        }

                        st.close();
                        rs.close();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                } else {
                    System.out.println("ERROR: Date must not be null");
                }
            }
        });

        
        
        table = new JTable();
        table.getSelectionModel().addListSelectionListener(e ->{
        	
        	if(table.getSelectedRow() != -1) {
        		
        		int selectedRow = table.getSelectedRow();
        		selectedTrainNumber = table.getValueAt(selectedRow, 0).toString();
        	}
        	
        });
        
        btnNewButton.setBounds(137, 128, 114, 30);
        getContentPane().add(btnNewButton);
        
     // Create the table and table model with column names
        String[] columnNames = {"TrainNo", "TrainType", "TrainName", "Class", "Food", "Seat", "Fare", "WL", "DeptTime", "ArrTime"};
        tableModel = new DefaultTableModel(columnNames, 0) {
        	public boolean isCellEditable(int row, int column) {
        		return column != 0;
        	}
        	
        };
        table = new JTable(tableModel);
        table.setModel(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 210, 814, 76);
        getContentPane().add(scrollPane);
        
        
        System.setProperty("sun.java2d.uiScale", "1.0"); // to reduce blur
        lblNewLabel_4 = new JLabel("");
        Image img = new ImageIcon(this.getClass().getResource("/leftright.png")).getImage();

        lblNewLabel_4.setIcon(new ImageIcon(img));

        lblNewLabel_4.setBounds(159, 62, 43, 56);
        getContentPane().add(lblNewLabel_4);
        
        JButton btnBookTrain = new JButton("Book Train");
        btnBookTrain.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		
				//GETTING TO NEXT WINDOW
				RailwayResult nextWindow;
				try {
					nextWindow = new RailwayResult(selectedTrainNumber, logInId);
					nextWindow.setVisible(true);
					RailwayWindow.this.dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
        		

        		
        		
        	}
        });
        btnBookTrain.setBounds(362, 296, 121, 49);
        getContentPane().add(btnBookTrain);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 0, 128));
        panel.setBounds(0, 0, 878, 17);
        getContentPane().add(panel);
                
                        JLabel lblNewLabel_3 = new JLabel("Book Train");
                        lblNewLabel_3.setBounds(20, 21, 182, 25);
                        getContentPane().add(lblNewLabel_3);
                        lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 20));
                        
                        JPanel panel_1_1_1 = new JPanel();
                        panel_1_1_1.setBackground(new Color(194, 239, 239));
                        panel_1_1_1.setBounds(0, 346, 844, 17);
                        getContentPane().add(panel_1_1_1);
        
        
        
        
        
        
        
        table.getSelectionModel().addListSelectionListener(e -> {
            if (table.getSelectedRow() != -1) {
                int selectedRow = table.getSelectedRow();
                selectedTrainNumber = table.getValueAt(selectedRow, 0).toString();
                System.out.println("this"+selectedTrainNumber);
                
                
                
                
            
            }
        });

        
        
        
        
    }
    

    private void filterStations(String text, JComboBox<String> comboBox) {
        String currentText = comboBox.getEditor().getItem().toString();
        List<String> filteredStations = new ArrayList<>();
        for (String station : stations) {
            if (station.toLowerCase().startsWith(text.toLowerCase())) {
                filteredStations.add(station);
            }
        }
        comboBox.setModel(new DefaultComboBoxModel<>(filteredStations.toArray(new String[0])));
        comboBox.setSelectedItem(currentText);
        comboBox.setPopupVisible(filteredStations.size() > 0);
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
    }
    
    public String getFormattedDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(selectedDate);
    }

    public String getSelectedStation_from() {
        return selectedStation_from;
    }

    public String getSelectedStation_to() {
        return selectedStation_to;
    }
    
    
    public String getTrainNumber() {
    	return selectedTrainNumber;
    }
}
