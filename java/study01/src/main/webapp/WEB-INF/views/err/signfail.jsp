<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 실패</h1>
	<nav>
		<ul>
			<li><a href = "${pageContext.request.contextPath }/">HOME</a></li>
			<li><a href = "${pageContext.request.contextPath }/intro">INTRO</a></li>
			<li><a href = "${pageContext.request.contextPath }/book/list">LIST</a></li>
			<li><a href = "${pageContext.request.contextPath }/signin">SINGIN</a></li>
		</ul>
	</nav>
	<p>일치하지 않는 정보입니다!</p>
	<div>
		<a href = "${pageContext.request.contextPath }/">메인으로</a>
	</div>
</body>
</html>