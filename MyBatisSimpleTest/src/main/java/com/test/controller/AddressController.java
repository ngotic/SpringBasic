package com.test.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.domain.AddressDTO;
import com.test.service.AddressService;


@Controller
public class AddressController {
	
	@Autowired
	private AddressService service;
	
	@GetMapping("/list.do")
	public String list(Model model) {
		List<AddressDTO> list = service.list();
		// tblAddress(1), tblEmail(N)
		model.addAttribute("list", list);
		return "list";
	}
	
	@GetMapping("/add.do")
	public String add(Model model) {
		return "add";
	}
	
	@PostMapping("/addok.do")
	public String addok(Model model, AddressDTO dto, String[] emailList) {
		System.out.println(">>>>>>>>>>>>>>>>>>>"+dto);
		System.out.println(Arrays.toString(emailList));
		
		service.add(dto, emailList);
		
		return "redirect:/list.do";
	}
	
	@GetMapping("/view.do")
	public String view(Model model) {
		return "view";
	}
}
