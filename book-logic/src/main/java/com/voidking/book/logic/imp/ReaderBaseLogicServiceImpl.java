package com.voidking.book.logic.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voidking.book.entity.Admin;
import com.voidking.book.entity.ReaderBase;
import com.voidking.book.logic.ReaderBaseLogicService;
import com.voidking.book.service.ReaderBaseService;

@Service
public class ReaderBaseLogicServiceImpl implements ReaderBaseLogicService {

	@Autowired
	private ReaderBaseService readerBaseService;

	public List<ReaderBase> readerBaseList() {
		return this.readerBaseService.findAll();
	}


	public String readerBaseAdd(ReaderBase readerBase, Admin admin) {
		if(admin==null)
		{
			return "管理员未登录";
		}
		if(readerBase==null)
		{
			return "输入读者信息错误";
		}
		this.readerBaseService.save(readerBase);
		return "成功添加读者信息";
	}

	public String readerBaseDelete(Long readerBaseId, Admin admin) {
		if(admin==null)
		{
			return "管理员未登录";
		}
		if(readerBaseId==null||this.readerBaseService.findOne(readerBaseId)==null)
		{
			return "被删除读者信息不存在";
		}
		this.readerBaseService.delete(readerBaseId);
		return "成功删除读者信息";
	}

	public String readerBaseUpdate(ReaderBase readerBase,
			Admin admin) {
		if(admin==null)
		{
			return "管理员未登录";
		}
		if(readerBase==null)
		{
			
			return "输入读者信息错误";
		}
		ReaderBase temp=this.readerBaseService.findOne(readerBase.getId());
		temp.setName(readerBase.getName());
		temp.setReaderkind(readerBase.getReaderkind());
		temp.setSex(readerBase.getSex());
		temp.setWork(readerBase.getWork());
		temp.setAddress(readerBase.getAddress());
		temp.setTelephone(readerBase.getTelephone());
		temp.setEmail(readerBase.getEmail());
		temp.setRegisterdate(readerBase.getRegisterdate());
		temp.setNotice(readerBase.getNotice());
		
		this.readerBaseService.save(temp);
		return "成功修改读者信息";
	}


	public ReaderBase readerBaseFind(Long readerBaseId) {
		if(readerBaseId==null)
		{
			return null;
		}
		return this.readerBaseService.findOne(readerBaseId);
	}

}
