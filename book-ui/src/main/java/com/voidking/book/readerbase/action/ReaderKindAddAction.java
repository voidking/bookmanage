package com.voidking.book.readerbase.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.voidking.book.entity.Admin;
import com.voidking.book.entity.ReaderKind;
import com.voidking.book.logic.ReaderKindLogicService;

@Controller
@Namespace("/readerKind")
@ParentPackage("custom-default")
public class ReaderKindAddAction extends ActionSupport{


	/**
	 * 
	 */
	private static final long serialVersionUID = -8641769682813015849L;

	@Autowired
	private ReaderKindLogicService readerKindLogicService;
	
	private ReaderKind readerKind;
	private String info;
	public ReaderKind getReaderKind() {
		return readerKind;
	}
	public void setReaderKind(ReaderKind readerKind) {
		this.readerKind = readerKind;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	@Action(value="readerKindAdd",results={@Result(name="success",type="json")})
	public String readerKindAdd() throws Exception
	{
		Admin admin = (Admin) ActionContext.getContext().getSession().get("admin");
		this.info=this.readerKindLogicService.readerKindAdd(readerKind,admin);
		return SUCCESS;
		
	}

}
