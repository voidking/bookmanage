package com.voidking.book.logic.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voidking.book.entity.Admin;
import com.voidking.book.entity.ReaderKind;
import com.voidking.book.logic.ReaderKindLogicService;
import com.voidking.book.service.ReaderKindService;

@Service
public class ReaderKindLogicServiceImpl implements ReaderKindLogicService{

	@Autowired
	private ReaderKindService readerKindService;


	public List<ReaderKind> readerKindList() {
		return this.readerKindService.findAll();
	}


	public String readerKindAdd(ReaderKind readerKind, Admin admin) {
		if(admin==null)
		{
			return "管理员未登录";
		}
		if(readerKind==null)
		{
			return "输入读者种类信息错误";
		}
		this.readerKindService.save(readerKind);
		return "成功添加读者种类信息";
	}

	public String readerKindDelete(Long readerKindId, Admin admin) {
		if(admin==null)
		{
			return "管理员未登录";
		}
		if(readerKindId==null||readerKindId==null)
		{
			return "被删除读者种类不存在";
		}
		this.readerKindService.delete(readerKindId);
		return "成功删除读者种类";
	}

	public String readerKindUpdate(ReaderKind readerKind,
			Admin admin) {
		if(admin==null)
		{
			return "管理员未登录";
		}
		if(readerKind==null)
		{
			return "读者种类信息输入错误";
		}

		ReaderKind temp = this.readerKindService.findOne(readerKind.getId());
		temp.setName(readerKind.getName());
		temp.setQuantity(readerKind.getQuantity());
		temp.setValidity(readerKind.getValidity());
		temp.setEnddate(readerKind.getEnddate());
		temp.setNotice(readerKind.getNotice());
		this.readerKindService.save(readerKind);
		return "成功修改读者种类信息";
	}


	public ReaderKind readerKindFind(Long readerKindId) {
		if(readerKindId==null)
		{
			return null;
		}
		return this.readerKindService.findOne(readerKindId);
	}

}
