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
					<h1>페이징된 게시판</h1>
					<table border="1" cellspacing="0" align="center" width="600">
						<tr>
							<th width="100">글번호</th>
							<th>제목</th>
							<th width="100">글쓴이</th>
							<th width="100">날짜</th>
						</tr>
						<%@ page import = "java.sql.*, java.util.Map" %>
						<%
							String msgL = request.getParameter("limit");
							int limit = 10;
							if(msgL != null) limit = Integer.parseInt(msgL);
							String key = request.getParameter("key");
							if(key == null) key = "sub";
							String word = request.getParameter("word");
							if(word == null) word = "";
							String msgP = request.getParameter("page");
							int p = 1;
							if(msgP != null) p=Integer.parseInt(msgP);
							//String sql = "select num, sub, id, nalja from bbs01 where num>=(select min(num)-10 from bbs01)-10*"+p+"and num <=(select max(num) from bbs01)-10*"+p+" order by num desc";
							// String sql="select num,sub,id,nalja from bbs01 where num>(select max(num)-10 from bbs01)-10*"+p+" and num<=(select max(num) from bbs01)-10*"+p+" order by num desc";
							// String sql="select num,sub,id,nalja from (select num,sub,id,nalja,@rownum:=@rownum+1 as rn from bbs01, (select @rownum:=0 as rn from dual)R order by num desc)R2 where rn>=1+10*"+p+"and rn<=10+10*"+p+";";
							// String sql="select num,sub,id,nalja from (select num,sub,id,nalja,@rownum:=@rownum+1 as rn from bbs01 , (select @rownum:=0 as rn from dual)R order by num desc)R2 where rn>=1+10*"+(p-1)+" and rn<=10+10*"+(p-1);
							String sql="select num,sub,id,nalja from bbs01 where "+key+" like '%"+word+"%' order by num desc limit " +limit +" offset "+(limit*(p-1));
							String tsql = "select CEILING(count(*)/"+limit+") from bbs01 where "+key+" like '%" + word + "%'";
							String driver = "com.mysql.jdbc.Driver";
							String url = "jdbc:mysql://localhost:3306/lecture";
							System.out.println(tsql);
							int total=0;
							Connection conn = null;
							Statement stmt = null;
							Statement stmt2 = null;
							ResultSet rs = null;
							ResultSet rs2 = null;
							
							try {
								Class.forName(driver);
								conn = DriverManager.getConnection(url, "root", "");
								stmt = conn.createStatement();
								stmt2 = conn.createStatement();
								rs = stmt.executeQuery(sql);
								rs2 = stmt2.executeQuery(tsql);
								if(rs2.next()) total = rs2.getInt(1);
								while(rs.next()) {
						%>
						<tr>
							<td><%=rs.getInt(1) %></td>
							<td><%=rs.getString(2) %></td>
							<td><%=rs.getString(3) %></td>
							<td><%=rs.getDate(4) %></td>
						</tr>
						<%
							}
								}finally {
							if(rs2!=null) rs.close();
							if(rs!=null) rs.close();
							if(stmt2 != null) stmt.close();
							if(stmt != null) stmt.close();
							if(conn != null) conn.close();
							
						}
							%>
							<tr align="center">
								<td colspan = "4">
								<form>
								<select name = "key">
									<option value = "sub">제목</option>
									<option value = "id">글쓴이</option>
									<option value = "content">내용</option>
								</select>
									<input type = "text" name="word">
									<input type = "submit" value = "검색">
								</form>
								<%
								int start = 0+5*((p-1)/5);
								int end = start+5;
								if(end>total) end=total;
								if(start != 0){
								%>
								<a href = "list.jsp?limit=<%=limit %>page=<%=start-1 %>&key=<%=key %>&word=<%=word %>">[prev]</a>
								<%}
								for(int i = start; i<end; i++){ 
								%>	
									<a href = "list.jsp?limit=<%=limit %>&page=<%=i+1 %>&key=<%=key %>&word=<%=word %>">[<%=i+1 %>]</a>
								<%
								} 
								if(end<total){
								%>
								<a href = "list.jsp?limit=<%=limit %>&page=<%=end+1 %>&key=<%=key %>&word=<%=word %>">[next]</a>
								<%} %>
								</td>
								
							</tr>
							<tr>
							<td colspan="4" align="right">
								<a href = "list.jsp?limit=5&page=<%=p %>&key=<%=key %>&word=<%=word %>">[5개씩 보기]</a>
								<a href = "list.jsp?limit=10&page=<%=p %>&key=<%=key %>&word=<%=word %>">[10개씩 보기]</a>
							</td>
						</tr>
					</table>
				<!-- 내용 끝-->
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