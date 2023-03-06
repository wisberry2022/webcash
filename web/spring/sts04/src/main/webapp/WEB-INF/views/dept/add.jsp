<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

</head>
<body>
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">
	        <img alt="Brand" src="${pageContext.request.contextPath}/resources/imgs/logo.jpg">
	      </a>
	    </div>
	    <p class = "">
		    <a class="navbar-text" href= "${pageContext.request.contextPath}/">home</a>
		    <a class="navbar-text" href= "${pageContext.request.contextPath}/intro">intro</a>
		    <a class="navbar-text" href= "${pageContext.request.contextPath}/dept/list">dept</a>
		    <a class="navbar-text navbar-right" href= "${pageContext.request.contextPath}/join/login">login</a>
	    </p>
	  </div>
	</nav>
	<ol class="breadcrumb">
	  <li><a href="${pageContext.request.contextPath }/">Home</a></li>
	  <li class="active">Dept</li>
	</ol>
	
	<div class="page-header">
	  <h1>Insert Page <small>Add Dept</small></h1>
	</div>
	
	<form method="post">
	  <div class="form-group">
	    <label for="dname">dname</label>
	    <input type="text" class="form-control" name="dname" id="dname">
	  </div>
	  <div class="form-group">
	    <label for="loc">loc</label>
	    <input type="text" class="form-control" name="loc" id="loc"">
	  </div>
	  <div class="btn-group-vertical btn-block" role="group">
		  <button type="submit" class="btn btn-primary">입력</button>
		  <button type="reset" class="btn btn-default">취소</button>
		  <button type="button" class="btn btn-default" onclick="history.back()">뒤로</button>
	  </div>
	</form>
</body>
</html>