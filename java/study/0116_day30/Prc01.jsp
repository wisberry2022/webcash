<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="3" cellpadding="5" >
		<tr>
		<% for(int i = 2; i<=9; i++) {%>
			<td align="center"><%=i %> 단</td>
		<%} %>
		</tr>
		<% for(int i = 1; i<=9; i++) { %>
			<tr>		
			<% for(int j = 2; j<=9; j++) { %>
				<td> <%=j%> * <%=i %> = <%=i*j %> </td>		
			<% } %>
			</tr>	
		<%} %> 
	</table>
	<table border="3" cellpadding="5">
		<% for(int i=1; i<11; i++) { %>
			<tr>
				<% for(int j=1; j<=8; j++) { %>
					<% if(i == 1) { %>
						<td><%=j+1 %>단</td>
					<% } %>
					<% if(i != 1) { %>
						<td><%=j+1 %> * <%=i-1 %> = <% out.print((j+1)*(i-1)); %></td>
					<% } %>
				<% } %>
			</tr>
		<%} %>
	</table>
</body>
</html>