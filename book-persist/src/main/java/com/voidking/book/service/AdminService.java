package com.voidking.book.service;

import com.voidking.book.entity.Admin;

public interface AdminService extends BaseService<Admin,Long> {
	
	Admin findByNameAndPwd(String name,String pwd);

}
