package com.voidking.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.voidking.book.entity.ReaderKind;
import com.voidking.book.service.ReaderKindService;

@Service
public class ReaderKindServiceImpl extends BaseServiceImpl<ReaderKind, Long> implements ReaderKindService
{
	
	@Autowired
	@Override
	public void setJpaRepository(JpaRepository<ReaderKind, Long> readerKindRepository) {
		super.repository = readerKindRepository;
	}
	
}