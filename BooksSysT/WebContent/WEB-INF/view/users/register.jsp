<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<script type="text/javascript">
	function register() {
		var userCode = document.getElementById("userCode").value;
		var password1=document.getElementById("password").value;
		var password2=document.getElementById("password2").value;
		var gender=document.getElementById("gender").value;
		var email=document.getElementById("email").value;
		
		var userCodeSpan = document.getElementById("userCodeSpan");
		var userPasswordSpan = document.getElementById("userPasswordSpan");
		var genderSpan=document.getElementById("genderSpan");
		var emailSpan=document.getElementById("emailSpan");
		var flag = true;
		if(userCode == null  || userCode == ''){
			userCodeSpan.innerHTML = "请输入用户名";
			flag = false;
		}
		if(password1 == null || password1 == ''){
			userPasswordSpan1.innerHTML = "请输入密码";
			flag = false;
		}
		if(password2 == null || password2 == ''){
			userPasswordSpan2.innerHTML = "请输入密码";
			flag = false;
		}
		if(password1!=password2){
			alert("两次输入密码不同");
		}
		if(gender=='请选择'){
			genderSpan.innerHTML="请选择性别";
		}
		if(email== null  || userCode == ''){
			emailSpan.innerHTML="请输入邮箱";
		}
		if(flag){
			document.sform.submit();
		}
		
	}
</script>
</head>
<body>
<h2>会员注册</h2>
<sf:form method="post" modelAttribute="users" name="sform">
	登录账户:<sf:input path="user_code" id="userCode"/><span style="color: red;">*</span>
		<span id="userCodeSpan" ></span>
		<sf:errors path="user_code"/><br/>
	密码:<sf:password path="password" id="password" /><span style="color: red;">*</span>
		<span id="userPasswordSpan1" ></span>
		<sf:errors path="password"/><br/>
	确定密码:<input type="password" id="password2"><span style="color: red;">*</span>
		<span id="userPasswordSpan2" ></span><br>
	性别:<select name="gender" id="gender">
			<option>请选择</option>
			<option>男</option>
			<option>女</option>
		</select><span style="color: red;">*</span>
		<span id="genderSpan"></span><br>
	电子邮箱:<sf:input path="email" id="email"/><span style="color: red;">*</span>
		<span id="emailSpan"></span>
		<sf:errors path="email"/><br/>
		<input type="button" value="注册" onclick="register()">
		<input type="button" value="返回" onclick="hostory:back()">
</sf:form>
</body>
</html>