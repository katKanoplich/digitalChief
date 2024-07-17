package com.testProject.digitalChief.service.impl;

import com.testProject.digitalChief.model.BookStore;
import com.testProject.digitalChief.repository.BookStoreRepository;
import com.testProject.digitalChief.service.BookStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookStoreServiceImpl implements BookStoreService {
    
    private final BookStoreRepository bookStoreRepository;

    public List<BookStore> getAllBookStores(){
        return bookStoreRepository.findAll();
    }

    public void deleteBookStore(long id){
        bookStoreRepository.deleteById(id);
    }

    public BookStore addBookStore(BookStore bookStore){
        bookStoreRepository.save(bookStore);
        return bookStore;
    }
    public BookStore updateBookStore(long id,BookStore updateBookStore){
        updateBookStore.setId(id);
        return bookStoreRepository.save(updateBookStore);
    }
    public BookStore getBookStoreById(long id){
        return bookStoreRepository.findById(id).orElseThrow();
    }

}
