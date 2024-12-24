package com.abhi.library.service;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.abhi.library.model.Book;

@SpringBootTest
public class BookServiceTests {
    @Autowired
    private BookService bookService;

    @Test
    public void testaddBook() {
        Book book = new Book();
        book.setTitle("testTitle");
        book.setAuthor("testAuthor");
        book.setAvailable(true);
        Book savedBook = bookService.addBook(book);
        assertNotNull(savedBook);
        assertNotEquals(0, savedBook.getId());
    }
}
