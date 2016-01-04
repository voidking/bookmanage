package com.voidking.book.logic.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voidking.book.entity.Admin;
import com.voidking.book.entity.BorrowInfo;
import com.voidking.book.logic.BorrowInfoLogicService;
import com.voidking.book.service.AdminService;
import com.voidking.book.service.BorrowInfoService;

@Service
public class BorrowInfoLogicServiceImpl implements BorrowInfoLogicService {

	@Autowired
	private BorrowInfoService borrowInfoService;
	
	@Autowired
	private AdminService adminService;

	public List<BorrowInfo> borrowInfoList() {
		return this.borrowInfoService.findAll();
	}

	public String borrowInfoAdd(BorrowInfo borrowInfo, Admin admin) {
		if(admin==null)
		{
			return "管理员未登录";
		}
		if(borrowInfo==null)
		{
			return "借阅信息输入错误";
		}
		this.borrowInfoService.save(borrowInfo);
		return "成功添加借阅信息";
	}

	public String borrowInfoDelete(Long borrowInfoId, Admin admin) {
		if(admin==null)
		{
			return "管理员未登录";
		}
		if(borrowInfoId==null||this.borrowInfoService.findOne(borrowInfoId)==null)
		{
			return "借阅信息不存在";
		}

		this.borrowInfoService.delete(borrowInfoId);
		return "成功删除借阅信息";
	}

	public String borrowInfoUpdate(BorrowInfo borrowInfo,
			Admin admin) {
		if(admin==null)
		{
			return "管理员未登录";
		}
		if(borrowInfo==null)
		{
			return "输入借阅信息错误";
		}
		BorrowInfo temp = this.borrowInfoService.findOne(borrowInfo.getId());
		temp.setBookbaseid(borrowInfo.getBookbaseid());
		temp.setReaderbaseid(borrowInfo.getReaderbaseid());
		temp.setBorrowdate(borrowInfo.getBorrowdate());
		temp.setReturndate(borrowInfo.getReturndate());
		temp.setNotice(borrowInfo.getNotice());
		this.borrowInfoService.save(temp);
		
		return "成功修改借阅信息";
	}

	public BorrowInfo borrowInfoFind(Long borrowInfoId) {
		if(borrowInfoId==null)
		{
			return null;
		}
		return this.borrowInfoService.findOne(borrowInfoId);
	}

}
