<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ include file="../template/head.jspf" %>
    <%@ include file="../template/header.jsp" %>
      <script type="text/javascript">
      	var cnt;
      	
        $(function () {
        	cnt = 5;
        	$.ajax({
                url: "http://localhost:8080/Practice02/api/rooms/" + cnt,
                dataType: 'json',
                method: 'get',
                success: function(data, msg, xhr){
                	console.log(data.rooms);
                }
              });
        });
      </script>
      <section>
        <h1>호텔예약페이지</h1>
      </section>