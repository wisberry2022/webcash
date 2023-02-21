<%@page import="java.util.StringTokenizer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String msg = "item1,item2,item3,item4";
pageContext.setAttribute("items", msg);
String[] arr1 = msg.split(",");
StringTokenizer stk = new StringTokenizer(msg,",");
while(stk.hasMoreTokens()) {
   System.out.println(stk.nextToken());
}


%>
   <h1>jstl etc</h1>
   <ul>
      <c:forTokens items="${items }" delims="," var="msg" varStatus="status">
         <li>${status.first} ${msg}</li>
      </c:forTokens>
   </ul>
</body>
</html>