package com.testProject.digitalChief.dto;

import com.testProject.digitalChief.model.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookStoreResponse {
    private Long id;
    private String name;
    private String address;
    private String contact;
    private List<Book> books = new ArrayList<>();
}
