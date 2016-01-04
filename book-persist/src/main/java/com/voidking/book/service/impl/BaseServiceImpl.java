package com.voidking.book.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.voidking.book.service.BaseService;

public class BaseServiceImpl<T,ID extends Serializable> implements BaseService<T, ID>
{
	protected JpaRepository<T, ID> repository;
	
	public boolean isExists(ID id) {
		
		return repository.exists(id);
	}

	public T save(T t) {
		
		return repository.save(t);
	}

	public void setJpaRepository(JpaRepository<T, ID> repository) {
		
		this.repository = repository;
	}

	public void delete(ID id) {
		
		this.repository.delete(id);
	}

	public void delete(T t) {
		
		this.repository.delete(t);
		
	}

	public List<T> findAll() {
		
		return this.repository.findAll();
	}

	public Page<T> findAll(Pageable pageable) {
		
		return this.repository.findAll(pageable);
	}

	public long count() {
		
		return this.repository.count();
	}

	public T findOne(ID id) {
		
		return this.repository.findOne(id);
	}

	public Page<T> findAll(int page, int size) {
		
		return this.repository.findAll(new PageRequest(page, size));
	}
}
