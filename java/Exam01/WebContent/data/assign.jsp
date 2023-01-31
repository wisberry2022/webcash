<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ page import = "java.util.Date, com.sql.DBControl" %>
	<jsp:useBean id = "User" class = "com.sql.DataBean"></jsp:useBean>
	<jsp:setProperty  property="*" name = "User" />
	<%
		DBControl.insertData(User.getUserid(), User.getPwd(), User.getEmail(), User.getTypeid());
	
		response.sendRedirect("../index.jsp");
	%>
</body>
</html>