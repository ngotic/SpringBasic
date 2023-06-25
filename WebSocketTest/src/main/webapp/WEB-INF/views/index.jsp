<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<style>

</style>
</head>
<body>
	<!-- index.jsp -->
	<h1>WebSocket <small>Chat</small></h1>
	
	<div>
		<div class="group">

			<label>대화명</label>
			<input type="text" name="name" id="name" class="short">
		</div>
	</div>
	
	<div>
		<button type="button" class="in">들어가기</button>
		
		<button type="button" class="in" data-name="강아지">강아지</button>
		<button type="button" class="in" data-name="고양이">고양이</button>
		<button type="button" class="in" data-name="사자">사자</button>
		
	</div>
	

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>
	$('.in').click(function(){          //chat.jsp를 연다
		
		let name = $(event.target).data('name');
	
		if( name == null || name == undefined ){
			name = $('#name').val();
		}
		
		let child = window.open('/websocket/chat.do', 'chat', 'width=404height=510');
	
		$('.in').css('opacity', .5);
		$('.in').css('disabled', true);
		
		// 근데 안뜬채로 밑에서 실행된
		// ★ 이놈이 다 뜨기를 기다려야 한다. 순서상의 차이는 중요하다. 
		// ★ 자식창의 내용이 전부다 읽히고 난 다음에 함수가 호출되어야 한다. 
		child.addEventListener('load', function(){
			// child.connect($('#name').val());
			child.connect(name);
		});
		
	});
	// 한번 누르면 버튼을 못누르게 막을 것이다. 
	// 그리고 대화창이 끝나면? 
			
	
	
</script>
</body>
</html>






