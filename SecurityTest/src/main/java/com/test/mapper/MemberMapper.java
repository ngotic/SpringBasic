package com.test.mapper;

import com.test.domain.AuthDTO;
import com.test.domain.MemberDTO;

public interface MemberMapper {

	public int register(MemberDTO dto) ;

	public void registerAuth(AuthDTO adto);

	public MemberDTO read(String userid);
	
}
