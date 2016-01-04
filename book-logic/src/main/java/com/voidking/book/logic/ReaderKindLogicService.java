package com.voidking.book.logic;

import java.util.List;

import com.voidking.book.entity.Admin;
import com.voidking.book.entity.ReaderKind;

public interface ReaderKindLogicService {
	
	String readerKindAdd(ReaderKind readerKind,Admin admin);
	String readerKindDelete(Long readerKindId,Admin admin);
	List<ReaderKind> readerKindList();
	ReaderKind readerKindFind(Long readerKindId);
	String readerKindUpdate(ReaderKind readerKind,Admin admin);

}
