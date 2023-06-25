package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 컨트롤러 구현
// 1. Controller 인터페이스 구현
// 2. @Controller 어노테이션 사용


@Controller
@RequestMapping(value="/ex03.do", method=RequestMethod.GET)
public class Ex03Controller {
	
	// 요청 메서드(핸들러) > 메서드 이름을 맘대로 ~
	@RequestMapping
	public String test() {
		// pageNotfound 
		// /web/ex03.do 를 스프링이 인식하지 못한다. 
		
		// 업무 코드
		// 뷰 호출하기
		// WEB-INF/views/ex03.jsp
		return "ex03"; // JSP 페이지 이름이라 생각 > View Resolver가 동작이 된다. 
	}

}
