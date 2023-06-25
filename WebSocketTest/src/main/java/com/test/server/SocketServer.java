package com.test.server;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;


//프로그램  <- (통신) -> 프로그램
//카톡     <-         -> 카톡서버 
//브라우저 <-          -> 톰켓 

// 상대편의 고유한 주소 인식!! > IP 주소(NIC) + 포트번호 > Endpoint (종단점) 상대방 구분하는 식별자이다. 콕 찝어낸다. 


// 클라이언트(WebSocket) 연결을 받아주는 역할 > 웹소켓 서버

// 192.168.30.31:8091/server.do   > 요러먼 전세계 어디서도 찾아가는데 이렇게 하는게 종단점 만드는 것이다. 
@ServerEndpoint("/server.do")
public class SocketServer {
	
	//클라이언트가 연결 요청을 하기를 기다림 > 자동 수락 
	@OnOpen 
	public void handleOpen() {
		System.out.println("클라이언트가 접속했습니다.");
	}
	
	// 클라이언트가 연결을 종료하면 발생
	@OnClose
	public void handleClose() {
		System.out.println("클라이언트와 연결이 종료되었습니다.");
	}
	
	// 클라이언트가 서버에게 메세지를 전손했을 때 발생
	@OnMessage
	public String handleMessage(String msg) { // 클라이언트가 보낸 메세지
		System.out.println("클라이언트 메세지 : "+msg);
		//return msg; // 클라이언트에게 보내는 메세지
		return "(응답)"+msg; // 가공
	}
	
	@OnError
	public void handlerError(Throwable e) {
		System.out.println("에러 발생 : "+e.getMessage());
	}
}
