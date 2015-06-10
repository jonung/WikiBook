package com.ebs.WikiBookService;

import com.ebs.WikiBookDao.TestDao;

public class TestService {
	
	private TestDao dao;
	
	public void testService(){
		System.out.println("this is testService!");
	}

	public void setDao(TestDao dao) {
		this.dao = dao;
	}
	
	
}
