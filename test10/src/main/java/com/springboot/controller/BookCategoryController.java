package com.springboot.controller;

import com.springboot.entity.BookCategory;
import com.springboot.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class BookCategoryController {
    @Autowired
    private BookCategoryService service;

    @GetMapping("")
    public List<BookCategory> findAll(){
        return service.findAll();
    }

    @PostMapping("")
    public void saveBookCategory(BookCategory bookCategory){
        service.saveBookCategory(bookCategory);
    }
}
