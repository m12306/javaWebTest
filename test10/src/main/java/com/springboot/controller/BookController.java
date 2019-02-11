package com.springboot.controller;

import com.springboot.dao.BookDao;
import com.springboot.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookDao bookDao;

    @PostMapping("")
    public List<Book> queryBook(String id){
        return bookDao.queryBook(id);
    }
}
