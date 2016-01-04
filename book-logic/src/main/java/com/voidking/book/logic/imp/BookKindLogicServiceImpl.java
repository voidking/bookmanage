package com.voidking.book.logic.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voidking.book.entity.Admin;
import com.voidking.book.entity.BookKind;
import com.voidking.book.logic.BookKindLogicService;
import com.voidking.book.service.AdminService;
import com.voidking.book.service.BookKindService;

@Service
public class BookKindLogicServiceImpl implements BookKindLogicService {

	@Autowired
	private BookKindService bookKindService;

	@Autowired
	private AdminService adminService;

	public List<BookKind> bookKindList() {
		return this.bookKindService.findAll();
	}

	public String bookKindAdd(BookKind bookKind, Admin admin) {
		if (admin == null) {
			return "管理员未登录";
		}
		if (bookKind == null) {
			return "书籍种类信息错误";
		}
		this.bookKindService.save(bookKind);
		return "成功添加书籍种类" + bookKind.getName();
	}

	public String bookKindDelete(Long bookKindId, Admin admin) {
		if (admin == null) {
			return "管理员未登录";
		}
		// 检查登录管理员的信息
		if (admin.getId() == null
				|| !this.adminService.isExists(admin.getId())) {
			return "非法管理员";
		}
		if (!this.bookKindService.isExists(bookKindId) || bookKindId == null) {
			return "书籍种类不存在";
		}
		this.bookKindService.delete(bookKindId);
		return "成功删除书籍种类" + bookKindId;

	}

	public String bookKindUpdate(BookKind bookKind, Admin admin) {
		if (admin == null) {
			return "管理员未登录";
		}
		if (bookKind == null) {
			return "输入书籍种类信息错误";
		}
		
		BookKind temp = this.bookKindService.findOne(bookKind.getId());
		temp.setName(bookKind.getName());
		temp.setKeyword(bookKind.getKeyword());
		temp.setNotice(bookKind.getNotice());
		this.bookKindService.save(temp);
		return "成功修改书籍种类信息";
	}

	public BookKind bookKindFind(Long bookKindId) {
		if (bookKindId == null) {
			return null;
		}
		return this.bookKindService.findOne(bookKindId);
	}

}
