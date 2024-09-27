package PAS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PASDBconnection {
	public Connection  connectDB() {
		String dbname = "PASDB";
		String username = "root";
		String pwd = "Menusha#@123";
		
		Connection conn = null;
		
		try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbname,username,pwd);
				return conn;
				}
				catch(SQLException e) {
				return conn;
				
		}
	}

}
