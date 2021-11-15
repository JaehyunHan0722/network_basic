<%@page import="multi.erp.emp.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<%
			EmpVO user = (EmpVO) session.getAttribute("loginOkUser");
		%>
	</head>
	<body>
			<h1>mypage</h1>
			<h3><%= user.getName() %></h3>
			
		 	<!--   ----------  -->
		 	<!--     db에서 조회한 로그인한 사용자의 성명 -->
	</body>
</html>