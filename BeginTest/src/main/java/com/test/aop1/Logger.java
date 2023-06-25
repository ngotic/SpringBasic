package com.test.aop1;

import java.util.Calendar;

import org.aspectj.lang.ProceedingJoinPoint;

// 보조 업무 객체
public class Logger {
	
	// 보조 업무 구현 
	public void log() {
		Calendar now = Calendar.getInstance();
		System.out.printf("[LOG][%tF %tT] 로그를 기록합니다.\n", now, now);
	}
	
	// 포인트컷만 잘 잡으면 된다. 
	public void time(ProceedingJoinPoint jp) { // 이걸 프록시 객체다.
		
		// 주업무를 실행하는 소요시간 
		long begin = System.nanoTime();
		System.out.println("[LOG] 기록을 시작합니다.");
		
		// 주 업무 실행
		//- 글쓰기 > 주 업무 객체의 가상 객체 참조
		try {
			jp.proceed(); // 현재 실행되는 주업무 메소드
		} catch(Throwable e) {
			e.printStackTrace();
		}
		long end = System.nanoTime();
		System.out.println("[LOG] 기록을 종료합니다.");		
		System.out.printf("[LOG] 소요시간 %,dns\n", end - begin);
	}
	
	// after-returning 
	// 리턴 해주는 걸 받아서 로그를 찎는다. 
	public void history(Object memo) { // 여기 인자 memo
		System.out.println("[LOG] 읽기 기록: "+memo);
	}
	
	public void check(Exception e) {   // 여기 인자 e
		System.out.println("[LOG] 예외 발생 "+ e.getMessage());
		// DB insert... 
		// 담당자 메일 or 메세지
	}
	
}
