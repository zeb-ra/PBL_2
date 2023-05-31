package com.travel.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PnrCheck {

    private JFrame frame;
    private JTextField pnrTextField;
    String tempPnr;
    private JTable dispTable;
    private DefaultTableModel tableModel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PnrCheck window = new PnrCheck();
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
    public PnrCheck() throws Exception {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private void initialize() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Enter PNR:");
        lblNewLabel.setBounds(35, 40, 79, 13);
        frame.getContentPane().add(lblNewLabel);

        pnrTextField = new JTextField();
        pnrTextField.setBounds(97, 37, 96, 19);
        frame.getContentPane().add(pnrTextField);
        pnrTextField.setColumns(10);

        JButton btnNewButton = new JButton("Fetch");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	
                tempPnr = pnrTextField.getText();
                System.out.println(tempPnr);

                try {
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");
                    String query = "SELECT * FROM bookingdetails WHERE pnr = ?";
                    PreparedStatement st = con.prepareStatement(query);
                    st.setString(1, tempPnr);

                    ResultSet rs = st.executeQuery();

                    // Clear existing table data
                    tableModel.setRowCount(0);

                    // Populate table with new data
                    while (rs.next()) {
                        Object[] row = new Object[6]; // 6 columns
                        row[0] = rs.getObject("userid");
                        row[1] = rs.getObject("pnr");
                        row[2] = rs.getObject("trainno");
                        row[3] = rs.getObject("paymentmode");
                        row[4] = rs.getObject("paxid");
                        row[5] = rs.getObject("txnid");
                        tableModel.addRow(row);
                    }

                    rs.close();
                    st.close();
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton.setBounds(213, 36, 85, 21);
        frame.getContentPane().add(btnNewButton);

        tableModel = new DefaultTableModel();
        
        tableModel.addColumn("User ID");
        tableModel.addColumn("PNR");
        tableModel.addColumn("Train No");
        tableModel.addColumn("Payment Mode");
        tableModel.addColumn("Pax ID");
        tableModel.addColumn("Transaction ID");

        dispTable = new JTable(tableModel);
        dispTable.setBounds(10, 134, 403, 52);
        frame.getContentPane().add(dispTable);
    }
}
