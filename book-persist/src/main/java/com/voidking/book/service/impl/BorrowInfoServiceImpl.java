package com.voidking.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.voidking.book.entity.BorrowInfo;
import com.voidking.book.service.BorrowInfoService;

@Service
public class BorrowInfoServiceImpl extends BaseServiceImpl<BorrowInfo, Long> implements BorrowInfoService
{
	
	@Autowired
	@Override
	public void setJpaRepository(JpaRepository<BorrowInfo, Long> borrowInfoRepository) {
		super.repository = borrowInfoRepository;
	}
	
}