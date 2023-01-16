<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		java.util.Enumeration en = request.getParameterNames();
		while(en.hasMoreElements()) {
			System.out.println(en.nextElement());
		}
		java.util.Map<String, String[]> pMap = request.getParameterMap();
		java.util.Set<java.util.Map.Entry<String, String[]>> set = pMap.entrySet();
		java.util.Iterator<java.util.Map.Entry<String, String[]>> ite = set.iterator();
		while(ite.hasNext()){
			java.util.Map.Entry<String, String[]> entry = ite.next();
			System.out.println(entry.getKey() + ":" + java.util.Arrays.toString(entry.getValue()));
		}
	
	%>
	<h1>사용자 요청 파라미터</h1>
	<p>id: <%=request.getParameter("id") %> </p>
	<p>pw: <%=request.getParameter("pw") %> </p>
	<p>ta: <%=request.getParameter("ta") %> </p>
	<p>ra: <%=request.getParameter("ra") %> </p>
	<p>ch: <%
		// 같은 이름의 여러 개의 쿼리가 있을 경우 배열로 받을 수 있는 메소드 - getParameterValues
		String[] vals = request.getParameterValues("ch");
		out.print(java.util.Arrays.toString(vals));
		
	%> </p>
	<p>sel: <%=request.getParameter("sel") %>
	<p><%
		java.util.Enumeration<String> info=request.getHeaderNames();
		while(en.hasMoreElements()) {
			System.out.print(en.nextElement());
		}
		
		%></p>
	
	
	
</body>
</html>