<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상세보기</h1>
	<%@ page import = "java.sql.*, java.util.Map" %>
	<%
		String sql = "select empno, ename, mgr, hiredate, sal, comm,";
		sql += "(select dname from dept B where B.deptno=A.deptno)";
		sql += " from emp A where empno=" + request.getParameter("empno");
		// String sql2 = "select empno, ename, mgr, hiredate, sal, comm, dname";
		// sql2 += "from emp inner join dept using(deptno) where deptno=";
		// sql2 += request.getParameter("empno");
		System.out.println(sql);
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/lecture";
		System.out.println(sql);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "root", "");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
	%>
	<table align = "center">
      <tr>
         <td>empno</td>
         <td><%=rs.getString(1) %></td>
      </tr>
      <tr>
         <td>ename</td>
         <td><%=rs.getString(2) %></td>
      </tr>
      <tr>
         <td>mgr</td>
         <td><%=rs.getInt(3) %></td>
      </tr>
      <tr>
         <td>hiredate</td>
         <td><%=rs.getDate(4) %></td>
      </tr>
      <tr>
         <td>sal</td>
         <td><%=rs.getInt(5) %></td>
      </tr>
      <tr>
         <td>comm</td>
         <td><%=rs.getInt(6) %></td>
      </tr>
      <tr>
         <td>dname</td>
         <td><%=rs.getString(7) %></td>
      </tr>
   

		
	</table>
	<p align="center">
		<a href = "delete.jsp?empno=<%=rs.getString(1) %>">[삭제]</a>
	</p>
	<%
			}
		}finally {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}
		%>
</body>
</html>