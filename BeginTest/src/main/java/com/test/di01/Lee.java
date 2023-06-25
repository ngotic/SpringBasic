package com.test.di01;

public class Lee {
	
	private Brush b;
	
	// DI 구현 > 의존 주입 도구
	
	// 1. 생성자
	// - 딱 1번만 호출 가능
	// - 좀 더 안정적 > 많이 사용 
	// 2. Setter 
	// - 언제든지 호출 가능 
	
	// 외부로부터 주입받는다.  
	/*
	public Lee(Brush b) { this.b = b; }
	 */
	
	// setter를 통해서 주입 받을 수 있다. 
	public void setB(Brush b) {
		this.b = b;
	}
	
	
	public void run() {
		
		// 기존 방식
		// - 반드시 필요로 하는 의존 객체를 직접 생성하는 방식
		// Brush b = new Brush();
		// 붓을 내가 만들지 않는다. 다른 사람이 만든다. 
		b.draw();
		// 방법은 여러가지 있다.
		// 생성자를 만들자... 
		
	}
}
