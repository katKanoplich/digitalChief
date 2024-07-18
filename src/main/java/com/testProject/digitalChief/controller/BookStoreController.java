package com.testProject.digitalChief.controller;

import com.testProject.digitalChief.dto.BookStoreRequest;
import com.testProject.digitalChief.dto.BookStoreResponse;
import com.testProject.digitalChief.service.BookStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookstore")
@RequiredArgsConstructor
public class BookStoreController {
    private final BookStoreService bookStoreService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBookStore(@RequestBody BookStoreRequest bookStoreRequest){
        bookStoreService.createBookStore(bookStoreRequest);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookStoreResponse> getAllBookStores(){
        return bookStoreService.getAllBookStores();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBookStore(@PathVariable long id) {
        bookStoreService.deleteBookStore(id);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookStoreResponse updateBookStore(@PathVariable long id, @RequestBody BookStoreRequest bookStoreRequest) {
        return bookStoreService.updateBookStore(id, bookStoreRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookStoreResponse getBookStoreById(@PathVariable long id) {
        return bookStoreService.getBookStoreById(id);
    }
}
