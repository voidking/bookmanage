package com.voidking.book.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voidking.book.entity.BookBase;

@Repository
public interface BookBaseRepository extends JpaRepository<BookBase,Long>{

}
