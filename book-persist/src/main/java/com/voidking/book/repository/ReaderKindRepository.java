package com.voidking.book.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voidking.book.entity.ReaderKind;

@Repository
public interface ReaderKindRepository extends JpaRepository<ReaderKind,Long>{

}
