package com.voidking.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.voidking.book.entity.ReaderBase;
import com.voidking.book.service.ReaderBaseService;

@Service
public class ReaderBaseServiceImpl extends BaseServiceImpl<ReaderBase, Long> implements ReaderBaseService
{
	
	@Autowired
	@Override
	public void setJpaRepository(JpaRepository<ReaderBase, Long> readerBaseRepository) {
		super.repository = readerBaseRepository;
	}
	
}