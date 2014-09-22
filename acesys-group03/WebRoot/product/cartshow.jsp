<%@ page language="java" import="java.util.*" import="com.pactera.bean.Product" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<script language="javascript">
 function updateQuantity(obj,str){
 	var pid = str;
    var quantity =obj.value;
 	if(isNaN(quantity)){
 	window.alert("不是数字");
 	}else{
   
   send_request("<%=request.getContextPath()%>/ShopcartServlet?a=updateNum&pid="+pid+"&quantity="+quantity);
   }
  } 
  
  var http_request = false;
	function send_request(url)
	{ //初始化、指定处理函数、发送请求的函数
		http_request = false;
		//开始初始化XMLHttpRequest对象
		if(window.XMLHttpRequest) 
		{ //Mozilla 浏览器
			http_request = new XMLHttpRequest();
			if(http_request.overrideMimeType) 
			{//设置MiME类别
				http_request.overrideMimeType('text/xml');
			}
		}
		else if(window.ActiveXObject) 
		{ // IE浏览器
			try 
			{
				http_request = new ActiveXObject("Msxml2.XMLHTTP");
			} 
			catch(e) 
			{
				try 
				{
					http_request = new ActiveXObject("Microsoft.XMLHTTP");
				}
				catch(e){}
			}
		}
		if(!http_request) 
		{ // 异常，创建对象实例失败
			window.alert("不能创建XMLHttpRequest对象实例.");
			return false;
		}
		http_request.onreadystatechange = processRequest;
		// 确定发送请求的方式和URL以及是否同步执行下段代码
		http_request.open("POST", url, true);
		http_request.send(null);
	}
	// 处理返回信息的函数
    function processRequest() 
    {
        if (http_request.readyState == 4) 
        { // 判断对象状态
            if (http_request.status == 200) 
            { // 信息已经成功返回，开始处理信息
               var divhtml = http_request.responseText;
			   alert(divhtml);
            }
        }
       
   } 
</script>
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
          <td height="20"><div class="right_proaducts">我的位置&gt;&gt;医药商务管理&gt;查看购物车<br />
            <br />
          </div>
		  <form action="" method="post" name="form" id="form">
  <DIV class=padding>
  <DIV id=middlebody>
  <table cellspacing="0" cellpadding="0" width="100%" border="0">
    <tbody>
      <tr>
        <td width="30%" background="./index.jsp"><div align="left">|&nbsp;&nbsp;欢迎,user&nbsp;&nbsp;|&nbsp;&nbsp;<a class="table_t"  href="./index.jsp">注销</a>&nbsp;&nbsp;|</div></td>
        <td width="15%"><div align="center"><a  href="./ordershow.jsp">查看订单</a></div></td>
        <td width="20%"><div align="center"><a  href="./cartshow.jsp">查看购物车</a></div></td>
        <td width="15%"><div align="center"><a href="./checkout.jsp">结算中心</a></div></td>
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
