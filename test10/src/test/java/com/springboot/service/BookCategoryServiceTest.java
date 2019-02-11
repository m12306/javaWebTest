package com.springboot.service;

import com.springboot.entity.BookCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class BookCategoryServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookCategoryService service;

    @Test
    public void findAll(){
        logger.debug(service.findAll().toString());
    }

    @Test
    public void saveBookCategory() {
        BookCategory bookCategory = new BookCategory();
        Timestamp time = new Timestamp(System.currentTimeMillis());
        bookCategory.setCategoryName("Java Web");
        bookCategory.setCreateTime(time);
        service.saveBookCategory(bookCategory);
    }
}