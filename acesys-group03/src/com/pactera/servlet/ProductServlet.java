package com.pactera.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pactera.bean.Product;
import com.pactera.bean.ProductCategory;
import com.pactera.bean.User;
import com.pactera.bean.UserRole;
import com.pactera.dao.ProductDAO;
import com.pactera.dao.impl.ProductDAOImpl;
import com.pactera.util.JsonTools;
import com.jspsmart.upload.SmartUpload;

public class ProductServlet extends HttpServlet {

	private static final String CONTENT_TYPE = "text/html; charset=GBK";
	private ServletContext sc = null;
	private ServletConfig config = null;
	private String uploadPath = "upload"; // ���ڴ���ϴ��ļ���Ŀ¼

	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		super.init();
		sc = this.getServletContext();
		config = this.getServletConfig();

		// �ļ��в����ھ��Զ�������
		if (!new File(uploadPath).isDirectory())
			new File(uploadPath).mkdirs();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		if (operation.equals("showAll"))
		{
			this.findProduceAll(request, response);
		}
		if (operation.equals("save")) {
			this.addProduct(request, response);
		}
		if (operation.equals("search")) {
			this.serachProduct(request, response);
		}
		if (operation.equals("updateProduct"))// ִ�и��µĲ�ѯ
		{
			this.productSerachbyid(request, response);
		}
		if (operation.equals("update"))// ���������Ϣ
		{
			this.updateProduct(request, response);
		}
		if (operation.equals("delete"))// ���������Ϣ
		{
			this.deleteProduct(request, response);
		}
		return;
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @param url
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doBrowse(HttpServletRequest request,
			HttpServletResponse response, String url) throws ServletException,
			IOException {
		RequestDispatcher rd = sc.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doBrowseErr(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = sc.getRequestDispatcher("/product/products.jsp");
		rd.forward(request, response);
	}

	private void doError(HttpServletRequest request,
			HttpServletResponse response, String error)
			throws ServletException, IOException {
		request.setAttribute("error", error);
		this.doBrowseErr(request, response);
	}

	// Clean up resources
	public void destroy() {
	}


	/**
	 * 
	 * @param request 
	 * @param response
	 */
	public void findProduceAll(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		ProductDAO Pd = new ProductDAOImpl();
		HttpSession mysession = request.getSession(false);
		
//		User manager = new User();
//		manager.setUserName("manager");
//		manager.setRole(UserRole.MANAGER);
//		mysession.setAttribute("productuser", manager);
		
		/**
		 * ��ҳ��	
		 * 
		 */	
//		User user = (User)mysession.getAttribute("productuser");
//		if(user != null && user.getRole().getRight() == '3'){    //����Ա
//			List<Product> procuctListOfManager = Pd.getALLProduct(1);    //����Ա��ѯ������ɾ����
//			if(procuctListOfManager == null){
//				this.doError(request, response, "productuserL_tip.login.fail");
//			}else{
//				mysession.setAttribute("productlist", procuctListOfManager);
//				this.doBrowse(request, response, "/manager/admin_products_show.jsp");
//			}
//		}else{   //�οͻ��û�
//			List<Product> productListOfNonManager = Pd.getALLProduct(0);    //�οͻ��û���ѯ��������ɾ����
//			if(productListOfNonManager == null){
//				this.doError(request, response, "productuserL_tip.login.fail");
//			}else{
//				mysession.setAttribute("productlist", productListOfNonManager);
//				this.doBrowse(request, response, "/product/products_show.jsp");
//			}
//		}
		
		
		/**
		 * Android��
		 */
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		List<Product> productListOfNonManager = Pd.getALLProduct(0);  
		
		PrintWriter out = response.getWriter();
		String jsonString = JsonTools.createJsonString("products", productListOfNonManager);
		out.println(jsonString);
		out.flush();
		out.close();		
	}

	/**
	 * ���Ӳ�Ʒʱ���������Ϣ
	 * @param request 
	 * @param response
	 */
	public void addProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		SmartUpload mySmartUpload = new SmartUpload();
		try {
			// Initialization
			mySmartUpload.initialize(config, request, response);
			mySmartUpload.setMaxFileSize(500 * 1024);
			// Upload
			mySmartUpload.upload();
			// ȡ��text���е�����
			String pnumber = mySmartUpload.getRequest().getParameter("productId");
			String pname = mySmartUpload.getRequest().getParameter("productname");
			String pcatalogno = mySmartUpload.getRequest().getParameter("catalogno");
			String pcas = mySmartUpload.getRequest().getParameter("cas");
			String pmdlnumber = mySmartUpload.getRequest().getParameter("mdlnumber");
			String pnewproduct = mySmartUpload.getRequest().getParameter("newproduct");
			String pformula = mySmartUpload.getRequest().getParameter("formula");
			String pmw = mySmartUpload.getRequest().getParameter("mw");
			String pcategory = mySmartUpload.getRequest().getParameter("category");
			String pstock = mySmartUpload.getRequest().getParameter("stock");
			String prealstock = mySmartUpload.getRequest().getParameter("realstock");
			String pprice1 = mySmartUpload.getRequest().getParameter("price1");
			String pprice2 = mySmartUpload.getRequest().getParameter("price2");
			String pnote = mySmartUpload.getRequest().getParameter("note");
			Product pdt = new Product();
			pdt.setProductNumber(pnumber);			
			pdt.setProductName(pname);
			if(pcatalogno.equals(ProductCategory.WESTMEDICINE.getCategoryNo()))
				pdt.setCategory(ProductCategory.WESTMEDICINE);
			else 
				pdt.setCategory(ProductCategory.BIOMEDICINE);
			pdt.setCas(pcas);
			pdt.setMDLNumber(pmdlnumber);
			pdt.setNewProduct(pnewproduct.charAt(0));
			pdt.setFormula(pformula);
			pdt.setWeight(Double.parseDouble(pmw));
			
			pdt.setStock(Integer.parseInt(pstock));
			pdt.setRealStock(Integer.parseInt(prealstock));
			pdt.setNormalPrice(Double.parseDouble(pprice1));
			pdt.setVipPrice(Double.parseDouble(pprice2));
			pdt.setNote(pnote);
			com.jspsmart.upload.File myfile = mySmartUpload.getFiles().getFile(0);		// ��ȡ�ϴ��ļ����ƺͺ�׺
			String fileName = myfile.getFileName();
			if (fileName != null && !fileName.equals("")) {
				pdt.setImageName(fileName);
				myfile.saveAs("/" + uploadPath + "/" + fileName, 1);
			}
			ProductDAO Pd = new ProductDAOImpl();
			pdt.getProductNumber();
			Pd.insertProduct(pdt);
		} catch (Exception e) {
			System.out.println("Unable to upload the file.<br>");
			System.out.println("Error : " + e.toString());
		}
		try {
			this.findProduceAll(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

	public void serachProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String searchNames = request.getParameter("searchName");
		System.out.println(searchNames + request.getCharacterEncoding());
		String searchValues = request.getParameter("searchValue");	
		System.out.println(searchValues);
		ProductDAO Pd = new ProductDAOImpl();
		List<Product> ProductList = Pd.findProducts(searchNames, searchValues);
		
		/**
		 * ��ҳ��
		 */		
//		HttpSession mysession = request.getSession(false);
//		mysession.setAttribute("searchproductlist", ProductList);
//		this.doBrowse(request, response, "/product/products_search_show.jsp");
		
		/**
		 * Android��
		 */
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		String jsonString = JsonTools.createJsonString("searchResults", ProductList);
		out.println(jsonString);
		out.flush();
		out.close();
		
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void productSerachbyid(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String productid = request.getParameter("pid");
		int pid = Integer.valueOf(productid);
		HttpSession mysession = request.getSession(false);
		ProductDAO Pd = new ProductDAOImpl();
		Product product = Pd.findProductByProductId(pid);
		mysession.setAttribute("pid_product", product);
		this.doBrowse(request, response, "/manager/update_products_admin.jsp");
	}

	// ���²�Ʒ
	/**
	 * 
	 */
	public void updateProduct(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		SmartUpload mySmartUpload = new SmartUpload();
		try {
			// Initialization
			mySmartUpload.initialize(config, request, response);
			mySmartUpload.setMaxFileSize(500 * 1024);
			// Upload
			mySmartUpload.upload();
			// ȡ��text���е�����
			String productid = mySmartUpload.getRequest().getParameter("pid");
			int pid = Integer.valueOf(productid);
			String pnumber = mySmartUpload.getRequest().getParameter("productId");
			String pname = mySmartUpload.getRequest().getParameter(
					"productname");
			String pcatalogno = mySmartUpload.getRequest().getParameter(
					"catalogno");
			String pcas = mySmartUpload.getRequest().getParameter("cas");
			String pmdlnumber = mySmartUpload.getRequest().getParameter(
					"mdlnumber");
			String pnewproduct = mySmartUpload.getRequest().getParameter(
					"newproduct");
			String pformula = mySmartUpload.getRequest()
					.getParameter("formula");
			String pmw = mySmartUpload.getRequest().getParameter("mw");
			String pcategory = mySmartUpload.getRequest().getParameter(
					"category");
			String pstock = mySmartUpload.getRequest().getParameter("stock");
			String prealstock = mySmartUpload.getRequest().getParameter(
					"realstock");
			String pprice1 = mySmartUpload.getRequest().getParameter("price1");
			String pprice2 = mySmartUpload.getRequest().getParameter("price2");
			String pnote = mySmartUpload.getRequest().getParameter("note");
			Product pdt = new Product();
//			pdt.setPid(pid);
//			pdt.setProductId(proid);
//			pdt.setProductname(pname);
//			pdt.setCatalogno(pcatalogno);
//			pdt.setCas(pcas);
//			pdt.setMdlnumber(pmdlnumber);
//			pdt.setNewproduct(pnewproduct);
//			pdt.setFormula(pformula);
//			pdt.setMw(pmw);
//			pdt.setCategory(pcategory);
//			pdt.setStock(pstock);
//			pdt.setRealstock(prealstock);
//			pdt.setPrice1(pprice1);
//			pdt.setPrice2(pprice2);
//			pdt.setNote(pnote);
			pdt.setProductID(pid);
			pdt.setProductNumber(pnumber);			
			pdt.setProductName(pname);
			if(pcatalogno.equals(ProductCategory.WESTMEDICINE.getCategoryNo()))
				pdt.setCategory(ProductCategory.WESTMEDICINE);
			else 
				pdt.setCategory(ProductCategory.BIOMEDICINE);
			pdt.setCas(pcas);
			pdt.setMDLNumber(pmdlnumber);
			pdt.setNewProduct(pnewproduct.charAt(0));
			pdt.setFormula(pformula);
			pdt.setWeight(Double.parseDouble(pmw));
			
			pdt.setStock(Integer.parseInt(pstock));
			pdt.setRealStock(Integer.parseInt(prealstock));
			pdt.setNormalPrice(Double.parseDouble(pprice1));
			pdt.setVipPrice(Double.parseDouble(pprice2));
			pdt.setNote(pnote);
			com.jspsmart.upload.File myfile = mySmartUpload.getFiles().getFile(0);
			// ��ȡ�ϴ��ļ����ƺͺ�׺
			String fileName = myfile.getFileName();
			if (fileName != null && !fileName.equals("")) {
				pdt.setImageName(fileName);
				myfile.saveAs("/" + uploadPath + "/" + fileName, 1);
			}

			ProductDAO Pd = new ProductDAOImpl();
			Pd.updateProductInfo(pdt);

		} catch (Exception e) {
			System.out.println("Unable to upload the file.<br>");
			System.out.println("Error : " + e.toString());
		}
		try {
			this.findProduceAll(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ɾ����Ʒ
	public void deleteProduct(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String productid = request.getParameter("pid");
		int pid = Integer.valueOf(productid);
		HttpSession mysession = request.getSession(false);
		ProductDAO Pd = new ProductDAOImpl();
		Pd.delSoftProdcut(pid, '1');
		List<Product> ProcuctList = Pd.getALLProduct(1);
		mysession.setAttribute("productlist", ProcuctList);
		this.doBrowse(request, response, "/manager/admin_products_show.jsp");
	}

}