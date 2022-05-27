package linkcode.bank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import linkcode.bank.model.Account;
import linkcode.bank.model.Login;
import linkcode.bank.model.dao.AccountDao;

/**
 * Servlet implementation class Logincontroller
 */
@WebServlet("/Logincontroller")
public class Logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logincontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Login lobj=new Login();
		lobj.setUname(request.getParameter("uname"));
		lobj.setPass(request.getParameter("pass"));
		AccountDao ad=new AccountDao();
		
		boolean b=ad.LoginData(lobj);
		if(b)
		{
			response.sendRedirect("Dashboard.jsp");
		}
		else {
			response.sendRedirect("Error.jsp");
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
