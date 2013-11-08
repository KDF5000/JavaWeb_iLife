package com.demo.interceptor;

import com.opensymphony.xwork2.ActionSupport;

public class interceptorAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(1000);
		return SUCCESS;
	}
	
}
