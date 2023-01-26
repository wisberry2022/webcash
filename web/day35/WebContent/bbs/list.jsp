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
	<h1 align = "center">list page</h1>
	
	<table align = "center">
		<tr>
			<th width = "80">글번호</th>
			<th>제목</th>
			<th width = "100">글쓴이</th>
			<th width = "80">조회수</th>
		</tr>
		<%@ page import = "com.bit.LocalSql, com.bit.BbsBean, java.sql.*, java.util.*" %>
		<%
			String sql = "select * from bbs35 order by num desc";
			ArrayList<BbsBean> list = null;
			list = new ArrayList<BbsBean>();
		
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try{
				conn = LocalSql.getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					BbsBean bean = new BbsBean();
					bean.setNum(rs.getInt("num"));
					bean.setSub(rs.getString("sub"));
					bean.setId(rs.getString("id"));
					bean.setCnt(rs.getInt("cnt"));
					list.add(bean);
				}
			}finally{
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}
			
			for(int i = 0; i<list.size(); i++){
				BbsBean bbs = list.get(i);
		%>
		<tr align = "center">
			<td><a href = "detail.jsp?num=<%=bbs.getNum() %>"><%=bbs.getNum() %></a></td>
			<td><a href = "detail.jsp?num=<%=bbs.getNum() %>"><%=bbs.getSub() %></a></td>
			<td><a href = "detail.jsp?num=<%=bbs.getNum() %>"><%=bbs.getId() %></a></td>
			<td><a href = "detail.jsp?num=<%=bbs.getNum() %>"><%=bbs.getCnt() %></a></td>
		</tr>
		<%} %>
	</table>
	<p align = "center">
		<a href = "add.jsp">[입력]</a>
	</p>
	<jsp:include page = "../template/footer.jsp"></jsp:include>
</body>
</html>