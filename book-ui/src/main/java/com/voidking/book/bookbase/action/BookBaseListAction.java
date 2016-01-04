package com.voidking.book.bookbase.action;

import java.util.List;

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
public class BookBaseListAction extends ActionSupport {

	private static final long serialVersionUID = -5536714370492891954L;

	@Autowired 
	private BookBaseLogicService bookBaseLogicService;
	
	private List<BookBase> bookBases;
	
	
	public List<BookBase> getBookBases() {
		return bookBases;
	}


	public void setBookBases(List<BookBase> bookBases) {
		this.bookBases = bookBases;
	}


	@Action(value="bookBaseList",results={@Result(name="success",type="json")})
	public String bookBaseList() throws Exception
	{
		bookBases=this.bookBaseLogicService.bookBaseList();
		return SUCCESS;
	}
}
