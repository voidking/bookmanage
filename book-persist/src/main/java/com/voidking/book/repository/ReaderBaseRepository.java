package com.voidking.book.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voidking.book.entity.ReaderBase;

@Repository
public interface ReaderBaseRepository extends JpaRepository<ReaderBase,Long>{

}
