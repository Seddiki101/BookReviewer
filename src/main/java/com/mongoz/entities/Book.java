package com.mongoz.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@ToString
@Document(collection = "Book")
public class Book {

    @Id
    private Long id;
    private String title;
    private String author;
    @DBRef
    private List<Review> reviews;

}
