<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
 <title>인사관리시스템</title>
  <meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		//json 데이터를 자바스크립트로 제어하기
		var person = {
				"name":"김서연",
				"age":"25",
				"like":["자바","서블릿","하둡"],
				"addr":{
					"zipcode":"11-22",
					"addr1":"인천시",
					"addr2":"남구"
				},
				"history":[
				    {
				    	"subject":"java",
				    	"month":"11"
				    },
				    {
				    	"subject":"servlet",
				    	"month":"1"
				    },
				    {
				    	"subject":"spring",
				    	"month":"1"
				    },
				    {
				    	"subject":"hadoop",
				    	"month":"2"
				    }
				]				
		}
	
		document.write("<h3>name:"+person.name+"</h3>");
		document.write("<h3>age:"+person.age+"</h3>");
		document.write("<h3>like:"+person.like[0]+"</h3>");
		document.write("<h3>like:"+person.like[1]+"</h3>");
		document.write("<h3>addr:"+person.addr.zipcode+"</h3>");
		document.write("<h3>addr:"+person.addr.addr1+"</h3>");
		document.write("<h3>history:"+person.history[2].subject+"</h3>");
		document.write("<h3>history:"+person.history[3].subject+"</h3>");
	</script>
</body>
</html>











