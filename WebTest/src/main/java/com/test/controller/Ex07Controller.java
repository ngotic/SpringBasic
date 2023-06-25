package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class Ex07Controller {
	
	@RequestMapping(value="/ex07.do", method=RequestMethod.GET) 
	public String ex07(@RequestParam(value="num") int num, Model model) {
		
		model.addAttribute("num", 100/num);
		return "ex07";
	}
}
// 우리가 알던 @RequestParam은 원래 문자열인데
//이건 문자열로 따로 캐스팅해서 넣어준다.

