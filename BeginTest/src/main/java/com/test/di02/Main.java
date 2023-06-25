package com.test.di02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		// [ 스프링 설명 ]
		// 1. XML 설정
		// 2. 어노테이션 설정 
		// 3. 자바 설정
		// > 1~2번 위주로 수업을 한다.
		
		// 스프링 환경
		// - 객체 생성 ~ 소멸 > 스프링 관리
		// - XML 기반 > 설정 XML 정의
		
		// Pen 객체 생성하기 
		Pen p1 = new Pen();
		p1.write();
		
		// Pen 객체 생성하기 > 스프링을 통해서 생성하기  
		//ApplicationContext context = new ClassPathXmlApplicationContext("file:/src/main/java/com/test/di02/di02.xml");
		
		//ApplicationContext context = new ClassPathXmlApplicationContext("./com/test/di02/di02.xml");  // 이건 상대경로다.
		ApplicationContext context = new ClassPathXmlApplicationContext("com/test/di02/di02.xml"); 
		context.getBean("pen"); // 1. id로 팬을 찾고, 2. id에 박힌 Class 위치를 찾고, 3. 객체를 만든다.
		
		Pen p2 = (Pen)context.getBean("pen"); // id
		p2.write();
		
		Brush b1 = (Brush)context.getBean("b1");   // name
		b1.draw();
		
		Brush b2 = (Brush)context.getBean("b2");   // name
		b2.draw();
		
		Brush b3 = (Brush)context.getBean("brush"); // name
		b3.draw();
		
		// -------------------------------------------
		//Hong hong = new Hong(); // 이걸 xml에서 해주면 편할듯
		Hong hong = (Hong)context.getBean("hong");
		// No default constructor found; nested exception is java.lang.NoSuchMethodException: com.test.di02.Hong.<init>()
		// 길동이가 스스로 일하기 위해서 펜이 필요하다. 그 펜은 자기가 안만들기했는데.... 얘는 펜이 없다. 펜이 없으면 자기 할 일 못한다.
		// constructor-arg를 쓴다. 
		// 여기선 홍만 가져오면 된다. 그러면 Pen을 같이 가져오는 셈이다.
		hong.run();
		
		Lee lee = (Lee)context.getBean("lee");
		lee.run();
 
	}
}
