<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
<script type="text/javascript">
function validate(){
	var userCode = document.getElementById("userCode").value;
	var userPassword = document.getElementById("userPassword").value;
	var userCodeSpan = document.getElementById("userCodeSpan");
	var userPasswordSpan = document.getElementById("userPasswordSpan");
	var flag = true;
	if(userCode == null  || userCode == ''){
		userCodeSpan.innerHTML = "请输入用户名";
		flag = false;
	}
	if(userPassword == null || userPassword == ''){
		userPasswordSpan.innerHTML = "请输入密码";
		flag = false;
	}
	//提交
	var actionForm = document.getElementById("actionForm");
	if(flag){
		actionForm.submit();
	}
	
}
	function register() {
		location.href="register";
	}
</script>
</head>
<body>
<h2>图书借阅系统</h2>
<form  action="dologin"  name="actionForm" id="actionForm"  method="post">
	登录账号:<input type="text" id="userCode" name="userCode"/><span id="userCodeSpan" ></span><br>
	登录密码:<input type="text" id="userPassword" name="userPassword"/><span id="userPasswordSpan"></span>
	<span style="color: red;">${error }</span><br>
	<input type="button" value="登录|Login" onclick="validate()">
	<input type="reset" value="重填">
	<input type="button" value="注册用户" onclick="register()">
</form>	

</body>
</html>