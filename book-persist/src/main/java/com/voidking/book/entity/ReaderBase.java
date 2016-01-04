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
 * ReaderBase
 */

@Entity
@Table(name = "readerbase")
public class ReaderBase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 20, nullable = false)
	private String name;
	
	@Column(length=2,nullable=false)
	private String sex;
	
	@Column(length=100,nullable=true)
	private String work;//工作单位
	
	@Column(length=200,nullable=true)
	private String address;
	
	@Column(length=11,nullable=true)
	private String telephone;
	
	@Column(length= 30,nullable=true)
	private String email;
	
	@Column(length=50,nullable=true)
	private String registerdate;
	
	@Lob
	private String notice;//备注
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="readerkind")
	private ReaderKind readerkind;
	
	

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public String getRegisterdate() {
		return registerdate;
	}

	public void setRegisterdate(String registerdate) {
		this.registerdate = registerdate;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public ReaderKind getReaderkind() {
		return readerkind;
	}

	public void setReaderkind(ReaderKind readerkind) {
		this.readerkind = readerkind;
	}
	
	
}
