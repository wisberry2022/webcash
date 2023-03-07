<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../template/header.jspf" %>
</head>
<body>
<%@ include file="../template/menu.jspf" %>
	<ol class="breadcrumb">
	  <li><a href="${pageContext.servletContext.contextPath }/">Home</a></li>
	  <li><a href="${pageContext.servletContext.contextPath }/dept/">List</a></li>
	  <li class="active">insert</li>
	</ol>
	<div class="page-header">
		<h1>Insert page <small>insert data</small></h1>
		<form method="post" class="form-horizontal">
		  <div class="form-group">
		    <label for="dname" class="col-sm-2 control-label">dname</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="dname" id="dname" placeholder="dname" value="">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="" class="col-sm-2 control-label">loc</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="loc" id="loc" placeholder="loc" value="">
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10" role="button">
		      <button type="submit" class="btn btn-primary">입력</button>
		      <button type="reset" class="btn btn-default">취소</button>
		      <button type="button" class="btn btn-default" onclick="history.back();">뒤로</button>
		    </div>
		  </div>
		</form>
	</div>
<%@ include file="../template/footer.jspf" %>
</body>
</html>