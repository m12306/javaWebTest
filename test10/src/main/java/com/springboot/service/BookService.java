package com.springboot.service;

import com.springboot.dao.BookDao;
import com.springboot.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDao dao;

    public List<Book> queryBook(String id){
        return dao.queryBook(id);
    }
}
