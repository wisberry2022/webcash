<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<title>Insert title here</title>
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
	  <h1>Detail Page <small>Edit Dept</small></h1>
	</div>
	
	<form action="update" method="post">
	  <div class="form-group">
	    <label for="deptno">deptno</label>
	    <input type="text" class="form-control" value="${bean.deptno }" name="deptno" id="deptno">
	  </div>
	  <div class="form-group">
	    <label for="dname">dname</label>
	    <input type="text" class="form-control" value="${bean.dname }" name="dname" id="dname">
	  </div>
	  <div class="form-group">
	    <label for="loc">loc</label>
	    <input type="text" class="form-control" value="${bean.loc }" name="loc" id="loc"">
	  </div>
	  <div class="btn-group-vertical btn-block" role="group">
		  <button type="submit" class="btn btn-primary">수정</button>
		  <button type="button" class = "btn btn-danger" role="button"  data-toggle="modal" data-target="#myModal">삭제</a>
		  <button type="reset" class="btn btn-default">취소</button>
		  <button type="button" class="btn btn-default" onclick="history.back()">뒤로</button>
	  </div>
	</form>
	
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">삭제 확인</h4>
	      </div>
	      <div class="modal-body">
	        	삭제하시겠습니까?
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        <form action = "delete" method="post">
				<input type="hidden" name="deptno" value="${bean.deptno }">
				<button type="submit" class="btn btn-danger">삭제</button>
		  </form>
	      </div>
	    </div>
	  </div>
	</div>
</body>
</html>