package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class TestController {
	@GetMapping("/index.do")
	public String index() {
		log.info("TestController > 회원 전용 페이지");
		return "index";
	}
	
	@GetMapping("/member.do")
	public String member() {
		log.info("TestController > 멤버 전용 페이지");
		return "member";
	}
	
	@GetMapping("/admin.do")
	public String admin() {
		log.info("TestController > 관리자 전용 페이지");
		return "admin";
	}
	
	@GetMapping("/template.do")
	public String template() {		
		return "template";
	}
}
