//登录的验证方法
function checkLogin(){
		if(form.username.value==""){
			alert("用户名不能为空");
			form.username.focus();
			return false;
		}
		if(form.password.value==""){
			alert("用户密码不能为空");
			form.password.focus();
			return false;
		}
//		if((form.username.value=="admin") && (form.password.value=="123")){
//			form.action="../product/products_showusers.html";
//			return true;
//		}
//		if((form.username.value=="user") && (form.password.value=="123")){
//			form.action="../product/products1.html";
//			return true;
//		}
		form.submit();
		return true;
	}
// index页面登录的验证方法	
	function checkLoginIndex(){
		if(form.username.value==""){
			alert("用户名不能为空");
			form.username.focus();
			return false;
		}
		if(form.password.value==""){
			alert("用户密码不能为空");
			form.password.focus();
			return false;
		}
/*		if((form.username.value=="admin") && (form.password.value=="123")){
			form.action="./product/products_showusers.html";
			return true;
		}
		if((form.username.value=="user") && (form.password.value=="123")){
			form.action="./product/products1.html";
			return true;
		}*/
		return true;
	}


 
//注册的验证方法
 function checkRegister(){
	if(form.username.value == "")
    {
       alert("用户名不能为空！"); 
       form.username.focus();
        return false;
    }
   if(form.password.value == "")
    {
        alert("请输入密码 ！");
        form.password.focus();
         return false;
    }
     if(form.password2.value == "")
    {
        alert("请再次输入密码 ！");
       form.password2.focus();
         return false;
    }
    if(form.password.value!=form.password2.value){
    
       alert("两次输入的密码不一致 ！");
        form.password2.focus();
         return false;
    }
    if(form.email.value == "")
    {
        alert("请输入邮件 ！");
        form.email.focus();
         return false;
    }
    
 var regm = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;//验证Mail的正则表达式,^[a-zA-Z0-9_-]:开头必须为字母,下划线,数字,
  if (form.email.value!="" && !form.email.value.match(regm) )
   		 {
     		alert("邮件格式不对，检查后重新输入！");
	     	form.email.focus();
             return false;
   		 }  
   if(form.code.value==""){
   		alert("请输入验证码！");
        form.code.focus();
         return false;
   }
  else 
    return true;
}

 function checkOrder(form){
	if(form.username.value == "")
    {
       alert("用户名不能为空！"); 
       form.username.focus();
        return false;
    }
    if(form.tel.value!=""){
    	 var mobilereg = /^(((13[0-9]{1})+\d{8}))|(((15[0-9]{1})+\d{8}))$/;
    	 var telreg = /^(((0[0-9]{2})+(\-)+\d{8}))|(((0[0-9]{3})+(\-)+\d{8}))|(((0[0-9]{3})+(\-)+\d{7}))$/;    
  		 var bl1=mobilereg.test(form.tel.value);
  		 var bl2=telreg.test(form.tel.value);
  		 if(bl1||bl2){
  		 	return true;
  		 }else{
  		 	alert("您输入正确手机或0xx-xxxxxxxx格式电话");
  		 	form.tel.focus();
  		 	return false;
  		 }
    }
   
    if(form.email.value == "")
    {
        alert("请输入邮件 ！");
        form.email.focus();
         return false;
    }
    
 var regm = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;//验证Mail的正则表达式,^[a-zA-Z0-9_-]:开头必须为字母,下划线,数字,
  if (form.email.value!="" && !form.email.value.match(regm) )
   		 {
     		alert("邮件格式不对，检查后重新输入！");
	     	form.email.focus();
             return false;
   		 }  
  else 
    return true;
}
//修改用户的验证方法
function updateProductUser(form)
{
	if(form.city.value == "")
    {
       alert("城市名称不能为空！"); 
       form.city.focus();
        return false;
    }
    if(form.username.value == "")
    {
       alert("用户名不能为空！"); 
       form.username.focus();
        return false;
    }
    if(form.fullname.value == "")
    {
       alert("真实姓名不能为空！"); 
       form.fullname.focus();
        return false;
    }
    if(form.title.value == "")
    {
       alert("称呼不能为空！"); 
       form.title.focus();
        return false;
    }
    if(form.tel.value == "")
    {
       alert("用户电话不能为空！"); 
       form.tel.focus();
        return false;
    }
    if(form.password.value == "")
    {
       alert("用户密码不能为空！"); 
       form.password.focus();
        return false;
    }
    if(form.zip.value == "")
    {
       alert("邮政编码不能为空！"); 
       form.zip.focus();
        return false;
    }
    if(form.job.value == "")
    {
       alert("职位不能为空！"); 
       form.job.focus();
        return false;
    }
    if(form.companyname.value == "")
    {
       alert("公司名称不能为空！"); 
       form.companyname.focus();
        return false;
    }
    if(form.companyaddress.value == "")
    {
       alert("公司地址不能为空！"); 
       form.companyaddress.focus();
        return false;
    }
    if(form.note.value == "")
    {
       alert("备注不能为空！"); 
       form.note.focus();
        return false;
    }
    return true;
    
    
}

//更换样式的方法
 function changeStyle(sel){
        var value = sel.options[sel.selectedIndex].value;
        var links = document.getElementById("styles");
        links.href="./css/"+value; 
     }
//搜素药品的验证方法  
function checkValue(obj)
{
	  var values = obj.searchValue.value;
	  if(values == "")
    {
        alert("请输入搜素内容 ！");
        obj.searchValue.focus();
        return false;
    }
}
//修改商品的验证方法
function updateProducts(from){
	if(form.productId.value == "")
    {
        alert("编号不能为空 ！");
        form.productId.focus();
        return false;
    }
    if(form.productname.value == "")
    {
        alert("产品名称不能为空 ！");
        form.productname.focus();
        return false;
    }
    if(form.catalogno.value == "")
    {
        alert("药品分类不能为空 ！");
        form.catalogno.focus();
        return false;
    }
    if(form.cas.value == "")
    {
        alert("化学文摘登记号不能为空 ！");
        form.cas.focus();
        return false;
    }
    if(form.mdlnumber.value == "")
    {
        alert("MDL编号不能为空 ！");
        form.mdlnumber.focus();
        return false;
    }
    if(form.newproduct.value == "")
    {
        alert("新产品必须选择 ！");
        form.newproduct.focus();
        return false;
    }
    if(form.formula.value == "")
    {
        alert("化学方程式必须输入 ！");
        form.formula.focus();
        return false;
    }
    if(form.mw.value == "")
    {
        alert("总重量必须输入 ！");
        form.mw.focus();
        return false;
    }
    if(form.category.value == "")
    {
        alert("药品类别必须输入！");
        form.category.focus();
        return false;
    }
    if(form.price1.value == "")
    {
        alert("请输入价格1 ！");
        form.price1.focus();
        return false;
    }
    if(form.stock.value == "")
    {
        alert("请输入库存！");
        form.stock.focus();
        return false;
    }
    if(form.price2.value == "")
    {
        alert("请输入 价格2 ！");
        form.price2.focus();
        return false;
    }
    if(form.realstock.value == "")
    {
        alert("请输入实际库存！");
        form.realstock.focus();
        return false;
    }
   return true;
	}
// 添加商品验证方法	
function addProducts(){
	if(form.productId.value == "")
    {
        alert("编号不能为空 ！");
        form.productId.focus();
        return false;
    }
    if(form.productname.value == "")
    {
        alert("产品名称不能为空 ！");
        form.productname.focus();
        return false;
    }
    if(form.catalogno.value == "")
    {
        alert("药品分类不能为空 ！");
        form.catalogno.focus();
        return;
    }
    if(form.cas.value == "")
    {
        alert("化学文摘登记号不能为空 ！");
        form.cas.focus();
        return false;
    }
    if(form.mdlnumber.value == "")
    {
        alert("MDL编号不能为空 ！");
        form.mdlnumber.focus();
        return false;
    }
    if(form.newproduct.value == "")
    {
        alert("新产品必须选择 ！");
        form.newproduct.focus();
        return false;
    }
   
  
    if(form.formula.value == "")
    {
        alert("化学方程式必须输入 ！");
        form.formula.focus();
        return false;
    }
    if(form.mw.value == "")
    {
        alert("总重量必须输入 ！");
        form.mw.focus();
        return false;
    }
    if(form.category.value == "")
    {
        alert("药品类别必须输入！");
        form.category.focus();
        return false;
    }
    if(form.price1.value == "")
    {
        alert("请输入价格1 ！");
        form.price1.focus();
        return false;
    }
    if(form.stock.value == "")
    {
        alert("请输入库存！");
        form.stock.focus();
        return false;
    }
    if(form.price2.value == "")
    {
        alert("请输入 价格2 ！");
        form.price2.focus();
        return false;
    }
    if(form.realstock.value == "")
    {
        alert("请输入实际库存 ！");
        form.realstock.focus();
        return false;
    }
    if(form.upload.value == "")
  {
       alert("请选择图片 ！");
      form.upload.focus();
      return false;
  }
   form.submit();
	}
	//验证邮件信息
	function checkMail(){
   			if(form.fromaddressname.value==""){
   				alert("发件Email地址");
   				form.fromaddressname.focus();
   				return false;
   			}
   			if(form.frompassword.value==""){
   				alert("发件Email密码");
   				form.frompassword.focus();
   				return false;
   			}
   			if(form.toaddress.value==""){
   				alert("收件Email地址");
   				form.toaddress.focus();
   				return false;
   			}
   			return true;
   		}