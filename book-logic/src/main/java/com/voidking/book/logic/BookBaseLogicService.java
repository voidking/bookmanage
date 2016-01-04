package com.voidking.book.logic;

import java.util.List;

import com.voidking.book.entity.Admin;
import com.voidking.book.entity.BookBase;

public interface BookBaseLogicService {
	
	String bookBaseAdd(BookBase bookBase,Admin admin);
	String bookBaseDelete(Long bookBaseId,Admin admin);
	List<BookBase> bookBaseList();
	BookBase bookBaseFind(Long bookBaseId);
	String bookBaseUpdate(BookBase bookBase,Admin admin);

}
