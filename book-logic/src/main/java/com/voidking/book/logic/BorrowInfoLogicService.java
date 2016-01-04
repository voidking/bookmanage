package com.voidking.book.logic;

import java.util.List;

import com.voidking.book.entity.Admin;
import com.voidking.book.entity.BorrowInfo;

public interface BorrowInfoLogicService {
	
	String borrowInfoAdd(BorrowInfo borrowInfo,Admin admin);
	String borrowInfoDelete(Long borrowInfoId,Admin admin);
	List<BorrowInfo> borrowInfoList();
	BorrowInfo borrowInfoFind(Long borrowInfoId);
	String borrowInfoUpdate(BorrowInfo borrowInfo,Admin admin);

}
