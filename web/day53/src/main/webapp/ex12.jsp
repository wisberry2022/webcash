<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id = "bean" class = "com.bit.model.DeptVo"></jsp:useBean>
	<jsp:setProperty property = "deptno" name = "bean" value = "1200000" />
<%-- 	<fmt:formatNumber value = "${bean.deptno}" var="su"></fmt:formatNumber> --%>
	<fmt:parseNumber value="${'10000'}" var="su2"></fmt:parseNumber>
	<fmt:formatNumber value="${su2+1 }" var="su" pattern="$###,###,###"></fmt:formatNumber>
	
	<p>${su }</p>
	
	<%
		pageContext.setAttribute("nalja", new java.util.Date());
	%>
<!-- 	날짜 포매팅 -->
	<fmt:formatDate value="${nalja }" var="nal" pattern="YYYY-MM-dd hh:mm:ss"/>
	<p>${nal }</p>
</body>
</html>