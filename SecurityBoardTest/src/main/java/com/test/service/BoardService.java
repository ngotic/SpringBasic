package com.test.service;

import java.util.List;

import com.test.domain.BoardDTO;

public interface BoardService {
	// 글쓰기
	int add(BoardDTO dto);
	// 목록보기
	List<BoardDTO> list();
	int edit(BoardDTO dto);
	int del(String seq);
	BoardDTO get(String seq);
	
}
