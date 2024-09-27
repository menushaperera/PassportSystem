package PAS;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Window;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.Toolkit;

public class Application extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nicField;
	private JTextField surnameField;
	private JTextField otherNamesField;
	private JTextField addressField;
	private JTextField dobField;
	private JTextField birthCetificateField;
	private JTextField professionField;
	private JTextField mobilePhoneField;
	private JTextField emailField;
	private JTextField placeofBirthField;
	protected Window frame;
	private static JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application frame = new Application();
					frame.setVisible(true);
					increment();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static int increment() {
		int n = 0;
		
		try {

			PASDBconnection ab = new PASDBconnection();
			Connection c = ab.connectDB();
			
			String sql = "Select AID from Applicant order by AID DESC";
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				int id = rs.getInt(1);
				n = id + 1;
				textField.setText(Integer.toString(n));
				
			}
			
			
		}	catch(Exception e) {
			
		}
		return n;
	}

	/**
	 * Create the frame.
	 */
	public Application() {
		setTitle("Application");
		increment();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 825);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 255, 212));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Application For Passport");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblNewLabel.setBounds(175, 68, 586, 86);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Type of Travel Document");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(71, 164, 175, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("NIC");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(71, 204, 175, 19);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Surname");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(71, 242, 175, 19);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Other Names");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1_1.setBounds(71, 284, 175, 19);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Permanet Address");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1_2.setBounds(71, 326, 175, 19);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("Date of Birth");
		lblNewLabel_1_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1_3.setBounds(71, 366, 175, 19);
		contentPane.add(lblNewLabel_1_1_1_3);
		
		JLabel lblNewLabel_1_1_1_4 = new JLabel("Birth Cetificate No");
		lblNewLabel_1_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1_4.setBounds(71, 407, 175, 19);
		contentPane.add(lblNewLabel_1_1_1_4);
		
		JLabel lblNewLabel_1_1_1_5 = new JLabel("Place of Birth");
		lblNewLabel_1_1_1_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1_5.setBounds(71, 448, 175, 19);
		contentPane.add(lblNewLabel_1_1_1_5);
		
		JLabel lblNewLabel_1_1_1_6 = new JLabel("Sex");
		lblNewLabel_1_1_1_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1_6.setBounds(71, 496, 175, 19);
		contentPane.add(lblNewLabel_1_1_1_6);
		
		JLabel lblNewLabel_1_1_1_7 = new JLabel("Profession/Occupation/Job");
		lblNewLabel_1_1_1_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1_7.setBounds(71, 540, 192, 19);
		contentPane.add(lblNewLabel_1_1_1_7);
		
		JLabel lblNewLabel_1_1_1_8 = new JLabel("Have you obtained \r\nDual Citizenship in Srilanka?");
		lblNewLabel_1_1_1_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1_8.setBounds(71, 585, 321, 19);
		contentPane.add(lblNewLabel_1_1_1_8);
		
		nicField = new JTextField();
		nicField.setBounds(265, 205, 295, 19);
		contentPane.add(nicField);
		nicField.setColumns(10);
		
		surnameField = new JTextField();
		surnameField.setColumns(10);
		surnameField.setBounds(265, 243, 636, 19);
		contentPane.add(surnameField);
		
		otherNamesField = new JTextField();
		otherNamesField.setColumns(10);
		otherNamesField.setBounds(265, 285, 636, 19);
		contentPane.add(otherNamesField);
		
		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(265, 327, 636, 19);
		contentPane.add(addressField);
		
		dobField = new JTextField();
		dobField.setColumns(10);
		dobField.setBounds(265, 367, 295, 19);
		contentPane.add(dobField);
		
		birthCetificateField = new JTextField();
		birthCetificateField.setColumns(10);
		birthCetificateField.setBounds(265, 408, 295, 19);
		contentPane.add(birthCetificateField);
		
		professionField = new JTextField();
		professionField.setColumns(10);
		professionField.setBounds(265, 541, 295, 19);
		contentPane.add(professionField);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mobile/Phone No");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(71, 635, 175, 19);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("E-mail address");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_3.setBounds(71, 676, 175, 19);
		contentPane.add(lblNewLabel_1_3);
		
		mobilePhoneField = new JTextField();
		mobilePhoneField.setColumns(10);
		mobilePhoneField.setBounds(265, 636, 295, 19);
		contentPane.add(mobilePhoneField);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(265, 677, 295, 19);
		contentPane.add(emailField);
		

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Option", "All Countries", "Middle East Countries", "Emergency Certificate", "Identity Cetificate"}));
		comboBox.setBounds(265, 164, 230, 21);
		contentPane.add(comboBox);
		
		JRadioButton maleRadioButton = new JRadioButton("Male");
		maleRadioButton.setBounds(265, 494, 64, 21);
		contentPane.add(maleRadioButton);
		
		JRadioButton femaleRadioButton = new JRadioButton("Female");
		femaleRadioButton.setBounds(409, 496, 64, 21);
		contentPane.add(femaleRadioButton);
		
		JRadioButton yesRadioButton = new JRadioButton("Yes");
		yesRadioButton.setBounds(398, 585, 52, 21);
		contentPane.add(yesRadioButton);
		
		JRadioButton noRadioButton = new JRadioButton("No");
		noRadioButton.setBounds(491, 585, 52, 21);
		contentPane.add(noRadioButton);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setForeground(new Color(255, 250, 250));
		btnNewButton.setBackground(new Color(0, 206, 209));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
					
					 String AID = textField.getText();
					 String TDocument = comboBox.getSelectedItem().toString();
					 String NIC = nicField.getText();
					 String Surname = surnameField.getText();
					 String OName = otherNamesField.getText();
					 String PermanteAddress = addressField.getText();
		             String DoB = dobField.getText();
		             String BCertificateNo =  birthCetificateField.getText();
		             String PlaceOfBirth = placeofBirthField.getText();
		             String gender;
		             String Occupation = professionField.getText();
		             String DualCitizenship;
		             String MobileNo = mobilePhoneField.getText();
		             String Email = emailField.getText();
		             String PoliceVerification = "Processing";
		             String DispatchStatus = "Processing";
		             
		             if(maleRadioButton.isSelected())
		            	 gender = "Male";
		             else
		            	 gender = "Female";
		             
		             if(yesRadioButton.isSelected())
		            	 DualCitizenship = "Yes";
		             else
		            	 DualCitizenship = "No";
		             
		             Applicanta m = new Applicanta();
		             m.registation(AID, TDocument, NIC, Surname, OName, PermanteAddress, DoB, BCertificateNo, PlaceOfBirth, gender, Occupation, DualCitizenship, MobileNo, Email,PoliceVerification,DispatchStatus);
		             
		             
			
              
                    JOptionPane.showConfirmDialog(null,"Form submitted successfully!","Success", JOptionPane.INFORMATION_MESSAGE);
                    
                 
            }
        
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(790, 675, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(new Color(255, 250, 250));
		btnExit.setBackground(new Color(255, 0, 0));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
	                PASLogin pasLogin = new PASLogin();
	                pasLogin.setVisible(true);
	                dispose();
                }
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExit.setBounds(790, 709, 85, 21);
		contentPane.add(btnExit);
		
		placeofBirthField = new JTextField();
		placeofBirthField.setColumns(10);
		placeofBirthField.setBounds(265, 449, 295, 19);
		contentPane.add(placeofBirthField);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(123, 21, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Application No");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(21, 20, 115, 19);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DEPARTMENT OF IMMIGRATION AND EMIGRATION");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(190, 61, 540, 18);
		contentPane.add(lblNewLabel_3);
		
		
		
	}
}
