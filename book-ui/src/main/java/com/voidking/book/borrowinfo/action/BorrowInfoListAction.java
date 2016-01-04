package com.voidking.book.borrowinfo.action;

import java.util.List;

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
public class BorrowInfoListAction extends ActionSupport {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -3544407193036918477L;

	@Autowired 
	private BorrowInfoLogicService borrowInfoLogicService;
	
	private List<BorrowInfo> borrowInfos;
	
	
	public List<BorrowInfo> getBorrowInfos() {
		return borrowInfos;
	}


	public void setBorrowInfos(List<BorrowInfo> borrowInfos) {
		this.borrowInfos = borrowInfos;
	}


	@Action(value="borrowInfoList",results={@Result(name="success",type="json")})
	public String borrowInfoList() throws Exception
	{
		borrowInfos=this.borrowInfoLogicService.borrowInfoList();
		return SUCCESS;
	}
}
