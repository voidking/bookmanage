package com.voidking.book.statistics.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.voidking.book.logic.StatisticsLogicService;

@Controller
@Namespace("/statistics")
@ParentPackage("custom-default")
public class StatisticsAction extends ActionSupport {

	private static final long serialVersionUID = -6894193765943704903L;

	@Autowired
	private StatisticsLogicService statisticsLogicService;

	private String result1;
	private String result2;

	public String getResult1() {
		return result1;
	}

	public void setResult1(String result1) {
		this.result1 = result1;
	}

	public String getResult2() {
		return result2;
	}

	public void setResult2(String result2) {
		this.result2 = result2;
	}

	@Action(value = "statistics", results = { @Result(name = "success", type = "json") })
	public String statistics() throws Exception {
		this.result1 = this.statisticsLogicService.scaleBookKind();
		this.result2 = this.statisticsLogicService.scaleBorrowInfo();
		return SUCCESS;
	}

}
