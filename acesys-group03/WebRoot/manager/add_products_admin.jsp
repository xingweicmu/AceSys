<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
<title>AscentSysҽҩ����ϵͳ</title>
<meta http-equiv="content-type" content="text/html; charset=GB2312" />
<meta name="description" content="Your website description goes here" />
<meta name="keywords" content="your,keywords,goes,here" />
<link rel="stylesheet" href="<%=path %>/css/andreas08(blue).css" type="text/css" media="screen,projection" />
<script type="text/javascript" src="<%=path %>/js/acesys.js"></script>
</head>

<body>
<div id="container" >

<div id="header">
<h1>���ô���˼�ɿƼ� </h1>
<h2>Quality is everything!</h2>
</div>

<div id="navigation">
<ul>
<li class="selected"></li>
<li><a href="<%=path %>/index.jsp">��ҳ</a></li>
<li><a href="<%=path %>/itservice.jsp">IT����</a></li>
<li><a href="<%=path %>/products.jsp">ҽҩ����ϵͳ</a></li>
<li><a href="<%=path %>/employee.jsp">Ա����Ƹ</a></li>
<li><a href="<%=path %>/ContactUs.jsp">��������</a></li>
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
          <td height="20"><div class="right_proaducts">�ҵ�λ��&gt;&gt;ҽҩ�������&gt;��Ʒ���<br />
            <br />
          </div>
		  <form action="../ProductServlet?operation=save" method="post" name="form" id="form" enctype="multipart/form-data">
  <DIV class=padding>
  <DIV id=middlebody>
<table width="100%">
    <tbody>
      <tr>
        <td height="20"><div class="table_t">|&nbsp;&nbsp;��ӭ,admin&nbsp;&nbsp;|&nbsp;&nbsp;<a 
      class="table_t" 
      href="<%=path %>/common/index.jsp">ע��</a>&nbsp;&nbsp;|</div></td>
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
      <!-- ��Ʒ�б� -->
      <!-- ��Ʒ�б� -->
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
      height="20">��Ʒ��Ϣ��&nbsp;<a 
      href="javascript:history.back(-1)">&lt;&lt;&lt; ����</a> </td>
        <td width="411"><input type="hidden" value="1" name="pid" /></td>
      </tr>
    </tbody>
  </table>
  <table width="100%" border="0" cellspacing="0" bordercolor="#9EA7AB" bgcolor="#f3f3f3">
  	 <tr>
      <td height="10" colspan="4"><s:property value="tip"/></td>
	 </tr>
	   <tr>
    <td width="122" height="15" class="table_c"><div align="right">���:</div></td>
	  <td width="122"><input name="productId" type="text"/></td>
	  <td width="85" class="table_c"><div align="right">��Ʒ����:</div></td>
	  <td width="163" height="15"><input name="productname" type="text" /></td>
  	 </tr>
	 <tr>
   <td width="122" height="15" class="table_c"><div align="right">ҩƷ����:</div></td>
	  <td width="122"><input name="catalogno" type="text" /></td>
	  <td width="85" class="table_c"><div align="right">��ѧ��ժ�ǼǺ�:</div></td>
	  <td width="163" height="15"><input name="cas" type="text" /></td>
  	 </tr>
	
	 <tr>
      <td width="122" height="15" class="table_c"><div align="right">MDL ���:</div></td>
	  <td width="122"> <input name="mdlnumber" type="text" /></td>
	  <td width="85" class="table_c"><div align="right">�²�Ʒ:</div></td>
	 <!--  <td width="163" height="35"><input name="newproduct" type="text" /></td> -->
	 <td height="15" class="table_c">
	 ��:  <input type="radio" name="newproduct" value="1" />
	 ��:   <input type="radio" name="newproduct" value="0" checked/>
	 </td>
  	 </tr>
  	  <tr>
      <td width="122" height="15" class="table_c"><div align="right">��ѧ����ʽ:</div></td>
	  <td width="122">
       <input name="formula" type="text" /></td>
	  <td width="85" class="table_c"><div align="right">������:</div></td>
	  <td width="163" height="15"><input name="mw" type="text" /></td>
  	 </tr>
  	 
	 <tr>
    <td width="122" height="15" class="table_c"><div align="right">ҩƷ���:</div></td>
	  <td width="122">
      <input name="category" type="text" /></td>
	  <td width="85" class="table_c"><div align="right">��ע:</div></td>
	  <td width="163" height="30"><input name="note" type="text" /></td>
  	 </tr> 
  	 <tr>
      <td width="122" height="15" class="table_c"><div align="right">�۸�1:</div></td>
	  <td width="122">
      <input name="price1" type="text" /></td>
	  <td width="85" class="table_c"><div align="right">���:</div></td>
	  <td width="163" height="15"><input name="stock" type="text" /></td>
  	 </tr>
	  <tr>
      <td width="122" height="15" class="table_c"><div align="right">�۸�2:</div></td>
	  <td width="122"><input name="price2" type="text" /></td>
	  <td width="85" class="table_c"><div align="right">ʵ�ʿ��:</div></td>
	  <td width="163" height="15"><input name="realstock" type="text" /></td>
  	 </tr>
  	 <tr>
	  <td width="122" class="table_c"><div align="right">ͼƬ:</div></td>
	  <td width="122" height="15">
	  <input type="file" name="upload" /> </td>   
       <td width="85" class="table_c"><div align="right"></div></td>
	  <td width="163" height="15"></td>   
  	 </tr>
	 <tr>
      <td height="15" colspan="4"><div align="center">
        
        <div class="loading_ll"><input type="button" value="�ύ" onclick="addProducts()"/>
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
<p><a href="http://www.ascenttech.com.cn/" target="_blank">��Ȩ���У�������˼������Ƽ����޹�˾ &copy;2004-2008|��ICP��05005681</a></p>
</div>

</div>
</body>
</html>
