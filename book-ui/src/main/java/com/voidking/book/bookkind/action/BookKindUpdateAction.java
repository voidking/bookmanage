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
import com.voidking.book.entity.BookKind;
import com.voidking.book.logic.BookKindLogicService;
@Controller
@Namespace("/bookKind")
@ParentPackage("custom-default")
public class BookKindUpdateAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 39943438539420176L;

	@Autowired
	private BookKindLogicService bookKindLogicService;
	
	private BookKind bookKind;
	private String info;
	
	public BookKind getBookKind() {
		return bookKind;
	}
	public void setBookKind(BookKind bookKind) {
		this.bookKind = bookKind;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	@Action(value="bookKindUpdate",results={@Result(name="success",type="json")})
	public String bookKindUpdate() throws Exception
	{
		Admin admin =(Admin) ActionContext.getContext().getSession().get("admin"); 
		this.info=this.bookKindLogicService.bookKindUpdate( bookKind, admin);
		return SUCCESS;
	}

}
