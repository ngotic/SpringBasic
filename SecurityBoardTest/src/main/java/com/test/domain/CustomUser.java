package com.test.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

// UserDetails 인터페이스 구현 > 유저 정보 객체 
// UserDetails <-- User 클래스

@Getter 
public class CustomUser extends User{

	private MemberDTO member;
	
	public CustomUser(String username, String password,
			Collection<?extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	public CustomUser(MemberDTO dto) {
		//MemberDTO > Custom(User)
		 super(dto.getId(),
			   dto.getPw(),
			   dto.getAuthlist().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
		this.member = dto; 
	}
}
