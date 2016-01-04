package com.voidking.book.bookbase.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.voidking.book.entity.Admin;
import com.voidking.book.logic.BookBaseLogicService;

@Controller
@Namespace("/bookBase")
@ParentPackage("custom-default")
public class BookBaseDeleteAction extends ActionSupport{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -956982432672965888L;

	@Autowired
	private BookBaseLogicService bookBaseLogicService;
	
	private Long bookBaseId;
	private String info;
	public Long getBookBaseId() {
		return bookBaseId;
	}
	public void setBookBaseId(Long bookBaseId) {
		this.bookBaseId = bookBaseId;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	@Action(value="bookBaseDelete",results={@Result(name="success",type="json")})
	public String bookBaseDelete() throws Exception
	{
		Admin admin = (Admin)ActionContext.getContext().getSession().get("admin");
		this.bookBaseLogicService.bookBaseDelete(bookBaseId, admin);
		return SUCCESS;
	}
	
}
