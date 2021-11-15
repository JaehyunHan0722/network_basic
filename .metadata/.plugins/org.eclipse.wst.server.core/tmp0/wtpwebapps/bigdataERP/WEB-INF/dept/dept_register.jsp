<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<form role="form" class="form-horizontal"
			action="/serverweb/dept/insert.do" method="POST" name="myform">
			<fieldset>
				<div id="legend">
					<legend>아래 양식을 작성해주세요.</legend>
				</div>
				<div class="form-group">
					<!-- 부서코드 -->
					<label class="control-label col-sm-2" for="orgcode">부서코드</label>
					<div class="col-sm-3">
						<input type="text" id="orgcode" name="deptno" placeholder="부서코드"
							class="form-control" required>
					</div>
				</div>



				<div class="form-group">
					<!-- 성명-->
					<label class="control-label col-sm-2" for="orgname">부서명</label>
					<div class="col-sm-3">
						<input type="text" id="orgname" name="deptname" placeholder="부서명"
							class="form-control" >

					</div>
				</div>
				<div class="form-group">
					<!-- 위치-->
					<label class="control-label col-sm-2" for="id">위치</label>
					<div class="col-sm-3">
						<input type="text" id="loc" name="loc" placeholder="위치"
							class="form-control">
					</div>
				</div>







				<div class="form-group">
					<!-- 패스워드-->
					<label class="control-label col-sm-2" for="pass">관리자</label>
					<div class="col-sm-3">
						<input type="text" id="mgr" name="mgr" placeholder="관리자"
							class="form-control">

					</div>
				</div>
				
				<div class="form-group">
					<!-- Button -->
					<div class="col-sm-3 col-sm-offset-2">
						<input type="submit" value="가입하기" class="btn btn-success" />
					</div>
					
				</div>
				<div class="form-group">
					<!-- Button -->
					<div class="col-sm-3 col-sm-offset-2">
						<a href="/serverweb/dept/list.do">부서목록조회하기</a>
					</div>
					
				</div>
				
			</fieldset>
		</form>
	</div>
</body>
</html>