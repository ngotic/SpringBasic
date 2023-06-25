package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping("/ex04.do") // 컨트롤러하나당 가상주소 겁나 늘릴 수 있다. 
public class Ex04Controller {
	
	
	@RequestMapping("/ex04.do") 
	public String ex04() {
		return "ex04";
	}
	
	@RequestMapping("/ex04_1.do") 
	public String ex04_1() {
		return "ex04";
	}

}

/*
@Controller 
@RequestMapping
public class Ex04Controller {
	
	
	@RequestMapping("/ex04.do")
	public String ex04() {
		return "ex04";
	}
	
	public String ex04_1() {
		return "ex04";
	}

}*/
