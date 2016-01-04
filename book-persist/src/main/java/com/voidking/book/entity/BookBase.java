package com.voidking.book.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * BookBase
 * 
 */

@Entity
@Table(name="bookbase")
public class BookBase {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(length=100,nullable=false)
	private String name;
	
	@Column(length=100,nullable=false)
	private String author;
	
	@Column(length=100,nullable=false)
	private String press;
	
	@Column(length=50,nullable=true)
	private String publishdate;
	
	private Float price;
	
	private Integer page;

	@Column(length=100,nullable=true)
	private String keyword;
	
	@Column(length=50,nullable=true)
	private String registerdate;
	
	@Column(length=2,nullable=false)
	private String borrowed;
	
	@Lob
	private String notice;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="bookkind")
	private BookKind bookkind;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	

	public String getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getRegisterdate() {
		return registerdate;
	}

	public void setRegisterdate(String registerdate) {
		this.registerdate = registerdate;
	}

	public String getBorrowed() {
		return borrowed;
	}

	public void setBorrowed(String borrowed) {
		this.borrowed = borrowed;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public BookKind getBookkind() {
		return bookkind;
	}

	public void setBookkind(BookKind bookkind) {
		this.bookkind = bookkind;
	}
	
}
