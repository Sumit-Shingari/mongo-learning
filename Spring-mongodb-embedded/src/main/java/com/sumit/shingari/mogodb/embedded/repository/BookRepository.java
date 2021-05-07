package com.sumit.shingari.mogodb.embedded.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sumit.shingari.mogodb.embedded.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer> {

}
