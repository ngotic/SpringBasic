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

import com.google.gson.Gson;
import com.test.domain.ChatDTO;

@ServerEndpoint("/chatserver.do")
public class ChatServer {
	
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
		
		System.out.println(msg);
		//JSON <- (변환) -> Java Object
		// -GSON
		
		Gson gson = new Gson();
		ChatDTO dto = gson.fromJson(msg, ChatDTO.class);
		
		// 이게 상태 코드에 따라 돌아가는데 .... 1이면 나머지 사람들에게 알려준다, 
		if (dto.getCode().equals("1")) {
			// 새로운 유저가 접속했습니다. > 모든 사람에게 알림 > 단, 현재 접속한 사람 빼고 
			for(Session s: sessionList) {
				if(s != session) {
					try {
						s.getBasicRemote().sendText(msg);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} else if(dto.getCode().equals("2")) {
			//  누군가 퇴장 > 나머지 사람들에게 알려줌 
			// 나간 사람은 이세션의 소유자고 arrayList에서 뺀다. 
			sessionList.remove(session); // 서버측에서의 퇴장 
			
			for ( Session s : sessionList ) {
				try {
					s.getBasicRemote().sendText(msg); // 이걸 에코서비스 하듯이 그대로 리턴한다. 
					//msg는 나간다고 전해준 그 메세지다. 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		} else if(dto.getCode().equals("3")) {
			// 대화 메세지 > 모두에게 전달 
			for(Session s: sessionList) {
				if(s != session) { // 나 빼고 나머지 사람 
					try {
						s.getBasicRemote().sendText(msg);
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
			
		} else if(dto.getCode().equals("4")) { // 이것도 비슷한데 이모티콘 처리임
			// 대화 메세지 > 모두에게 전달 
			for(Session s: sessionList) {
				if(s != session) { // 나 빼고 나머지 사람 
					try {
						s.getBasicRemote().sendText(msg);
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
			
		}
		
		
	} 
	//chat.jsp에서 날린 json 내용이 이리로 들어간다. 근데 이걸 자바클래스로 변환하기 어렵다.
	// gson이라는 라이브러리가 있다. 개편함
	//<dependency>
	//	<groupId>com.google.code.gson</groupId>
	//	<artifactId>gson</artifactId>
	//	<version>2.10.1</version>
	//</dependency>
	
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
