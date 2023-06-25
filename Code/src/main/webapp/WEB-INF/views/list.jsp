<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Code</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<style>
	.main {
		display : grid;
		grid-template-columns: 1fr 1fr 1fr;	
	}
	
	.item {
		width: 235px;
		border : 1px solid #AAA;
		margin : 10px;
		cursor: pointer;
	}
	
	.item > div:nth-child(1) {
		padding: .5rem;
		padding-left: 1rem;
	}
	
	.item > div:nth-child(2) {
		min-height: 150px;
		display : flex;
		justify-content : center;
		align-items : center;
		border-top : 1px solid #AAA;
		border-bottm : 1px solid #AAA;
	}
	
	.item > div:nth-child(3) {
		padding: .5rem;
		font-size : 14px;
		text-align : right;
	}
	
	.filter{
		text-align : right;
		padding-right:1rem;
	}
	.filter input {
		background-color: #fff;
	}
	
	html {
		overflow-y : scroll;
	}
	
	
</style>
</head>
<body>
	<!-- list.jsp -->
	<h1>Code <small>목록보기</small></h1>
	
	<div class="filter">
		<input type="button" value="Java" data-language="java" data-selected="0" data-color="tomato">
		<input type="button" value="SQL"  data-language="sql" data-selected="0" data-color="gold">
		<input type="button" value="HTML" data-language="html" data-selected="0" data-color="cornflowerblue">
	</div>
	
	<div class="main">
		<c:forEach items="${list}" var="dto">
			<div class="item" onclick="location.href='/view.do?seq=${dto.seq}';">
				<c:choose>
					<c:when test="${dto.language == 'java'}">
						<c:set var="color" value="tomato" />
					</c:when>
					<c:when test="${dto.language == 'sql'}">
						<c:set var="color" value="gold" />
					</c:when>
					<c:when test="${dto.language == 'html'}">
						<c:set var="color" value="blue" />
					</c:when>
				</c:choose>
				<div style="background-color:${color}">${dto.language}</div>
				<div>${dto.subject}</div>
				<div>${dto.regdate}</div>
			</div>
		</c:forEach>
	</div>
	
	<div>
		<button type="button" class="add" onclick="location.href='/add.do';">
			추가하기
		</button>
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>
// list.do?language=java&language=sql&language=java&
		
	let param = '';
	$(".filter > input").click(function(){
		
		if( $(this).attr('data-selected')=='0' ) {
			//$(this).data("selected", "1");
			$(this).attr('data-selected', "1");
			$(this).css("background-color", $(this).data("color"));
		} else {
			//$(this).data('selected', 0);
			$(this).attr('data-selected', "0");
			$(this).css("background-color", $(this).data("#FFF"));
		}
		
		// console.clear();
		$('.filter > input').each((index, item) => {
		
				if($(item).data('selected') == "1"){
					console.log($(item).data('language'));
					param += 'language='+$(item).data('language') + '&';
				}
		});
		
		location.href ='list.do?' + param;
		
	});
	
	
	<c:forEach items="${language}" var="lang">
		$('.filter input[data-language=${lang}]').attr('data-selected', '1');
		$('.filter input[data-language=${lang}]').css('background-color', 
		$('.filter input[data-language=${lang}]').data('color'));
	</c:forEach>
	
	
</script>
</body>
</html>






