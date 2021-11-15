<%@page import="multi.erp.board.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="/bigdataERP/common/css/main.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		//id속성이 boardCategory로 정의된 li에 익명의 함수를 적용
		$("#boardCategory>li").each(function(){
			$(this).click(function(){ //this가 선택한 <li>
				category = $(this).text();
				//alert("선택됨:"+category);
				$("#boardCategory>li").removeAttr("class");//id가 boardCategory인 컴포넌트의 하위 엘리먼트 li태그의 모든 class속성을 지운다.
				$(this).attr("class","active");//클릭하는 엘리먼트가 선택되도록
				//ajax로 BoardController의 메소드를 호출
				/*
				$.ajax
				모든 속성을 json형식으로 넘기기
				url: ajax통신하기 위해 요청하는 path
				type: 요청방식(get or post)
				data: Ajax요청할때 컨트롤러로 넘길 데이터(category)
				success:요청이 성공하고 호출되는 함수
				
				*/
				$.ajax({
					url:"/bigdataERP/board/ajax_list.do",
					type:"get",
					data:{"category":category},
					success:function(data){
						mydata = "";//데이터를 누적할 변수
						//조회한 json데이터(ArrayList<BoardVO) 갯수만큼 출력
						//Ajax는 데이터만 가져오기 때문에 뷰에 연결하는 작업을 success인 경우 실행할 함수에서 처리한다.
						//alert(data.length)
						for(i=0;i<data.length;i++){
							//mydata = mydata + data[i].title +","+data[i].write_date;
							//Ajax의 실행결과로 만들어진 뷰를 - 동적으로 만들어진 뷰
							mydata = mydata +"<tr>"+
									"<td class='boardContent' style=''><span id='test"+i+"'>"
															+data[i].title+"</span></td>"+
									"<td class='boardDate' style=''>"+data[i].write_date+ "</td>"+
									"</tr>"	
							//동적으로 만들어진 뷰에 이벤트를 연결
							//$(document).on("이벤트명","이벤트를 연결할 객체","이벤트가 발생하면 실행할 함수")
							$(document).on("click","#test"+i, function() {
								alert("이벤트연결성공");
							})
						}
						//alert(mydata);
						//데이터 전송이 성공하면 어떤 방법으로 뷰를 만들 것인지 명시
						//결과를 테이블에 추가
						$("#mydatalist").empty();
						$("#mydatalist").append(mydata);
					}
				})//end ajax
			})//end click
		})//end each
	});//end ready func
	
</script>
<title>Insert title here</title>
</head>
<body>
<% ArrayList<BoardVO> boardlist = (ArrayList<BoardVO>) request.getAttribute("boardlist"); 
	   int size = boardlist.size();
	%>
	<div class="container">
		<div class="row">
			<div class="col-sm-7">
				<div id="myCarousel" class="carousel slide" data-ride="carousel"
					style="width: 600px; height: 300px">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
						
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<img src="/bigdataERP/images/multi1.jpg" alt="Image"
								style="width: 600px; height: 300px">

						</div>
						<div class="item">
							<img src="/bigdataERP/images/multi2.jpg" alt="Image"
								style="width: 800px; height: 300px">
						</div>
						<div class="item">
							<img src="/bigdataERP/images/multi3.jpg" alt="Image"
								style="width: 600px; height: 300px">

						</div>

					
					</div>

					<!-- Left and right controls -->
					<a class="left carousel-control" href="#myCarousel" role="button"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#myCarousel" role="button"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="panel panel-primary"
					style="border-color: #edeef1; height: 300px; width: 450px">
					<div class="panel-footer">사내소식</div>
					<div class="panel-body">
						<ul class="nav nav-tabs" id="boardCategory">
							<li class="active"><a href="#">게시판</a></li>
							<li><a href="#">사내소식</a></li>
							<li><a href="#">경조사</a></li>
							
						</ul>
						<div id="boardMain" style="padding-top: 20px; padding-left: 10px">
							<table id="mydatalist">
								<%for(int i=0;i<size;i++){
									BoardVO board = boardlist.get(i);%>
								<tr>
									<td class="boardContent" style=""><%= board.getTitle() %></td>
									<td class="boardDate" style=""><%= board.getWrite_date() %></td>
								</tr>
								<%} %>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<hr />
		<div class="row main-row">
			<div class="col-sm-3">
				<div class="panel panel-primary"
					style="border-color: #edeef1; height: 300px">
					<div class="panel-footer">News</div>
					<div class="panel-body"></div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="panel panel-primary"
					style="border-color: #edeef1; height: 300px">
					<div class="panel-footer">회사소식</div>
					<div class="panel-body"></div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="panel panel-primary"
					style="border-color: #edeef1; height: 300px">
					<div class="panel-footer">회사소식</div>
					<div class="panel-body"></div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="panel panel-primary"
					style="border-color: #edeef1; height: 300px">
					<div class="panel-footer">회사소식</div>
					<div class="panel-body"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>