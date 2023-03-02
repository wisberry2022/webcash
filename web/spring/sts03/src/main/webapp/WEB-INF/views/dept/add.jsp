<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../template/head.jspf" %>
</head>
<body>
<%-- 	<c:if test="${errs ne null }"> --%>
<%-- 		<c:forEach items="${errs }" var = "errs"> --%>
<%-- 			<div class="alert alert-danger" role="alert">${errs.defaultMessage} --%>
<!-- 		      <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button> -->
<!-- 		   	</div> -->
<%-- 		 </c:forEach> --%>
<%-- 	 </c:if> --%>
	<%@ include file="../template/header.jspf" %>
	<%@ include file="../template/menu.jspf" %>
	
	<h2>Insert Page</h2>
	<form action="insert.do" method="post">
	  <div class="form-group">
	    <label for="deptno">deptno</label><span>${errs.deptno}</span>
	    <input type="text" class="form-control" id="deptno" placeholder="숫자를 입력하세요" name="deptno">
	  </div>
	  <div class="form-group">
	    <label for="dname">dname</label><span>${errs.dname}</span>
	    <input type="text" class="form-control" id="dname" name="dname" placeholder="부서명을 입력하세요" >
	  </div>
	  <div class="form-group">
	    <label for="loc">loc</label><span>${errs.loc}</span>
	    <input type="text" class="form-control" id="loc" placeholder="위치를 입력하세요" name="loc">
	  </div>
	  <button type="submit" class="btn btn-primary btn-block">입력</button>
	  <button type="reset" class="btn btn-default btn-block">취소</button>
	  <button type="button" class="btn btn-default btn-block" onclick="history.back();">뒤로</button>
	</form>
	<%@ include file="../template/footer.jspf" %>
</body>
</html>