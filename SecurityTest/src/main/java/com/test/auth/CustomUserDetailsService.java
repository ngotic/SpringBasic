package com.test.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.test.domain.CustomUser;
import com.test.domain.MemberDTO;
import com.test.mapper.MemberMapper;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private MemberMapper mapper;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// 기본 > username, password, enabled, authority 
		// 재정의 > 기본 + 추가 정보 
		log.info("load User by UserName : " + username); //id
		MemberDTO dto = mapper.read(username);
		
		log.info("Queried by member : " + dto);
		
		return dto !=null ? new CustomUser(dto) : null;
	}

}
