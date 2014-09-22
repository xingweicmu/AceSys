<%@ page language="java" import="com.pactera.bean.*" pageEncoding="utf-8" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
 <head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>AscentWeb电子商务</title><link rel="stylesheet" href="<%=path%>/css/andreas08(blue).css" type="text/css" media="screen,projection" />
		<script type="text/javascript" src="<%=path %>/js/acesys.js"></script>

</head>

<body>
<form name="form" method="post" action="<%=request.getContextPath()%>/ProductServlet?operation=update" encType=multipart/form-data>
			<div id="container">
<div id="header">
<h1>加拿大·亚思晟科技 </h1>
<h2>Quality is everything!</h2>
</div>

<div id="navigation">
<ul>
<li class="selected"></li>
<li><a href="<%=path%>/index.jsp">首页</a></li>
<li><a href="<%=path%>/itservice.jsp">IT服务</a></li>
<li><a href="<%=path%>/products.jsp">医药商务系统</a></li>
<li><a href="<%=path%>/employee.jsp">员工招聘</a></li>
<li><a href="<%=path%>/ContactUs.jsp">关于我们</a></li>
<li></li>
</ul>
</div>
				<div id="content2">
					<table width="100%" height="41" border="0" align="center" cellpadding="0" cellspacing="0">
						
						<tr>
							<td height="4" colspan="2" align="left" valign="bottom"></td>
						</tr>
						<tr>
							<td height="15" align="left" valign="top">&nbsp;
							</td>
							<td height="15" align="left" valign="top" class="12">
							 <table width="100%" height="20" border="0" cellpadding="0"cellspacing="0">
								<tr><td height="20"><div class="right_proaducts">我的位置&gt;&gt;电子商务管理&gt;商品修改
										<br />	
											</div>
										<DIV class=padding>
										<DIV id=middlebody>
														<%
															User p = (User) session.getAttribute("productuser");
															if (p != null && p.getRole().getRight() == '3') {
																Product product = (Product) session.getAttribute("pid_product");
																char newproduct = product.isNewProduct();
																System.out.println(newproduct);
														%>
									<table width="100%">
										<tbody>
										<tr>
											<td height="10">
											<div class="table_t">|&nbsp;&nbsp;欢迎,admin&nbsp;&nbsp;|&nbsp;&nbsp;
												<a href="<%=path%>/login?a=out" class="table_t">注销</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="javascript:history.back()"><<< 返回</a></div>
											</td>
										</tr><%--
										 <tr>
										  <td width="157" height="20" bgcolor="#B4E4FE" class="table_c"> 产品信息：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:history.back()"><<< 返回</a> </td>
										  <td width="411"> " /></td>
										 </tr>
																--%><!-- 产品列表 -->
									  </tbody>
									</table>
									<table class="mars" cellspacing="1" cellpadding="0" width="100%" border="0">
									  <tbody>
										 <tr> <td height="10" colspan="4"><input name="pid" type="hidden" value="<%=product.getProductID()%>"></td>
	 </tr>
	 
	   <tr>
      <td width="122" height="15" class="table_c"> <div align="right">编号:</div></td>
	  <td width="122"><input name="productId" type="text" value="<%=product.getProductNumber()%>" readonly="true"/></td>
	  <td width="85" class="table_c"><div align="right">名称:</div></td>
	  <td width="163" height="15"><input name="productname" type="text" value="<%=product.getProductName()%>"/></td>
  	 </tr>
  	  <tr>
      <td width="122" height="15" class="table_c"><div align="right">CatalogNo:</div></td>
	  <td width="122"><input name="catalogno" type="text" value="<%=product.getCategory().getCategoryNo()%>"/></td>
	  <td width="85" class="table_c"><div align="right">CAS:</div></td>
	  <td width="163" height="15"><input name="cas" type="text" value="<%=product.getCas()%>" /></td>
  	 </tr>
	
	 <tr>
      <td width="122" height="15" class="table_c"><div align="right">MDL Number:</div></td>
	  <td width="122">
       <input name="mdlnumber" type="text" value="<%=product.getMDLNumber()%>"/></td>
	  <td width="85" class="table_c"><div align="right">新产品:</div></td>
	  
	  <%
	  	  	if (newproduct == '0') {
	  	  %>
	  <td height="15" class="table_c">
	 是:  <input type="radio" name="newproduct" value="1" />
	 否:   <input type="radio" name="newproduct" value="0" checked/>
	 </td>
	 <%
	 	}
	 		if (newproduct == '1') {
	 %>
	 <td height="15" class="table_c">
	 是:  <input type="radio" name="newproduct" value="1" checked/>
	 否:   <input type="radio" name="newproduct" value="0" />
	 </td>
	 <%
	 	}
	 %>
	 </tr>
	   <tr>
      <td width="122" height="15" class="table_c"><div align="right">Formula:</div></td>
	  <td width="122">
       <input name="formula" type="text" value="<%=product.getFormula()%>"/></td>
	  <td width="85" class="table_c"><div align="right">MW:</div></td>
	  <td width="163" height="15"><input name="mw" type="text" value="<%=product.getWeight()%>"/></td>
  	 </tr>
  	  <tr>
      <td width="122" height="15" class="table_c"><div align="right">类型:</div></td>
	  <td width="122"><input name="category"  value="<%=product.getCategory().getCategoryName()%>" type="text" /></td>
  	  <td width="85" class="table_c"><div align="right">备注:</div></td>
	  <td width="163" height="15">
	  <%
	  	if (product.getNote() == null) {
	  %>
	  <input name="note" type="text" value=""/>
  	 <%
  	 	} else {
  	 %>
  	  <input name="note" id="" type="text" value="<%=product.getNote()%>"/>
  	  <%
  	  	}
  	  %>
  	 </td>
  	 </tr> 
  	  <tr>
	   <td width="122" height="15" class="table_c"><div align="right">价钱1:</div></td>
	  <td width="122"><input name="price1" type="text" value="<%=product.getNormalPrice()%>"/></td>
  	  <td width="85" class="table_c"><div align="right">Stock:</div></td>
	  <td width="163" height="35"><input name="stock" type="text" value="<%=product.getStock()%>"/></td>
  	 </tr>
	  <tr>
      <td width="122" height="15" class="table_c"><div align="right">价格2:</div></td>
	  <td width="122"><input name="price2" type="text" value="<%=product.getVipPrice()%>"/></td>
	  <td width="85" class="table_c"><div align="right">Real Stock:</div></td>
	  <td width="163" height="15"><input name="realstock" type="text" value="<%=product.getRealStock()%>"/></td>
  	 </tr>
  	
  	 <tr>
	  <td width="85" class="table_c"><div align="right">图片:</div></td>
	  <td width="163" height="15">
	  <input type="file" name="upload" /><!-- value="ppm.getStructure()%>"-->
	  <div class="img"><img src="<%=request.getContextPath()%>/upload/<%=product.getImageName()%>" width="100" height="50" /></div>
      <!--  获取错误信息 -->
 	 
      </td>      
  	 </tr>
	 <tr>
      <td height="15" colspan="4"><div align="center">
        <div class="loading_ll"><input type="image" src="<%=request.getContextPath()%>\images\update1.jpg" onclick="return updateProducts();"  border="0" alt="修改"/></div>
      </div></td>
	 </tr>
				
									  </tbody>
							        </table>
														<%
															} else { //最上面的if的else
														%>
																<br/><br/><br/><br/><br/><br/>
																<center><h3>对不起，您没有权限查看！！！</h3></center>
																<br/><br/><br/><br/><br/><br/>
																<br/><br/><br/><br/><br/><br/>
														<%
															}
														%>    
													
											
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>
				<div id="footer">
					<p>
						<a href="http://www.ascenttech.com.cn/" target="_blank">版权所有：北京亚思晟商务科技有限公司
							&copy;2004-2008|京ICP备05005681</a>
					</p>
				</div>

			</div>
		</form>
	</body>
</html>