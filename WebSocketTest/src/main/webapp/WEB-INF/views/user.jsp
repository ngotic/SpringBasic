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
	#msgBox {
		border : 1px solid var(--border-color);
		width : 200px;
		height: 150px;
		display:flex;
		justify-content : center;
		align-items: center;
		padding:0;
		background-color:#FFF;
		border-radius: 5px;
		position : fixed;
		right: 20px;
		bottom: -200px;
		opacity:0;
		transition: all 1s;
	}
</style>
</head>
<body>
	<!-- user.jsp -->
	<h1>알림 서비스 <small>유저</small></h1>
	
	<div id="msgBox"></div>
	

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>
	function showMsgBox(msg){
		alert(msg);
		$('#msgBox').text(msg);
		
		$('#msgBox').css({
			bottom: '20px',
			opacity: 1
		});
		
		setTimeout(function() {
			$('#msgBox').css({
				bottom: '-200px',
				opacity: 0
			});	
		}, 5000);
	}
	
	//showMsgBox();
	
	const uri = 'ws://localhost:8091/websocket/noticeserver.do';
	
	let ws;
	// 연결을 계속 지속하므로서 데이터의 이동이 있다면 그걸 받는다.
	// 클라이언트가 기다리고만 있으면 계속 수신이다. 
	// > 한번에 연결 가능한 최대 연결수는 128개 정도??
			
	$(document).ready(function(){
		
		ws = new WebSocket(uri);
		ws.onopen = function(evt){};
		
		ws.onmessage = function(evt){
			console.log(evt.data);
			showMsgBox(evt.data);
			
		};
		ws.onclose = function(evt){};
		ws.onerror = function(evt){};
	});
	
</script>
</body>
</html>






