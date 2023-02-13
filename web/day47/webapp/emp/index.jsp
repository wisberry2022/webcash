<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "com.bit.model.EmpDto, com.bit.model.EmpDao, java.util.*" %>
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
	
	#content table{
		border-collapse: collapse;
		margin: 10px auto;
		width: 80%;
	}
	
	#content table,
	#content table th,
	#content table td {
	border: 1px solid gray;
	
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
	
	#content .box{
		margin: 10px auto;
		width: 80%;
		background-color: darkgreen;
		border-radius: 10px;
		padding: 50px; 
	}
	
	#content .box>h1{
		color: white;
	}
	
	#content .box>p {
		text-align: right;
		margin-left: auto;
		width: 100px;
		background-color: green;		
	}
	
	#content>p {
		text-align: center;
	}
	
	#content>p>a{
		margin: 50px auto;
		display: inline-block;
		width: 200px;
		height: 50px;
		background-color: lightgreen;
		border-radius: 3px;
		text-align: center;
		line-height: 50px;
		color: white;
		font-weight: bold;
		text-decoration: none;
	}
	
	
	
	#footer {
	}
</style>
<script type = "text/javascript" src = "<%=root %>/js/jquery-1.12.4.min.js" ></script>
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
				<li><a href = "<%=root%>/intro.jsp">INTRO</a></li>
				<li><a href = "<%=root%>/emp/list.do">EMP</a></li>
				<li><a href = "<%=root%>/user/login.do">LOGIN</a></li>
			</ul>
		</div>
		<div id = "content">
			<h2>EMP LIST</h2>
			<table>
				<thead>
					<tr>
						<th>empno</th>
						<th>ename</th>
						<th>hiredate</th>
						<th>sal</th>
					</tr>
				</thead>
				<tbody>
					<%
						List<EmpDto> list = null;
						EmpDao dao = new EmpDao();
						list = (List<EmpDto>)request.getAttribute("empList");
						for(EmpDto bean:list) {
					%>
					<tr>
						<td><a href = "detail.do?empno=<%=bean.getEmpno() %>"><%=bean.getEmpno() %></a></td>
						<td><a href = "detail.do?empno=<%=bean.getEmpno() %>"><%=bean.getEname() %></a></td>
						<td><a href = "detail.do?empno=<%=bean.getEmpno() %>"><%=bean.getHiredate() %></a></td>
						<td><a href = "detail.do?empno=<%=bean.getEmpno() %>"><%=bean.getSal() %></a></td>	
					</tr>
					<%} %>
				</tbody>
			</table>
			<p>
				<a href = "add.do">입력</a>
			</p>
		</div>
		<div id = "footer">
			&copy; by INSEO co.ltd All rights reserved.
		</div>
	</div>
</body>
</html>