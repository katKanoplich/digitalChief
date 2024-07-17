package com.testProject.digitalChief.service.impl;

import com.testProject.digitalChief.model.Book;
import com.testProject.digitalChief.repository.BookRepository;
import com.testProject.digitalChief.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    public void deleteBook(long id){
        bookRepository.deleteById(id);
    }

    public Book addBook(Book book){
        bookRepository.save(book);
        return book;
    }
    public Book updateBook(long id,Book updateBook){
        updateBook.setId(id);
        return bookRepository.save(updateBook);
    }
    public Book getBookById(long id){
        return bookRepository.findById(id).orElseThrow();
    }
}
