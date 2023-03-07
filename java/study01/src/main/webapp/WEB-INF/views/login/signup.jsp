<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입하기</h1>
	<nav>
		<ul>
			<li><a href = "${pageContext.request.contextPath }/">HOME</a></li>
			<li><a href = "${pageContext.request.contextPath }/intro">INTRO</a></li>
			<li><a href = "${pageContext.request.contextPath }/book/list">LIST</a></li>
			<li><a href = "${pageContext.request.contextPath }/signin">SINGIN</a></li>
		</ul>
	</nav>
	<form method="post">
		<div>
			<label for="id">아이디</label>
			<input type="text" id="id" name="id" />
		</div>
		<div>
			<label for="pwd">비밀번호</label>
			<input type="password" id="pwd" name="pwd" />
		</div>
		<button>회원가입하기</button>
	</form>
</body>
</html>