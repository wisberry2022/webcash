<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>INDEX</h1>
<dl>
<%@page import="com.mongodb.MongoClient"%>
<%@page import="com.mongodb.*"%>
<%@page import="com.mongodb.client.*"%>
<%@page import="org.bson.Document"%>
<%
	MongoClient client = new MongoClient("127.0.0.1");
	Document doc = new Document(); 
	MongoDatabase db = client.getDatabase("lec32");
	MongoCollection<Document> coll = db.getCollection("bbs01");
	FindIterable<Document> rs = coll.find().sort(doc.append("_id", -1)).skip(5).limit(5);
	MongoCursor<Document> ite = rs.iterator();
	while(ite.hasNext()){
		doc = ite.next(); 
%>		
		<dt>
			<a href = "detail.jsp?id=<%=doc.get("_id")%>"><%=doc.get("sub") %></a>
		</dt>
		<dd>
			<%=doc.get("content") %>
		</dd>
		
<%
	}
%>
</dl>
<p><a href = "add.jsp">[입력]</a></p>
</body>
</html>