package com.testProject.digitalChief.service.impl;

import com.testProject.digitalChief.dto.BookRequest;
import com.testProject.digitalChief.dto.BookResponse;
import com.testProject.digitalChief.dto.BookStoreResponse;
import com.testProject.digitalChief.model.Book;
import com.testProject.digitalChief.model.Book;
import com.testProject.digitalChief.model.BookStore;
import com.testProject.digitalChief.repository.BookRepository;
import com.testProject.digitalChief.repository.BookRepository;
import com.testProject.digitalChief.repository.BookStoreRepository;
import com.testProject.digitalChief.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookStoreRepository bookStoreRepository;
//    public List<Book> getAllBook(){
//        return bookRepository.findAll();
//    }
//
//    public void deleteBook(long id){
//        bookRepository.deleteById(id);
//    }
//
//    public Book createBook(Book book){
//        bookRepository.save(book);
//        return book;
//    }
//    public Book updateBook(long id,Book updateBook){
//        updateBook.setId(id);
//        return bookRepository.save(updateBook);
//    }
//    public Book getBookById(long id){
//        return bookRepository.findById(id).orElseThrow();
//    }
private final BookRepository BookRepository;
//
//    public List<Book> getAllBooks(){
//        return BookRepository.findAll();
//    }

    public void deleteBook(long id){
        BookRepository.deleteById(id);
    }

    public void createBook(BookRequest bookRequest) {
        BookStore bookStore = bookStoreRepository.findById(bookRequest.getBookStoreId())
                .orElseThrow(() -> new RuntimeException("BookStore not found"));

        Book book = Book.builder()
                .title(bookRequest.getTitle())
                .genre(bookRequest.getGenre())
                .author(bookRequest.getAuthor())
                .publisher(bookRequest.getPublisher())
                .price(bookRequest.getPrice())
                .year(bookRequest.getYear())
                .quantity(bookRequest.getQuantity())
                .bookStore(bookStore)
                .build();

        bookRepository.save(book);
        log.info("Book {} is saved", book.getId());
    }
    //    public Book updateBook(long id,Book updateBook){
//        updateBook.setId(id);
//        return BookRepository.save(updateBook);
//    }
//    public Book getBookById(long id){
//        return BookRepository.findById(id).orElseThrow();
//    }
    public List<BookResponse> getAllBooks(){
        List<Book> products = BookRepository.findAll();
        return products.stream().map(this::mapToBookResponse).toList();
    }

    public BookResponse updateBook(Long id, BookRequest updateBookRequest) {
        Book existingBook = BookRepository.findById(id)
                .orElseThrow();

        existingBook.setTitle(updateBookRequest.getTitle());
        existingBook.setAuthor(updateBookRequest.getAuthor());
        existingBook.setGenre(updateBookRequest.getGenre());
        existingBook.setPrice(updateBookRequest.getPrice());
        existingBook.setPublisher(updateBookRequest.getPublisher());
        existingBook.setYear(updateBookRequest.getYear());
        existingBook.setQuantity(updateBookRequest.getQuantity());
//        existingBook.setBookStore(updateBookRequest.getBookStore());
        Book updatedProduct = BookRepository.save(existingBook);
        return mapToBookResponse(updatedProduct);
    }
    public BookResponse getBookById(long id) {
        return BookRepository.findById(id)
                .map(this::mapToBookResponse)
                .orElseThrow();
    }
    private BookResponse mapToBookResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .price(book.getPrice())
                .genre(book.getGenre())
                .year(book.getYear())
                .quantity(book.getQuantity())
                .publisher(book.getPublisher())
                .bookStore(book.getBookStore())
                .build();
    }
}
