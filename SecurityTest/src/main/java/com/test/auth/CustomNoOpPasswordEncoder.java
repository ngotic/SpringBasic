package com.test.auth;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomNoOpPasswordEncoder implements PasswordEncoder{
	
	@Override
	public String encode(CharSequence rawPassword) {
		log.info("before encode: " +rawPassword);
		return rawPassword.toString();
	}

	// 1111 > sdasdasds3213213d > 1111 (양방향)
	// 1111 > sdasdasds3213213d

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		log.info("matched: "+rawPassword + ":" + encodedPassword);
		return rawPassword.toString().equals(encodedPassword);
	}
	
}
