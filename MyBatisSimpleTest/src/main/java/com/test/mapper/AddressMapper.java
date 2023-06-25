package com.test.mapper;

import java.util.List;

import com.test.domain.AddressDTO;
import com.test.domain.EmailDTO;

public interface AddressMapper {
	public void add(AddressDTO dto);
	// 이게 xml에서 쿼리태그의 id이어야 한다.

	public void addEmail(EmailDTO edto);

	public List<AddressDTO> list();

	public List<EmailDTO> elist(String pseq);

	public List<AddressDTO> list2();

}
