package com.voidking.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.voidking.book.entity.BookBase;
import com.voidking.book.service.BookBaseService;

@Service
public class BookBaseServiceImpl extends BaseServiceImpl<BookBase, Long> implements BookBaseService
{
	
	@Autowired
	@Override
	public void setJpaRepository(JpaRepository<BookBase, Long> bookBaseRepository) {
		super.repository = bookBaseRepository;
	}
	
}