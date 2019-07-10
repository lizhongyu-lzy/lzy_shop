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
	
	$(".page-link").click(function(){
		var url = $(this).attr("data")
		location.href = url + "&" + $("form").serialize();
	})
	
	var tid = '${map.tid}'
	for ( var i in tid) {
		$("[name='tid'][value='"+tid[i]+"']").prop("checked",true);
	}
	
})
function toadd() {
	location.href="toadd";
}
function cha(sid) {
	location.href="cha?sid="  + sid;
}
function plsc() {
	var sid = "";
	$(":checked").each(function(){
		sid += "," + $(this).val()
	})
	sid = sid.substring(1)
	if(sid != null){
		$.post("del",{sid:sid},function(flag){
			if(flag){
				alert("删除成功")
				location.href = "list"
			}else{
				alert("添加成功")
			}
		},"json")
	}
	
	
}

</script>
</head>
<body>
	<form action="list" method="post">
		<c:forEach items="${list2 }" var="c" varStatus="v">
			<input type="checkbox" name="tid" value="${c.tid }">${c.tname } 
		</c:forEach><br><br>
		店铺名称:<input type="text" name="sname" value="${map.sname }">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="查询">
		<input type="button" value="添加" onclick="toadd()">
		<input type="button" value="批量删除" onclick="plsc()">
		
	</form>

	<table class="table">
		<tr>
			<td></td>
			<td>编号</td>
			<td>电铺名称</td>
			<td>创建日期</td>
			<td>销售产品</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list }" var="c" varStatus="v">
			<tr>
				<td>
					<input type="checkbox" value="${c.sid }" name="sid">
				</td>
				<td>${v.count }</td>
				<td>${c.sname}</td>
				<td>${c.date}</td>
				<td>${c.tname}</td>
				<td>
					<button onclick="cha(${c.sid})">详情</button>
				</td>
			</tr>
		</c:forEach>
			<tr>
				<td colspan="11">
					${pageInfo }
				</td>
			</tr>
	</table>
</body>
</html>