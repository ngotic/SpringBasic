package com.test.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/noticeserver.do")
public class NoticeServer {
	
	private static List<Session> sessionList;
	
	static {
		sessionList = new ArrayList<Session>();
	}
	
	@OnOpen
	public void handleOpen(Session session) { // 이 Session은 소켓이 쓰는 세션이다. 
		System.out.println("연결 성공");
		sessionList.add(session);// 여기 안을 뒤져야함
	}

	
	@OnMessage // 이친구가 받는다. 
	public void handleMessage(String msg, Session session) {
		
		clearSession(); // 메세지를 보내기 전에 살이있는 세션에게만 보낸다. 
		
		System.out.println("메세지 : "+ msg); // 여기는 무조건 공지사항이다.
		// 관리자 > (전송) > 공지사항 > (수신) > 서버 > (전송) > 모든 유저
		
		for(Session s : sessionList) {
			if(session != s) {
				try {
					// 관리자 제외한 나머지 유저들에게만 메시지 전달 
					s.getBasicRemote().sendText(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	} 
	// 서버쪽엔 메세지를 받음 이걸 유저들에게 뿌려야 한다.
	// 이 받은 메세지를 다른 사람에게 돌려줘야 한다. 
	
	@OnClose
	public void handleClose() {}
	
	@OnError
	public void handleError(Throwable e) {}
	
	public void clearSession() {
		
		Iterator<Session> iter = sessionList.iterator();
		
		while(iter.hasNext()) {
			if(!(iter.next()).isOpen()) {
				iter.remove(); // 접속이 끊긴 클라이언트 소켓(세션)을 제거 
			}
		}
	}
	
}
