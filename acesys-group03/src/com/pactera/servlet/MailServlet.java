package com.pactera.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pactera.bean.Mailtb;
import com.pactera.bean.User;
import com.pactera.bean.UserRole;
import com.pactera.dao.MailDAO;
import com.pactera.dao.loginDAO;
import com.pactera.dao.impl.LoginDAOImpl;
import com.pactera.dao.impl.MailDAOImpl;

public class MailServlet extends HttpServlet {
	private ServletContext sc = null;
	/**
	 * Constructor of the object.
	 */
	public MailServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		String fromaddressname = request.getParameter("fromaddressname");	
		String fromaddresstype = request.getParameter("fromaddresstype");
		String frompassword = request.getParameter("frompassword");
		String toaddress = request.getParameter("toaddress");
		
		MailDAO mailDAO = new MailDAOImpl();
		Mailtb mail = new Mailtb(fromaddressname+fromaddresstype,frompassword,toaddress);

		if(fromaddressname==null){
			mail = mailDAO.findMail();
		}else{
			mailDAO.saveMail(mail);
		}
		
		
		HttpSession mysession = request.getSession(false);
		
		mysession.setAttribute("mailname",mail.getFromaddress());
		mysession.setAttribute("mailto", mail.getToaddress());
				
		RequestDispatcher rd = sc.getRequestDispatcher("/product/mailmanager.jsp");
		response.sendRedirect("product/mailmanager.jsp");
			
			
		

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		sc = this.getServletContext();
	}

}
