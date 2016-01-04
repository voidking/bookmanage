package com.voidking.book.logic;

import java.util.List;

import com.voidking.book.entity.Admin;
import com.voidking.book.entity.BookKind;

public interface BookKindLogicService {
	
	String bookKindAdd(BookKind bookKind,Admin admin);
	String bookKindDelete(Long bookKindId,Admin admin);
	List<BookKind> bookKindList();
	BookKind bookKindFind(Long bookKindId);
	String bookKindUpdate(BookKind bookKind,Admin admin);

}
