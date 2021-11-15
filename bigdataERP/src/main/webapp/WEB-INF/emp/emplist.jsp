<%@page import="multi.erp.emp.EmpVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
	<% ArrayList<EmpVO> userlist = (ArrayList<EmpVO>) request.getAttribute("userlist"); 
	   int size = userlist.size();
	%>
	<h3>사원목록보기</h3>
	<div style="padding-top: 30px">
		<div class="col-md-3" style="padding-bottom: 10px">
		    구분:
			<form>
				<select name="category"  id="category">
					<option value="all">전체게시물</option>
					<option value="경조사">경조사</option>
					<option value="사내소식">사내소식</option>
					<option value="게시판">게시판</option>
				</select>
			</form>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>사번</th>
					<th>성명</th>
					<th>부서코드</th>
					<th>주소</th>
				</tr>
			</thead>
			<tbody>
				<%for(int i=0;i<size;i++){
					EmpVO user = userlist.get(i);
				%>
					<tr>
						<td><%= user.getId() %></td>
						<td><%= user.getName() %></td>
						<td><%= user.getDeptno() %></td>
						<td><%= user.getAddr() %></td>
					</tr>
				<%} %>
			</tbody>
		</table>
	</div>
	<form action="/bigdataERP/board/search.do">
		<select name="tag">
			<option value="id">작성자</option>
			<option value="title">제목</option>
			<option value="content">본문</option>
			<option value="write_date">작성일</option>
		</select> <input type="text" name="search" /> <input type="submit" value="검색">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="/bigdataERP/board/user/insertView.do" style="text-align: right;">글쓰기</a></li>
		</ul>
	</form>

</body>
</html>
