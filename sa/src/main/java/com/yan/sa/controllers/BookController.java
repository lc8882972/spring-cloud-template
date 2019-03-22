package com.yan.sa.controllers;

import com.yan.sa.entities.Book;
import com.yan.sa.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookService service;

    @GetMapping(path = "/book")
    public Iterable<Book> get() {
        return  service.findAll();
    }

    @GetMapping(path = "/book/{id}")
    public Optional<Book> get(@PathVariable long id) {
        return  service.findById(id);
    }

    @PostMapping(path = "/book")
    public String post() {

        Book b =  new Book();
        b.setName("hello");
        service.create(b);
        return "ok";
    }
}
