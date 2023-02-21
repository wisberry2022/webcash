<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- bean이라는 객체가 여러개 있을 때(이름이 중복될 때) -->
	<%
		com.bit.model.DeptVo bean1 = new com.bit.model.DeptVo(1111, "user1", null);
		com.bit.model.DeptVo bean2 = new com.bit.model.DeptVo(2222, "user2", null);
		com.bit.model.DeptVo bean3 = new com.bit.model.DeptVo(3333, "user3", null);
		com.bit.model.DeptVo bean4 = new com.bit.model.DeptVo(4444, "user4", null);
		// default는 page scope이다.(우선순위 가장 높다)
		// 각 scope의 우선순위
		// page -> request -> session -> application
		pageContext.setAttribute("bean", bean1);
		request.setAttribute("bean", bean2);
		session.setAttribute("bean", bean3);
		application.setAttribute("bean", bean4);
	%>
<!-- 	 만약 객체 이름을 모두 동일하게 해야한다면, 스코프를 명세한다. -->
	<p>${bean }</p>
	<p>${pageScope.bean }</p>
	<p>${requestScope.bean }</p>
	<p>${sessionScope.bean }</p>
	<p>${applicationScope.bean }</p>
	
	<hr />
	<%
		request.getContextPath();
	%>
	<p>${request}</p>
<!-- 	서블릿으로부터 전달받는 값이기 때문에 기본적으로 값이 나오지 않는다 -->
	<p>${response }</p>
	<p>${pageContext.request.contextPath} </p>
</body>
</html>