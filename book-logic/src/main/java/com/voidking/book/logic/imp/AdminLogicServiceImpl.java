package com.voidking.book.logic.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voidking.book.entity.Admin;
import com.voidking.book.logic.AdminLogicService;
import com.voidking.book.repository.AdminRepository;
import com.voidking.book.service.AdminService;

@Service
public class AdminLogicServiceImpl implements AdminLogicService {

	@Autowired
	private AdminService adminService;

	@Autowired
	private AdminRepository adminRepository;

	public String login(Admin admin) {
		if (admin == null) {
			return "表现层错误";
		}
		if (admin.getName() == null || admin.getName().equals("")) {
			return "用户名错误";
		}
		if (admin.getPwd() == null || admin.getPwd().equals("")) {
			return "密码错误";
		}

		// AdminBase tmp = this.adminBaseService.findByNameAndPwd(
		// adminBase.getName(), adminBase.getPwd());
		Admin tmp = this.adminRepository.findByNameAndPwd(admin.getName(),
				admin.getPwd());

		if (tmp == null) {
			return "用户名或者密码错误";
		}

		admin.setId(tmp.getId());

		// this.adminBaseService.save(adminBase);

		return "登录成功";

	}

}
