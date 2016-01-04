package com.voidking.book.admin.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.voidking.book.entity.Admin;
import com.voidking.book.logic.AdminLogicService;

@Controller
@Namespace("/admin")
@ParentPackage("custom-default")
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 2936224923889056993L;

	@Autowired
	private AdminLogicService adminLogicService;

	private Admin admin;
	private String info;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Action(value = "login", results = { @Result(name = "success", type = "json") })
	public String login() throws Exception {

		this.info = this.adminLogicService.login(admin);

		if (admin.getId() != null)// 登录成功
		{
			ActionContext.getContext().getSession().put("admin", admin);
		}
		return SUCCESS;
	}
}
