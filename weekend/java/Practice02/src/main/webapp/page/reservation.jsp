<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ include file="../template/head.jspf" %>
    <%@ include file="../template/header.jsp" %>
      <script type="text/javascript">
      	var roomInfo;
      	var btn5, btn10;
      	var clearCallback = function() {
      		var childrens = roomInfo.children();
      		
      		if(childrens.length) {
      			childrens.remove();
      		}
      	}
      	
      	var roomsCallback = function(cnt, type) {
      		if(type === 'rooms') {
        		$.ajax({
                    url: "http://localhost:8080/Practice02/api/rooms/" + (cnt ? cnt : 5),
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
      		}else if(type === 'floor') {
      			$.ajax({
      				url:"http://localhost:8080/Practice02/api/floors/" + (cnt ? cnt : 1),
      				dataType: 'json',
      				method: 'get',
      				success: function(data, msg, xhr) {
      					console.log(data.rooms);
      				}
      			})
      		}
    	};
      	
      	
        $(function () {
        	roomInfo = $('#roomInfo');
  
        	roomsCallback(5, 'rooms');
        	roomsCallback(2, 'floor');
        	
        	$.ajax({
        		url: "http://localhost:8080/Practice02/api/infos",
        		dataType: 'json',
        		method: 'get',
        		success: function(data, msg, xhr) {
        			console.log(data.infos);
        		}
        	})
        	
        	btn5 = $('.btnBox').children().eq(0);
        	btn10 = $('.btnBox').children().eq(1);
        	
        	btn5.click(function(e) {
        		clearCallback();
        		roomsCallback(5, 'rooms');
        	})
        	
        	btn10.click(function(e) {
        		clearCallback();
        		roomsCallback(10,'rooms');
        	})
        	
        });
      </script>
      <section>
        
        <div class = "container">
        	<h1>호텔예약페이지</h1>
        	<div id = "roomInfo">
        	</div>
        	<div class = "btnBox">
        		<button type = "button">5개씩 보기</button>
        		<button type = "button">10개씩 보기</button>
        	</div>
        	<div class = "floor">
        	</div>
        </div>
      </section>