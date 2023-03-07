<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Book Detail</h1>
	<p>${sessionScope.uid eq null ? "로그인을 해주세요" : sessionScope.uid}</p>
	<nav>
		<ul>
			<li><a href = "${pageContext.request.contextPath }/">HOME</a></li>
			<li><a href = "${pageContext.request.contextPath }/intro">INTRO</a></li>
			<li><a href = "${pageContext.request.contextPath }/book/list">LIST</a></li>
			<c:choose>
				<c:when test="${sessionScope.uid eq null}"><li><a href = "${pageContext.request.contextPath }/signin">SINGIN</a></li></c:when>
				<c:when test="${sessionScope.uid ne null}"><li><a href = "${pageContext.request.contextPath }/signout">SINGOUT</a></li></c:when>
			</c:choose>
		</ul>
	</nav>
	
	<h3>${book.getName() }'s Detail</h3>
	<div>
		<div class="row">
			<strong>도서번호</strong>
			<span>${book.getNum()}</span>
		</div>
		<div class="row">
			<strong>도서명</strong>
			<span>${book.getName()}</span>
		</div>
		<div class="row">
			<strong>저자</strong>
			<span>${book.getAuthor()}</span>
		</div>
		<div class="row">
			<strong>출판일자</strong>	
			<span>${book.getPublished()}</span>
		</div>						
	</div>
	
</body>
</html>