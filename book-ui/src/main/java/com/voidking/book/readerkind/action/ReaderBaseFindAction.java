package com.voidking.book.readerkind.action;

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
public class ReaderBaseFindAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 407385530270264903L;

	@Autowired
	private ReaderBaseLogicService readerBaseLogicService;
	
	private ReaderBase readerBase;
	private Long readerBaseId;
	
	public ReaderBase getReaderBase() {
		return readerBase;
	}
	public void setReaderBase(ReaderBase readerBase) {
		this.readerBase = readerBase;
	}

	
	public Long getReaderBaseId() {
		return readerBaseId;
	}
	public void setReaderBaseId(Long readerBaseId) {
		this.readerBaseId = readerBaseId;
	}
	@Action(value="readerBaseFind",results={@Result(name="success",type="json")})
	public String newsKindFind()throws Exception{
		this.readerBase=this.readerBaseLogicService.readerBaseFind(readerBaseId);
		return SUCCESS;
	}

}
