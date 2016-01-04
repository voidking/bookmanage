package com.voidking.book.readerbase.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.voidking.book.entity.ReaderKind;
import com.voidking.book.logic.ReaderKindLogicService;

@Controller
@Namespace("/readerKind")
@ParentPackage("custom-default")
public class ReaderKindFindAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1040858953222536854L;

	@Autowired
	private ReaderKindLogicService readerKindLogicService;
	
	private ReaderKind readerKind;
	private Long readerKindId;
	
	public ReaderKind getReaderKind() {
		return readerKind;
	}
	public void setReaderKind(ReaderKind readerKind) {
		this.readerKind = readerKind;
	}

	
	public Long getReaderKindId() {
		return readerKindId;
	}
	public void setReaderKindId(Long readerKindId) {
		this.readerKindId = readerKindId;
	}
	@Action(value="readerKindFind",results={@Result(name="success",type="json")})
	public String newsKindFind()throws Exception{
		this.readerKind=this.readerKindLogicService.readerKindFind(readerKindId);
		return SUCCESS;
	}

}
