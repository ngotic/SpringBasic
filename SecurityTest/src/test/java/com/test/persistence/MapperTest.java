package com.test.persistence;

import static org.junit.Assert.assertNotNull;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MapperTest {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void sessionTest() {
		
		assertNotNull(sqlSessionFactory);
		
		//SqlSessionTemplate > SQL 실행 > Statement 역할: 내부다. 
		SqlSession session = sqlSessionFactory.openSession(); // 요거 만드는거 귀찬아... 그래서 빈으로 만든다.
		

	}
	
}
// SAXParseException;
// lineNumber: 1 djWJrn 
