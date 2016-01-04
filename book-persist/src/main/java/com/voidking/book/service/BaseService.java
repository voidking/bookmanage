package com.voidking.book.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseService<T,ID extends Serializable> 
{
	public boolean isExists(ID id);
	
	public T save(T t);
	
	public void delete(ID id);
	
	public void delete(T t);
	
	public List<T> findAll();
	
	public Page<T> findAll(Pageable pageable);
	
	public Page<T> findAll(int page,int size);
	
	public long count();
	
	public T findOne(ID id);
	
	void setJpaRepository(JpaRepository<T, ID> repository);
}