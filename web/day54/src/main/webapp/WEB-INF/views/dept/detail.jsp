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
	<form action = "update.do">
		<input type = "hidden" name="origin" value = "${bean.deptno }"/>
		<div>
			<label>deptno</label>
			<input name = "deptno" value = "${bean.deptno }"/>
		</div>
		<div>
			<label>dname</label>
			<input name = "dname" value="${bean.dname }"/>
		</div>
		<div>
			<label>loc</label>
			<input name = "loc" value="${bean.loc }"/>
		</div>
		<div>
			<button>수정</button>
		</div>
	</form>
</body>
</html>