<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	div {
		padding: 10px 0;
	}

	a {
		color: black;
	}
</style>
</head>
<body>
<jsp:useBean id = "User" class = "com.sql.DataBean" scope = "session" />
<%
	String view = request.getParameter("page") == null ? "home" : request.getParameter("page");
	String url = "page/" + view + ".jsp";
%>
<div align = "center" style="margin-bottom: 30px; color:white; background:gray;">
	<a href = "?page=home">[HOME]</a>
	<a href = "?page=list">[LIST]</a>
	<a href = "?page=menu">[MENU]</a>
	<% System.out.println(User.isLoginState()); %>
	<% if(!User.isLoginState()){ %>
		<a href = "?page=login">[LOGIN]</a>
	<%}else { %>
		<a href = "?page=logout">[LOGOUT]</a>
	<%} %>
</div>

<div>
	<jsp:include page="<%=url %>"></jsp:include>
</div>


</body>
</html>