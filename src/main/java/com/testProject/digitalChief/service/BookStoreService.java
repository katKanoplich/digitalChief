package com.testProject.digitalChief.service;

import com.testProject.digitalChief.dto.BookStoreRequest;
import com.testProject.digitalChief.dto.BookStoreResponse;
import com.testProject.digitalChief.model.BookStore;

import java.util.List;

public interface BookStoreService {
    List<BookStoreResponse> getAllBookStores();
    void createBookStore(BookStoreRequest bookStoreRequest);
    void deleteBookStore(long id);
    BookStoreResponse updateBookStore(Long id, BookStoreRequest updateProductRequest);
    BookStoreResponse getBookStoreById(long id);
}
