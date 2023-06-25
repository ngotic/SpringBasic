package com.test.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Log {
	
	/*
	@After("execution(* add(..))")
	public void m1() {
		System.out.println("[보조업무] 기록을 남깁니다.");
	}
	*/
	
	@Pointcut("execution(* add(..))")
	public void pc1() {
		// 구현부 없음 
	}

	@After("pc1()")
	public void m1() {
		System.out.println("[보조업무] 기록을 남깁니다.");
	}
}
