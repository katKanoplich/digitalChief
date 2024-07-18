package com.testProject.digitalChief.dto;

import com.testProject.digitalChief.model.BookStore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private int year;
    private String genre;
    private double price;
    private int quantity;
    private BookStore bookStore;
}
