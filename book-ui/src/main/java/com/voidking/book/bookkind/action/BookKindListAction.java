package com.voidking.book.bookkind.action;

import java.util.List;

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
public class BookKindListAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 999642767747794588L;

	@Autowired 
	private BookKindLogicService bookKindLogicService;
	
	private List<BookKind> bookKinds;
	
	
	public List<BookKind> getBookKinds() {
		return bookKinds;
	}


	public void setBookKinds(List<BookKind> bookKinds) {
		this.bookKinds = bookKinds;
	}


	@Action(value="bookKindList",results={@Result(name="success",type="json")})
	public String bookKindList() throws Exception
	{
		this.bookKinds=this.bookKindLogicService.bookKindList();
		return SUCCESS;
	}
}
