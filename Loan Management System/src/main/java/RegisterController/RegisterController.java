package RegisterController;
import RegisterDaoImpl.RegisterDaoImpl;
import RegisterDao.registerData;
import UserData.userModel;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String confirm_password = request.getParameter("confirm_password");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		if(confirm_password.equals(password)) {
			userModel user = new userModel(username,email,password);
			registerData userobj = new RegisterDaoImpl();
			int i = userobj.createUser(user);
			if(i>0) {
				session.setAttribute("data", i);
				response.sendRedirect("login.jsp");
			}
		}
		else {
			String error = "Password & Confirm Password field must be same.";
			session.setAttribute("error", error);
			response.sendRedirect("register.jsp");
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
