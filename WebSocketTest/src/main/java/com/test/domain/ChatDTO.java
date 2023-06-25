package com.test.domain;

import lombok.Data;

@Data
public class ChatDTO {
	private String code;
	private String sender;
	private String receiver;
	private String content;
	private String regdate;
}

// 채팅 내용에 대한 DTO가 필요하다. 
//let chat = {
//		code     : '1',
//		sender   : window.name,
//		receiver : '',
//		content  : '',
//		regdate  : dayjs.format('YYYY-MM-DD HH:mm:ss')
//	};