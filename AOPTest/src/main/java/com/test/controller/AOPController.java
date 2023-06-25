package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.persistence.AOPDAO;

@Controller
public class AOPController {
	
	@Autowired
	private AOPDAO dao;
	
	@GetMapping("/list.do")
	public String list() {
		
		dao.list();
		System.out.println("Controller.list");
		return "list";
	}
	
	@GetMapping("/add.do")
	public String add() {
		dao.add();
		System.out.println("Controller.add");
		return "add";
	}
	
	@GetMapping("/view.do")
	public String view() {
		dao.view();
		System.out.println("Controller.view");
		return "view";
	}
}
