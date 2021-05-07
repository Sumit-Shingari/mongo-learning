package com.sumit.shingari.mogodb.embedded.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.sumit.shingari.mogodb.embedded.model.User;

public interface FlipkartRepository extends MongoRepository<User, Integer> {

	List<User> findByName(String name);
	
	@Query("{'Address.city': ?0}")
	List<User> findByCity(String city);

}
