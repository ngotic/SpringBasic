package com.test.service;

import java.util.List;

import com.test.domain.AddressDTO;

public interface AddressService {

	void add(AddressDTO dto, String[] emailList);

	List<AddressDTO> list();

}
