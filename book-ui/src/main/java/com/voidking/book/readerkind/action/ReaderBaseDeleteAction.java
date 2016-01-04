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
import com.voidking.book.logic.ReaderBaseLogicService;

@Controller
@Namespace("/readerBase")
@ParentPackage("custom-default")
public class ReaderBaseDeleteAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6266228430561577739L;

	@Autowired
	private ReaderBaseLogicService readerBaseLogicService;
	
	private Long readerBaseId;
	private String info;
	public Long getReaderBaseId() {
		return readerBaseId;
	}
	public void setReaderBaseId(Long readerBaseId) {
		this.readerBaseId = readerBaseId;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	@Action(value="readerBaseDelete",results={@Result(name="success",type="json")})
	public String readerBaseDelete() throws Exception
	{
		Admin admin = (Admin)ActionContext.getContext().getSession().get("admin");
		this.readerBaseLogicService.readerBaseDelete(readerBaseId, admin);
		return SUCCESS;
	}
	
}
