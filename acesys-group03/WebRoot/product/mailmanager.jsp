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
<script type="text/javascript" src="../js/acesys.js"></script>
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
<form name="form" method="post" action="<%=path %>/MailServlet">
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
      <td height="15" align="left" valign="top" class="12"><a 
href="javascript:history.go(-1);">返回&gt;&gt;&gt;</a>
        
        <%
        HttpSession mysession = request.getSession(false); 
      	if(mysession.getAttribute("mailto")!=null){
      	      	%><div id="xianshi">
      
 管理员邮箱：
    <br></br>
      
发件地址：<%=mysession.getAttribute("mailname")%>
    <br></br>
      
收件地址：<%=mysession.getAttribute("mailto")%>
    <br></br>
      
如果想修改，请进行下面的操作
    <br></br>
    <%
    mysession.removeAttribute("mailname");
    mysession.removeAttribute("mailto");
      	}else{
      	%>
      	<div id="xianshi"><a href="<%=path %>/MailServlet">已设邮箱</a></div>
      	<%
      	}
        %>
        <div align="center">
          <table width="70%" border="0" cellpadding="0" cellspacing="8" bgcolor="f3f3f3">
            <tbody>
              <tr>
                <td width="26%"><div align="center">发件Email地址 </div>
                    <div align="center"></div></td>
                <td width="43%" align="left"><input id="fromaddressname" name="fromaddressname" />
                </td>
                <td width="31%"><select id="fromaddresstype" name="fromaddresstype">
                    <option 
        value="@163.com" selected="selected">@163.com</option>
                    <option 
        value="@126.com">@126.com</option>
                    <option 
        value="@sohu.com">@sohu.com</option>
                    <option 
        value="@sina.com">@sina.com</option>
                    <option 
        value="@gmail.com">@gmail.com</option>
                </select></td>
              </tr>
              <tr>
                <td><div align="center">发件Email密码</div></td>
                <td align="left"><input name="frompassword" type="password" id="frompassword" size="21" /></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td><div align="center">收件Email地址</div></td>
                <td align="left"><input id="toaddress" name="toaddress" /></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td colspan="3"><div align="center">
                  <input onclick="return checkMail(form);" type="submit" value="提交" name="Submit" />
                  &nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="reset" value="取消" name="Reset" />
                </div></td>
              </tr>
            </tbody>
          </table>
        </div>
        <div><br />
          帮助：<br />
          &lt;1&gt;请正确的设置发件箱地址及密码，该邮件是负责发送邮件的地址<br />
          &lt;2&gt;请正确的设置收件箱地址，该邮件是接收邮件的地址，当客户在<br />
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;结算中心提交后，邮件会发送到该邮件<br />
          &lt;3&gt;试运行时请重新设置自己的邮箱，库中邮件地址您无法查看测试 </div>
        <br/>
        <div class="table_wz"></div></td></tr>
  </table>
  </div>
 </form>
<div id="footer">
<p><a href="http://www.ascenttech.com.cn/" target="_blank">版权所有：北京亚思晟商务科技有限公司 &copy;2004-2008|京ICP备05005681</a></p>
</div>

</div>
</body>
</html>
