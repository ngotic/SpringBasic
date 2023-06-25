package com.test.mapper;

import java.util.List;

import com.test.domain.BoardDTO;

public interface BoardMapper {

	int add(BoardDTO dto);

	List<BoardDTO> list();

	BoardDTO get(String seq);

	int edit(BoardDTO dto);

	int del(String seq);

}
