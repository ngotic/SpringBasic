package com.test.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class AuthController {
	
	@GetMapping("/accesserror.do")
	public String accesserror(Authentication auth, Model model) {
		log.info("Access Denied : " + auth);
	
		model.addAttribute("msg", "Access Denied"+ auth);
		return "accesserror";
	} // 톰켓이 보여주는 페이지가 아니라 우리가 만든 페이지로 보여줄래 
	
	@GetMapping("/customlogin.do")
	public String customlogin(String error, String logout, Model model) {
		log.info("error :  "+ error);
		log.info("logout : "+ logout);
		model.addAttribute("error" , error);
		model.addAttribute("logout" , logout);
		return "customlogin";
	}
	
	@GetMapping("/customlogout.do")
	public String customlogout() {
		
		log.info("custom logout");
		
		return "customlogout";
		
	}
}
