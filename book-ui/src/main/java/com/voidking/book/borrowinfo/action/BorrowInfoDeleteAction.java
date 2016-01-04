package com.voidking.book.borrowinfo.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.voidking.book.entity.Admin;
import com.voidking.book.logic.BorrowInfoLogicService;

@Controller
@Namespace("/borrowInfo")
@ParentPackage("custom-default")
public class BorrowInfoDeleteAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4851465311610136923L;

	@Autowired
	private BorrowInfoLogicService borrowInfoLogicService;
	
	private Long borrowInfoId;
	private String info;
	public Long getBorrowInfoId() {
		return borrowInfoId;
	}
	public void setBorrowInfoId(Long borrowInfoId) {
		this.borrowInfoId = borrowInfoId;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	@Action(value="borrowInfoDelete",results={@Result(name="success",type="json")})
	public String borrowInfoDelete() throws Exception
	{
		Admin admin = (Admin)ActionContext.getContext().getSession().get("admin");
		this.borrowInfoLogicService.borrowInfoDelete(borrowInfoId, admin);
		return SUCCESS;
	}
	
}
