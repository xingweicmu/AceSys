package com.pactera.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pactera.bean.Product;
import com.pactera.dao.ProductDAO;
import com.pactera.dao.impl.ProductDAOImpl;

public class ShopcartServlet extends HttpServlet {
	 private static final String CONTENT_TYPE = "text/html;charset=GBK";
	 private   ServletContext sc=null;
	/**
	 * Constructor of the object.
	 */
	public ShopcartServlet() {
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
		System.out.println("helasdado");
			response.setCharacterEncoding("utf-8");
		   String state= request.getParameter("a");
		   if(state.equals("add"))//向购物车添加产品动作
		   {
			   this.addtoShopCart(request, response);
		   }
//		   if(state.equals("find"))//查找购物车添加产品动作
//		   {
//			   this.findShopCart(request, response);
//		   }
//		   if(state.equals("checkout"))//结帐
//		   {
//			   this.checkout(request, response);
//		   }
//		   if(state.equals("move"))
//		   {
//			   this.delShopCartProduct(request, response);
//		   }
		   if(state.equals("updateNum"))
		   {
			   this.updateCartProductNum(request, response);
		   }

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
		doGet(request,response);

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
	
	private void addtoShopCart(HttpServletRequest request, HttpServletResponse response) throws
	  ServletException, IOException{
		  System.out.println("helo");
		   HttpSession session = request.getSession(false);
		   ArrayList<Product> ShopCart = (ArrayList<Product>)session.getAttribute("shopcart");
		   if(ShopCart==null)
		   {
			   ShopCart= new ArrayList<Product>();
		   }
		   String pid = request.getParameter("pid");
		   int ppid =Integer.parseInt(pid);
//		   boolean bl = ShopCart.checkHashMapid(pid);//判断购物车是否已经添加
//		   System.out.println(bl +" --------------");
		   boolean flag = false;
		   
		   for(int i=0;i< ShopCart.size();i++){
			   if(ppid==ShopCart.get(i).getProductID()){
				   flag=true;
				   break;
			   }
		   }
		   
		   
		   if(flag)//该产品已经添加
		   {
//			 Ajax返回该商品已经添加过的提示
				String dthtml ="该产品已经保存在购物车里";//"该商品已经添加过";
//				dthtml = new String(dthtml.getBytes("iso-8859-1"),"utf-8");
//				response.setContentType("text/html;charset=gb2312");
//				response.getOutputStream().print(dthtml);//返回页面
				response.getWriter().print(dthtml);
		   }else//没有添加
		   {
			   ProductDAO pd = new ProductDAOImpl();
			   Product product= pd.findProductByProductId(ppid);
			   product.setWeight(1);
			   ShopCart.add(product);
			   String dthtml ="药品添加成功";//"该商品已经添加过";
//			   dthtml = new String(dthtml.getBytes("iso-8859-1"),"utf-8");
//			   response.setContentType("text/html;charset=gb2312");
//			   response.getOutputStream().print(dthtml);//返回页面
			   response.getWriter().print(dthtml);
		   }
		   session.setAttribute("shopcart", ShopCart);
	  }
	
	private void updateCartProductNum(HttpServletRequest request, HttpServletResponse response) throws
	  ServletException, IOException{
		  HttpSession session = request.getSession(false);
		  ArrayList<Product> ShopCart = (ArrayList<Product>)session.getAttribute("shopcart");
		  String pid = request.getParameter("pid");
		  String number = request.getParameter("quantity");
		  ProductDAO pd = new ProductDAOImpl();
		  Product product = null;
		  for(int i=0;i<ShopCart.size();i++){
			  if(ShopCart.get(i).getProductID()==Integer.parseInt(pid)){
				  product = ShopCart.get(i);
				  break;
			  }
		  }
		  product.setWeight(Double.parseDouble(number));
		  pd.updateProductInfo(product);
		  //Ajax返回该商品已经添加过的提示
		  String dthtml ="该产品已经修改";//"该商品已经添加过";
//		  dthtml = new String(dthtml.getBytes("iso-8859-1"),"utf-8");
//		  response.setContentType("text/html;charset=gb2312");
		  response.getWriter().print(dthtml);//返回页面 
		  session.setAttribute("shopcart", ShopCart);
	  }

}
