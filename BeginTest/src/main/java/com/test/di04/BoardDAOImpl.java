package com.test.di04;

public class BoardDAOImpl implements BoardDAO {

	@Override
	public void list() {
		System.out.println("select * from tblBoard");
	}
	

}
