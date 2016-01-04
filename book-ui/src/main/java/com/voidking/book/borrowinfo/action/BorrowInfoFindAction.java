package com.voidking.book.borrowinfo.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.voidking.book.entity.BorrowInfo;
import com.voidking.book.logic.BorrowInfoLogicService;

@Controller
@Namespace("/borrowInfo")
@ParentPackage("custom-default")
public class BorrowInfoFindAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6785198086128497185L;

	@Autowired
	private BorrowInfoLogicService borrowInfoLogicService;
	
	private BorrowInfo borrowInfo;
	private Long borrowInfoId;
	
	public BorrowInfo getBorrowInfo() {
		return borrowInfo;
	}
	public void setBorrowInfo(BorrowInfo borrowInfo) {
		this.borrowInfo = borrowInfo;
	}

	
	public Long getBorrowInfoId() {
		return borrowInfoId;
	}
	public void setBorrowInfoId(Long borrowInfoId) {
		this.borrowInfoId = borrowInfoId;
	}
	@Action(value="borrowInfoFind",results={@Result(name="success",type="json")})
	public String newsKindFind()throws Exception{
		this.borrowInfo=this.borrowInfoLogicService.borrowInfoFind(borrowInfoId);
		return SUCCESS;
	}

}
