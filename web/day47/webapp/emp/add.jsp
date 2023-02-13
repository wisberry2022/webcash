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
	
	#content {}
	#content>form{
		display: block;
		margin: 10px auto;
		width: 500px;
	}
	#content>form>div{
		margin: 0 auto;
		width: 600px;
	}
	#content>form>div>label{
		display: inline-block;
		width: 200px;
	}
	#content>form>div>input{
		box-sizing: border-box;
		width: 300px;
	}
	#content>form>div:last-child{
		text-align: center;
	}
	#footer {
	}
</style>
<script type = "text/javascript" src = "<%=root %>/js/jquery-1.12.4.min.js" ></script>
<script type = "text/javascript">
	$(function() {
		$('#content')
			.find('input').eq(0).focus()
			.end()
			.end()
			.find('button').last().click(function() {
				history.back();
			});
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
			<div class = "box">
				<h2>INSERT EMP</h2>
				<form method = "POST">
					<div>
						<label for = "empno">empno</label>
						<input id = "empno" name = "empno" />
					</div>
					<div>
						<label for = "ename">ename</label>
						<input id = "ename" name = "ename" />
					</div>
					<div>
						<label for = "sal">sal</label>
						<input id = "sal" name = "sal" />
					</div>
					<div>
						<button>입력</button>
						<button type = "reset">취소</button>
						<button type = "button">뒤로</button>
					</div>
				</form>
				
			</div>
		</div>
		<div id = "footer">
			&copy; by INSEO co.ltd All rights reserved.
		</div>
	</div>
</body>
</html>