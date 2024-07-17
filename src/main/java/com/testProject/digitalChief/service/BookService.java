package com.testProject.digitalChief.service;

import com.testProject.digitalChief.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBook();
    Book addBook(Book book);
    void deleteBook(long id);
    Book updateBook(long id, Book updateBook);
    Book getBookById(long id);
}
