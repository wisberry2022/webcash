<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "data/login.jsp" method = "post">
		<table align = "center" cellspacing="5">
			<tr align = "center">
				<td>아이디</td>
				<td><input type = "text" name = "userid" /></td>
			</tr>
			<tr align = "center">
				<td>비밀번호</td>
				<td><input type = "password" name = "pwd" style="width:98%"/></td>
			</tr>
			<tr align = "center">
				<td colspan = "2"><input type = "submit" value = "로그인"/></td>
			</tr>
		</table>
	</form>
	<p align = "center">
		<a href = "index.jsp?page=signup">회원가입</a>
	</p>
</body>
</html>