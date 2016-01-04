package com.voidking.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voidking.book.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long>{
	Admin findByNameAndPwd(String name,String pwd);
}
