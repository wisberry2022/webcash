<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page = "template/header.jsp"></jsp:include>
<jsp:include page = "template/menu.jsp">
	<jsp:param value = "." name = "path" />
</jsp:include>
	<img width="80%" src = "/day35/imgs/seoulmap.png" />
<jsp:include page="template/footer.jsp"></jsp:include>
	
</body>
</html>