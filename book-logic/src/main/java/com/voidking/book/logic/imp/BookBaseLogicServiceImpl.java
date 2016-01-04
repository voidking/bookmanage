package com.voidking.book.logic.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voidking.book.entity.Admin;
import com.voidking.book.entity.BookBase;
import com.voidking.book.logic.BookBaseLogicService;
import com.voidking.book.service.AdminService;
import com.voidking.book.service.BookBaseService;

@Service
public class BookBaseLogicServiceImpl implements BookBaseLogicService {
	
	@Autowired
	private BookBaseService bookBaseService;
	
	@Autowired 
	private AdminService adminService;

	public List<BookBase> bookBaseList() {
		return this.bookBaseService.findAll();
	}


	public String bookBaseAdd(BookBase bookBase, Admin admin) {
		if(admin==null)
		{
			return "管理员未登录";
		}
		if(bookBase==null)
		{
			return "输入数据错误";
		}
		this.bookBaseService.save(bookBase);
		return "成功添加书籍"+bookBase.getName();
	}

	public String bookBaseDelete(Long bookBaseId, Admin admin) {
		if(admin==null)
		{
			return "管理员未登录";
		}
		if(bookBaseId==null||this.bookBaseService.findOne(bookBaseId)==null)
		{
			return "书籍编号不存在";
		}
		this.bookBaseService.delete(bookBaseId);
		return "成功删除书籍"+bookBaseId;
	}

	public String bookBaseUpdate( BookBase bookBase,
			Admin admin) {
		if(admin==null)
		{
			return "管理员未登录";
		}
		if(bookBase==null)
		{
			return "输入书籍信息错误";
		}
		BookBase temp=this.bookBaseService.findOne(bookBase.getId());
		temp.setName(bookBase.getName());
		temp.setBookkind(bookBase.getBookkind());
		temp.setAuthor(bookBase.getAuthor());
		temp.setPress(bookBase.getPress());
		temp.setPublishdate(bookBase.getPublishdate());
		temp.setPrice(bookBase.getPrice());
		temp.setPage(bookBase.getPage());
		temp.setKeyword(bookBase.getKeyword());
		temp.setRegisterdate(bookBase.getRegisterdate());
		temp.setNotice(bookBase.getNotice());
		this.bookBaseService.save(temp);
		return "修改书籍信息成功";
	}


	public BookBase bookBaseFind(Long bookBaseId) {
		if(bookBaseId==null)
		{
			return null;
		}
		return this.bookBaseService.findOne(bookBaseId);
	}

}
