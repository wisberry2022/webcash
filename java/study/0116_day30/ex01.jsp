<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<!-- html 주석 -->
	<h1>jsp 문서작성</h1>
	<% 
		// java 주석
		out.println("<h2>hello Tomcat!</h2>");
		for(int i = 0; i<5; i++) {
			// java 주석
			out.println("<p>콘솔 출력</p>");
		}
		for(int i = 0; i<5; i++) {
	%>
	<p>화면 출력<%out.println(i); %></p>
	<%} %>
	</body>
</html>