package com.voidking.book.logic.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voidking.book.entity.BookBase;
import com.voidking.book.logic.SearchLogicService;
import com.voidking.book.service.BookBaseService;

@Service
public class SearchLogicServiceImpl implements SearchLogicService {

	@Autowired
	private BookBaseService bookBaseService;

	// 这个函数实际上做成了不止用书名搜索，用作者、出版社也可以
	public List<BookBase> findByName(String name) {
		List<BookBase> bookBases = this.bookBaseService.findAll();
		List<BookBase> deletes = new ArrayList<BookBase>();
		for (BookBase bookBase : bookBases) {
			if (!name.equals(bookBase.getName())
					&& !name.equals(bookBase.getAuthor())
					&& !name.equals(bookBase.getPress())
					&& !name.equals(bookBase.getBookkind().getName())
					&& !name.equals(bookBase.getKeyword())
					&& !name.equals(bookBase.getNotice())
					&& !name.equals(bookBase.getId())
					&& !name.equals(bookBase.getPrice())
					&& !name.equals(bookBase.getPublishdate())
					&& !name.equals(bookBase.getRegisterdate())) {
				deletes.add(bookBase);
			}
		}
		bookBases.removeAll(deletes);
		return bookBases;
	}

	public List<BookBase> findByAuthor(String author) {
		List<BookBase> bookBases = this.bookBaseService.findAll();
		List<BookBase> deletes = new ArrayList<BookBase>();
		for (BookBase bookBase : bookBases) {
			if (!author.equals(bookBase.getAuthor())) {
				deletes.add(bookBase);
			}
		}
		bookBases.removeAll(deletes);
		return bookBases;
	}

	public List<BookBase> findByPress(String press) {
		List<BookBase> bookBases = this.bookBaseService.findAll();
		List<BookBase> deletes = new ArrayList<BookBase>();
		for (BookBase bookBase : bookBases) {
			if (!press.equals(bookBase.getPress())) {
				deletes.add(bookBase);
			}
		}
		bookBases.removeAll(deletes);
		return bookBases;
	}

}
