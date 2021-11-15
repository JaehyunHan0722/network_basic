<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript">
  	$(document).ready(function(){
  		$("#id").on("keyup",function(){
  			/*
  			 jQuery에서 Ajax로 요청하기 - get방식
  			 [형식]
  			 url => Ajax로 요청할 요청path
  			 data => Ajax 요청을 실행하기 위해 외부에서 입력받아야 하는 값이 있는 경우 전달
  			         json형식으로 만들어서 보낸다.
  			         json형식 : {"name":"value","name":"value",.....}
  			 success => Ajax요청해서 성공적으로 데이터를 받으면 처리할 내용을 함수로 표현(익명의 함수)
  			            Ajax요청으로 받아온 데이터를 이용해서 뷰를 변경하는 코드
  			 dataType => Ajax요청 후 응답으로 전달받을 데이터의 형식(text,json....)
  			 $.get(url,data,success,dataType)
  			 
  			 jQuery에서 Ajax로 요청하기 - post방식
  			 $.get과 동일한 형식
  			 $.post(url,data,success,dataType)
  			*/
  			
  			$.get("/bigdataERP/emp/idcheck.do",
  				  {"id":$("#id").val()},
  				   function(data){ //data는 응답되어 오는 데이터를 자동으로  success란에 명시하는 함수의 매개변수로 전달
  					               //  -----------------------
  					               //       Ajax성공으로 받은 데이터
  					  //Ajax로 요청해서 응답받은 데이터를 <span>태그의 내부 텍스트로 출력
  					  $("#checkVal").text(data);
  				  },
  				  "text");
  			//자바스크립트에서 동기방식으로 요청하기 - 기존에 우리가 웹을 요청해서 응답받아 사용하는 방법
  			//location.href="/erp/emp/idcheck.do?id="+$("#id").val(); - > 원하는 작업을 표현할 수 없다.
  		});
  	});
  
  </script>
</head>
<body>
	<div class="container">
		<br><br>
		<div>
				<form role="form" class="form-horizontal"
					action="/bigdataERP/emp/insert.do" method="POST" 
					name="myform">
					<fieldset>
						<div id="legend">
							<legend>아래 양식을 작성해주세요.</legend>
						</div>
						<%-- <jsp:include page="map.jsp"></jsp:include> --%>
						<div class="form-group">
							<!-- 부서코드 -->
							<label class="control-label col-sm-2" for="orgcode">부서코드</label>
							<div class="col-sm-3">
								<input type="text" id="orgcode" name="deptno"
									placeholder="부서코드" class="form-control"
									 required>
							</div>
						</div>
	
						
						
						<div class="form-group">
							<!-- 성명-->
							<label class="control-label col-sm-2" for="orgname">성명</label>
							<div class="col-sm-3">
								<input type="text" id="orgname" name="name"
									placeholder="성명" class="form-control" minlength="2" >
	
							</div>
						</div>
						<div class="form-group">
							<!-- 사번-->
							<label class="control-label col-sm-2" for="id">사번</label>
							<div class="col-sm-3">
								<input type="text" id="id" name="id"
									placeholder="사번" class="form-control" 
									minlength="4" required >
								
							</div>
							<span id="checkVal">${result}</span>
						</div>
	
	
	
					
	
	
						
						<div class="form-group">
							<!-- 패스워드-->
							<label class="control-label col-sm-2" for="pass">패스워드</label>
							<div class="col-sm-3">
								<input type="text" id="pass" name="pass"
									placeholder="패스워드" class="form-control" minlength="4" >
	
							</div>
						</div>
						<div class="form-group">
							<!-- 주소-->
							<label class="control-label col-sm-2" for="addr">주소</label>
							<div class="col-sm-3">
								<input type="text" id="addr" name="addr" 
								placeholder="주소"
									class="form-control" minlength="4" required>
	
							</div>
						</div>
	<!-- 				<div class="form-group">
							포인트
							<label class="control-label col-sm-2" for="point">포인트</label>
							<div class="col-sm-3">
								<input type="text" id="point" name="point" 
								placeholder="포인트"
									class="form-control" minlength="4" required>
	
							</div>
						</div>
						 -->
						<div class="form-group">
							<!-- Button -->
							<div class="col-sm-3 col-sm-offset-2">
								<input type="submit" value="가입하기" class="btn btn-success"/>
							</div>
							
						</div>
					</fieldset>
				</form>
		</div>
	</div>
</body>
</html>