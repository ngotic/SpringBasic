package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.domain.BoardDTO;
import com.test.service.BoardService;

@Controller 
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/board/list.do")
	public String list(Model model) {
		model.addAttribute("list", service.list());
		return "board/list";
	}
	
	// 접근전에 권한 검사 하는 것 
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/board/add.do")
	public String add() {		
		return "board/add";
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/board/addok.do")
	public String addok(BoardDTO dto) {
		int result = service.add(dto);
		return "redirect:/board/list.do";
	}
	
	@GetMapping("/board/view.do")
	public String view(Model model, String seq) {
		BoardDTO dto = service.get(seq);
		model.addAttribute("dto", dto);
		return "board/view";
	}
	
	@PreAuthorize("isAuthenticated() and principal.username == #id")
	@GetMapping("/board/edit.do")
	public String edit(Model model, String seq, String id) {
		BoardDTO dto = service.get(seq);
		model.addAttribute("dto", dto );
		return "board/edit";
	}
	
	
	@PreAuthorize("isAuthenticated()") // 얘는 토큰 전달이라 따로 안막아도 된다. 
	@PostMapping("/board/editok.do") // ★★★★★ 이렇게 조건문 체크 ★★★★★ 
	public String editok(BoardDTO dto) {		
		int result = service.edit(dto);
		return "redirect:/board/view.do?seq="+dto.getSeq();
	}
	
	@PreAuthorize("isAuthenticated() and principal.username == #id")
	@GetMapping("/board/del.do")
	public String del(Model model, String seq, String id) {
		model.addAttribute("seq", seq);
		return "board/del";
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/board/delok.do")
	public String delok(String seq) {		
		int result = service.del(seq);
		return "redirect:/board/list.do";
	}
	
	// 글쓰기
	/*
	 * public int add(BoardDTO dto) {
	 * 
	 * }
	 */
	// 목록보기
	
	// 상세보기
	
	// 수정하기
	
	// 삭제하기
	
}


// 단위테스트를 하는데 데이터베이스에 대한 테스트를 주로 한다.
// 예를 들어서 CRUD를 먼저 구현하는데 테스트를 한다.
// UI 단을 만드는데 시간이 많이 들어감 
