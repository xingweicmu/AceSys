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
          <td height="20"><div class="right_proaducts">我的位置&gt;&gt;医药商务管理&gt;&gt;用户修改 </div></td>
        </tr>
      </table>
        <br/>
        <table width="680" border="0" cellpadding="0" cellspacing="0">
          <tbody>
            
            <tr>
              <td bgcolor="#467AA7" colspan="2" height="5"></td>
            </tr>
            <tr>
              <td colspan="2" height="7"></td>
            </tr>
            <tr>
              <td width="110" height="20" bgcolor="#bbddff" class="table_c">　修改用户信息 </td>
              <td width="439" bgcolor="#ffffff">&nbsp;&nbsp;&nbsp;&nbsp;<a 
      href="javascript:history.back()">&lt;&lt;&lt; 返回</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <S:PROPERTY value="tip" 
/></td>
            </tr>
          </tbody>
        </table>
        <form name="form"  method="post" action="products_showusers.jsp">
        <div class="table_wz">
          <table width="90%" border="0" cellpadding="0" cellspacing="0" bgcolor="#F3F3F3">
            <tbody>
              <tr>
                <td colspan="4" height="10"></td>
              </tr>
            </tbody>
            <div>
              <input type="hidden" value="1" name="uid" />
            </div>
            <tr>
              <td class="table_hui" width="71" height="30"><div align="right">城市:</div></td>
              <td class="table_c" width="166" height="30"><input value="beijing" name="city" />
              </td>
              <td class="table_c" width="70"><div class="table_hui" id="result_box" dir="ltr">
                  <div align="right">用户名:</div>
              </div></td>
              <td class="table_c" width="155"><input value="admin" name="username" /></td>
            </tr>
            <tr>
              <td class="table_hui" width="71" height="30"><div align="right">全名:</div></td>
              <td class="table_c" width="166" height="30"><input value="管理员" name="fullname" />
              </td>
              <td class="table_c" width="70"><div class="table_hui" id="result_box" dir="ltr">
                  <div align="right">称呼:</div>
              </div></td>
              <td class="table_c" width="155"><input name="title" value="aa" />
              </td>
            </tr>
            <tr>
              <td class="table_hui" height="30"><div align="right">电话:</div></td>
              <td class="table_c" height="30"><input value="123456" name="tel" />
              </td>
              <td class="table_c" height="30"><div class="table_hui" id="div" dir="ltr">
                  <div align="right">密码:</div>
              </div></td>
              <td class="table_c" height="30"><input type="password" value="admin" 
    name="password" /></td>
            </tr>
            <tr>
              <td class="table_hui" height="25"><div align="right">邮政编码:</div></td>
              <td class="table_c" height="25"><input value="100086" name="zip" />
              </td>
              <td class="table_hui" height="25"><div align="right">职务:</div></td>
              <td class="table_hui" height="25"><span class="table_c">
                <input value="manager" 
      name="job" />
              </span></td>
            </tr>
            <tr>
              <td class="table_hui" height="30"><div align="right">邮件:</div></td>
              <td class="table_c" height="30"><input value="admin@163.com" name="email" /></td>
              <td class="table_hui" height="30"><div align="right">国家:</div></td>
              <td class="table_c" height="30"><input value="china" name="country" />
              </td>
            </tr>
            <tr>
              <td height="30" align="right" class="table_hui">公司名称:</td>
              <td class="table_c"  height="30"><input value="ascent"   name="companyname" /> </td>
              <td class="table_hui" height="25"><div align="right">公司地址: </div></td>
              <td height="25"  class="table_hui"><input value="beijing"   name="companyaddress" /></td>
            </tr>
            <tr>
              <td align="right" class="table_hui">备注：
              </td>
              <td height="25" colspan="3" align="left" class="table_hui"></td>
            </tr>
            <tr>
              <td height="25" colspan="4" align="center" class="table_hui"><textarea name="note" rows="8" cols="70"></textarea>
              </td>
            </tr>
            <tr>
              <td colspan="4" height="45"><div align="center">
                <input class="table_hui" onclick="return updateProductUser(form);" type="submit" value="更新" name="Submit" />
              </div></td>
            </tr>
            <tr>
            <td>
            </TBODY>
            </td>
            </tr>
          </table>
        </div></td>
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
