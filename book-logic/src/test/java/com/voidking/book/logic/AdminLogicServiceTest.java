package com.voidking.book.logic;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.voidking.book.entity.Admin;

public class AdminLogicServiceTest {

	private AdminLogicService adminLogicService;
	@Before
	public void prepare(){

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-persist.xml");

		adminLogicService = ctx.getBean(AdminLogicService.class);
	}
	
	@Test
	public void testLogin() {
		Admin admin = new Admin("haojin","haojin");
		System.err.println(this.adminLogicService.login(admin));

	}
}
