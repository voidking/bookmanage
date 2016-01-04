package com.voidking.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.voidking.book.entity.BookKind;
import com.voidking.book.service.BookKindService;

@Service
public class BookKindServiceImpl extends BaseServiceImpl<BookKind, Long> implements BookKindService
{
	
	@Autowired
	@Override
	public void setJpaRepository(JpaRepository<BookKind, Long> bookKindRepository) {
		super.repository = bookKindRepository;
	}
	
}