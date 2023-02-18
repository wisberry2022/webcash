<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String top = request.getContextPath();
%>	
<script type = "text/javascript">
	$(function() {
		$('h1').click(function() {
			location.href = "<%=top %>";
		});
	})
	
</script>
<div id="topHeader">
  <h1 class="bg_set">롯데호텔</h1>
  <ul>
    <li><a href="#">호텔찾기</a></li>
    <li><a href="#">멤버십</a></li>
    <li><a href="#">예약조회</a></li>
    <li><a href="<%=top %>/page/login.do">로그인</a></li>
    <li><a href="<%=top %>/page/signup.do">회원가입</a></li>
  </ul>
</div>
<header>
  <nav>
    <div class="container">
      <ul>
        <li><a href="<%=top %>/page/reservation.do">객실 예약</a></li>
        <li><a href="#">다이닝 예약</a></li>
        <li><a href="#">스페셜 오퍼</a></li>
        <li><a href="#">웨딩&컨벤션</a></li>
        <li><a href="#">e-SHOP</a></li>
        <li><a href="#">드라이브 스루</a></li>
        <li><a href="#">BLOG</a></li>
      </ul>
    </div>
  </nav>
</header>