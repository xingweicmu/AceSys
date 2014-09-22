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
<link rel="stylesheet" href="./css/andreas08(blue).css" type="text/css" media="screen,projection" />
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
<li><a href="./index.jsp">首页</a></li>
<li><a href="./itservice.jsp">IT服务</a></li>
<li><a href="./products.jsp">医药商务系统</a></li>
<li><a href="./employee.jsp">员工招聘</a></li>
<li><a href="./ContactUs.jsp">关于我们</a></li>
<li></li>
</ul>
</div>

<div id="content"> <br />
<table width="400" height="233"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="15" height="18" align="left" valign="top" bgcolor="#a5a5a5"><div align="left"></div></td>
      <td width="385" align="left" valign="bottom" bgcolor="#a5a5a5" class="12"><strong>联系我们</strong></td>
    </tr>
  <tr>
    <td height="4" colspan="2" align="left" valign="bottom" bgcolor="#eeeeee"></td>
    </tr>
  <tr>
    <td height="4" align="left" valign="bottom" bgcolor="#eeeeee">&nbsp;</td>
      <td height="4" align="left" valign="bottom" bgcolor="#eeeeee" class="12"><strong>亚思晟科技</strong></td>
    </tr>
  <tr>
    <td height="15" align="left" valign="top" bgcolor="#eeeeee">&nbsp;</td>
      <td height="15" align="left" valign="top" bgcolor="#eeeeee" class="12"><strong>BEIJING 
        ASCENT TECHNOLOGIES INC.</strong></td>
    </tr>
  <tr>
    <td height="15" align="left" valign="top" bgcolor="#eeeeee">&nbsp;</td>
      <td height="15" align="left" valign="top" bgcolor="#eeeeee" class="12">地址:北京市海淀区上地东路29号留学人员创业园303-306室</td>
    </tr>
  <tr>
    <td height="15" align="left" valign="top" bgcolor="#eeeeee">&nbsp;</td>
      <td height="15" align="left" valign="top" bgcolor="#eeeeee" class="12">Add:Room 
        303-306,29Shangdi East Road,Overseas 
        Student Pioneer </td>
    </tr>
  <tr>
    <td height="15" align="left" valign="top" bgcolor="#eeeeee">&nbsp;</td>
      <td height="15" align="left" valign="top" bgcolor="#eeeeee" class="12">Park,Beijing,P.R.China</td>
    </tr>
  <tr>
    <td height="15" align="left" valign="top" bgcolor="#eeeeee">&nbsp;</td>
      <td height="15" align="left" valign="top" bgcolor="#eeeeee" class="12">邮编Post 
        Code:100085</td>
    </tr>
  <tr>
    <td height="15" align="left" valign="top" bgcolor="#eeeeee">&nbsp;</td>
      <td height="15" align="left" valign="top" bgcolor="#eeeeee" class="12">传真Fax:010-62969799</td>
    </tr>
  <tr>
    <td height="15" align="left" valign="top" bgcolor="#eeeeee">&nbsp;</td>
      <td height="15" align="left" valign="top" bgcolor="#eeeeee" class="12">电话Tel:010-82780848/82780167</td>
    </tr>
  <tr>
    <td height="15" align="left" valign="top" bgcolor="#eeeeee">&nbsp;</td>
      <td height="15" align="left" valign="top" bgcolor="#eeeeee" class="12">E-mail:ascent@ascenttech.com.cn</td>
    </tr>
  <tr>
    <td height="15" align="left" valign="top" bgcolor="#eeeeee">&nbsp;</td>
      <td height="15" align="left" valign="top" bgcolor="#eeeeee" class="12">Java技术讨论群： 
        3307453</td>
    </tr>
  <tr>
    <td height="15" colspan="2" valign="top" bgcolor="#eeeeee">&nbsp;</td>
    </tr>
  <tr>
    <td height="15" colspan="2" valign="top" bgcolor="#a5a5a5"></td>
    </tr>
  </table>
  <p>&nbsp;</p>
</div><div id="subcontent">
  <div class="small box">
    <table width="150" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="30%" valign="middle"><img src="./images/username.jpg" width="61" height="17" align="bottom" />
            <input name="username" type="text" size="7"/>
        </td>
      </tr>
      <tr>
        <td valign="middle"><img src="./images/password.jpg" width="61" height="17" />
            <input name="password" type="password" size="6" /></td>
      </tr>
      <tr>
        <td height="30" valign="bottom"><input name="image" type="image" onclick="return checkLogin();" src="./images/login_1_7.jpg" alt="登录" width="44" height="17" border="0"/>
          &nbsp;&nbsp;</td>
      </tr>
    </table>
  </div>
  <h2>最新商品列表</h2>
  <ul class="menublock">
    <li><a href="#">项目实战精解</a><a href="#"><img src="./images/buy.gif" width="20" height="16" border="0"/></a></li>
    <li><a href="#">java核心技术</a><a href="#"><img src="./images/buy.gif" width="20" height="16" border="0"/></a></li>
    </ul>

  <h2>友情链接</h2>
  <ul class="menublock">
  <li><a href="http://www.ascenttech.cn" target="_blank">亚思晟视频在线</a></li>
  <li><a href="http://www.ascenttech.com.cn/" target="_blank">亚思晟公司主页</a></li>
  </ul>
  
</div>
<div id="footer">
<p><a href="http://www.ascenttech.com.cn/" target="_blank">版权所有：北京亚思晟商务科技有限公司 &copy;2004-2008|京ICP备05005681</a></p>
</div>

</div>
</body>
</html>
