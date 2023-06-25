package com.test.di04;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.di03.DiTest;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // 있는거 쓰다보니까... 얘를 씀 어떤거 써도 갠찬
@Log4j
public class XMLTest {
	
	@Autowired
	private BoardController controller;
	
	@Test
	public void testController() {
		
		assertNotNull(controller); 
		
		controller.doGet();
		
	}
	
}	
