package com.voidking.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.voidking.book.entity.Admin;
import com.voidking.book.repository.AdminRepository;
import com.voidking.book.service.AdminService;

@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin, Long> implements AdminService
{
	private AdminRepository adminRepository;
	@Autowired
	@Override
	public void setJpaRepository(JpaRepository<Admin, Long> adminRepository) {
		super.repository = adminRepository;
		this.adminRepository=(AdminRepository) adminRepository;
	}

	public Admin findByNameAndPwd(String name, String pwd) {
		return this.adminRepository.findByNameAndPwd(name, pwd);
	}
	
}