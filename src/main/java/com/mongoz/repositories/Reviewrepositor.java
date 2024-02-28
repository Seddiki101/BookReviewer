package com.mongoz.repositories;

import com.mongoz.entities.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Reviewrepositor extends MongoRepository<Review,Long> {
}
