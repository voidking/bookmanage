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
public class ReaderBaseAddAction extends ActionSupport{

	private static final long serialVersionUID = 1327364795509828982L;

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
	
	@Action(value="readerBaseAdd",results={@Result(name="success",type="json")})
	public String readerBaseAdd() throws Exception
	{
		Admin admin = (Admin) ActionContext.getContext().getSession().get("admin");
		this.info=this.readerBaseLogicService.readerBaseAdd(readerBase,admin);
		return SUCCESS;
		
	}

}
