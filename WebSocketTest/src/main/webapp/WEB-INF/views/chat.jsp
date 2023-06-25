<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<link rel="stylesheet" href="/websocket/resources/css/chat.css">
<style>

</style>
</head>
<body>
	<!-- chat.jsp -->
	<div id="main">
		<div id="header">
			<h2>WebSocket <small></small></h2>
		</div>
		<!-- 내쪽 메세지는 me라는 클래스, 상대방쪽은 other -->
		<div id="list">
			
		</div>
		<input type="text" id="msg" placeholder="대화 내용을 입력하세요.">
	</div>	

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/dayjs@1.11.8/dayjs.min.js"></script>
<script>

	// beforeunload라는 이벤트가 있는 것.!!! > 이벤트를 알자 
	$(window).on('beforeunload', function(){
		
		$(opener.document).find('.in').css('opacity', 1);
		$(opener.document).find('.in').prop('disabled', false);
		
		// 저 나가요! 라고 알려주는 것 
		let chat = {
				code     : '2',
				sender   : window.name,
				receiver : '',
				content  : '',
				regdate  : dayjs().format('YYYY-MM-DD HH:mm:ss')
		};
		
		ws.send(JSON.stringify(chat)); // 나갈 때 다른사람에게 나간다고 메세지가 전달 된다. 
		//서버에선 이 메세지를 받아서 나머지 사람들에게 알려줘야 한다. 
	});// 이게 나갈 때다. 
	
	window.onkeydown = function() {
			if(event.keyCode == 116) {
				event.preventDefault();
				return false;
			}
	};
	/*
		101#hong#lee#안녕하세요.#2023... > 프로토콜을 설계한다고 한다. 
		
		서버 <- (대화) -> 클라이언트
		
		- code : 상태코드 
			1 : 새로운 유저가 들어옴
			2 : 기존 유저가 나감
			3 : 메세지 전달
		- sender : 보내는 유저명
		- receiver : 받는 유저명 
		- content : 메세지
		- regdate : 날짜/시간
		
		json으로 오고가고 할 것이다. 
	
	*/
	
	
	
	// 채팅준비
	const url = 'ws://localhost:8091/websocket/chatserver.do';
	
	let ws; 
	
	var name; // 
	
	function connect(name) { // index.jsp에서 호출한다. 
		
		window.name = name;	
		$('#header small').text(name);
		
		// 연결하기
		ws = new WebSocket(url);
		
		ws.onopen = function(evt) {
			log('서버 연결 성공');
			
			//내가 접속했다고 다른 사람들에게 알려줄 것이다. 
			let chat = {
				code     : '1',
				sender   : window.name,
				receiver : '',
				content  : '',
				regdate  : dayjs().format('YYYY-MM-DD HH:mm:ss')
			};
			
			ws.send(JSON.stringify(chat));
			print('','입장했습니다.', 'me', 'state', chat.regdate);
			
			$('#msg').focus(); // 들어오자 마자 대화를 해야하니까
			
		};
		// 우리 쓰는 Date는 format 변환이 없다. 그래서 불편하다. 
		// JavaScript 날짜 시간
		// -> new Date() // 근데 이거 별로임... 표준화가 안됨 시간 단위가
		// JavaScript 날짜시간 라이브러리
		// -> moment.js > 무거워....
		// -> day.js > 그래서 이거써
		
		ws.onmessage = function(evt) {
			
			log('메세지 수신');                  // 서버로 부터 데이터 쉰 
			let chat = JSON.parse(evt.data);    // 사용자가 보내준 데이터
			                      // JSON.parse해야 오브젝트가 된다. 보고싶은걸 찎자. 
			log(chat.code + ':' + chat.sender);  //handleMessage에서 메세지 받고 이걸 여기서 받음 찎은거임
								  // sender가 들어온 사람이다.
			
			// 들어왔을 때 행동, 나갈 때도 한다. 
			if(chat.code == '1'){ // 들어온 사람이 차례로 뜬다.
				// 다른 사람 입장
				print('',`[\${chat.sender}]님이 입장했씁니다.`,'other','state',chat.regdate);
			} else if (chat.code == '2') {
			// 다른 사람이 퇴장
				print('',`[\${chat.sender}]님이 퇴장했씁니다.`,'other','state',chat.regdate);
			} else if(chat.code =='3' ) { // 네트워크 프로그래밍이 흐름이 잘 안그려진다. 
			// 대화 수신 
				print(chat.sender, chat.content, 'other', 'msg', chat.regdate);
			} else if (chat.code == '4'){
				printEmoticon(window.name, chat.content, 'me', 'msg', chat.regdate);
			}
			// 이 방식으로 추가적인 업무가 있으면 상태코드를 추가해서 경우의 수를 나눠서 업무를 잘 분화시켜야 한다. 
		};
		
		ws.onclose = function(evt) {
			
		};
		
		ws.onerror = function(evt) {
			
		};
		
	}
	
	function log(msg){
		console.log(`[\${new Date().toLocaleTimeString()}]` + msg);
	}
	
	// 대화내용이 길면 스크롤바가 내려로 내려오는데 자동으로 안간다. 
	// 그래서 대화내용이 길면 자동으로 내려야 한다. 
	              // 사용자이름, 왼 오 메세제, 상태, 시간 이런건 매개변수로 뺐다. 
	function print(name, msg, side, state, time) {
	            	  
		let temp = `
			<div class="item \${state} \${side}">
				<div>
					<div>\${name}</div>
					<div>\${msg}</div>
				</div>
				<div>\${time}</div>
			</div>
		`;
		
		$('#list').append(temp); 
		scrollList(); // 대화 내용이 쌓여도 스크롤바를 내려준다. 
	}
	
	
	function printEmoticon(name, msg, side, state, time) {
  	// 이미지를 보여줄것이다. 저기 아래쪽에 눈에 보이는 글자가 아니라 이미지를 집어넣을 것이다.   
		let temp = `
			<div class="item \${state} \${side}">
				<div>
					<div>\${name}</div>
					<div style="background-color:#FFF; border:0;"><img src="/websocket/resources/emoticon\${msg}.png"></div>
				</div>
				<div>\${time}</div>
			</div>
		`;
		
		$('#list').append(temp); 
		// scrollList(); // 대화 내용이 쌓여도 스크롤바를 내려준다.
		// 스크롤이 안내려지는 문제가 있다. > 속도 문제다. 
		// 속도 문제가 조금 이싿. 약간의 딜레이를 주면 된다.
		// <★> 스크롤이 먼저 밑으로 내려가고 이미지가 들어온 문제다.
		setTimeout(scrollList, 100); // ★ < 약간의 딜레이를 주는 방법 > 
	}
	
	$('#msg').keydown(function(evt){
		if(evt.keyCode== 13 ){
			let chat = {
					code     : '3',
					sender   : window.name,
					receiver : '',
					content  : $('#msg').val(),
					regdate  : dayjs().format('YYYY-MM-DD HH:mm:ss')
			};
			
			
			// 이모티콘 전송 
			if($('#msg').val().startsWith('/')){
				chat.code = '4';
				chat.content = chat.content.split(' ')[0]; // 첫번째 덩어리만 보낸다. 
			}
			// /궁금 rndrma 이렇게 다른 단어 붙여서 보내면 깨지니까 공백 기준으로 split 한다.
			// 유효성 검사를 한다. 
			
			ws.send(JSON.stringify(chat));
			
			if (chat.code == '3'){
				print(window.name, chat.content, 'me', 'msg', chat.regdate);
			} else if (chat.code == '4'){
				printEmoticon(window.name, chat.content, 'me', 'msg', chat.regdate);
			}
			$('#msg').val('').focus();//포커스 처리 필 
		}
	});
	
	function scrollList() {
		$('#list').scrollTop($('#list')[0].scrollHeight + 500); // ★★★★
		// 끝까지 내려가고도 혹시라도 여백이 남아있으면 그것마저도 아래로 내릴 수 있도록 숫자를 조금 더 준다.
		
	}
	
</script>
</body>
</html>






