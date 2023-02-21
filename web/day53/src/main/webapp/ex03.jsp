<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ page import = "java.util.*" %>
	<%
		String[] arr1 = {"item1", "item2", "item3", "item4"};
// 		pageContext.setAttribute("arr1", arr1);
		List arr2 = new ArrayList();
		arr2.add(1111);
		arr2.add(2222);
		arr2.add(3333);
		arr2.add(4444);
		pageContext.setAttribute("arr2", arr2);
		Map map = new HashMap();
		map.put("key1", "val1");
		map.put("key2", "val2");
		map.put("key3", "val3");
		map.put("key4", "val4");
		pageContext.setAttribute("map", map);
		
		com.bit.model.DeptVo bean1 = new com.bit.model.DeptVo();
		pageContext.setAttribute("bean1", bean1);
		bean1.setDeptno(1111);
		bean1.setDname("user1");
	%>
	<jsp:useBean id = "bean2" class = "com.bit.model.DeptVo" scope="page"></jsp:useBean>
<!-- 	EL 표현식의 객체 호출은 page scope에 실려있는 객체값을 꺼내오는 것 -->
<!-- EL 표현식을 활용하면 값이 있다면 객체를 얻어내고, 그렇지 않으면 view에 출력시키지 않는다. -->
<%-- 	<p>bean1: ${bean1.deptno }</p> --%>
<%-- 	<p>bean2: jsp 태그로 갖고온 bean2-${bean2 }</p> --%>
	<p>${arr1}</p>
	<ul>
		<li>${arr1[0] }</li>
		<li>${arr1[1] }</li>
		<li>${arr1[2] }</li>
		<li>${arr1[3] }</li>
	</ul>
	<p>${arr2}</p>
	<ul>
		<li>${arr2[0]}</li>
		<li>${arr2[1]}</li>
		<li>${arr2[2]}</li>
		<li>${arr2[3]}</li>
	</ul>
		<p>${map}</p>
	<ul>
		<li>${map['key1']}</li>
		<li>${map['key2']}</li>
		<li>${map['key3']}</li>
		<li>${map['key4']}</li>
	</ul>
	<ul>
		<li>${map.key1}</li>
		<li>${map.key2}</li>
		<li>${map.key3}</li>
		<li>${map.key4}</li>
	</ul>
	<p>${bean1 }</p>
	<ul>
<!-- 	getter가 없으면 값을 호출할 수 없다 -->
		<li>${bean1.getDeptno()}</li>
		<li>${bean1.getDname()}</li>
		<li></li>
	</ul>
</body>
</html>