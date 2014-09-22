<%@ page language="java" import="java.util.*" import="com.pactera.bean.Product" pageEncoding="UTF-8"%>
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
<li><a href="./index.jsp">首页</a></li>
<li><a href="./itservice.jsp">IT服务</a></li>
<li><a href="./products.jsp">医药商务系统</a></li>
<li><a href="./employee.jsp">员工招聘</a></li>
<li><a href="./ContactUs.jsp">关于我们</a></li>
<li></li>
</ul>
</div>
 <form name="form" method="post" action="OrderServlet">
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
          <td height="20"><div class="right_proaducts">我的位置&gt;&gt;医药商务管理&gt;结算中心<br />
            <br />
          </div>
		
  <DIV class=padding>
  <DIV id=middlebody>
  <table cellspacing="0" cellpadding="0" width="100%" border="0">
    <tbody>
      <tr>
        <td width="30%"><div align="left">|&nbsp;&nbsp;欢迎,user&nbsp;&nbsp;|&nbsp;<a href="./index.jsp">&nbsp;注销</a>&nbsp;&nbsp;|</div></td>
        <td width="15%"><div align="center">&nbsp;</div></td>
        <td><div align="center"><a 
      href="./products_show.jsp">商品查询</a></div></td>
        <td><div align="center"><a 
      href="./ordershow.jsp">查看订单</a></div></td>
        <td><div align="center"><a 
      href="./cartshow.jsp">查看购物车</a></div></td>
      </tr>
    </tbody>
  </table>
  <div></div>
  

          <table class="mars" cellspacing="1" cellpadding="0" width="100%" border="0">
            <tbody>
              <tr bgcolor="#fba661" height="30">
                <td><div align="center">编号</div></td>
                <td><div align="center">名称</div></td>
               <td><div align="center">药品分类</div></td>
                <td><div align="center">MDL编号</div></td>
                <td><div align="center">价格</div></td>
                <td><div align="center">数量</div></td>
                <td><div align="center">删除</div></td>
              </tr>
              <%HttpSession mysession = request.getSession(false);
              ArrayList<Product> list = (ArrayList<Product>)mysession.getAttribute("shopcart");
              
              for(int i=0;i<list.size();i++){
              int id = list.get(i).getProductID();
              
               %>
              <tr bgcolor="#f3f3f3" height="25">
                <td width="5%"><div align="center"><%=list.get(i).getProductNumber() %></div></td>
                <td width="13%"><div align="center"><%=list.get(i).getProductName() %></div></td>
                <td width="12%"><div align="center"><%=list.get(i).getCategory().getCategoryName() %></div></td>
                <td width="13%"><div align="center"><%=list.get(i).getMDLNumber() %></div></td>
                <td width="8%"><div align="center"><%=list.get(i).getNormalPrice() %></div></td>
                <td width="29%"><div align="center">
                  <input onchange="updateQuantity(this,<%=id%>)" value="<%=list.get(i).getWeight()+"g" %>"  name="number" />
                  </div></td>
                <td width="13%"><div align="center"><a href="cartshow1.jsp">删除</a></div></td>
              </tr>
              <%} %>
            </tbody>
          </table>
          <br />
          

          <table cellspacing="0" cellpadding="0" width="80%" border="0">
            <tbody>
              <tr bgcolor="#cccccc" height="20">
                <td width="50%" bgcolor="#f3f3f3">&nbsp;&nbsp;<font size="2">用户信息：</font></td>
              </tr>
              <tr>
                <td ><div align="center">
                    <table width="40%" border="0" align="center" cellpadding="0" cellspacing="0">
                      <tbody>
                        <tr>
                          <td><div align="right">用户名称：</div></td>
                          <td><input id="username" value="lixing" name="username" /></td>
                        </tr>
                        <tr>
                          <td><div align="right">常用电话：</div></td>
                          <td><input id="tel" name="tel" /></td>
                        </tr>
                        <tr>
                          <td><div align="right">常用邮箱：</div></td>
                          <td><input id="email" value="lixing@163.com" name="email" /></td>
                        </tr>
                        <tr>
                          <td><div align="right">公司名称：</div></td>
                          <td><input id="companyname" name="companyname" /></td>
                        </tr>
                        <tr>
                          <td><div align="right">公司地址：</div></td>
                          <td><input id="companyaddress" name="companyaddress" /></td>
                        </tr>
                        <tr>
                          <td colspan="2"><div  align="center">
                            <input type="submit" value="提交" name="Submit" />
                            &nbsp;&nbsp;&nbsp;&nbsp;
                              <input id="reset" type="submit" value="取消" name="reset" />
                          </div></td>
                        </tr>
                      </tbody>
                    </table>
                       
                </div></td>
              </tr>
            </tbody>
          </table></td>
        </tr>
      </table>
  
        <br/>
        <div class="table_wz"></div></td>
  </tr>
  </table>
  </div>
   </form>
<div id="footer">
<p><a href="http://www.ascenttech.com.cn/" target="_blank">版权所有：北京亚思晟商务科技有限公司 &copy;2004-2008|京ICP备05005681</a></p>
</div>

</div>
</body>
</html>
