package PAS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Color;

public class CheckStatus extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckStatus frame = new CheckStatus();
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
	public CheckStatus() {
		setTitle("Check Ststus");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 501);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 255, 212));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Applicant No");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(98, 160, 104, 31);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setForeground(new Color(255, 250, 250));
		btnNewButton.setBackground(new Color(0, 206, 209));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String AID = textField.getText();
				 String OName = "";
	             String PoliceVerification = "";
	             String DispatchStatus = "";
	             
	             try {
	            	    PASDBconnection ab = new PASDBconnection();
						Connection c = ab.connectDB();
	                    String query = "SELECT AID,OName,PoliceVerification,DispatchStatus FROM Applicant WHERE AID = ?";
	                    PreparedStatement st = c.prepareStatement(query);
	                    st.setString(1, AID);
	                    ResultSet rs = st.executeQuery();

	                    if (rs.next()) {
	                    	 AID = rs.getString("AID");
	        				 OName = rs.getString("OName");
	        	             PoliceVerification = rs.getString("PoliceVerification");
	        	             DispatchStatus = rs.getString("DispatchStatus");
	                    } else {
	                        textField_1.setText("Applicant ID not found");
	                        textField_2.setText("");
	                        textField_3.setText("");
	                        return;
	                    }
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	                
	                textField_1.setText(OName);
	                textField_2.setText(PoliceVerification);
	                textField_3.setText(DispatchStatus);
	            }
			
		});
		btnNewButton.setIcon(null);
		btnNewButton.setBounds(425, 160, 104, 31);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(212, 164, 188, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Application Ststus");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 46));
		lblNewLabel_1.setBounds(231, 55, 435, 56);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setForeground(new Color(255, 250, 250));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
	                PASLogin pasLogin = new PASLogin();
	                pasLogin.setVisible(true);
	                dispose();
                }
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(773, 408, 85, 31);
		contentPane.add(btnNewButton_1);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(141, 227, 57, 31);
		contentPane.add(lblName);
		
		JLabel lblPoliceVerifivation = new JLabel("Police Verifivation");
		lblPoliceVerifivation.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPoliceVerifivation.setBounds(61, 276, 130, 31);
		contentPane.add(lblPoliceVerifivation);
		
		JLabel lblDispatchStatus = new JLabel("Dispatch Status");
		lblDispatchStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDispatchStatus.setBounds(73, 331, 118, 31);
		contentPane.add(lblDispatchStatus);
		
		textField_1 = new JTextField();
		textField_1.setBounds(212, 227, 657, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(212, 284, 657, 27);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(212, 339, 657, 27);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_2 = new JLabel("DEPARTMENT OF IMMIGRATION AND EMIGRATION");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(178, 10, 545, 23);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1_1 = new JButton("Clear");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
			}
		});
		btnNewButton_1_1.setForeground(new Color(255, 250, 250));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1_1.setBackground(new Color(0, 206, 209));
		btnNewButton_1_1.setBounds(626, 408, 85, 31);
		contentPane.add(btnNewButton_1_1);
		
	}
}
