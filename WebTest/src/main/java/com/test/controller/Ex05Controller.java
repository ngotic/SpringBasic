package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.domain.SpringDTO;

@Controller
public class Ex05Controller {
	
	@GetMapping("/ex05.do")   // add.do 역할 
	public String ex05() {
		return "ex05";
	}
	
	// 데이터 수신
	// - 기존 : req.getParameter("")
	/*
	@PostMapping("/ex05ok.do") // addok.do 역할
	public String ex05ok(HttpSession session,
			HttpServletRequest req,
			HttpServletResponse resp) {
		
		// 얘네 매개변수 위치를 바꾸어도 상관이 없다.
		// System.out.println(req == null);
		// System.out.println(resp == null);
		// System.out.println(session == null);
		
		String data = req.getParameter("data"); 
		// 이거 request를 잘안쓴다. > 물론 쓸 수는 있다. 
		
		req.setAttribute("data", data); // request로 넘김 
		
		return "ex05ok";
	}*/
	
	/*
	@PostMapping("/ex05ok.do")
	public String ex05ok() {
		return "ex05ok";
	}*/
	
	/*
	@PostMapping("/ex05ok.do")
	public String ex05ok(@RequestParam("data") String data,
			Model model) {
		// String data = req.getParameter("data")
		// @RequestParam("data") String data
		
		System.out.println(data);
		
		//ModelAndView > Model 
		
		model.addAttribute("data", data); // req.setAttribute
		
		return "ex05ok";
	}*/
	
	/*@PostMapping("/ex05ok.do")
	public String ex05ok(Model model, String data) {
		
		// @RequestParam("data") > 생략할 수 있다.
		
		System.out.println(data);
		return "ex05ok";
	}*/
	
	
	
	// @RequestParam("data") 생략해버리면 String data 에서 data 이름으로 파라미터가 만들어진다. 
	/*
	@PostMapping("/ex05ok.do")
	public String ex05ok(Model model, String data) {
		
		// @RequestParam("data") > 생략할 수 있다.
		
		System.out.println(data);
		
		model.addAttribute("data", data);
		
		return "ex05ok";
	}*/
	
	/*
	@PostMapping("/ex05ok.do")
	public String ex05ok (
				Model model,
				@RequestParam("name") String name,
				@RequestParam("age") String age,
				@RequestParam("address") String address
			) {
		
		SpringDTO dto = new SpringDTO();
		dto.setName(name);
		dto.setAge(age);
		dto.setAddress(address);
		
		model.addAttribute("dto", dto);
		
		return "ex05ok";
	}*/
	/*
	@PostMapping("/ex05ok.do")
	public String ex05ok (
				Model model,
				String name,
				String age,
				String address
			) {
		
		SpringDTO dto = new SpringDTO();
		
		dto.setName(name);
		dto.setAge(age);
		dto.setAddress(address);
		
		model.addAttribute("dto", dto);
		
		return "ex05ok";
	}*/
	/*
	@PostMapping("/ex05ok.do")
	public String ex05ok (Model model,
						  SpringDTO dto, // 대박인듯
						  String seq) {
		
		model.addAttribute("dto", dto);
		System.out.println(dto);
		System.out.println(seq);
		return "ex05ok";
	}*/
	/*
	@PostMapping("/ex05ok.do")
	public String ex05ok(Model model,
			// @RequestParam("cb") String[] cb
			//String[] cb
			@RequestParam("cb") List<String> cb
			// ArrayList<String> cb 이건 안된다.
			){
		//String[] list = req.getParameterValues("cb")
		model.addAttribute("cb", cb);
		return "ex05ok";
	}*/
	
	/*
	@PostMapping("/ex05ok.do")
	public String ex05ok(@ModelAttribute("data") String data) {
		// @ModelAttribute("data") 이걸 쓰면 
		// model.addAttribute("data", data); 와 같다.   
		return "ex05ok";
	}*/
	
	
	// input태그에 name="name"과 setter 의 이름이 같아야 한다. 
	@PostMapping("/ex05ok.do") // 어떻게 맵핑한거지?? 
	public String ex05ok( @ModelAttribute("dto") SpringDTO dto) {
			// SpringDTO dto) {
		//1. <input type="text" name="name">
		System.out.println(dto);
		
		return "ex05ok";
	}
	
}
