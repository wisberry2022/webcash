<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file = "../template/menu.jspf" %>
	<h1>add.jsp</h1>
	<form action = "insert.do">
		<div>
			<label>deptno</label>
			<input name = "deptno" />
		</div>
		<div>
			<label>dname</label>
			<input name = "dname" />
		</div>
		<div>
			<label>loc</label>
			<input name = "loc" />
		</div>
		<div>
			<button>제출</button>
		</div>
		
	</form>
</body>
</html>