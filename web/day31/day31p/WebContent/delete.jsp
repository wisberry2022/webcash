<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="0; url=list.jsp">
<title>Insert title here</title>
</head>
<body>
	<% out.println(request.getParameter("num")); %>
	<%@ page import = "java.sql.*, java.util.*" %>
	<%
		String sql = "delete from bbs01 where num="+request.getParameter("num");
		String Driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/lecture";
		System.out.println(sql);
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, "root", "");
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
		}finally {
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}
	%>
</body>
</html>