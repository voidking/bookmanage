package com.voidking.book.bookkind.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.voidking.book.entity.BookKind;
import com.voidking.book.logic.BookKindLogicService;

@Controller
@Namespace("/bookKind")
@ParentPackage("custom-default")
public class BookKindFindAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2715737583641398282L;

	@Autowired
	private BookKindLogicService bookKindLogicService;

	private BookKind bookKind;
	private Long bookKindId;

	public BookKind getBookKind() {
		return bookKind;
	}

	public void setBookKind(BookKind bookKind) {
		this.bookKind = bookKind;
	}

	public Long getBookKindId() {
		return bookKindId;
	}

	public void setBookKindId(Long bookKindId) {
		this.bookKindId = bookKindId;
	}

	@Action(value = "bookKindFind", results = { @Result(name = "success", type = "json") })
	public String newsKindFind() throws Exception {
		this.bookKind = this.bookKindLogicService.bookKindFind(bookKindId);
		return SUCCESS;
	}

}
