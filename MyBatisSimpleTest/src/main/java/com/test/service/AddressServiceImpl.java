package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.domain.AddressDTO;
import com.test.domain.EmailDTO;
import com.test.mapper.AddressMapper;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired 
	private AddressMapper mapper;
	
	@Override
	public void add(AddressDTO dto, String[] emailList) {
		// TODO Auto-generated method stub
		mapper.add(dto);
		
		for(int i=0; i<emailList.length ; i++) {
			if(emailList[i].equals("")) continue;
			EmailDTO edto = new EmailDTO();
			edto.setPseq(dto.getSeq());
			edto.setEmail(emailList[i]);
			mapper.addEmail(edto);
		}
	}

	@Override
	public List<AddressDTO> list() {
		// tblAddress(1) : tblEmail(N)
		// 1. 직접구현
		// 2. MyBatis
		/*
		 * List<AddressDTO> list = mapper.list();
		for(AddressDTO dto : list) {
			List<EmailDTO> elist = mapper.elist(dto.getSeq());
			dto.setEmail(elist);
		}*/
		
		// 이걸 마이바티스 쪽에서 해결한다. 
		List<AddressDTO> list = mapper.list2();
		
		return list;
	}

}
