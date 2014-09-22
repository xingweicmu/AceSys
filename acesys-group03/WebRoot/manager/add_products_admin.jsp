<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
<title>AscentSys医药商务系统</title>
<meta http-equiv="content-type" content="text/html; charset=GB2312" />
<meta name="description" content="Your website description goes here" />
<meta name="keywords" content="your,keywords,goes,here" />
<link rel="stylesheet" href="<%=path %>/css/andreas08(blue).css" type="text/css" media="screen,projection" />
<script type="text/javascript" src="<%=path %>/js/acesys.js"></script>
</head>

<body>
<div id="container" >

<div id="header">
<h1>加拿大·亚思晟科技 </h1>
<h2>Quality is everything!</h2>
</div>

<div id="navigation">
<ul>
<li class="selected"></li>
<li><a href="<%=path %>/index.jsp">首页</a></li>
<li><a href="<%=path %>/itservice.jsp">IT服务</a></li>
<li><a href="<%=path %>/products.jsp">医药商务系统</a></li>
<li><a href="<%=path %>/employee.jsp">员工招聘</a></li>
<li><a href="<%=path %>/ContactUs.jsp">关于我们</a></li>
<li></li>
</ul>
</div>

<div id="content2">
  <table width="100%" height="41"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="15" height="18" align="left" valign="top"><div align="left"></div></td>
      <td width="385" align="left" valign="bottom" class="12">&nbsp;</td>
    </tr>
  <tr>
    <td height="4" colspan="2" align="left" valign="bottom"></td>
    </tr>
  
  <tr>
    <td height="15" align="left" valign="top">&nbsp;</td>
      <td height="15" align="left" valign="top" class="12"><table width="100%" height="20" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td height="20"><div class="right_proaducts">我的位置&gt;&gt;医药商务管理&gt;商品添加<br />
            <br />
          </div>
		  <form action="../ProductServlet?operation=save" method="post" name="form" id="form" enctype="multipart/form-data">
  <DIV class=padding>
  <DIV id=middlebody>
<table width="100%">
    <tbody>
      <tr>
        <td height="20"><div class="table_t">|&nbsp;&nbsp;欢迎,admin&nbsp;&nbsp;|&nbsp;&nbsp;<a 
      class="table_t" 
      href="<%=path %>/common/index.jsp">注销</a>&nbsp;&nbsp;|</div></td>
        <td><div><a href="<%=path %>/common/products_showusers.jsp"><img 
      src="<%=path %>/images/button/userlist.jpg" 
      border="0" /></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a 
      href="<%=path %>/manager/admin_products_show.jsp"><img 
      src="<%=path %>/images/button/productslist.jpg" 
      border="0" /></a>&nbsp;&nbsp;&nbsp;&nbsp; <a 
      href="<%=path %>/admin_ordershow.jsp"><img 
      src="<%=path %>/images/button/ShowOrders.jpg" border="0" /></a> &nbsp;&nbsp;&nbsp;&nbsp; <a 
      href="<%=path %>/add_products_admin.jsp"><img 
      src="<%=path %>/images/button/addProduct.jpg" border="0" /> </a>&nbsp;&nbsp;&nbsp;&nbsp; </div></td>
      </tr>
      <!-- 产品列表 -->
      <!-- 产品列表 -->
    </tbody>
  </table>
  <table width="580">
    <tbody>
      <tr>
        <td colspan="2" height="20"></td>
      </tr>
      <tr>
        <td bgcolor="#666666" colspan="2" height="5"></td>
      </tr>
      <tr>
        <td colspan="2" height="7"></td>
      </tr>
      <tr>
        <td class="table_c" width="180" 
      height="20">商品信息：&nbsp;<a 
      href="javascript:history.back(-1)">&lt;&lt;&lt; 返回</a> </td>
        <td width="411"><input type="hidden" value="1" name="pid" /></td>
      </tr>
    </tbody>
  </table>
  <table width="100%" border="0" cellspacing="0" bordercolor="#9EA7AB" bgcolor="#f3f3f3">
  	 <tr>
      <td height="10" colspan="4"><s:property value="tip"/></td>
	 </tr>
	   <tr>
    <td width="122" height="15" class="table_c"><div align="right">编号:</div></td>
	  <td width="122"><input name="productId" type="text"/></td>
	  <td width="85" class="table_c"><div align="right">产品名称:</div></td>
	  <td width="163" height="15"><input name="productname" type="text" /></td>
  	 </tr>
	 <tr>
   <td width="122" height="15" class="table_c"><div align="right">药品分类:</div></td>
	  <td width="122"><input name="catalogno" type="text" /></td>
	  <td width="85" class="table_c"><div align="right">化学文摘登记号:</div></td>
	  <td width="163" height="15"><input name="cas" type="text" /></td>
  	 </tr>
	
	 <tr>
      <td width="122" height="15" class="table_c"><div align="right">MDL 编号:</div></td>
	  <td width="122"> <input name="mdlnumber" type="text" /></td>
	  <td width="85" class="table_c"><div align="right">新产品:</div></td>
	 <!--  <td width="163" height="35"><input name="newproduct" type="text" /></td> -->
	 <td height="15" class="table_c">
	 是:  <input type="radio" name="newproduct" value="1" />
	 否:   <input type="radio" name="newproduct" value="0" checked/>
	 </td>
  	 </tr>
  	  <tr>
      <td width="122" height="15" class="table_c"><div align="right">化学方程式:</div></td>
	  <td width="122">
       <input name="formula" type="text" /></td>
	  <td width="85" class="table_c"><div align="right">总重量:</div></td>
	  <td width="163" height="15"><input name="mw" type="text" /></td>
  	 </tr>
  	 
	 <tr>
    <td width="122" height="15" class="table_c"><div align="right">药品类别:</div></td>
	  <td width="122">
      <input name="category" type="text" /></td>
	  <td width="85" class="table_c"><div align="right">备注:</div></td>
	  <td width="163" height="30"><input name="note" type="text" /></td>
  	 </tr> 
  	 <tr>
      <td width="122" height="15" class="table_c"><div align="right">价格1:</div></td>
	  <td width="122">
      <input name="price1" type="text" /></td>
	  <td width="85" class="table_c"><div align="right">库存:</div></td>
	  <td width="163" height="15"><input name="stock" type="text" /></td>
  	 </tr>
	  <tr>
      <td width="122" height="15" class="table_c"><div align="right">价格2:</div></td>
	  <td width="122"><input name="price2" type="text" /></td>
	  <td width="85" class="table_c"><div align="right">实际库存:</div></td>
	  <td width="163" height="15"><input name="realstock" type="text" /></td>
  	 </tr>
  	 <tr>
	  <td width="122" class="table_c"><div align="right">图片:</div></td>
	  <td width="122" height="15">
	  <input type="file" name="upload" /> </td>   
       <td width="85" class="table_c"><div align="right"></div></td>
	  <td width="163" height="15"></td>   
  	 </tr>
	 <tr>
      <td height="15" colspan="4"><div align="center">
        
        <div class="loading_ll"><input type="button" value="提交" onclick="addProducts()"/>
      </div></td>
	 </tr>
 </table>
  <div></div>
</form>
</td>
        </tr>
      </table>
        <br/>
        <div class="table_wz"></div></td>
  </tr>
  </table>
  </div>
<div id="footer">
<p><a href="http://www.ascenttech.com.cn/" target="_blank">版权所有：北京亚思晟商务科技有限公司 &copy;2004-2008|京ICP备05005681</a></p>
</div>

</div>
</body>
</html>
