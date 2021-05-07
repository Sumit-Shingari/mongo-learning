package com.sumit.shingari.springbootmongodb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.sumit.shingari.springbootmongodb.model.Expense;

@Repository
public interface ExpenseRepository extends MongoRepository<Expense, String>{

	@Query("{'name': ?0}")
	Optional<Expense> findByName(String name);
}
