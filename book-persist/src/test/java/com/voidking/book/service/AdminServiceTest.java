package com.voidking.book.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdminServiceTest {
	private AdminService adminService;

	@Before
	public void prepare(){

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-persist.xml");

		this.adminService = ctx.getBean(AdminService.class);
		
	}

	@Test
	public void testAdminService(){
		
	}
}
