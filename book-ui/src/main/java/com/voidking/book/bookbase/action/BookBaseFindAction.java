package com.voidking.book.bookbase.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.voidking.book.entity.BookBase;
import com.voidking.book.logic.BookBaseLogicService;

@Controller
@Namespace("/bookBase")
@ParentPackage("custom-default")
public class BookBaseFindAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7476989868796794670L;

	@Autowired
	private BookBaseLogicService bookBaseLogicService;
	
	private BookBase bookBase;
	private Long bookBaseId;
	
	public BookBase getBookBase() {
		return bookBase;
	}
	public void setBookBase(BookBase bookBase) {
		this.bookBase = bookBase;
	}

	
	public Long getBookBaseId() {
		return bookBaseId;
	}
	public void setBookBaseId(Long bookBaseId) {
		this.bookBaseId = bookBaseId;
	}
	@Action(value="bookBaseFind",results={@Result(name="success",type="json")})
	public String newsKindFind()throws Exception{
		this.bookBase=this.bookBaseLogicService.bookBaseFind(bookBaseId);
		return SUCCESS;
	}

}
