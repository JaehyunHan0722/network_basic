<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
 <title>인사관리시스템</title>
  <meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>부서정보 출력하기</h1>
	<hr/>
	<div id="dept_eval"></div>
	<div id="dept_parser"></div>
	<script type="text/javascript">
		var deptlist = '{"dept":'+
			'[{"code":"001","name":"정보시스템팀","loc":"4층",'+
			 '"tel":"02-770-1111"},'+
			 '{"code":"002","name":"시스템지원팀","loc":"5층",'+
			 '"tel":"02-770-2222"},'+
			 '{"code":"003","name":"기업영업팀","loc":"6층",'+
			 '"tel":"02-770-3333"},'+
			 '{"code":"004","name":"전산실","loc":"7층",'+
			 '"tel":"02-770-4444"}]}';
		//파싱되지 않은 json 문자열은 그대로 사용할 수 없다.
		//document.write("<h3>name:"+deptlist.dept[1].name+"</h3>");
		
		//JSON파서의 parse()메소드를 이용해서 파싱 후에 작업 - 내장
		var obj = JSON.parse(deptlist);
		mydata = obj.dept[1].code+","+obj.dept[1].name;
		document.getElementById("dept_parser").innerHTML = mydata;
	</script>
</body>
</html>