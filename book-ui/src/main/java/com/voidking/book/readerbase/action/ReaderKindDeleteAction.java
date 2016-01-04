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
import com.voidking.book.logic.ReaderKindLogicService;

@Controller
@Namespace("/readerKind")
@ParentPackage("custom-default")
public class ReaderKindDeleteAction extends ActionSupport{


	/**
	 * 
	 */
	private static final long serialVersionUID = 3730130641857468049L;

	@Autowired
	private ReaderKindLogicService readerKindLogicService;
	
	private Long readerKindId;
	private String info;
	public Long getReaderKindId() {
		return readerKindId;
	}
	public void setReaderKindId(Long readerKindId) {
		this.readerKindId = readerKindId;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	@Action(value="readerKindDelete",results={@Result(name="success",type="json")})
	public String readerKindDelete() throws Exception
	{
		Admin admin = (Admin)ActionContext.getContext().getSession().get("admin");
		this.readerKindLogicService.readerKindDelete(readerKindId, admin);
		return SUCCESS;
	}
	
}
