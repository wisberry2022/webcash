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
	</div>
	<form action="edit" method="get" class="form-horizontal">
	  <div class="form-group">
	    <label for="deptno" class="col-sm-2 control-label">deptno</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" name="deptno" id="deptno" readonly value="${bean.deptno }">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="dname" class="col-sm-2 control-label">dname</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" name="dname" id="dname" readonly value="${bean.dname }">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="loc" class="col-sm-2 control-label">loc</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" name="loc" id="loc" placeholder="loc" readonly value="${bean.loc }">
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10" role="button">
	      <button type="submit" class="btn btn-primary">수정</button>
	      <button type="reset" class="btn btn-default"  data-toggle="modal" data-target="#myModal">삭제</button>
	      <button type="button" class="btn btn-default" onclick="history.back();">뒤로</button>
	    </div>
	  </div>
	</form>
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">${bean.deptno }를 삭제하시겠습니까?</h4>
	      </div>
	      
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
	        <form method="post">
	        	<input type="hidden" name="deptno" value="${bean.deptno }">
	        	<button type="submit" class="btn btn-primary">삭제</button>
	        </form>
	        
	      </div>
	    </div>
	  </div>
<%@ include file="../template/footer.jspf" %>
</body>
</html>