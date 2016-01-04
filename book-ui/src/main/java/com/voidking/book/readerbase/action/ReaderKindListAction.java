package com.voidking.book.readerbase.action;

import java.util.List;

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
public class ReaderKindListAction extends ActionSupport {

	private static final long serialVersionUID = -2003177964374021064L;

	@Autowired 
	private ReaderKindLogicService readerKindLogicService;
	
	private List<ReaderKind> readerKinds;
	
	
	public List<ReaderKind> getReaderKinds() {
		return readerKinds;
	}


	public void setReaderKinds(List<ReaderKind> readerKinds) {
		this.readerKinds = readerKinds;
	}


	@Action(value="readerKindList",results={@Result(name="success",type="json")})
	public String readerKindList() throws Exception
	{
		readerKinds=this.readerKindLogicService.readerKindList();
		return SUCCESS;
	}
}
