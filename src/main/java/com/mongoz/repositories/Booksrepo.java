package com.mongoz.repositories;

import com.mongoz.entities.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Booksrepo extends MongoRepository<Book, Long> {
}
