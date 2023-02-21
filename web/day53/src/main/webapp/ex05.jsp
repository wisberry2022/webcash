<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>jstl</h1>
<!-- 	화면 출력 -->
	<p><c:out value = "1234"></c:out></p>
	<p><c:out value = "${1234 }"></c:out></p>
<!-- 	변수 선언 및 출력  -->
	<c:set var = "msg1" value="abcd"></c:set>
	<c:out value = "${msg1 }"></c:out>
	<p><c:set var="msg2">abcdefgh</c:set></p>
	<p><c:out value = "${msg2 }"></c:out></p>
	<hr />
	<%
		pageContext.setAttribute("temp", null);
	%>
<%-- 	<c:set var = "temp"></c:set> --%>
	<c:set var = "msg3" value = "${temp}"></c:set>
<!-- 	msg3가 null이면 태그 안의 값이, null이 아닐 경우 실제 변수(msg3)의 할당된 값이 나온다 -->
	<p><c:out value = "${msg3 }">나도값</c:out></p>
	<p>${msg3 eq null ? '나도' : msg3} </p>
	
	
<!-- 	자료형과 변수는 EL이, 변수 선언, 제어는 JSTL이 담당한다 -->
</body>
</html>