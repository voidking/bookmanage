package com.voidking.book.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * BorrowInfo
 *
 */

@Entity
@Table(name="borrowinfo")
public class BorrowInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(length=50,nullable=true)
	private String borrowdate;
	
	@Column(length=50,nullable=true)
	private String returndate;
	
	@Lob
	private String notice;
	
	private Long readerbaseid;
	
	private Long bookbaseid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getBorrowdate() {
		return borrowdate;
	}

	public void setBorrowdate(String borrowdate) {
		this.borrowdate = borrowdate;
	}

	public String getReturndate() {
		return returndate;
	}

	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public Long getReaderbaseid() {
		return readerbaseid;
	}

	public void setReaderbaseid(Long readerbaseid) {
		this.readerbaseid = readerbaseid;
	}

	public Long getBookbaseid() {
		return bookbaseid;
	}

	public void setBookbaseid(Long bookbaseid) {
		this.bookbaseid = bookbaseid;
	}
	
}
