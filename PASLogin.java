package PAS;

import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Window;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Button;
import java.awt.Color;
import javax.swing.UIManager;

public class PASLogin extends JFrame {
	
	private static final long serialVersionUID = 1L;
	protected static final Window frame = null;
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	protected Object selectedRole;
	protected Component loginFrame;
	protected JLabel comboBox;
	protected JComboBox comboUser;
	protected Object rs;
	protected PreparedStatement pst;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PASLogin frame = new PASLogin();
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
	public PASLogin() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 656, 414);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 255, 212));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel.setBounds(256, 42, 133, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("password");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_2.setBounds(54, 217, 90, 26);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("username");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_3.setBounds(54, 165, 90, 21);
		contentPane.add(lblNewLabel_3);
		
		usernameField = new JTextField();
		usernameField.setBounds(160, 165, 429, 26);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Option", "Applicant", "Admin"}));
		comboBox.setBounds(160, 111, 429, 26);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(new Color(255, 250, 250));
		btnNewButton.setBackground(new Color(0, 206, 209));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                
                try {
                	PASDBconnection ab = new PASDBconnection();
					Connection c = ab.connectDB();
					
					ResultSet rs = null;
					String user = usernameField.getText();
					String pwd1 = passwordField.getText();
					String value = comboBox.getSelectedItem().toString();
                	
        			
                	String sql = "Select * from SignUp where username ='"+user+"' and password ='"+pwd1+"' and usertype ='"+value+"'";
                	pst = c.prepareStatement(sql);
                	rs = pst.executeQuery(sql);
                	
                	if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "User Login Successful!");
                        
                     if(value == "Applicant") {
                    	 UDashboard uDashboard = new UDashboard();
                         uDashboard.setVisible(true);
                     }
                     if(value == "Admin") {
                    	 Admin a = new Admin();
                    	 a.setVisible(true);
                     }
                     
                	}
                	
                    else {
                    JOptionPane.showMessageDialog(loginFrame, "Invalid username or password.");
                    }
                }
                catch(SQLException ex) {
    			System.out.println(ex);
                }
                
                
                try {
                    PASDBconnection ab = new PASDBconnection();
                    Connection c = ab.connectDB();

                    String sql = "INSERT INTO Login (value, user, password) VALUES (?, ?, ?)";

                    String value = comboBox.getSelectedItem().toString();
                    String user = usernameField.getText();
                    String password = passwordField.getText();

                    PreparedStatement statement = c.prepareStatement(sql);

                    statement.setString(1, value);
                    statement.setString(2, user);
                    statement.setString(3, password);

                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0)
                        System.out.println("Data inserted successfully!");
                    else
                        System.out.println("Data insertion failed!");
                } catch (SQLException ex) {
                    System.out.println("Data insertion failed!");
                    System.out.println(ex);
                }
               
				
            }
        });
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(518, 276, 85, 33);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(160, 217, 429, 26);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_3_1 = new JLabel("User Type");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_3_1.setBounds(54, 109, 90, 21);
		contentPane.add(lblNewLabel_3_1);
		
		JButton btnExit = 	new JButton("Exit");
		btnExit.setBackground(new Color(255, 0, 0));
		btnExit.setForeground(new Color(255, 250, 250));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnExit.setBounds(518, 319, 85, 33);
		contentPane.add(btnExit);
		
		JButton btnNewButton_1 = new JButton("SignUp");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(175, 238, 238));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewPASLogin NL = new NewPASLogin();
                NL.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(34, 320, 99, 33);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Create an account?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(34, 296, 150, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("DEPARTMENT OF IMMIGRATION AND EMIGRATION");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4.setBounds(99, 10, 458, 22);
		contentPane.add(lblNewLabel_4);
	}
}
