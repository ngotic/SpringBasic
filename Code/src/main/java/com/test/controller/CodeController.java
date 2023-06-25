package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.domain.CodeDTO;
import com.test.persistence.CodeDAO;

// 이거 controller 스캔 안해놓으면 에러 뜬다. 


@Controller 
public class CodeController {
	
	@Autowired
	private CodeDAO dao; 
	
	@GetMapping("/list.do") //required 기본값이 true다.
	public String list(Model model, @RequestParam(value="language", required=false) List<String> language) {
		
		System.out.println(language);
		
		List<CodeDTO> list = dao.list(language);
		
		model.addAttribute("list", list);
		model.addAttribute("language", language);
		
		return "list";
	}
	
	@GetMapping("/add.do")
	public String add() {
		return "add";
	}
	
	@PostMapping("/addok.do")
	public String addok(CodeDTO dto) {
		int result = dao.add(dto);
		
		if(result == 1) {
			return "redirect:/list.do";
		} else {
			return "redirect:/add.do";
		}
	}
		
	
	
	@GetMapping("/view.do")
	public String view(Model model, String seq) {
		
		CodeDTO dto = dao.view(seq);
		
		model.addAttribute("dto", dto);
		
		return "view";
	}
	
}
