package com.voidking.book.logic;

import java.util.List;

import com.voidking.book.entity.Admin;
import com.voidking.book.entity.ReaderBase;

public interface ReaderBaseLogicService {
	
	String readerBaseAdd(ReaderBase readerBase,Admin admin);
	String readerBaseDelete(Long readerBaseId,Admin admin);
	List<ReaderBase> readerBaseList();
	ReaderBase readerBaseFind(Long readerBaseId);
	String readerBaseUpdate(ReaderBase readerBase,Admin admin);

}
