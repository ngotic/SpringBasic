package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	// - "/web/list.do"
	// - "/web/add.do"
	// - "/web/addok.do"
	
	// - "/web/board/addok.do"
	// - "/web/board/addok.do"
	// - "/web/board/addok.do"
	
	@RequestMapping(value="/list.do", method= { RequestMethod.GET, RequestMethod.POST})
	public String list() {
		return "list";
	}
	

	// doGet() 역할
	// @RequestMapping(value="/add.do", method=RequestMethod.GET)
	@GetMapping(value="/add.do")
	public String add() {
		return "add";
	}
	
	// 누가 get이든 post든 티가 안난다. 이게 범용이다. 근데 method를 명시해주면 된다. 
	// doPost()
	// @RequestMapping(value="/addok.do", method=RequestMethod.POST)
	@PostMapping(value="/addok.do")
	public String addok() {
		return "addok";
	}
}
