<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file = "../template/header.jspf" %>
<%@ include file = "../template/menu2.jspf" %>
<% if(request.getParameter("err")!=null){ %>
<p align = "center"><font color = "red">입력확인요망</font></p>
<%} %>
<%@ include file = "../template/head.jspf" %>
<%
	String param = request.getParameter("num");
	int num = Integer.parseInt(param);
	int kor = 0;
	int eng = 0;
	int math = 0;
	String sql = "select * from stu33 where num="+num;
	
	try{
		Class.forName(driver);
		conn = DriverManager.getConnection(url, "root", "");
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		if(rs.next()) {
			if(request.getParameter("err") == null) {
				kor = rs.getInt("kor");
				eng = rs.getInt("eng");
				math = rs.getInt("math");	
			}
		}
	}finally {
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
	}
	
	
%>
	<h2>수정 페이지</h2>
	<form action = "update.jsp">
		<table width = "600" align = "center">
			<tr>
				<td>학번</td>
				<td><input type = "text" name = "num" value = "<%=num %>" readonly="readonly"></td>
			</tr>
			<tr>
				<td>국어</td>
				<td><input type = "text" name = "kor" value="<%=request.getParameter("err") == null ? kor : request.getParameter("kor") %>" /></td>
			</tr>
			<tr>
				<td>영어</td>
				<td><input type = "text" name="eng" value="<%=eng %>" /></td>
			</tr>
			<tr>
				<td>수학</td>
				<td><input type = "text" name = "math" value = "<%=math %>" /></td>
			</tr>
			<tr>
				<td colspan = "2">
					<input type = "submit" name = "수정" />
					<input type = "reset" name = "취소" />
					<input type = "button" name = "뒤로" value="뒤로가기" onclick="history.back()"/>
				</td>
				
			</tr>
		</table>
	</form>
<%@ include file = "../template/footer.jspf" %>
</body>
</html>