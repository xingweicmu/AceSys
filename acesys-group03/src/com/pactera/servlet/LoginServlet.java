package com.pactera.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pactera.bean.User;
import com.pactera.bean.UserRole;
import com.pactera.dao.UserManagerDAO;
import com.pactera.dao.loginDAO;
import com.pactera.dao.impl.LoginDAOImpl;
import com.pactera.dao.impl.UserManagerDAOImpl;

public class LoginServlet extends HttpServlet {
	private ServletContext sc = null;
	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
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

		String a = request.getParameter("a");
		System.out.println(a);
		
		if(a.equals("login")){
			System.out.println("ITS IN");
			this.login(request,response);
		}
		if(a.equals("logout")||a.equals("out")){
			this.logout(request,response);
		}
		
		
	}
	
	

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession mysession = request.getSession(false);
		
		mysession.removeAttribute("productuser");
		mysession.removeAttribute("shopcart");
		mysession.removeAttribute("orderitemlist");
		response.sendRedirect("products.jsp");
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + "in servelt");
		loginDAO lDAO = new LoginDAOImpl();
		User user = lDAO.login(username, password);

		/**
		 * ÍøÒ³°æ
		 */		
//		if(user==null){
//			response.setStatus(500);
//			System.out.println("no account");
//			//response.sendRedirect("products.jsp?flag=wrong");
//		} else if(user.getDelsoft() == '1') {
//			response.sendRedirect("products.jsp?flag=wrong");
//		} else {
//			request.setAttribute("username", user.getUserName());
//			HttpSession mysession = request.getSession(false);
//			mysession.setAttribute("productuser", user);
////			System.out.print(user.getPassword());
//			if(user.getRole() == UserRole.MANAGER){
//				
//				
//				
//				UserManagerDAO uDao = new UserManagerDAOImpl();
//				
//				List<User> allUser = uDao.findAllProductUsr();
//				mysession.setAttribute("allUsersList", allUser);
//				
//				response.sendRedirect("manager/products_showusers.jsp");
//			}else{
//				response.sendRedirect("products.jsp");
//			}
//			
//		}
//		 
		/**
		 * Android°æ
		 */
		if(user==null){
			response.setStatus(404);
		}else{
			response.setStatus(200);
		}
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
