package com.voidking.book.search.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.voidking.book.entity.BookBase;
import com.voidking.book.logic.SearchLogicService;

@Controller
@Namespace("/search")
@ParentPackage("custom-default")
public class SearchAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5793417773798931929L;

	@Autowired
	private SearchLogicService searchLogicService;

	private String name;
	private String author;
	private String press;
	private List<BookBase> bookBases;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public List<BookBase> getBookBases() {
		return bookBases;
	}

	public void setBookBases(List<BookBase> bookBases) {
		this.bookBases = bookBases;
	}

	@Action(value = "findByName", results = { @Result(name = "success", type = "json") })
	public String findByName() throws Exception {
		this.bookBases = this.searchLogicService.findByName(name);
		return SUCCESS;
	}

	@Action(value = "findByAuthor", results = { @Result(name = "success", type = "json") })
	public String findByAuthor() throws Exception {
		this.bookBases = this.searchLogicService.findByAuthor(author);
		return SUCCESS;
	}
	
	@Action(value = "findByPress", results = { @Result(name = "success", type = "json") })
	public String findByPress() throws Exception {
		this.bookBases=this.searchLogicService.findByPress(press);
		return SUCCESS;
	}

}
