package com.test.di05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



//@Component 
@Service  // 주업무 > 왜 이렇게 만들었나? 가독성 높이려고 
public class BoardServiceImpl implements BoardService {

	private BoardDAO dao;
	
	@Autowired
	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public void list() {
		// 목록 가져오기..
		// 직접쓰는 방법 vs 외부로 주입하는 방식  
		// BoardDAO dao = new BoardDAOImpl();
		// dao.list();
		this.dao.list();
	}

}
