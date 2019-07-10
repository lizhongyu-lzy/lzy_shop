<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resource/css/index7.css">

<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
$(function () {
	
			
}) 
function re() {
	location = "list"
}
</script>
</head>
<body>
	<div align="center">
		<form action="">
			店铺名称:<input type="text" name="sname" value="${shop.sname}" disabled="disabled"><br><br>
			创建日期:<input type="text" name="date" value="${shop.date }" disabled="disabled"><br><br>
			销售商品:<c:forEach items="${type }" var="c" varStatus="v">
						<input type="button" name="tid" value="${c.tname }" disabled="disabled">
					</c:forEach>
			<br><br>
			<input type="button" value="返回" onclick="re()">
		</form>
	</div>
</body>
</html>