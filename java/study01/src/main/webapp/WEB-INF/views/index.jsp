<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>INDEX PAGE</h1>
	<nav>
		<ul>
			<li><a href = "${pageContext.request.contextPath }/">HOME</a></li>
			<li><a href = "${pageContext.request.contextPath }/intro">INTRO</a></li>
			<li><a href = "${pageContext.request.contextPath }/list">LIST</a></li>
			<li><a href = "${pageContext.request.contextPath }/signin">SINGIN</a></li>
		</ul>
	</nav>
</body>
</html>