<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>request 내장객체</h1>
	<p><%=request.getRemoteAddr() %></p>
	<p><%=request.getMethod() %></p>
	<p><%=request.getRequestURI() %></p>
	<p><%=request.getContextPath() %></p>
	<p><%=request.getServerName() %></p>
	<p><%=request.getServerPort() %></p>
	<p><a href = "https://search.naver.com/search.naver?where=nexearch&sm=top_sug.pre&fbm=0&acr=3&acq=van+halen&qdt=0&ie=utf8&query=van+halen">[link]</a></p>
</body>
</html>