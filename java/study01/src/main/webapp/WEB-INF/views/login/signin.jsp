<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 하기</h1>
	<form method="post">
		<div>
			<label for="id">아이디</label>
			<input type="text" id="id" name="id" />
		</div>
		<div>
			<label for="pwd">비밀번호</label>
			<input type="password" id="pwd" name="pwd" />
		</div>
		<button>로그인하기</button>
	</form>
	<div>
		<a href="signup">회원가입하기</a>
		<a href="#">아이디/비밀번호 찾기</a>
	</div>
</body>
</html>