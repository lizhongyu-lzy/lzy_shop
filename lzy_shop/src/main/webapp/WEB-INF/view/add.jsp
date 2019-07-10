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

function add() {
	$.post("add",$("form").serialize(),function(flag){
		if(flag){
			alert("添加成功")
			location.href = "list"
		}else{
			alert("添加成功")
		}
	},"json")
}

</script>
</head>
<body>
	<div align="center">
		<form action="">
			店铺名称:<input type="text" name="sname"><br><br>
			创建日期:<input type="date" name="date"><br><br>
			销售商品:<c:forEach items="${list }" var="c" varStatus="v">
						<input type="checkbox" name="tid" value="${c.tid }">${c.tname } 
					</c:forEach>
			<br><br>
			<input type="button" value="添加" onclick="add()">
		</form>
	</div>
</body>
</html>