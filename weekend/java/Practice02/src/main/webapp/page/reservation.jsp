<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ include file="../template/head.jspf" %>
    <%@ include file="../template/header.jsp" %>
      <script type="text/javascript">
      	var cnt;
      	var roomInfo;
      	
        $(function () {
        	cnt = 5;
        	roomInfo = $('#roomInfo');
        	$.ajax({
                url: "http://localhost:8080/Practice02/api/rooms/" + cnt,
                dataType: 'json',
                method: 'get',
                success: function(data, msg, xhr){
                	data.rooms.forEach(function(ele, idx) {
                		var row = $('<div/>');
                		row.append($('<span/>').text(ele.num));
                		row.append($('<span/>').text(ele.type));
                		row.append($('<span/>').text(ele.name));
                		row.append($('<span/>').text(ele.maxnum));
                		row.append($('<span/>').text(ele.price));
                		roomInfo.append(row);
                	})	
                }
              });
        	
        	$.ajax({
        		url: "http://localhost:8080/Practice02/api/infos",
        		dataType: 'json',
        		method: 'get',
        		success: function(data, msg, xhr) {
        			console.log(data.infos);
        		}
        	})
        });
      </script>
      <section>
        
        <div class = "container">
        	<h1>호텔예약페이지</h1>
        	<div id = "roomInfo">
        	</div>
        </div>
      </section>