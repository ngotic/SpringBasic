package com.test.di01;


// 길동이는 펜으로 일을 한다. 
public class Main {
	
	public static void main(String[] args) {
		
		// 의존 관계
		// Main > (의존) > Hong > (의존) > Pen
		// - Pen은 Hong의 의존객체다.
		// - Hong은 Main의 의존객체다. 
		
		// 기존 방식
		// - 의존 객체를 직접 생성한다. 
		Hong hong = new Hong();
		hong.run();
		
		// DI 
		// - 의존 관계를 다른 방식으로 형성하는 디자인 패턴
		// - 의존 주입 > 의존 객체를 자신이 직접 생성하지 않고, 다른 누군가에 의해서 건내받는 패턴
		// Lee lee = new Lee();
		
		Brush b = new Brush(); 
		//Lee lee = new Lee(b); // 의존 주입(DI) 발생
		Lee lee = new Lee();
		
		lee.setB(b); // 의존 주입(DI) 발생
		
		lee.run();
		
	}
	
}
