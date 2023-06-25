package com.test.aop1;

public interface Memo {
	
	// 메모 쓰기
	void add(String memo);
	
	// 메모 읽기
	String read(int seq) throws Exception;
	
	// 메모 수정
	boolean edit(int seq, String memo);
	
	// 메모 삭제
	boolean del(int seq);
	
}
