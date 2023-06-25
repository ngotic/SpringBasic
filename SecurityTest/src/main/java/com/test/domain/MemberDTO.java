package com.test.domain;

import java.util.List;

import lombok.Data;

@Data
public class MemberDTO {
	private String userid;
	private String userpw;
	private String userauth;
	private String username;
	private boolean enabled;
	private String regdate;
	private String updatedate;
	
	List<AuthDTO> authlist;
}
