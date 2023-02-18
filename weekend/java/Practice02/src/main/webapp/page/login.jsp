<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../template/head.jspf" %>
<%@ include file = "../template/header.jsp" %>
<section>
	<form method = "post">
		<div>
			<label for = "id">아이디</label>
			<input type = "text" id = "id" name = "id" />
		</div>
		<div>
			<label for = "pwd">패스워드</label>
			<input type = "password" id = "pwd" name = "pwd" />
		</div>
		<div>
			<button>로그인</button>
		</div>
	</form>
</section>