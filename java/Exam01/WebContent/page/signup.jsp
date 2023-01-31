<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "data/assign.jsp" method = "post">
		<input type = "hidden" name = "typeid" value = "2" />
		<table align = "center">
			<tr>
				<td>아이디</td>
				<td><input type = "text" name = "userid" /></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type = "text" name = "pwd" /></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type = "text" name = "email" /></td>
			</tr>
			<tr align = "center">
				<td colspan = "2"><input type = "submit" value = "등록하기"/></td>
			</tr>		
		</table>
	</form>
</body>
</html>