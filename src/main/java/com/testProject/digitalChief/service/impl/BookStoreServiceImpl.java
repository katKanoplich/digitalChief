package com.testProject.digitalChief.service.impl;

import com.testProject.digitalChief.dto.BookStoreRequest;
import com.testProject.digitalChief.dto.BookStoreResponse;
import com.testProject.digitalChief.model.BookStore;
import com.testProject.digitalChief.repository.BookStoreRepository;
import com.testProject.digitalChief.service.BookStoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookStoreServiceImpl implements BookStoreService {
    
    private final BookStoreRepository bookStoreRepository;
//
//    public List<BookStore> getAllBookStores(){
//        return bookStoreRepository.findAll();
//    }

    public void deleteBookStore(long id){
        bookStoreRepository.deleteById(id);
    }

    public void createBookStore(BookStoreRequest bookStoreRequest){
        BookStore bookStore = BookStore.builder()
                .name(bookStoreRequest.getName())
                .address(bookStoreRequest.getAddress())
                .contact(bookStoreRequest.getContact())
                .build();

        bookStoreRepository.save(bookStore);
        log.info("BookStore {} is saved", bookStore.getId());
    }
//    public BookStore updateBookStore(long id,BookStore updateBookStore){
//        updateBookStore.setId(id);
//        return bookStoreRepository.save(updateBookStore);
//    }
//    public BookStore getBookStoreById(long id){
//        return bookStoreRepository.findById(id).orElseThrow();
//    }
public List<BookStoreResponse> getAllBookStores(){
    List<BookStore> products = bookStoreRepository.findAll();
    return products.stream().map(this::mapToBookStoreResponse).toList();
}

    public BookStoreResponse updateBookStore(Long id, BookStoreRequest updateProductRequest) {
        BookStore existingBookStore = bookStoreRepository.findById(id)
                .orElseThrow();

        existingBookStore.setName(updateProductRequest.getName());
        existingBookStore.setAddress(updateProductRequest.getAddress());
        existingBookStore.setContact(updateProductRequest.getContact());

        BookStore updatedProduct = bookStoreRepository.save(existingBookStore);
        return mapToBookStoreResponse(updatedProduct);
    }
    public BookStoreResponse getBookStoreById(long id) {
        return bookStoreRepository.findById(id)
                .map(this::mapToBookStoreResponse)
                .orElseThrow();
    }
    private BookStoreResponse mapToBookStoreResponse(BookStore bookStore) {
        return BookStoreResponse.builder()
                .id(bookStore.getId())
                .name(bookStore.getName())
                .address(bookStore.getAddress())
                .contact(bookStore.getContact())
                .build();
    }
}
