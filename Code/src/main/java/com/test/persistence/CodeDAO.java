package com.test.persistence;

import java.util.List;

import com.test.domain.CodeDTO;

public interface CodeDAO {

	int add(CodeDTO dto);

	//List<CodeDTO> list();

	CodeDTO view(String seq);

	List<CodeDTO> list(List<String> language);

}
