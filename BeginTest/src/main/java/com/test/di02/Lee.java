package com.test.di02;

public class Lee {
	private Brush brush;
	
	// Setter 의존 주입 
	public void setBrush(Brush brush) {
		this.brush = brush;
	}
	
	public void run() {
		this.brush.draw();
	}
}
