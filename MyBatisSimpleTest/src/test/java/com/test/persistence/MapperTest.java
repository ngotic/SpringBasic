package com.test.persistence;

import static org.junit.Assert.assertNotNull;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.mapper.TimeMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MapperTest {
	
	@Autowired 
	private TimeMapper mapper;
	
	@Test
	public void testGetTime() {
		System.out.println(mapper.getTime());
		System.out.println(mapper.getTime2());
		//System.out.println(mapper.getClass().getName());
	} 
	
	
	
}
