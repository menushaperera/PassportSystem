package PAS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Applicanta {
	
	public void registation(String AID,String TDocument,String NIC,String Surname,String OName,String PermanteAddress,String DoB,String BCertificateNo,String PlaceOfBirth,String gender,String Occupation,String DualCitizenship,String MobileNo,String Email, String policeVerification, String dispatchStatus ) {
		try {
			
			PASDBconnection ab = new PASDBconnection();
			Connection c = ab.connectDB();
			
			String sql = "insert into Applicant(AID,TDocument,NIC,Surname,OName,PermanetAddress,DoB,BCetificateNo,PlaceOfBirth,gender,Occupation,DualCitizenship,MobileNo,Email,PoliceVerification,DispatchStatus)"
             		+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
             
             PreparedStatement statement = c.prepareStatement(sql);
             
             statement.setString(1,AID);
             statement.setString(2,TDocument);
             statement.setString(3,NIC);
             statement.setString(4,Surname);
             statement.setString(5,OName);
             statement.setString(6,PermanteAddress);
             statement.setString(7,DoB);
             statement.setString(8,BCertificateNo);
             statement.setString(9,PlaceOfBirth);
             statement.setString(10,gender);
             statement.setString(11,Occupation);
             statement.setString(12,DualCitizenship);
             statement.setString(13,MobileNo);
             statement.setString(14,Email);
             statement.setString(15,policeVerification);
             statement.setString(16,dispatchStatus);
             
             
             int update = statement.executeUpdate();
 			
 			if (update > 0) {
 				 System.out.println("Data updated successfully!");
 			} 
 			else {
 				 System.out.println("Data update Failed!");
 			}
 			
 		
		}catch(SQLException ex) {
			
		}
	}

}
