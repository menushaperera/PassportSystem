package PAS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;

public class UDashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected Window frame;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UDashboard frame = new UDashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public UDashboard() {
		setTitle("Dashboard\r\n\r\n");
		setFont(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 475);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 255, 212));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Registation");
		btnNewButton.setForeground(new Color(245, 245, 245));
		btnNewButton.setBackground(new Color(112, 128, 144));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	                // Open the Application class when the "Register" button is clicked
	                Application application = new Application();
	                application.setVisible(true);
	                application.increment();
;	                dispose();  // Close the current login frame
	            
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 45));
		btnNewButton.setBounds(161, 100, 342, 94);
		contentPane.add(btnNewButton);
		
		JButton btnCheckStatus = new JButton("Check Status");
		btnCheckStatus.setForeground(new Color(245, 245, 245));
		btnCheckStatus.setBackground(new Color(112, 128, 144));
		btnCheckStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckStatus CS = new CheckStatus();
                CS.setVisible(true);
;	            dispose();
			}
		});
		btnCheckStatus.setFont(new Font("Tahoma", Font.BOLD, 45));
		btnCheckStatus.setBounds(161, 261, 342, 94);
		contentPane.add(btnCheckStatus);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setForeground(new Color(245, 245, 245));
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
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(592, 368, 85, 41);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("DEPARTMENT OF IMMIGRATION AND EMIGRATION");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(69, 29, 629, 41);
		contentPane.add(lblNewLabel);
	}
}
