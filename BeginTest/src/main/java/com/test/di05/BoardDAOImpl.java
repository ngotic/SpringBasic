package com.test.di05;

import org.springframework.stereotype.Repository;

//@Component
@Repository
public class BoardDAOImpl implements BoardDAO {

	@Override
	public void list() {
		System.out.println("select * from tblBoard");
	}
	

}
