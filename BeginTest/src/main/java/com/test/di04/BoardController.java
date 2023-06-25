package com.test.di04;

public class BoardController {
	
	
	// 의존 주입 도구 
	// 1. 생성자
	// 2. Setter
	
	private BoardService service;
	
	// 주입 도구를 만든거다. 실제 주입은 스프링한테 시킨다. 
	public BoardController(BoardService service) {
		this.service = service;
	}
	
	// list.do 
	public void doGet() {
		
		//BoardController > (의존) > BoardService > (의존) > BoardDAO
		
		// 어떤 객체를 쓰다가 필요한 의존 객체가 있으면 만들어서 썼다.
		
		// 객체 생성 순서
		// 1. BoardController
		// 2. BoardService
		// 3. BoardDAO
		
		// 의존 객체 
		//BoardService service = new BoardServiceImpl();
		//service.list();
		
		this.service.list();
	}
	
}

// 남이 만든건 XML(라이브러리 가져다 쓸때)
// 우리가 만든것은 애너테이션을 쓴다.
// 하나는 XML 방식, 하나는 애노테이션 방식을 쓴다. 

