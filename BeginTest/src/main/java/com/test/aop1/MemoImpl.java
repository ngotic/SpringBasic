package com.test.aop1;

import java.util.Calendar;

public class MemoImpl implements Memo{

	@Override
	public void add(String memo) {
		System.out.println("메모 쓰기 : " +memo);
		// 로그 기록 
		//Calendar now = Calendar.getInstance();
		//System.out.printf("[LOG][%tF %tT] 로그를 기록합니다.\n", now, now);
	}// 주업무는 주업무만 코딩, 보조업무는 보조업무만 한다. 

	
	// 인터페이스 땜에 에러난다.  // Exception Exception is not compatible with throws clause in Memo.read(int)
	@Override
	public String read(int seq) throws Exception {
		// 로그 기록 
		//Calendar now = Calendar.getInstance();
		//System.out.printf("[LOG][%tF %tT] 로그를 기록합니다.\n", now, now);
		if(seq  < 10) {
			System.out.println("메모 읽기");
		} else {
			throw new Exception("존재하지 않는 메모");
		}
		return "리드";
	}

	@Override
	public boolean edit(int seq, String memo) {
		System.out.println("메모 수정 : "+ memo);
		return true;
	}

	@Override
	public boolean del(int seq) {
		System.out.println("메모 삭제 : "+seq);
		return true;
	}

}
