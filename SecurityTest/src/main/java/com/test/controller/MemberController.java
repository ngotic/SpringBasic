package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.domain.AuthDTO;
import com.test.domain.MemberDTO;
import com.test.mapper.MemberMapper;

@Controller
public class MemberController {
	@Autowired
	private MemberMapper mapper;
	
	@Autowired 
	private PasswordEncoder encoder;
	
	@GetMapping("/register.do")
	public String register() {
		return "register";
	}
	
	@PostMapping("/registerok.do")
	public String registerok(Model model,
			MemberDTO dto, int auth) {
		// 암호 인코딩
		System.out.println(">"+dto);
		dto.setUserpw(encoder.encode(dto.getUserpw()));
		int result = mapper.register(dto);
		
		if(auth >= 1) {
			AuthDTO adto = new AuthDTO();
			adto.setUserid(dto.getUserid());
			adto.setAuth("ROLE_MEMBER");
			mapper.registerAuth(adto);
		}
		
		if(auth >= 2) { // ? 
			AuthDTO adto = new AuthDTO();
			adto.setUserid(dto.getUserid());
			adto.setAuth("ROLE_ADMIN");
			mapper.registerAuth(adto);
		}
		
		model.addAttribute("result", result);
		
		return "registerok";
	}
	
	@GetMapping("/info.do")
	public String info() {
		
		return "info";
		
	}
}
