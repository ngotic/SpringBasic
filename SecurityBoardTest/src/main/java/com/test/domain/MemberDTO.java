package com.test.domain;

import java.util.List;

import lombok.Data;

@Data
public class MemberDTO {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String gender;
	private String regdate;
	private String enabled;
	private List<AuthDTO> authlist;
}
