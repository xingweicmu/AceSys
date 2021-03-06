/**
 * 描述系统业务接口和数据接口的实现类
 */
package com.pactera.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pactera.bean.Product;
import com.pactera.bean.ProductCategory;
import com.pactera.dao.ProductDAO;
import com.pactera.util.DataAccess;

/**
 * ProductDAO类的实现类
 * 
 * @author David.Wei
 * @version 1.0 
 * created: 2013-06-08
 */
public class ProductDAOImpl implements ProductDAO {

	/** 
	 * 商品软删除方法的实现
	 * @see com.pactera.dao.ProductDAO#delSoftProdcut
	 */
	public int delSoftProdcut(int pid, char delSoft) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int updateRows = 0;
		String sql = null;	
		
		try {			
			conn = DataAccess.getConnection();
			conn.setAutoCommit(false);			
			sql="UPDATE product SET delsoft = ? WHERE pid = ? "; 
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(delSoft) );
			pstmt.setInt(2, pid);			
			updateRows = pstmt.executeUpdate();			
			conn.commit();
			
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} 
		finally{
			try {
				DataAccess.close(pstmt, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return updateRows;
	}

	/** 
	 * 根据商品标识号查询方法的实现
	 * @see com.pactera.dao.ProductDAO#findProductByProductId
	 */
	public Product findProductByProductId(int theProductId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;	
		Product product = null;
		
		try {
			conn = DataAccess.getConnection();
			sql="SELECT * FROM product where pid = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, theProductId);			
			rs = pstmt.executeQuery();			
			if(rs.next()){
				product = new Product();
				product.setProductID(rs.getInt("pid"));
				product.setProductNumber(rs.getString("product_number"));
				product.setProductName(rs.getString("productname"));
				if(rs.getString("categoryno").equals(ProductCategory.WESTMEDICINE.getCategoryNo()))
					product.setCategory(ProductCategory.WESTMEDICINE);
				else 
					product.setCategory(ProductCategory.BIOMEDICINE);
				product.setMDLNumber(rs.getString("mdlnumber"));
				product.setCas(rs.getString("cas"));
				product.setFormula(rs.getString("formula"));
				product.setVipPrice(rs.getDouble("vip_price"));
				product.setNormalPrice(rs.getDouble("normal_price"));
				product.setStock(rs.getInt("stock"));
				System.out.println(rs.getInt("realstock"));
				product.setRealStock(rs.getInt("realstock"));
				product.setNewProduct((rs.getString("newproduct").charAt(0)));
				product.setImageName(rs.getString("imagename"));	
				product.setWeight(rs.getDouble("weight"));
				System.out.println(rs.getInt("weight"));
				product.setNote(rs.getString("note"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally{
			try {
				DataAccess.close(rs, pstmt, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return product;
	}

//	/** 
//	 * @see com.pactera.dao.ProductDAO#findProductByProductNumber
//	 */
//	public Product findProductByProductNumber(String theProductNumber) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String sql = null;	
//		Product product = null;
//		
//		try {
//			conn = DataAccess.getConnection();
//			sql="SELECT * FROM product where product_number = ?";
//			pstmt=conn.prepareStatement(sql);
//			pstmt.setString(1, theProductNumber);
//			
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()){
//				product = new Product();
//				product.setProductNumber(rs.getString("product_number"));
//				product.setProductName(rs.getString("productname"));
//				if(rs.getString("categoryno").equals(ProductCategory.WESTMEDICINE.getCategoryNo()))
//					product.setCategory(ProductCategory.WESTMEDICINE);
//				else 
//					product.setCategory(ProductCategory.BIOMEDICINE);
//				product.setMDLNumber(rs.getString("mdlnumber"));
//				product.setVipPrice(rs.getDouble("vip_price"));
//				product.setNormalPrice(rs.getDouble("normal_price"));
//				product.setStock(rs.getInt("stock"));
//				product.setImageName(rs.getString("imagename"));	
//			
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		finally{
//			try {
//				DataAccess.close(rs, pstmt, conn);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		return product;
//	}
//
//	/** 
//	 * @see com.pactera.dao.ProductDAO#findProductsByCategory
//	 */
//	public List<Product> findProductsByCategory(String theCategory) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String sql = null;	
//		ArrayList<Product> products = new ArrayList<Product>();
//		
//		try {
//			conn = DataAccess.getConnection();
//			sql="SELECT * FROM product where categoryno = ?";
//			pstmt=conn.prepareStatement(sql);
//			if(theCategory.equals(ProductCategory.WESTMEDICINE.getCategoryName()))
//				pstmt.setString(1, "001");
//			else 
//				pstmt.setString(1, "002");
//			
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()){
//				Product product = new Product();
//				product.setProductNumber(rs.getString("product_number"));
//				product.setProductName(rs.getString("productname"));
//				if(rs.getString("categoryno").equals(ProductCategory.WESTMEDICINE.getCategoryNo()))
//					product.setCategory(ProductCategory.WESTMEDICINE);
//				else 
//					product.setCategory(ProductCategory.BIOMEDICINE);
//				product.setMDLNumber(rs.getString("mdlnumber"));
//				product.setVipPrice(rs.getDouble("vip_price"));
//				product.setNormalPrice(rs.getDouble("normal_price"));
//				product.setStock(rs.getInt("stock"));
//				product.setImageName(rs.getString("imagename"));
//				products.add(product);
//			
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		finally{
//			try {
//				DataAccess.close(rs, pstmt, conn);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		return products;
//	}

	/** 
	 * @see com.pactera.dao.ProductDAO#getALLProduct
	 */
	public List<Product> getALLProduct(int flag) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<Product> products = new ArrayList<Product>();
		
		try {
			
			conn = DataAccess.getConnection();		

			if(flag == 1) 		 //manager
				sql="SELECT * FROM product";
			else     		 // normal user or VIP user
				sql="SELECT * FROM product where delsoft <> 1";
			pstmt=conn.prepareStatement(sql);			
			rs = pstmt.executeQuery();		
			
			while(rs.next()){
				Product product = new Product();
				product.setProductID(rs.getInt("pid"));
				product.setProductNumber(rs.getString("product_number"));
				product.setProductName(rs.getString("productname"));
				if(rs.getString("categoryno").equals(ProductCategory.WESTMEDICINE.getCategoryNo()))
					product.setCategory(ProductCategory.WESTMEDICINE);
				else 
					product.setCategory(ProductCategory.BIOMEDICINE);
				product.setMDLNumber(rs.getString("mdlnumber"));
				product.setVipPrice(rs.getDouble("vip_price"));
				product.setNormalPrice(rs.getDouble("normal_price"));
				product.setStock(rs.getInt("stock"));
				product.setRealStock(rs.getInt("realstock"));
				product.setFormula(rs.getString("formula"));
				product.setWeight(rs.getDouble("weight"));
				product.setCas(rs.getString("cas"));
				product.setNote(rs.getString("note"));
				product.setNewProduct(rs.getString("newproduct").charAt(0));
				product.setImageName(rs.getString("imagename"));	
				products.add(product);
			}	
	
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally{
			try {
				DataAccess.close(rs, pstmt, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		return products;
	}

	/** 
	 * @see com.pactera.dao.ProductDAO#insertProduct
	 */
	public int insertProduct(Product theProduct) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int updateRows = 0;
		String sql = null;	
		
		try {
			conn = DataAccess.getConnection();
			conn.setAutoCommit(false);
			
			sql = "insert into product (product_number,categoryno,note,productname,delsoft,imagename,newproduct,normal_price,vip_price," 
	    		+"realstock,stock,cas,mdlnumber,formula,weight) "
	                    + "  values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);	
			pstmt.setString(1, theProduct.getProductNumber()); 
			pstmt.setString(2, theProduct.getCategory().getCategoryNo());
			pstmt.setString(3, theProduct.getNote());
			pstmt.setString(4, theProduct.getProductName());
			pstmt.setString(5, String.valueOf(theProduct.getDel_soft()));
			pstmt.setString(6, theProduct.getImageName());
			pstmt.setString(7, String.valueOf(theProduct.isNewProduct()));
			pstmt.setDouble(8, theProduct.getNormalPrice());
			pstmt.setDouble(9, theProduct.getVipPrice());
			pstmt.setInt(10, theProduct.getRealStock());
			pstmt.setInt(11, theProduct.getStock());
			pstmt.setString(12, theProduct.getCas());
			pstmt.setString(13, theProduct.getMDLNumber());
			pstmt.setString(14, theProduct.getFormula());
			pstmt.setDouble(15, theProduct.getWeight());
			updateRows = pstmt.executeUpdate();			
			conn.commit();
			
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} 
		finally{
			try {
				DataAccess.close(pstmt, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return updateRows;		
	}

	/** 
	 * @see com.pactera.dao.ProductDAO#updateProductInfo
	 */
	public int updateProductInfo(Product theProduct) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;	
		int updateRows = 0;
		
		try {
			conn = DataAccess.getConnection();
			conn.setAutoCommit(false);

			sql = "UPDATE product SET product_number = ?, categoryno = ?, "
					+ "note = ?, productname = ?, delsoft = ?, imagename = ?, newproduct = ?, "
					+ "normal_price = ?, vip_price = ?, realstock = ?, stock = ? ,"
					+ "cas = ?, mdlnumber = ?, formula = ?,weight = ? WHERE pid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, theProduct.getProductNumber());
			pstmt.setString(2, theProduct.getCategory().getCategoryNo());
			pstmt.setString(3, theProduct.getNote());
			pstmt.setString(4, theProduct.getProductName());
			pstmt.setString(5, String.valueOf(theProduct.getDel_soft()));
			pstmt.setString(6, theProduct.getImageName());
			pstmt.setString(7, String.valueOf(theProduct.isNewProduct()));
			pstmt.setDouble(8, theProduct.getNormalPrice());
			pstmt.setDouble(9, theProduct.getVipPrice());
			pstmt.setInt(10, theProduct.getRealStock());
			pstmt.setInt(11,theProduct.getStock());
			pstmt.setString(12, theProduct.getCas());
			pstmt.setString(13, theProduct.getMDLNumber());
			pstmt.setString(14, theProduct.getFormula());
			pstmt.setDouble(15, theProduct.getWeight());
			pstmt.setInt(16, theProduct.getProductID());
			System.out.println(pstmt);
			System.out.println(theProduct.getNote());
			updateRows = pstmt.executeUpdate();		
			conn.commit();
			
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} 
		finally{
			try {
				DataAccess.close(pstmt, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return updateRows;		
	}

//	public List<Product> findProductsByCategoryName(String theCategoryName) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String sql = null;	
//		ArrayList<Product> products = new ArrayList<Product>();
//		
//		try {
//			conn = DataAccess.getConnection();
//			sql="SELECT * FROM product,category where category_name = ?";   
//			
//			pstmt=conn.prepareStatement(sql);
//			
//			pstmt.setString(1, theCategoryName);
//			
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()){
//				Product product = new Product();
//				product.setProductNumber(rs.getString("product_number"));
//				product.setProductName(rs.getString("productname"));
//				if(rs.getString("categoryno").equals(ProductCategory.WESTMEDICINE.getCategoryNo()))
//					product.setCategory(ProductCategory.WESTMEDICINE);
//				else 
//					product.setCategory(ProductCategory.BIOMEDICINE);
//				product.setMDLNumber(rs.getString("mdlnumber"));
//				product.setVipPrice(rs.getDouble("vip_price"));
//				product.setNormalPrice(rs.getDouble("normal_price"));
//				product.setStock(rs.getInt("stock"));
//				product.setImageName(rs.getString("imagename"));
//				products.add(product);
//			
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		finally{
//			try {
//				DataAccess.close(rs, pstmt, conn);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}		
//		return products;
//	}
//
//	public List<Product> findProductsByCategoryNo(String theCategoryNo) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String sql = null;	
//		ArrayList<Product> products = new ArrayList<Product>();
//		
//		try {
//			conn = DataAccess.getConnection();
//			sql="SELECT * FROM product where categoryno = ?";
//			pstmt=conn.prepareStatement(sql);
//				pstmt.setString(1, theCategoryNo);
//
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()){
//				Product product = new Product();
//				product.setProductNumber(rs.getString("product_number"));
//				product.setProductName(rs.getString("productname"));
//				if(rs.getString("categoryno").equals(ProductCategory.WESTMEDICINE.getCategoryNo()))
//					product.setCategory(ProductCategory.WESTMEDICINE);
//				else 
//					product.setCategory(ProductCategory.BIOMEDICINE);
//				product.setMDLNumber(rs.getString("mdlnumber"));
//				product.setVipPrice(rs.getDouble("vip_price"));
//				product.setNormalPrice(rs.getDouble("normal_price"));
//				product.setStock(rs.getInt("stock"));
//				product.setImageName(rs.getString("imagename"));
//				products.add(product);
//			
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		finally{
//			try {
//				DataAccess.close(rs, pstmt, conn);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		return products;
//	}
//
//	public Product findProductsByProductName(String theProductName) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String sql = null;	
//		Product product = null;
//		
//		try {
//			conn = DataAccess.getConnection();
//			sql="SELECT * FROM product where productname = ?";
//			pstmt=conn.prepareStatement(sql);
//			pstmt.setString(1, theProductName);
//			
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()){
//				product = new Product();
//				product.setProductNumber(rs.getString("product_number"));
//				product.setProductName(rs.getString("productname"));
//				if(rs.getString("categoryno").equals(ProductCategory.WESTMEDICINE.getCategoryNo()))
//					product.setCategory(ProductCategory.WESTMEDICINE);
//				else 
//					product.setCategory(ProductCategory.BIOMEDICINE);
//				product.setMDLNumber(rs.getString("mdlnumber"));
//				product.setVipPrice(rs.getDouble("vip_price"));
//				product.setNormalPrice(rs.getDouble("normal_price"));
//				product.setStock(rs.getInt("stock"));
//				product.setImageName(rs.getString("imagename"));	
//			
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		finally{
//			try {
//				DataAccess.close(rs, pstmt, conn);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		return product;
//	}

	/** 
	 * 按商品名称、商品编号、商品分类名称、商品你分类号查询方法的实现
	 * @see com.pactera.dao.ProductDAO#findProducts(String,String)
	 */
	public List<Product> findProducts(String searchName, String searchValue) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;	
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			conn = DataAccess.getConnection();
			sql="SELECT * FROM product_category p where p."+searchName+" like '%%"+searchValue+"%' and p.delsoft=0 ";
			System.out.println(sql);
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Product product = new Product();
				product.setProductNumber(rs.getString("product_number"));
				product.setProductName(rs.getString("productname"));
				if(rs.getString("categoryno").equals(ProductCategory.WESTMEDICINE.getCategoryNo()))
					product.setCategory(ProductCategory.WESTMEDICINE);
				else 
					product.setCategory(ProductCategory.BIOMEDICINE);
				product.setMDLNumber(rs.getString("mdlnumber"));
				product.setVipPrice(rs.getDouble("vip_price"));
				product.setNormalPrice(rs.getDouble("normal_price"));
				product.setStock(rs.getInt("stock"));
				product.setRealStock(rs.getInt("realstock"));
				product.setFormula(rs.getString("formula"));
				product.setWeight(rs.getDouble("weight"));
				product.setCas(rs.getString("cas"));
				product.setNote(rs.getString("note"));
				product.setNewProduct(rs.getString("newproduct").charAt(0));
				product.setImageName(rs.getString("imagename"));
				products.add(product);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally{
			try {
				DataAccess.close(rs, pstmt, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return products;
	}
}
