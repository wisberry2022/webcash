<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Date" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>디렉티브 <% out.println(new Date()); %></h1>
	<%
		int su1 = 3;
	%>
	<ul>
		<li>page</li>
		<li>taglib</li>
		<li>include</li>
	</ul>
	<%
		// 자바코드
		// out.println(su1);
	%>
	
	<p>표현식 su1= <% out.print(su1); %> </p>
	<p>표현식 su1= <%=su1 %> </p>
	<p>선언부</p>
	<%!
		public void fun() {
			System.out.println("HELLO WORLD!");
		}
	%>
	<% fun(); %>
</body>
</html>