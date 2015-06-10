package com.ebs.ckcest.testAction;

import com.ebs.WikiBookService.TestService;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{
	
	private TestService ser;
	/**
	 * @Function: test
	 * @Description: TODO
	 * @param @return    
	 * @return String    
	 * @date 2015年6月10日 上午10:23:18
	 * @throws
	 */
		
	public String test(){
		System.out.println("this is test action!");
		return SUCCESS;
	}
	public TestService getSer() {
		return ser;
	}
	public void setSer(TestService ser) {
		this.ser = ser;
	}
	
	
}
