<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
		String root = request.getContextPath();
%>
<style rel = "stylesheet" type = "text/css">
	* {
		margin: 0;
		padding: 0;
	}
	.container {
		margin: 0 auto;
		width: 800px;
	}
	.container>div{}
	#header{
		overflow: hidden;
	}
	#header>h1{
		width: 205px;
		height: 42px;
		background-image: url("<%=root%>/imgs/logo.jpg");
		text-indent: -999px;
		float: left;
	}
	#header>div{
		float: right;
	}
	#header>div>form{
		
	}
	
	#header>div>form button,
	#header>div>form a{
		border: 1px solid gray;
		border-radius: 2px;
		padding: 2px;
		background-color: gray;
		color: #333333;
		text-decoration: none;
		font-size: 12px;
		display: inline-block;
		
	}
	
	#menu{
		background-color: gray;
	}
	#menu>ul{
		margin: 0 auto;
		width: 400px;
		list-style: none;
		overflow: hidden;
	}
	#menu>ul>li{
		float: left;
		width: 100px;
		
	}
	#menu>ul>li>a{
		display: block;
		border: 1px solid darkgray;
		height: 35px;
		box-sizing: border-box;
		color: white;
		text-align: center;
	}
	
	#content>h2+form>div:last-child {
		text-align: center;
	}
	
	#content>h2+form>div>a{
		margin: 50px auto;
		display: inline-block;
		width: 100px;
		height: 50px;
		background-color: lightgreen;
		border-radius: 3px;
		text-align: center;
		line-height: 50px;
		color: white;
		font-weight: bold;
		text-decoration: none;
	}
	
	#content {}
	#content>h2 {}
	#content>h2+form {}
	#content>h2+form>div {
	   width: 440px;
	   margin: 10px auto;
	}
	#content>h2+form>div>span {
	   display: inline-block;
	   width: 100px;
	   height: 35px;
	   line-height: 35px;
	}
	
	#content>h2+form>div>span:nth-child(2n) {
		border-bottom: 1px solid gray;
	}
	
	#content>h2+form>div>span:nth-child(2n-1) {
		padding-left: 5px;
		border-right: 5px solid gray;
	  	color: #333333;
	}
	
	#content>h2+form input {
	border:0px solid white;
	width: 100px;
	font-weight: bold;
	color: black; 
	}
	
	#footer {
	}
</style>
<script type = "text/javascript" src = "<%=root %>/js/jquery-1.12.4.min.js" ></script>
<script type = "text/javascript">
	$(function() {
		$('#content')
			.find('button')
					.last().click(function() {
						history.back();
					})
	})
</script>
</head>
<body>
	
	<div class = "container">
		<div id = "header">
			<h1>비트교육센터</h1>
			<div>
				<form action = "<%=root%>/user/result.do">
					<label>id</label><input />
					<label>pw</label><input type = "password" />
					<button>login</button>
					<a href = "<%=root %>/user/join.do">join</a>
				</form>
			</div>
		</div>
		<div id = "menu">
			<ul>
				<li><a href = "<%=root%>/">HOME</a></li>
				<li><a href = "<%=root%>/intro.do">INTRO</a></li>
				<li><a href = "<%=root%>/emp/list.do">EMP</a></li>
				<li><a href = "<%=root%>/user/login.do">LOGIN</a></li>
			</ul>
		</div>
		<div id = "content">
			<%@page import = "com.bit.model.EmpDto" %>
			<%
				EmpDto bean = (EmpDto)request.getAttribute("dto");
			%>
				<h2><%=bean.getEmpno() %></h2>
				<form method="POST">
					<input type="hidden" name="empno" value="<%=bean.getEmpno() %>"/>
					<div>
						<span>ename</span>
						<span><input name = "ename" value = "<%=bean.getEname() %>" /></span>
					</div>
					<div>
						<span>hiredate</span>
						<span><%=bean.getHiredate() %></span>
					</div>
					<div>
						<span>sal</span>
						<span><input name = "sal" value = "<%=bean.getSal() %>" /></span>
						<span>comm</span>
						<span><input name = "comm" value = "<%=bean.getComm() %>" /></span>
					</div>
					<div>
						<span>job</span>
						<span><%=bean.getJob() %></span>
						<span>mgr</span>
						<span><input name = "mgr" value = "<%=bean.getMgr() %>" /></span>
					</div>
					<div>
						<button>수정</button>
						<button type = "reset">취소</button>
						<button type = "button">뒤로</button>
					</div>
				</form>
		</div>
		<div id = "footer">
			&copy; by INSEO co.ltd All rights reserved.
		</div>
	</div>
</body>
</html>