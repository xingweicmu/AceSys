<%@ page language="java" import="java.util.*,com.pactera.bean.*" contentType="text/html;charset=gb2312" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>AscentSys医药商务系统</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<meta name="description" content="Your website description goes here" />
<meta name="keywords" content="your,keywords,goes,here" />
<link rel="stylesheet" href="<%=path%>/css/andreas08(blue).css" type="text/css" media="screen,projection" />
</head>

<body>
<div id="container" >

<div id="header">
<h1>加拿大・亚思晟科技 </h1>
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
          <td height="20"><div class="right_proaducts">我的位置&gt;&gt;医药商务管理&gt;商品列表<br />
            <br />
          </div>
		  <form action="" method="post" name="form" id="form">
  <DIV class=padding>
  <DIV id=middlebody>  
  
  <table cellspacing="0" cellpadding="0" width="100%" border="0">
    <tbody>
      <tr>
      <%
      	User manager = new User();
      	manager.setUserName("manager");
      	manager.setRole(UserRole.NORMAL);
      	request.getSession().setAttribute("productuser",manager);      	
      	
      	User user = (User)session.getAttribute("productuser");
     	if(user == null){  //游客
       %>      
        <td background="./index.jsp"><div align="left">|&nbsp;&nbsp;欢迎,游客&nbsp;&nbsp;|&nbsp;&nbsp;<a class="table_t" href="./index.jsp">注销</a>&nbsp;&nbsp;|</div></td>
        <td><div align="center">&nbsp;</div></td>
        <td><div align="center"><a href="./Product_Search.jsp">商品查询</a></div></td>
        <td><div align="center"><a href="./cartshow.jsp">查看购物车</a></div></td>
	   
        <%} else{  //用户    
        %> 
        <td background="./index.jsp"><div align="left">|&nbsp;&nbsp;欢迎,<%=user.getUserName()%>&nbsp;&nbsp;|&nbsp;&nbsp;<a class="table_t" href="./index.jsp">注销</a>&nbsp;&nbsp;|</div></td>
        <td><div align="center">&nbsp;</div></td>
        <td><div align="center"><a href="./Product_Search.jsp">商品查询</a></div></td>
        <td><div align="center"><a href="./ordershow.jsp">查看订单</a></div></td>
        <td><div align="center"><a href="./cartshow.jsp">查看购物车</a></div></td>
        <%} %>
      </tr>
    </tbody>
  </table>
  <div></div>
</form>
          <table class="mars" cellspacing="1" cellpadding="0" width="100%" border="0">
            <tbody>
              <tr bgcolor="#fba661" height="30">
                <td><div align="center">编号</div></td>
                <td><div align="center">名称</div></td>
                  <td><div align="center">药品分类</div></td>
                <td><div align="center">MDL编号</div></td>
                <td><div align="center">价格</div></td>
                <td><div align="center">库存</div></td>
                <td><div align="center">图片</div></td>
                <td><div align="center">购买</div></td>
              </tr>
              <%     
    			ArrayList<Product> list= (ArrayList<Product>)session.getAttribute("searchproductlist");
    			Iterator<Product> its= list.iterator();
    			while(its.hasNext())
    			{
       				Product product = new Product();
       				product= (Product)its.next(); 
      		 %>
              <tr bgcolor="#f3f3f3" height="25">
                <td width="10%"><div align="center"><%=product.getProductNumber()%></div></td>
                <td width="13%"><div align="center"><%=product.getProductName()%></div></td>
                <td width="12%"><div align="center"><%=product.getCategory().getCategoryNo()%></div></td>
                <td width="13%"><div align="center"><%=product.getMDLNumber()%></div></td>
                <td width="10%"><div align="center"><%=product.getNormalPrice()%></div></td>
                <td width="13%"><div align="center"><%=product.getStock()%></div></td>
                <td width="12%"><div align="center"><img height="52" hspace="0"  src="./images/button/23007.gif" width="83" border="0" /></div></td>
                <td width="13%"><div align="center"><a  href="javascript:alert('已经添加到购物车')">购买</a></div></td>
              </tr>
              
            </tbody>
            <%}%>
          </table></td>
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
