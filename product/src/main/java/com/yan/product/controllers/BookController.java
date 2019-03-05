package com.yan.product.controllers;

import com.yan.product.dtos.PostBookDTO;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(description = "books", tags = "restful")
@RestController
public class BookController {

    @ApiOperation(value = "获取books列表")
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    List<PostBookDTO> list() {
        List<PostBookDTO> books = new ArrayList<>();
        return books;
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    String get(@PathVariable("id") int bookId) {
        return "bookid = " + bookId;
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public String post(@RequestBody PostBookDTO dto) {
        return dto.getBookName();
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
    public String put(@PathVariable Integer bookId) {
        return "put() ";
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.PATCH)
    public String patch(@PathVariable Integer bookId) {
        return "put() ";
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer bookId) {
        return "delete() ";
    }
}
