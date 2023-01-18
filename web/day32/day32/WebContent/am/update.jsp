<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@page import = "java.sql.*, java.util.Map" %>
	<%
		int num = Integer.parseInt(request.getParameter("num"));
		String sub = request.getParameter("sub");
		String content = request.getParameter("content");
		String sql = "update bbs01 set sub = '" + sub+ "', content='" + content;
		sql += "' where num="+num;
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/lecture";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "root", "");
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
			response.sendRedirect("detail.jsp?num="+num);
			
			
		}finally {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}
	%>
</body>
</html>