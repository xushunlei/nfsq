<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书借阅系统主界面</title>
<script type="text/javascript">
var totalPage = ${totalPage};
var currentPage=${currentPage};
function query() {
	document.queryform.currentPage.value="1";
	document.queryform.submit();
}
function first(){
	if(currentPage==1){
		alert("当前已是第一页");
	}else{
		currentPage=1;
		document.queryform.currentPage.value=currentPage;
		document.queryform.submit();
	}
}
function pre(){
	if(currentPage==1){
		alert("当前已是第一页");
	}else{
		currentPage--;
		document.queryform.currentPage.value=currentPage;
		document.queryform.submit();
	}
}
function next(){
	if(currentPage==totalPage){
		alert("当前已是最后一页");
	}else{
		currentPage++;
		document.queryform.currentPage.value=currentPage;
		document.queryform.submit();
	}
}
function last(){
	if(currentPage==totalPage){
		alert("当前已是最后一页");
	}else{
		currentPage=totalPage;
		document.queryform.currentPage.value=currentPage;
		document.queryform.submit();
	}
}	
function go() {
	var page=document.getElementById("page").value;
	if(page<1||page>totalPage){
		alert("没有此页");
	}else {
		currentPage=page;
		document.queryform.currentPage.value=currentPage;
		document.queryform.submit();
	}
}
function drop(){
	if(confirm("是否退出系统")){
		location.href="../users/drop";
	}
}
</script>
</head>
<body >
<h1>图书借阅系统主界面</h1>
<form action="" method="get" name="queryform">
图书分类:
<select name="type_name">
	<option value="0">请选择</option>
	<c:forEach items="${book_typeName}" var="a">
		<option value="${a}">${a}</option>
	</c:forEach>	
</select>
图书名称:
<input type="text" name="book_name" >
是否借阅:
<select name="is_borrow">
	<option >请选择</option>
	<option value="0">已借阅</option>
	<option value="1">未借阅</option>
</select>
<input type="hidden" name="currentPage" value="${page.currenpage}">
<input type="button" value="查找" onclick="query();">
</form>

当前用户:${sessionScope.users.user_code} <!-- <a href="../users/drop">退出</a> --><button onclick="drop()">退出</button>

<div>
 <table border="2">
	<tr>
		<th>图书编号</th><th>图书分类</th><th>图书名称</th><th>作者</th>
		<th>出版社</th><th>操作</th>
	</tr>
	<c:forEach items="${bList}" var="bookInfo">
		<tr>
			<td>${bookInfo.book_code}</td>
			<td>${bookInfo.book_type}</td>
			<td>${bookInfo.book_name}</td>
			<td>${bookInfo.book_author}</td>
			<td>${bookInfo.publish_press}</td>
			<td><c:if test="${bookInfo.is_borrow==0}">
					<a href="${bookInfo.book_id}/update">申请借阅</a>
				</c:if>
				<c:if test="${bookInfo.is_borrow==1}">
					<span style="color: red;">已借阅</span>
				</c:if>
			</td>
		</tr>
	</c:forEach>
</table>
</div>

<span>
	<input type="button" value="首页|" onclick="first()">&nbsp;
	<input type="button" value="上一页" onclick="pre()">&nbsp;
	<input type="button" value="下一页" onclick="next()">&nbsp;
	<input type="button" value="|尾页" onclick="last()">&nbsp;
	第<input type="text" id="page" style="width:20px">页<input type="button" value="go" onclick="go()">&nbsp;&nbsp;
	当前第<span id="cpage">${currentPage}</span>页/
	共<span id="tpage">${totalPage}</span>页&nbsp;&nbsp;
</span>

</body>
</html>