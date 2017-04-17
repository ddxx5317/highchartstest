<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript"
	src="<%=basePath%>resources/jquery-1.11.0.min.js"></script>
<style type="text/css">
a {
	border: 1px solid rgb(73, 58, 58);
	background-color: rgb(133, 133, 133);
	height: 50px;
	line-height: 50px;
	color: white;
	text-decoration: none;
	font-weight: bold;
	padding: 5px;
	margin: 5px;
}
</style>
<script type="text/javascript">

function deleteUser(id){
	$.ajax({
		type: 'delete',
		url:'<%=basePath%>user/'+id,
		dataType:'text', 
		success:function(data){
			if(data=="suc"){
				alert("删除成功");
				location.reload();
			}
		},
		error:function(data){
		}
	});
}

</script>
</head>

<body>
	SUCCESS
</body>
</html>
