<%@ page language="java" import="java.util.*" import="com.pactera.bean.User" pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="./css/andreas08(blue).css" type="text/css" media="screen,projection" />
<script charset="gb2312" language="javascript" type="text/javascript" src="./js/acesys.js"></script>
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

<div id="content"> 
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td>我的位置 &gt;&gt; 医药商务管理</td>
    </tr>
    <tr>
      <td><hr noshade="noshade" /></td>
    </tr>
    <tr>
      <td>商品信息</td>
    </tr>
  </table>
  <br />
  <div class="md_wenzi"> 某某提供全世界配药，生物科技和agroche mical药物研究&amp;发展的先进和新颖的中间体。
    我们的编目是最新与1500年药物象产品。 超过五十种新的化合物每个月增加到产品名单。我们先进的中间体的宽广的类型，
    包括积木，新颖的胺物、被保护的胺物、不自然的氨基酸、酮、醋醛、heterocycles、isatoic酐、boroinc酸和手性
    的中间体可能加速您的药物研究过程。某某也提供半大块中间体(10公斤)，大块中间体(对吨)，使原材料和他们的
    中间体服麻醉剂进入合理的价格和优良品质。 
    请参观<a href="./ProductServlet?operation=showAll">浏览产品页</a>。 <br />
    编目可以在网上被观看或者由<a href="./product/Product_Search.jsp">查询产品浏览产品</a> 或您喜欢电子上接受我们的编目的(以PDF或SD格式)，请电子邮件我们. </div>
  <p>&nbsp;</p>
</div><div id="subcontent">
<%
HttpSession mysession = request.getSession(false);

String type=request.getParameter("a");

if(mysession.getAttribute("productuser")!=null && type==null){
User user=(User)mysession.getAttribute("productuser");%>

<div class="small box"><div class="loading_p"> … </div><div class="loading_p">
      欢迎您，<%=user.getUserName() %>
    </div><div class="loading_p">
      邮箱：<%=user.getEmail()%>
    </div><div class="loading_p"><a href="<%=path%>/LoginServlet?a=logout">
      注销
    </a></div><div class="loading_p"><a href="#"></a></div></div>


<%}else{
	if(type!=null && type.equals("out")){
		mysession.removeAttribute("productuser");
	}
 %>







<form name="form" method="post" action="./LoginServlet?a=login">
  <div class="small box">
    <table width="150" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="30%" colspan="2" valign="middle"><img src="./images/username.jpg" width="61" height="17" align="bottom" />
            <input name="username" type="text" size="7"/>        </td>
      </tr>
      <tr>
        <td colspan="2" valign="middle"><img src="./images/password.jpg" width="61" height="17" />
            <input name="password" type="password" size="6" /></td>
      </tr>
      <% 
      if(request.getParameter("flag")!=null){
      	
       %>
      <tr>
        <td colspan="2" valign="middle"><font color='#ff0000'>用户名密码错误</font> </td>
      </tr>
      <% } %>
      <tr>
        <td height="30" valign="bottom"><span class="big_k">点击这里<a href="register.jsp">注册
          
        </a></span></td>
        <td align="left" valign="bottom"><a href="#">
          <input name="image" type="image" onclick="return checkLogin(form);" src="./images/login_1_7.jpg" alt="登录" width="44" height="17" border="0"/>
        </a></td>
      </tr>
      <tr>
        <td colspan="2" valign="bottom">&nbsp;</td>
      </tr>
    </table>
  </div>
</form>
<%
}
%>
  <h2>最新商品列表</h2>
  <ul class="menublock">
    <li><a href="<%=path%>/ProductServlet?operation=search&searchName=category_name&searchValue=西药">西药</a><a href="#"><img src="./images/buy.gif" width="20" height="16" border="0"/></a></li>
    <li><a href="<%=path%>/ProductServlet?operation=search&searchName=category_name&searchValue=中药">中药</a><a href="#"><img src="./images/buy.gif" width="20" height="16" border="0"/></a></li>
    </ul>


  </div>
<div id="footer">
<p><a href="http://www.ascenttech.com.cn/" target="_blank">版权所有：北京亚思晟商务科技有限公司 &copy;2004-2008|京ICP备05005681</a><a href="#"></a></p>
</div>

</div>
</body>
</html>
