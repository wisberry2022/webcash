<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' href='${pageContext.servletContext.contextPath}/webjars/bootstrap/3.1.0/css/bootstrap.min.css'>
<style type="text/css">
	#carousel-example-generic img {
		margin: 0 auto;
	}
</style>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/webjars/jquery/1.12.4/dist/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/webjars/bootstrap/3.1.0/js/bootstrap.min.js"></script>

</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
	  <div class="container-fluid">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="${pageContext.servletContext.contextPath }/">비트교육센터</a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li><a href="#">Link <span class="sr-only">(current)</span></a></li>
	        <li class="active"><a href="${pageContext.servletContext.contextPath }/intro">Intro</a></li>
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="${pageContext.servletContext.contextPath }/dept/">List</a></li>
	            <li role="separator" class="divider"></li>   
	            <li><a href="${pageContext.servletContext.contextPath }/dept/add">Insert</a></li>
	          </ul>
	        </li>
	      </ul>
	      <form class="navbar-form navbar-left">
	        <div class="form-group">
	          <input type="text" class="form-control" placeholder="Search">
	        </div>
	        <button type="submit" class="btn btn-default">Submit</button>
	      </form>
	      <ul class="nav navbar-nav navbar-right">
	        <li><a href="${pageContext.servletContext.contextPath }/login/">Login</a></li>
	        <li><a href="${pageContext.servletContext.contextPath }/join/">Join</a></li>
	      </ul>
	    </div>
	  </div>
	</nav>

	<div class="page-header">
  		<h1>List Page <small>dept list</small></h1>
	</div>

	<ol class="breadcrumb">
  		<li><a href="${pageContext.servletContext.contextPath }/">Home</a></li>
  		<li class="active">Data</li>
	</ol>
	<div class="modal show" tabindex="-1" role="dialog">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title">상세 페이지</h4>
	      </div>
	      <div class="modal-body">
	        <div class="modal-body">
		        <form method="post">
		        	<input type="hidden" name="_method" value="PUT">
		        	<div class="form-group">
		        		<input name="deptno" value="${bean.deptno }" class="form-control" readonly />
		        	</div>
		        	<div class="form-group">
		        		<input name="dname" value="${bean.dname }" class="form-control" readonly />
		        	</div>
		        	<div class="form-group">
		        		<input name="loc" value="${bean.loc }" class="form-control" readonly />
		        	</div>
		        	<button type="submit" class="btn-block btn btn-primary">수정</button>
		        </form>
			        
			        <form method="post" class="btn-block">
						<input type="hidden" name="_method" value="delete">
						<button class="btn btn-danger btn-block">삭제</button>	        
			        </form>
					<button type="button" class="btn btn-block btn-default"onclick="history.back();">뒤로</button>
	      	</div>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	<!-- Button trigger modal -->
	<script type = "text/javascript">
		$('.modal-body>form').one('submit', function(e) {
			$(this).find('input').not(':eq(0)').not(':eq(0)').removeProp('readonly');
			return false;
		})
		
	</script>

</body>
</html>