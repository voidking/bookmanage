package com.voidking.book.bookkind.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.voidking.book.entity.Admin;
import com.voidking.book.logic.BookKindLogicService;

@Controller
@Namespace("/bookKind")
@ParentPackage("custom-default")
public class BookKindDeleteAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7917795440933529815L;

	@Autowired
	private BookKindLogicService bookKindLogicService;
	
	private Long bookKindId;
	private String info;
	public Long getBookKindId() {
		return bookKindId;
	}
	public void setBookKindId(Long bookKindId) {
		this.bookKindId = bookKindId;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	@Action(value="bookKindDelete",results={@Result(name="success",type="json")})
	public String bookKindDelete() throws Exception
	{
		Admin admin = (Admin)ActionContext.getContext().getSession().get("admin");
		this.bookKindLogicService.bookKindDelete(bookKindId, admin);
		return SUCCESS;
	}
	
}
