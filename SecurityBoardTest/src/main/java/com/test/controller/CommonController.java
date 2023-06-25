package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
	
	@GetMapping("/template.do")
	public String template() {
		return "template";
	}
	

	@GetMapping("/index.do")
	public String index() {
		return "index";
	}
	
	@GetMapping("/rest.do")
	public String rest() {
		return "rest";
	}
	// restfull은 서버다. 데이터만 주고 받는...
	
	// 그래서 화면을 구성하려면 별도의 클라이언트를 따로 만든다.
	
	// RestFull아까 프로젝트는 서버
	// SecurityBoardTest는 클라이언트다. 화면을 구성함 
}
