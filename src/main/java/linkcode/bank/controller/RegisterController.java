package linkcode.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import linkcode.bank.model.Account;
import linkcode.bank.model.dao.AccountDao;

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
	//retrive values from registerView
		//set value to set and get class
		//create obj for acc dao class
		//call save data method
		
		Account acc=new Account();
		acc.setAccno(Integer.parseInt(request.getParameter("accno")));
		acc.setCname(request.getParameter("cname"));
		acc.setUname(request.getParameter("uname"));
		acc.setPass(request.getParameter("pass"));
		acc.setAccbal(Integer.parseInt(request.getParameter("accbal")));
		
		System.out.println(acc.getAccbal()+acc.getPass());
		AccountDao adao=new AccountDao();
		int i=adao.saveData(acc);
		if (i>0) {
			
			PrintWriter pw=response.getWriter();
			pw.print("Recod inserted");
			response.sendRedirect("LoginView.jsp");
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
