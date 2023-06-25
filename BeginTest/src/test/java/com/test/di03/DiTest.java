package com.test.di03;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

// 테스트 용도 자바 클래스 > JUnit 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DiTest {
	
	private Hong hong;
	
	@Autowired 
	public void setHong(Hong hong) {
		this.hong = hong;
	}
	
	@Test
	public void testExist() {
		// 여러가지 테스트
		assertNotNull(hong); // 객체 생성이 잘되었는지 확인한다.
		hong.run();
	}
	
}
