package com.abhi.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.library.model.Book;
import com.abhi.library.model.BookList;
import com.abhi.library.service.BookService;

@RestController
@RequestMapping("/api/books")
public class Controller {
    @Autowired
    private BookService bookService;

    @GetMapping
    public BookList getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book retrieveBook(@PathVariable("id") Long id) {
        return bookService.getBook(id);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @DeleteMapping("/{id}")
    public void deletebook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
}
