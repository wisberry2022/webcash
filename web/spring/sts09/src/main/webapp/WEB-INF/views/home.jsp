<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Home</title>
</head>
<body>
<h1>Hello world!</h1>
<ul>
	<c:forEach items="${list }" var="bean">
		<li><a href="${bean.deptno }">${bean.dname } - ${bean.loc }</a></li>
	</c:forEach>
</ul>
<a href="./add">입력</a>
</body>
</html>
