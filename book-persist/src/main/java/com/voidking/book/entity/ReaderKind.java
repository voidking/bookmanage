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
 *ReaderKind
 * 
 */

@Entity
@Table(name = "readerkind")
public class ReaderKind {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 20, nullable = false)
	private String name;
	
	private Integer quantity;//可借阅数量
	
	private Integer validity;//借书期限
	
	@Column(length=50,nullable=true)
	private String enddate;//有效期限
	
	@Lob
	private String notice;//备注

	@OneToMany(cascade=CascadeType.ALL,mappedBy="readerkind")
	private Set<ReaderBase> readerbases;
	
	

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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getValidity() {
		return validity;
	}

	public void setValidity(Integer validity) {
		this.validity = validity;
	}

	

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public Set<ReaderBase> getReaderbases() {
		return readerbases;
	}

	public void setReaderbases(Set<ReaderBase> readerbases) {
		this.readerbases = readerbases;
	}
	
	
	
}
