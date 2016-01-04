package com.voidking.book.readerkind.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.voidking.book.entity.Admin;
import com.voidking.book.entity.ReaderBase;
import com.voidking.book.logic.ReaderBaseLogicService;
@Controller
@Namespace("/readerBase")
@ParentPackage("custom-default")
public class ReaderBaseUpdateAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2522887796406283492L;
	
	@Autowired
	private ReaderBaseLogicService readerBaseLogicService;
	
	private ReaderBase readerBase;
	private String info;
	
	public ReaderBase getReaderBase() {
		return readerBase;
	}
	public void setReaderBase(ReaderBase readerBase) {
		this.readerBase = readerBase;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	@Action(value="readerBaseUpdate",results={@Result(name="success",type="json")})
	public String readerBaseUpdate() throws Exception
	{
		Admin admin =(Admin) ActionContext.getContext().getSession().get("admin"); 
		this.info=this.readerBaseLogicService.readerBaseUpdate(readerBase, admin);
		return SUCCESS;
	}

}
