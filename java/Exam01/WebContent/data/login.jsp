<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="User" class = "com.sql.DataBean" scope="session"/>
	<jsp:setProperty property="userid" name = "User" />
	<jsp:setProperty property="pwd" name = "User" />
	<%@ page import = "com.sql.DBControl" %>
	<%
		if(DBControl.searchData(User.getUserid(), User.getPwd())) {
			response.sendRedirect("../index.jsp"); %>
	<jsp:setProperty property="loginState" name = "User" value = "<%=true %>" />
	<%}else {%>
	<h1>로그인 실패!</h1>
	<%} %>
</body>
</html>