package com.voidking.book.logic;

import java.util.List;

import com.voidking.book.entity.BookBase;


public interface SearchLogicService {
	
	List<BookBase> findByName(String name);
	List<BookBase> findByAuthor(String author);
	List<BookBase> findByPress(String press);	
}
