package com.testProject.digitalChief.service;

import com.testProject.digitalChief.model.BookStore;

import java.util.List;

public interface BookStoreService {
    List<BookStore> getAllBookStores();
    BookStore addBookStore(BookStore bookStore);
    void deleteBookStore(long id);
    BookStore updateBookStore(long id, BookStore updateBookStore);
    BookStore getBookStoreById(long id);
}
