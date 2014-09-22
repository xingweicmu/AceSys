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
          <td><div class="right_proaducts">
            <div class="right_proaducts">我的位置 &gt;&gt; 医药商务管理 &gt;&gt;商品查询 </div>
            <div class="right_proaducts"><a href="javascript:history.back()">&lt;&lt;&lt;返回</a> </div>
            <div class="biankuang_s">
              <div class="f_s">
                <div class="biao_q">商品查询</div>
              </div>
              <div class="f_s1"></div>
      <form action="<%=path %>/ProductServlet?operation=search" method="post" name="form" id="form">          
              <div class="f_s3">
                <table width="400">
                  <tbody>
                    <tr>
                      <td class="table_hui" width="184" height="20"><div align="right"></div></td>
                      <td width="204"></td>
                    </tr>
                    <tr>
                      <td class="table_hui"><div align="right">请选择:</div></td>
                      <td class="table_hui"><select name="searchName">
                          <option value="product_number" selected="selected">商品编号</option>
                          <option value="productname">商品名称</option>
                          <option value="category_name">商品分类名</option>
                          <option value="categoryno">商品分类号</option>
                      </select></td>
                      <td><input name="searchValue" /></td>
                    </tr>
                    <tr>
                      <td class="table_hui" height="30">　 </td>
                      <td class="table_hui" height="30"><input onclick="return checkValue(form);" type="submit" value="查询" name="Submit" /></td>
                      <td class="table_hui" height="30"><input type="reset" value="取消" name="Reset" /></td>
                    </tr>
                  </tbody>
                </table>
              </div>
              </form>
              <div class="f_s2"></div>
            </div>
          </div>
		  <br /></td>
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
