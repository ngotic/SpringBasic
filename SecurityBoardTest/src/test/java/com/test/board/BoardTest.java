package com.test.board;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.test.domain.BoardDTO;
import com.test.mapper.MapperTest;
import com.test.service.BoardService;

import lombok.extern.log4j.Log4j;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class BoardTest {
	
	@Autowired 
	private BoardService service;
	
	// 테스트는 위에것 부터 실행된다. 
	
//	@Test
//	public void testAdd() {
//		
//		assertNotNull(service);
//		
//		BoardDTO dto = new BoardDTO();
//		dto.setId("dog");
//		dto.setSubject("글쓰기 테스트2");
//		dto.setContent("내용2");
//		
//		int result = service.add(dto);
//		log.info(result); // 1
//	}
	
//	@Test
//	public void testList() {
//		List<BoardDTO> list = service.list();
//		
//		for(BoardDTO dto : list) {
//			System.out.println(dto);
//		}
//		
//	}
//	@Test 
//	public void testGet() {
//		BoardDTO dto = service.get("21");
//		log.info(dto);
//	}
//	
//	@Test
//	public void testEdit() {
//		BoardDTO dto = new BoardDTO();
//		
//		dto.setSeq("21");
//		dto.setSubject("수정한 제목");
//		dto.setContent("수정한 내용");
//		
//		log.info(service.edit(dto));
//		
//		log.info(service.get("1"));
//	}
//
	
	@Test
	public void testDel() {
		log.info(service.del("21"));		
		log.info(service.list());
	}
	
}
