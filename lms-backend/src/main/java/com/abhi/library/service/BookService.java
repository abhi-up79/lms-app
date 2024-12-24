package com.abhi.library.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.library.model.Book;
import com.abhi.library.model.BookList;
import com.abhi.library.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    private BookList books = new BookList();

    public BookList getAllBooks() {
        books.setBooks(bookRepository.findAll());
        return books;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book getBook(Long id) {
        Optional<Book> op = bookRepository.findById(id);
        if (op.isPresent()) {
            return op.get();
        }
        return null;
    }

    public void deleteBook(Long id) {
        Optional<Book> op = bookRepository.findById(id);
        if (op.isPresent()) {
            bookRepository.delete(op.get());
        }
    }
    
    public Book borrowBook(Long id) {
        Optional<Book> op = bookRepository.findById(id);
        if (op.isPresent()) {
            Book borrowedBook = op.get();
            borrowedBook.setAvailable(false);
            return bookRepository.save(borrowedBook);
        }
        return null;
    }
}
