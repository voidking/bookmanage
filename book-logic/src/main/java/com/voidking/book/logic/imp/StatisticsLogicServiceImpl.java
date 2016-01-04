package com.voidking.book.logic.imp;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voidking.book.entity.BookBase;
import com.voidking.book.entity.BookKind;
import com.voidking.book.logic.StatisticsLogicService;
import com.voidking.book.service.AdminService;
import com.voidking.book.service.BookBaseService;
import com.voidking.book.service.BookKindService;

@Service
public class StatisticsLogicServiceImpl implements StatisticsLogicService {

	@Autowired
	private BookKindService bookKindService;
	@Autowired
	private BookBaseService bookBaseService;
	@Autowired
	private AdminService adminService;

	public String scaleBookKind() {
		List<BookKind> bookKinds = this.bookKindService.findAll();
		String result = "";
		int sum = 0;
		for (BookKind bookKind : bookKinds) {
			sum += bookKind.getBookbases().size();
		}
		
		for (BookKind bookKind : bookKinds) {
			int size=bookKind.getBookbases().size();			
			result += bookKind.getName()
					+ " 占图书比例为 "
					+round(1.0*size/sum, 2, BigDecimal.ROUND_CEILING)+"     ";
		}
		System.out.println(result);
		return result;
	}

	public String scaleBorrowInfo() {
		List<BookBase> bookBases = this.bookBaseService.findAll();
		String result = "";
		int sum = bookBases.size();
		int borrowed = 0, notborrowed = 0;
		for (BookBase bookBase : bookBases) {
			if (("是").equals(bookBase.getBorrowed())) {
				borrowed++;
			} else if (("否").equals(bookBase.getBorrowed())) {
				notborrowed++;
			}
		}
		result = "书籍总量为" + sum + "本，库存" + notborrowed + "本，借出" +borrowed + "本。库存和借出比例为"+round(1.0*notborrowed/sum, 2, BigDecimal.ROUND_CEILING)+":"+round(1.0*borrowed/sum, 2, BigDecimal.ROUND_CEILING);
		System.out.println(result);
		return result;
	}
	
	public static double round(double value, int scale, int roundingMode) {  
        BigDecimal bd = new BigDecimal(value);  
        bd = bd.setScale(scale, roundingMode);  
        double d = bd.doubleValue();  
        bd = null;  
        return d;  
    }  
}
