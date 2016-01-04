package com.voidking.book.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voidking.book.entity.BorrowInfo;

@Repository
public interface BorrowInfoRepository extends JpaRepository<BorrowInfo,Long>{

}
