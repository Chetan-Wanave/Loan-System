package LoanController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import LoanModel.LoanModel;
import RegisterDao.registerData;
import RegisterDaoImpl.RegisterDaoImpl;
import UserData.userModel;

/**
 * Servlet implementation class LoanController
 */
@WebServlet("/LoanController")
public class LoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int loanAmount = Integer.parseInt(request.getParameter("loanAmount"));
		long adhaar = Long.parseLong(request.getParameter("adhaar"));
		String pan = request.getParameter("pan");
		long accountno = Long.parseLong(request.getParameter("accountno"));
		String ifsc = request.getParameter("ifsc");
		
		HttpSession session = request.getSession();
		LoanModel loan = new LoanModel(loanAmount,adhaar,pan,accountno,ifsc);
		userModel user = (userModel) session.getAttribute("data");
		registerData loanUser = new RegisterDaoImpl();
		
		int i = loanUser.creatLoan(loan, user);
		
		if(i>0) {
			session.setAttribute("approval", "Your loan approved successfully.");
			response.sendRedirect("account.jsp");
		}
		else {
			session.setAttribute("approval", "Your loan rejected.");
			response.sendRedirect("account.jsp");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
