<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL language</h1>
	<p><%="abcd" %></p>
	<p>${"abcd"}</p>
	<h2>자료형 표현</h2>
	<table>
		<tr>
			<td>자료형</td>
			<td>jsp</td>
			<td>el</td>
		</tr>
		<tr>
			<td>숫자(10진수 정수)</td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>연산(정수)</td>
			<td><%=1+2+3 %></td>
			<td>${1+2+3 }</td>
		</tr>
		<tr>
			<td>연산(정수)</td>
			<td><%=6+6 %></td>
			<td>${6+6} </td>
		</tr>
		<tr>
			<td>연산(정수)</td>
			<td><%=5%2 %></td>
			<td>${5%2}</td>
		</tr>
		<tr>
			<td>문자</td>
			<td><%='A'%></td>
			<td>${'A'}</td>
		</tr>
		<tr>
			<td>문자열</td>
			<td><%="ABCD"%></td>
			<!-- el에서는  문자가 존재하지 않고 문자열만 존재 -->
			<td>${'ABCD'}</td>
		</tr>
		<tr>
			<td>불리언</td>
			<td><%=true%></td>
			<td>${true}</td>
		</tr>
		<tr>
			<td>Object</td>
			<td><%=new java.util.Date() %></td>
<!-- 			el 에서는 null일 경우 view에서 나오지 않는다 -->
			<td>${null}</td>
		</tr>
		<jsp:useBean id = "bean" class = "java.util.Date"></jsp:useBean>
		<tr>
			<td>객체</td>
			<td><%=bean %></td>
			<td>${bean}</td>
		</tr>
		
	</table>
</body>
</html>