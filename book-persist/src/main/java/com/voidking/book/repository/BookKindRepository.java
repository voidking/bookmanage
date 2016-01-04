package com.voidking.book.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voidking.book.entity.BookKind;

@Repository
public interface BookKindRepository extends JpaRepository<BookKind,Long>{

}
