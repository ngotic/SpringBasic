package com.test.di03;

import org.springframework.stereotype.Component;


// Pen과 Hong에 둘다 Component를 붙여야 한다. 
// > 스프링이 관리하는 객체이다. 

@Component
public class Pen {
	public void write() {
		System.out.println("펜으로 글씨를 적습니다.");
	}
}
