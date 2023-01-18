<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width = "100%">
		<tr>
			<td>
				<img alt = "logo" src = "/day32/imgs/logo.png" />	
			</td>
		</tr>
		<tr>
			<td bgcolor="gray">
				<p align = "center">
					<a href = "/day32/">[HOME]</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href = "/day32/am/list.jsp">[ A M ]</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href = "/day32/pm/list.jsp">[ P M ]</a>
				</p>
			</td>
		</tr>
		<tr>
			<td>
				<!-- 내용 작성 -->
				<%@ page import="java.util.*, java.sql.*" %>
				<%
					int num = Integer.parseInt(request.getParameter("num"));
					String sub = "";
					String id= "";
					String content = "";
					java.util.Date nalja = null;
					
					String sql = "select sub,id,content,nalja from bbs01 where num="+request.getParameter("num");
					String driver = "com.mysql.jdbc.Driver";
					String url = "jdbc:mysql://localhost:3306/lecture";
					
					Connection conn = null;
					Statement stmt = null;
					ResultSet rs = null;
					
					try {
						Class.forName(driver);
						conn = DriverManager.getConnection(url, "root", "");
						stmt = conn.createStatement();
						rs = stmt.executeQuery(sql);
						
						if(rs.next()) {
							sub = rs.getString(1);
							id = rs.getString(2);
							content = rs.getString(3);
							nalja = rs.getDate(4);
						}
						
					}finally {
						if(rs != null) rs.close();
						if(stmt != null) stmt.close();
						if(conn != null) conn.close();
					}
					
				%>
				<h1><%=num %>번 게시글</h1>
				<table align="center" width="600">
					<tr>
						<td bgcolor="gray">제목</td>
						<td colspan = "3"><%=sub %></td>
					</tr>
					<tr>
						<td bgcolor="gray">글쓴이</td>
						<td><%=id %></td>
						<td bgcolor="gray">날짜</td>
						<td><%=nalja %></td>
					</tr>
					<tr>
						<td colspan = "4" bgcolor="gray">
						<pre><%=content %></pre>
						</td>
					</tr>
					<tr>
						<td colspan = "4" bgcolor="gray">
							<a href = "edit.jsp?num=<%=num %>">[수 정]</a>
							<a href = "delete.jsp?num=<%=num %>">[삭 제]</a>
						</td>
					</tr>
				</table>		
			</td>
		</tr>
		<tr bgcolor="gray">
			<td>
				<p align = "center">
					&copy; by bitacademy co.ltd. All rights reserved. http://www.bitacademy.com
				</p>
			</td>
		</tr>
	</table>
</body>
</html>