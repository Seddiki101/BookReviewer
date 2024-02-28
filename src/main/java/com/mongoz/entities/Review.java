package com.mongoz.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "Review")
public class Review {

    @Id
    private Long id;
    private String content;
    private Rating rating;
    private Long bookId;

}
