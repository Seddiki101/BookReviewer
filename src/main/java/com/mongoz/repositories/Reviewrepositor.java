package com.mongoz.repositories;

import com.mongoz.entities.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface Reviewrepositor extends MongoRepository<Review,Long> {
    List<Review> findByBookId(Long bookId);
}
