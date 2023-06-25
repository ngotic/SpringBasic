package com.test.di02;

public class Hong {
	
	private Pen pen;
	
	// 생성자 > 의존 주입 
	public Hong(Pen pen) {
		this.pen = pen;
	}
	
	public void run() {
		// 의존 개체 사용 
		pen.write();
	}
}
