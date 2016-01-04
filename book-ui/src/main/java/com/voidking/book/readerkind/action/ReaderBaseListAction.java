package com.voidking.book.readerkind.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.voidking.book.entity.ReaderBase;
import com.voidking.book.logic.ReaderBaseLogicService;

@Controller
@Namespace("/readerBase")
@ParentPackage("custom-default")
public class ReaderBaseListAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1339146120617398396L;

	@Autowired 
	private ReaderBaseLogicService readerBaseLogicService;
	
	private List<ReaderBase> readerBases;
	
	
	public List<ReaderBase> getReaderBases() {
		return readerBases;
	}


	public void setReaderBases(List<ReaderBase> readerBases) {
		this.readerBases = readerBases;
	}


	@Action(value="readerBaseList",results={@Result(name="success",type="json")})
	public String readerBaseList() throws Exception
	{
		readerBases=this.readerBaseLogicService.readerBaseList();
		return SUCCESS;
	}
}
