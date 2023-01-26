<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id = "login" class="com.bit.UserBean" scope = "session" />
	<jsp:setProperty property = "*" name = "login" />
	<%@ page import = "java.sql.*, com.bit.LocalSql, java.util.*" %>
	<%
		// useBean life - scope
		// scope
		// 1. page - 해당 페이지
		// 2. request - 동일 request 
		// 3. session - 세션 유지 기간 동안(서버에서)
		// 4. application - 서버를 열어서 닫기 전까지
		String sql = "select count(*) as cnt from user35 where id='"+login.getId()+"' and pw=md5('"+login.getPw()+"')";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			conn = LocalSql.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) login.setResult(rs.getInt("cnt")>0);
				
			
		}finally{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn!= null) conn.close();
		}
		
		response.sendRedirect("../");
	%>
	<h1>로그인 성공? <%=login.isResult() %></h1>
</body>
</html>