package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.domain.BoardDTO;
import com.test.mapper.BoardMapper;


@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired 
	private BoardMapper mapper;
	
	// 글쓰기 
	@Override
	public int add(BoardDTO dto) {
		return mapper.add(dto);
	}
	
	// 상세보기
	@Override
	public BoardDTO get(String seq) {
		return mapper.get(seq);
	}
	
	// 목록보기
	@Override
	public List<BoardDTO> list() {
		return mapper.list();
	}
	
	// 수정하기
	@Override
	public int edit(BoardDTO dto) {
		return mapper.edit(dto);
	}
	
	// 삭제하기 
	@Override
	public int del(String seq) {
		return mapper.del(seq);
	}


	
}
