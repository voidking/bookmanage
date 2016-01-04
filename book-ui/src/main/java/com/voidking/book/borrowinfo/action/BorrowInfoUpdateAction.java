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
import com.voidking.book.entity.BorrowInfo;
import com.voidking.book.logic.BorrowInfoLogicService;
@Controller
@Namespace("/borrowInfo")
@ParentPackage("custom-default")
public class BorrowInfoUpdateAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7027239974224635943L;

	@Autowired
	private BorrowInfoLogicService borrowInfoLogicService;
	
	private BorrowInfo borrowInfo;
	private String info;
	
	
	public BorrowInfo getBorrowInfo() {
		return borrowInfo;
	}
	public void setBorrowInfo(BorrowInfo borrowInfo) {
		this.borrowInfo = borrowInfo;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	@Action(value="borrowInfoUpdate",results={@Result(name="success",type="json")})
	public String borrowInfoUpdate() throws Exception
	{
		Admin admin =(Admin)ActionContext.getContext().getSession().get("admin");
		this.info=this.borrowInfoLogicService.borrowInfoUpdate(borrowInfo, admin);
		return SUCCESS;
	}
}
