package PAS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowFilter.Entry;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Admin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public Admin() {
		setTitle("Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1220, 798);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 255, 212));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Administration");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 42));
		lblNewLabel.setBounds(433, 53, 325, 59);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 174, 699, 461);
		contentPane.add(scrollPane);
		//model = new DefaultTableModel(new Object[]{"Application No", "Travel Type", "NIC", "Surname", "Name", "Address", "Date of Birth", "B Cetificate No", "Place Of Birth", "Gender", "Occupation", "Dual Citizenship", "Phone No", "Email", "Police Verification", "Passport"}, 0);
	        table = new JTable();
	        table.setForeground(new Color(255, 255, 255));
	        table.setFont(new Font("Tahoma", Font.BOLD, 10));
	        table.setBackground(new Color(178, 34, 34));
	        scrollPane.setViewportView(table);
	       
		
		//table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					PASDBconnection ab = new PASDBconnection();
					Connection c = ab.connectDB();
					
					int row = table.getSelectedRow();
					String Id = (table.getModel().getValueAt(row,0)).toString();
					
					
					String sql = "select * from Applicant where AID = '"+Id+"'";
					PreparedStatement st = c.prepareStatement(sql);
					ResultSet rs = st.executeQuery();
					
					while(rs.next()) {
						textField_13.setText(rs.getString("AID"));
						textField_6.setText(rs.getString("TDocument"));
						textField_5.setText(rs.getString("NIC"));
						textField_4.setText(rs.getString("Surname"));
						textField_3.setText(rs.getString("OName"));
						textField_2.setText(rs.getString("PermanetAddress"));
						textField_1.setText(rs.getString("DoB"));
						textField.setText(rs.getString("BCetificateNo"));
						textField_7.setText(rs.getString("PlaceOfBirth"));
						textField_8.setText(rs.getString("gender"));
						textField_9.setText(rs.getString("Occupation"));
						textField_10.setText(rs.getString("DualCitizenship"));
						textField_11.setText(rs.getString("MobileNo"));
						textField_12.setText(rs.getString("Email"));
						
					}
					st.close();
					
				}catch(SQLException ex) {
					System.out.println("Failed");
					System.out.println(ex);
				}
			}
		});
		scrollPane.setViewportView(table);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Application No", "Travel Type", "NIC", "Surname", "Name", "Address", "Date of Birth", "B Cetificate No", "Place Of Birth", "Gender", "Occupation", "Dual Citizenship", "Phone No", "Email", "Police Verification", "Passport"
			}
		));
		
		JButton btnNewButton = new JButton("Display");
		btnNewButton.setBackground(new Color(169, 169, 169));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Table();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(10, 645, 103, 38);
		contentPane.add(btnNewButton);
		
		JButton btnApprove = new JButton("Approve");
		btnApprove.setForeground(new Color(255, 250, 250));
		btnApprove.setBackground(new Color(0, 206, 209));
		btnApprove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePassportStatus("Dispatced");
				
			}
		});
		btnApprove.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnApprove.setBounds(360, 645, 103, 38);
		contentPane.add(btnApprove);
		
		JButton btnDicline = new JButton("Reject");
		btnDicline.setForeground(new Color(255, 250, 250));
		btnDicline.setBackground(new Color(0, 206, 209));
		btnDicline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rejectApplication("Rejected");
			}
		});
		btnDicline.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDicline.setBounds(360, 693, 103, 38);
		contentPane.add(btnDicline);
		
		JLabel lblNewLabel_1 = new JLabel("Application No");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(747, 152, 95, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Travel Type");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(747, 188, 95, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("surname");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(747, 266, 95, 13);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Name");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(747, 305, 95, 13);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Address");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4.setBounds(747, 342, 95, 13);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Date of Birth");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_5.setBounds(747, 379, 95, 13);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Birth Cetificate No");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_6.setBounds(747, 415, 121, 13);
		contentPane.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Place of Birth");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_7.setBounds(747, 456, 95, 13);
		contentPane.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_8 = new JLabel("Gender");
		lblNewLabel_1_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_8.setBounds(747, 492, 95, 13);
		contentPane.add(lblNewLabel_1_8);
		
		JLabel lblNewLabel_1_9 = new JLabel("Occupation");
		lblNewLabel_1_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_9.setBounds(747, 525, 95, 13);
		contentPane.add(lblNewLabel_1_9);
		
		JLabel lblNewLabel_1_10 = new JLabel("Dual Citizenship");
		lblNewLabel_1_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_10.setBounds(747, 561, 113, 13);
		contentPane.add(lblNewLabel_1_10);
		
		JLabel lblNewLabel_1_11 = new JLabel("Phone No");
		lblNewLabel_1_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_11.setBounds(747, 605, 95, 13);
		contentPane.add(lblNewLabel_1_11);
		
		JLabel lblNewLabel_1_12 = new JLabel("Email");
		lblNewLabel_1_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_12.setBounds(747, 641, 95, 13);
		contentPane.add(lblNewLabel_1_12);
		
		JLabel lblNewLabel_1_13 = new JLabel("NIC");
		lblNewLabel_1_13.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_13.setBounds(747, 226, 95, 13);
		contentPane.add(lblNewLabel_1_13);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 10));
		textField.setBounds(878, 413, 318, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		textField_1.setColumns(10);
		textField_1.setBounds(878, 377, 318, 19);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		textField_2.setColumns(10);
		textField_2.setBounds(878, 340, 318, 19);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		textField_3.setColumns(10);
		textField_3.setBounds(878, 303, 318, 19);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		textField_4.setColumns(10);
		textField_4.setBounds(878, 264, 318, 19);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		textField_5.setColumns(10);
		textField_5.setBounds(878, 224, 318, 19);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.BOLD, 10));
		textField_6.setColumns(10);
		textField_6.setBounds(878, 186, 318, 19);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.BOLD, 10));
		textField_7.setColumns(10);
		textField_7.setBounds(878, 454, 318, 19);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.BOLD, 10));
		textField_8.setColumns(10);
		textField_8.setBounds(878, 490, 318, 19);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.BOLD, 10));
		textField_9.setColumns(10);
		textField_9.setBounds(878, 523, 318, 19);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Tahoma", Font.BOLD, 10));
		textField_10.setColumns(10);
		textField_10.setBounds(878, 559, 318, 19);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Tahoma", Font.BOLD, 10));
		textField_11.setColumns(10);
		textField_11.setBounds(878, 603, 318, 19);
		contentPane.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Tahoma", Font.BOLD, 10));
		textField_12.setColumns(10);
		textField_12.setBounds(878, 639, 318, 19);
		contentPane.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setFont(new Font("Tahoma", Font.BOLD, 10));
		textField_13.setColumns(10);
		textField_13.setBounds(878, 150, 160, 19);
		contentPane.add(textField_13);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(new Color(255, 250, 250));
		btnExit.setBackground(new Color(255, 0, 0));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExit.setBounds(1093, 677, 103, 38);
		contentPane.add(btnExit);
		
		textField_14 = new JTextField();
		textField_14.setFont(new Font("Tahoma", Font.BOLD, 10));
		textField_14.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String searchString = textField_14.getText();
				search(searchString);
		}});
		textField_14.setBounds(112, 127, 137, 19);
		contentPane.add(textField_14);
		textField_14.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Scearch No");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(25, 127, 77, 19);
		contentPane.add(lblNewLabel_2);
		
		JButton btnPoliceVerification = new JButton("Police Verified");
		btnPoliceVerification.setForeground(new Color(255, 250, 250));
		btnPoliceVerification.setBackground(new Color(0, 206, 209));
		btnPoliceVerification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 updatePoliceStatus("Verified");
				
			}
		});
		btnPoliceVerification.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPoliceVerification.setBounds(128, 645, 207, 38);
		contentPane.add(btnPoliceVerification);
		
		JLabel lblNewLabel_3 = new JLabel("DEPARTMENT OF IMMIGRATION AND EMIGRATION");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_3.setBounds(289, 10, 645, 33);
		contentPane.add(lblNewLabel_3);
		
		JButton btnPoliceDicline = new JButton("Police Dicline");
		btnPoliceDicline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePoliceStatus("Not Verified");
			}
		});
		btnPoliceDicline.setForeground(new Color(255, 250, 250));
		btnPoliceDicline.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPoliceDicline.setBackground(new Color(0, 206, 209));
		btnPoliceDicline.setBounds(128, 693, 207, 38);
		contentPane.add(btnPoliceDicline);
	}
	public void Table() {
		try {
			PASDBconnection ab = new PASDBconnection();
			Connection c = ab.connectDB();
			
			Statement st = c.createStatement();
			String query = "select * from Applicant";
			ResultSet rs = st.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			
			int cols = rsmd.getColumnCount();
			String[] colName = new String[cols];
			for(int i = 0; i<cols ; i++)
				colName[i] = rsmd.getColumnName(i+1);
			model.setColumnIdentifiers(colName);
			
			while(rs.next()) {
				 String AID = rs.getString("AID");
				 String TDocument = rs.getString("TDocument");
				 String NIC = rs.getString("NIC");
				 String Surname = rs.getString("Surname");
				 String OName = rs.getString("OName");
				 String PermanteAddress = rs.getString("PermanetAddress");
	             String DoB = rs.getString("DoB");
	             String BCertificateNo =  rs.getString("BCetificateNo");
	             String PlaceOfBirth = rs.getString("PlaceOfBirth");
	             String gender = rs.getString("gender");
	             String Occupation = rs.getString("Occupation");
	             String DualCitizenship = rs.getString("DualCitizenship");
	             String MobileNo = rs.getString("MobileNo");
	             String Email = rs.getString("Email");
	             String PoliceVerification = rs.getString("PoliceVerification");
	             String DispatchStatus = rs.getString("DispatchStatus");
	             
	             String[]row = {AID,TDocument,NIC,Surname,OName,PermanteAddress,DoB,BCertificateNo,PlaceOfBirth,gender,Occupation,DualCitizenship,MobileNo,Email,PoliceVerification,DispatchStatus};
	             model.addRow(row);
			}
			st.close();
			c.close();
		}
		catch(SQLException ex) {
			System.out.println("Failed");
			System.out.println(ex);
		}
	}
	public void updatePoliceStatus(String policeStatus) {
	    int selectedRow = table.getSelectedRow();
	    if (selectedRow != -1) {
	        String AID = (String) table.getValueAt(selectedRow, 0);
	        try {
	            PASDBconnection ab = new PASDBconnection();
	            Connection c = ab.connectDB();
	            String sql = "UPDATE Applicant SET PoliceVerification = ? WHERE AID = ?";
	            PreparedStatement statement = c.prepareStatement(sql);
	            statement.setString(1, policeStatus);
	            statement.setString(2, AID);
	            statement.executeUpdate();

	            // Update the table model
	            DefaultTableModel model = (DefaultTableModel) table.getModel();
	            model.setValueAt(policeStatus, selectedRow, 14);

	            JOptionPane.showMessageDialog(null, "Police Verification updated successfully!");
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	}

	public void updatePassportStatus(String status) {
	    int selectedRow = table.getSelectedRow();
	    if (selectedRow != -1) {
	        String AID = (String) table.getValueAt(selectedRow, 0);
	        String PoliceVerification = (String) table.getValueAt(selectedRow, 14); // Get police verification status
	        if (PoliceVerification.equals("Verified")) { // Check if police verification is verified
	            try {
	                PASDBconnection ab = new PASDBconnection();
	                Connection c = ab.connectDB();
	                String sql = "UPDATE Applicant SET DispatchStatus = ? WHERE AID = ?";
	                PreparedStatement statement = c.prepareStatement(sql);
	                statement.setString(1, status);
	                statement.setString(2, AID);
	                statement.executeUpdate();

	                // Update the table model
	                DefaultTableModel model = (DefaultTableModel) table.getModel();
		            model.setValueAt(status, selectedRow, 15); 

	                JOptionPane.showMessageDialog(null, "Passport dispatch successful!");
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Police verification is required before dispatching passport!");
	        }
	    }
	}

	public void rejectApplication(String rejectStatus) {
	    int selectedRow = table.getSelectedRow();
	    if (selectedRow != -1) {
	        String AID = table.getValueAt(selectedRow, 0).toString();
	        try {
	            PASDBconnection ab = new PASDBconnection();
	            Connection c = ab.connectDB();
	            String sql = "UPDATE Applicant SET DispatchStatus = ? WHERE AID = ?";
	            PreparedStatement statement = c.prepareStatement(sql);
	            statement.setString(1, rejectStatus);
	            statement.setString(2, AID);
	            statement.executeUpdate();

	            // Update the table model
	            DefaultTableModel model = (DefaultTableModel) table.getModel();
	            model.setValueAt(rejectStatus, selectedRow, 15);

	            JOptionPane.showMessageDialog(null, "Application rejected!");
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	}
	
	public void search(String str) {
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
	    table.setRowSorter(trs);

	    // Use a custom RowFilter to match the ID partially or completely
	    RowFilter<DefaultTableModel, Object> rowFilter = new RowFilter<DefaultTableModel, Object>() {
	        @Override
	        public boolean include(Entry<? extends DefaultTableModel, ? extends Object> entry) {
	            for (int i = 0; i < entry.getValueCount(); i++) {
	                String value = entry.getStringValue(i);
	                if (value.contains(str)) {
	                    // If a match is found, set the text fields with the data
	                    setTextFieldValues(entry);
	                    return true;
	                }
	            }
	            return false;
	        }
	    };

	    trs.setRowFilter(rowFilter);
	}

	private void setTextFieldValues(Entry<? extends DefaultTableModel, ? extends Object> entry) {
	    textField_13.setText(entry.getStringValue(0));
	    textField_6.setText(entry.getStringValue(1));
	    textField_5.setText(entry.getStringValue(2));
	    textField_4.setText(entry.getStringValue(3));
	    textField_3.setText(entry.getStringValue(4));
	    textField_2.setText(entry.getStringValue(5));
	    textField_1.setText(entry.getStringValue(6));
	    textField.setText(entry.getStringValue(7));
	    textField_7.setText(entry.getStringValue(8));
	    textField_8.setText(entry.getStringValue(9));
	    textField_9.setText(entry.getStringValue(10));
	    textField_10.setText(entry.getStringValue(11));
	    textField_11.setText(entry.getStringValue(12));
	    textField_12.setText(entry.getStringValue(13));
	}
}


