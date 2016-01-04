package com.voidking.book.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * BookKind
 * 
 */

@Entity
@Table(name = "bookkind")
public class BookKind {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 100, nullable = false)
	private String name;

	@Column(length = 100, nullable = true)
	private String keyword;

	@Lob
	private String notice;// 备注
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="bookkind")
	private Set<BookBase> bookbases;
	
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

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public Set<BookBase> getBookbases() {
		return bookbases;
	}

	public void setBookbases(Set<BookBase> bookbases) {
		this.bookbases = bookbases;
	}
	
	

}
