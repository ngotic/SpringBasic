package com.test.di03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

//@Component : <bean> 태그와 동일한 역할
// > 스프링에 관리하는 객체 

// @Autowired : 의존주입 어노테이션
// > 아래에 있는 대상에 객체를 주입해주세요~.

@Component
//@Data
public class Hong {
	
	// 얘를 가장 많이 썼다.
	@Autowired 
	private Pen pen; // 여기다가 Autowired를 붙여도 된다. 그러면 잡다한게 다 사라진다.
	// 얘는 내부적으로 setter를 호출한 셈이다. 밑에서부터 위로 올라온 과정이다. 
	
	// Setter라는 lombok 애너테이션이 있다. 
	//@Setter(onMethod_ = @Autowired) // 얘의 setter를 만들어줘 
	//private Pen pen;
	
	// 생성자 주입 
	/*
	 * @Autowired public Hong(Pen pen) { this.pen = pen; }
	 */
	
	
	// setter 주입
	/*
	 * @Autowired public void setPen(Pen pen) { this.pen = pen; }
	 */
	
	public void run() {
		pen.write();
	}
	
}
