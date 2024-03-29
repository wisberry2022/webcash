<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page = "../template/header.jsp"></jsp:include>
<jsp:include page = "../template/menu.jsp">
	<jsp:param value = ".." name = "path" />
</jsp:include>
<jsp:useBean id = "bean" class = "com.bit.BbsBean"></jsp:useBean>
<jsp:setProperty property="num" name="bean" />
<h1><%=bean.getNum() %>번 글</h1>
<%@ page import = "com.bit.LocalSql, java.util.*, java.sql.*" %>
<%
	String sql = "select * from bbs35 where num="+bean.getNum();
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try {
		conn = LocalSql.getConnection();
		stmt = conn.createStatement();
		
		
		rs = stmt.executeQuery(sql);
		if(rs.next()) {
			bean.setSub(rs.getString("sub"));
			bean.setId(rs.getString("id"));
			bean.setCnt(rs.getInt("cnt"));
			bean.setContent(rs.getString("content"));
		}
	}finally {
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
	}
%>
<form action = "update.jsp" method = "post">
	<input type = "hidden" name = "num" value="<%=bean.getNum() %>" />
	<table width = "500" align="center">
		<tr>
			<td width = "100">제목</td>
			<td colspan = "3"><input type = "text" name = "sub" value = "<%=bean.getSub() %>" /></td>
		</tr>
		<tr>
			<td width = "100">글쓴이</td>
			<td><jsp:getProperty property = "id" name = "bean" /></td>
			<td width = "100">조회수</td>
			<td><jsp:getProperty property = "cnt" name = "bean" /></td>
		</tr>
		<tr>
			<td colspan = "4">
			<textarea name = "content" cols = "20" rows = "5">
				<jsp:getProperty property = "content" name = "bean" />
			</textarea>
			</td>
		</tr>
		<tr>
			<td colspan = "4" align = "center">
				<input type = "submit" value = "수정" />
				<input type = "reset" value = "취소" />
				<input type = "button" value = "뒤로" onclick="history.back()" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>