package com.test.domain;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AddressDTO {
	private String seq;
	

	private String name;
	
	private String age;
	private String address;
	
	private List<EmailDTO> email;
}
