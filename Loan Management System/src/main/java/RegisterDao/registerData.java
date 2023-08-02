package RegisterDao;

import java.sql.ResultSet;

import LoanModel.LoanModel;
import UserData.userModel;

public interface registerData {
	int createUser(userModel user);
	userModel retriveUser(String username,String password);
	userModel getUser(String username,String password);
	int creatLoan(LoanModel loan,userModel user);
	ResultSet retriveLoan(int user_id);
}
