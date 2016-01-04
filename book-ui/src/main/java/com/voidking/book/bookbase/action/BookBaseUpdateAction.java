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
import com.voidking.book.entity.BookBase;
import com.voidking.book.logic.BookBaseLogicService;
@Controller
@Namespace("/bookBase")
@ParentPackage("custom-default")
public class BookBaseUpdateAction extends ActionSupport {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4888998037293663011L;

	@Autowired
	private BookBaseLogicService bookBaseLogicService;
	
	private BookBase bookBase;
	private String info;
	
	public BookBase getBookBase() {
		return bookBase;
	}
	public void setBookBase(BookBase bookBase) {
		this.bookBase = bookBase;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	@Action(value="bookBaseUpdate",results={@Result(name="success",type="json")})
	public String bookBaseUpdate() throws Exception
	{
		Admin admin =(Admin) ActionContext.getContext().getSession().get("admin"); 
		this.info=this.bookBaseLogicService.bookBaseUpdate(bookBase, admin);
		return SUCCESS;
	}

}
