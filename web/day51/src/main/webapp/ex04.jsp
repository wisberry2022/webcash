<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String oldname = (String)request.getAttribute("oldname");
		String nowname = (String)request.getAttribute("nowname");
	%>
	<h1>업로드 결과</h1>
	<p><a href = "upload/<%=nowname%>">download</a></p>
</body>
</html>