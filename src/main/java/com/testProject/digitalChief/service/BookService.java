package com.testProject.digitalChief.service;

import com.testProject.digitalChief.dto.BookRequest;
import com.testProject.digitalChief.dto.BookResponse;
import com.testProject.digitalChief.model.Book;

import java.util.List;

public interface BookService {
    List<BookResponse> getAllBooks();
    void createBook(BookRequest bookRequest);
    void deleteBook(long id);
    BookResponse updateBook(Long id, BookRequest updateBookRequest);
    BookResponse getBookById(long id);
}
