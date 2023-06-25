package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.domain.BoardDTO;
import com.test.mapper.BoardMapper;

//@Controller
@RestController // 우리가 쓰던 컨트롤러와 사실 동일하다. 
public class TestController {
	
	@Autowired 
	private BoardMapper mapper; 
	
	/*
	@GetMapping("/m1.do")
	public @ResponseBody BoardDTO m1(){
		BoardDTO dto = new BoardDTO();
		dto.setSeq("1");
		dto.setSubject("제목입니다,");
		dto.setContent("내용압니다,");
		dto.setRegdate("2023-04-24");
		dto.setId("hong");
		return dto;
	}*/
	
	@GetMapping("/m1.do")
	public BoardDTO m1(){
		BoardDTO dto = new BoardDTO();
		
		dto.setSeq("1");
		dto.setSubject("제목입니다,");
		dto.setContent("내용압니다,");
		dto.setRegdate("2023-04-24");
		dto.setId("hong");
		
		return dto;
	}
	
	//Board > CRUD
	
	// 글쓰기
	// 1. http://localhost:8091/rest/address
	// 2. POST
	// 3. return int
	//                              RequestMethod.에 PUT, PATCH, DELETE 이런거 다 있다. 
	// @RequestMapping(value="/board", method=RequestMethod.POST)
	
	// REST 서비스 > 테스트 > 클라이언트 툴 (POSTMAN, INSOMNIA, VS CODE, 크롬 확장 프로그램 등.. )
	@PostMapping("/board")
	public int add(@RequestBody BoardDTO dto) {
		int result = mapper.add(dto);
		return result; 
	}

	// 목록 가져오기
	// 1. http://localhost/rest/board
	// 2. GET
	// 3. List<DTO> -> JSON 변환
	@GetMapping("/board")
	public List<BoardDTO> list(){
		return mapper.list();
	}
	
	// 요소 수정하기
	// 1. http://localhost/rest/board/6
	// 2. PUT or PATCH 
	// 3. return int
	@PutMapping("/board/{seq}") // 경로변수라고 한다. 
	public int edit(@RequestBody BoardDTO dto,
			@PathVariable("seq") String seq) { // getParameter와 헷갈리니까 @PathVariable을 붙인다.
		dto.setSeq(seq);
		return mapper.edit(dto);
	}
	
	// 삭제하기
	// 1. http://localhost/rest/board/6
	// 2. DELETE  
	// 3. return int
	
	@DeleteMapping("/board/{seq}")
	public int del(@PathVariable("seq") String seq) {
		return mapper.del(seq);
	}
	
	//검색하기
	// 1. http://localhost/rest/board/3
	// 2. GET
	// 3. return DTO 
	@GetMapping("/board/{seq}")
	public BoardDTO get(@PathVariable("seq") String seq) {
		return mapper.get(seq);
	}
	
}


