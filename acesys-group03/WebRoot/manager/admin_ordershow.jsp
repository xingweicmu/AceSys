<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="../css/andreas08(blue).css" type="text/css" media="screen,projection" />
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
<li><a href="../common/index.jsp">首页</a></li>
<li><a href="../common/itservice.jsp">IT服务</a></li>
<li><a href="../common/products.jsp">医药商务系统</a></li>
<li><a href="../commom/employee.jsp">员工招聘</a></li>
<li><a href="../commom/ContactUs.jsp">关于我们</a></li>
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
          <td height="20"><div class="right_proaducts">我的位置&gt;&gt;医药商务管理&gt;订单管理<br />
            <br />
          </div>
		  <form action="" method="post" name="form" id="form">
  <DIV class=padding>
  <DIV id=middlebody>
  <table cellspacing="0" cellpadding="0" width="100%" border="0">
    <tbody>
      <tr>
        <td width="33%"><div align="left">|&nbsp;&nbsp;欢迎,admin&nbsp;&nbsp;|&nbsp;&nbsp;<a 
      class="table_t" 
      href="../common/index.jsp">注销</a>&nbsp;&nbsp;|</div></td>
        <td width="19%"><div align="center"><a href="../admin_products_show.jsp"><img height="17" src="../images/button/productslist.jpg" width="77" border="0" /></a></div></td>
        <td width="16%"><div align="center"><a 
      href="../admin_ordershow.jsp">订单管理</a></div></td>
      
      
      </tr>
    </tbody>
  </table>
  <table class="mars" cellspacing="1" cellpadding="0" width="100%" border="0">
    <tbody>
      <tr bgcolor="#fba661" height="30">
        <td><div align="center">编号</div></td>
        <td><div align="center">用户ID</div></td>
        <td><div align="center">查看</div></td>
        <td><div align="center">删除</div></td>
      </tr>
      <tr bgcolor="#f3f3f3">
        <td><div align="center">13</div></td>
        <td><div align="center"><a  href="admin_orderuser.jsp">2</a></div></td>
        <td><div align="center"><a  href="adminorderitem_show.jsp">查看</a></div></td>
        <td><div align="center"><a  href="admin_ordershow1.jsp">删除</a></div></td>
      </tr>
       <tr bgcolor="#f3f3f3">
        <td><div align="center">14</div></td>
        <td><div align="center"><a  href="admin_orderuser.jsp">4</a></div></td>
        <td><div align="center"><a  href="adminorderitem_show.jsp">查看</a></div></td>
        <td><div align="center"><a  href="admin_ordershow1.jsp">删除</a></div></td>
      </tr>
      <tr bgcolor="#f3f3f3">
        <td><div align="center">15</div></td>
        <td><div align="center"><a  href="admin_orderuser.jsp">5</a></div></td>
        <td><div align="center"><a  href="adminorderitem_show.jsp">查看</a></div></td>
        <td><div align="center"><a  href="admin_ordershow1.jsp">删除</a></div></td>
      </tr>
    </tbody>
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
