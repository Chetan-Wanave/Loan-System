package RegisterDaoImpl;

import RegisterDao.registerData;
import UserData.userModel;
import Database.DBConnection;
import LoanModel.LoanModel;

import java.sql.*;

public class RegisterDaoImpl implements registerData {

	@Override
	public int createUser(userModel user) {
		Connection con = DBConnection.myConnection();
		System.out.println("Connected to database: " + con);
		
		try {
			PreparedStatement pstate = con.prepareStatement("insert into userdata (username,email,password) value (?,?,?)");
			pstate.setString(1, user.getUsername());
			pstate.setString(2, user.getEmail());
			pstate.setString(3, user.getPassword());
			
			int i = pstate.executeUpdate();
			return i;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	@Override
	public userModel retriveUser(String username,String password) {
		Connection con = DBConnection.myConnection();
		//String str = "select * from userdata where username = 'prerana' and password = 'pj'";
		try {
			//Statement stat = con.createStatement();
			PreparedStatement pstate = con.prepareStatement("select * from userdata where username = ? and password = ?");
			pstate.setString(1, username);
			pstate.setString(2, password);
			ResultSet rs = pstate.executeQuery();
			while(rs.next()) {
				userModel r = new userModel(rs.getString(2),rs.getString(3),rs.getString(4));
				return r;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public userModel getUser(String username, String password) {
		Connection con = DBConnection.myConnection();
		
		return null;
	}

	@Override
	public int creatLoan(LoanModel loan, userModel user) {
		Connection con = DBConnection.myConnection();
		System.out.println("Connected to database: " + con);
		
		try {
			
			PreparedStatement pstate = con.prepareStatement("select * from userdata where username = ? and password = ?");
			System.out.println(user.getUsername() + " " + user.getPassword());
			pstate.setString(1, user.getUsername());
			pstate.setString(2, user.getPassword());
			
			ResultSet rs = pstate.executeQuery();
			int z = 0;
			while(rs.next()) {
				 z = rs.getInt(1);
			}
			
			System.out.println( " z: " + z  );
			
			pstate = con.prepareStatement("insert into loandata (amount,adhaar,pan,accountno,ifsc,user_id) value (?,?,?,?,?,?)");
			pstate.setFloat(1, loan.getLoanAmount());
			pstate.setLong(2, loan.getAdhaar());
			pstate.setString(3, loan.getPan());
			pstate.setLong(4, loan.getAccountno());
			pstate.setString(5, loan.getIfsc());
			pstate.setInt(6, z);
			
			int i = pstate.executeUpdate();
			System.out.println("i : " + i);
			return i;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int retriveUserID(userModel user) {
		Connection con = DBConnection.myConnection();	
		try {
			
			PreparedStatement pstate = con.prepareStatement("select * from userdata where username = ? and password = ?");
			pstate.setString(1, user.getUsername());
			pstate.setString(2, user.getPassword());
			
			ResultSet rs = pstate.executeQuery();
			int z = 0;
			while(rs.next()) {
				 z = rs.getInt(1);
				 return z;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	@Override
	public ResultSet retriveLoan(int user_id) {
		Connection con = DBConnection.myConnection();
		//String str = "select * from userdata where username = 'prerana' and password = 'pj'";
		try {
			PreparedStatement pstate = con.prepareStatement("SELECT loandata.id, loandata.amount, loandata.accountno, loandata.year, userdata.email FROM loandata JOIN userdata ON loandata.user_id = userdata.id where userdata.id = 4");
			//pstate.setInt(1, user_id);
			ResultSet rs = pstate.executeQuery();
			return rs;
			//Statement stat = con.createStatement();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	

}
