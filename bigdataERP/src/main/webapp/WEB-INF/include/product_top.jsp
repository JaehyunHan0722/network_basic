<%@page import="multi.erp.emp.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		EmpVO user = (EmpVO) session.getAttribute("loginOkUser");
	%>
<div>
  <div class="container text-center">
    <h1>Java World Store</h1>      
    <p>Mission, Vission & Values</p>
  </div>
</div>

<div style="height:90px" style="padding:10px">
		<div id="toparea"  class="navbar navbar-inverse">
			<a href="/bigdataERP/index.do" style="position:absolute;top:30px;font-size: 18pt; font-weight: bolder;text-decoration: none;padding-left: 10px">KimSaemERP</a>
			<ul class="nav navbar-nav navbar-right" 
			 style="position:relative ;top:20px" >
				<%if(user==null){ %>
					<li style="margin-right: 20px;height: 70px">
					<a href="/bigdataERP/emp/loginPage.do"><span class="glyphicon glyphicon-log-in">
							</span>Login</a></li>
						
						<li><a href="/bigdataERP/emp/insertPage.do"><span class="glyphicon glyphicon-log-out"></span>
								회원가입</a></li>
					</ul>
				<%}else{ %>
						<li><a href="/bigdataERP/emp/logout.do"><span class="glyphicon glyphicon-log-out"></span>
								Logout</a></li>
						<li><a href="/bigdataERP/product/index.do"><span class="glyphicon glyphicon-log-out"></span>
								사내상품몰</a></li>
								
					</ul>
					
					<span  class="navbar-form pull-right" >	
						<img  class="img-circle" style="width: 60px;height: 70px"
									src="/bigdataERP/images/kimdong.jpg"  />
					</span>  
				<%} %>
			<form class="navbar-form pull-right" style="position:relative ;top:20px">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				
			</form>
		</div>
	</div>
	<nav>
	<div class="container-fluid">
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					 <li class="active"><a href="/bigdataERP/product/list.do">Home</a></li>
			        <li><a href="/bigdataERP/product/list.do?category=CAT000000001">DRESS</a></li>
			        <li><a href="/bigdataERP/product/list.do?category=CAT000000004">OUTER</a></li>
			        <li><a href="/bigdataERP/product/list.do?category=CAT000000002">TOP</a></li>
			        <li><a href="/bigdataERP/product/list.do?category=CAT000000003">BOTTOM</a></li>
			        <li><a href="/bigdataERP/product/list.do?category=CAT000000005">ACC</a></li>
				</ul>

			</div>
		</div>
	</nav>

</body>
</html>