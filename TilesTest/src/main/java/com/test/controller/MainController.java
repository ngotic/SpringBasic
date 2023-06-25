package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
	
	@GetMapping("/index.do")
	public String index() {
		// TilesViewResolver > 아래의 문자열 > <definition>의 name 속성값으로 인식
		//return "test";
		return "index";
	}
	
}
