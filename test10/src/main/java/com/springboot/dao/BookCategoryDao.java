package com.springboot.dao;

import com.springboot.entity.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface BookCategoryDao extends JpaRepository<BookCategory, BigInteger> {
    List<BookCategory> findAll();
}
