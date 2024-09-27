package PAS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class NewPASLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewPASLogin frame = new NewPASLogin();
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
	public NewPASLogin() {
		setTitle("SignUp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 453);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 255, 212));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create Account");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(199, 43, 298, 68);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(107, 167, 81, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(107, 218, 81, 20);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Confirm Password");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(43, 265, 145, 20);
		contentPane.add(lblNewLabel_1_2);
		
		textField = new JTextField();
		textField.setBounds(213, 170, 360, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.setForeground(new Color(245, 245, 245));
		btnNewButton.setBackground(new Color(0, 206, 209));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PASDBconnection ab = new PASDBconnection();
					Connection c = ab.connectDB();
					
		             String usertype = "Applicant";
		             String name = textField_1.getText();
					 String username1 = textField.getText();
					 String password = passwordField.getText();
					 String conPassword = passwordField_1.getText();
					 
					 String sql = "insert into SignUp(usertype,name,Username,password,ConPassword) values(?,?,?,?,?)";
					 
					 PreparedStatement statement = c.prepareStatement(sql);
					 
					 statement.setString(1,usertype);
					 statement.setString(2,name);
					 statement.setString(3,username1);
		             statement.setString(4,password);
		             statement.setString(5,conPassword);
		             
		             int update = statement.executeUpdate();
			 			
			 			if (update > 0) 
			 				 System.out.println("Data updated successfully!");
			 			
			 			else 
			 				 System.out.println("Data update Failed!");
			 			
				}
			 			
					
					catch(SQLException ex) {
						System.out.println("Update Failed");
						System.out.println(ex);
						}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(492, 308, 136, 38);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(213, 221, 360, 19);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(213, 268, 360, 19);
		contentPane.add(passwordField_1);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(new Color(255, 0, 0));
		btnExit.setForeground(new Color(245, 245, 245));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
	                PASLogin pasLogin = new PASLogin();
	                pasLogin.setVisible(true);
	                dispose();  
			}
		}});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnExit.setBounds(492, 356, 136, 38);
		contentPane.add(btnExit);
		
		JLabel lblNewLabel_1_3 = new JLabel("Name");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(137, 124, 55, 20);
		contentPane.add(lblNewLabel_1_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(213, 125, 360, 19);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("DEPARTMENT OF IMMIGRATION AND EMIGRATION");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(74, 20, 542, 25);
		contentPane.add(lblNewLabel_2);
	}
}
