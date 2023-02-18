<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file = "../template/head.jspf" %>
<%@include file = "../template/header.jsp" %>
<section>
	<h1>회원가입창</h1>
	<form method = "post">
		<div>
			<label for = "id">아이디</label>
			<input type = "text" id = "id" name = "id" />
		</div>
		<div>
			<label for = "pwd">비밀번호</label>
			<input type = "password" id = "pwd" name = "pwd" />
		</div>
		<div>
			<label for = "re">비밀번호 재확인</label>
			<input type = "password" id = "re" name = "re" />
		</div>
		<div>
			<label for = "name">이름</label>
			<input type = "text" id = "name" name = "name" />
		</div>
		<div>
			<label for = "email">이메일</label>
			<input type = "text" id = "email" name = "email" />
		</div>
		<div>
			<button>회원가입하기</button>
			<button type = "button">취소</button>
		</div>
	</form>
</section>