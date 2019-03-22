package com.yan.sa.services;

import com.yan.sa.entities.Book;
import com.yan.sa.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository resp;

    public Optional<Book> findById(long id){
        return  resp.findById(id);
    }

    public Iterable<Book> findAll(){
        return  resp.findAll();
    }

    public  boolean create(Book entity){
        resp.save(entity);
        return true;
    }
}
