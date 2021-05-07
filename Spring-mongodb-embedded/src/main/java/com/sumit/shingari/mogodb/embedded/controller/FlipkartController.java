package com.sumit.shingari.mogodb.embedded.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.sumit.shingari.mogodb.embedded.model.User;
import com.sumit.shingari.mogodb.embedded.repository.FlipkartRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class FlipkartController {

	private final FlipkartRepository repository;
	
	@PostMapping
	public String saveOrder(@RequestBody User user) {
		repository.save(user);
		return "Order placed successfully!!";
	}
	
	@GetMapping("/getUserByName/{name}")
	public List<User> getUserByName(@PathVariable String name) {
		return repository.findByName(name);
	}
	
	@GetMapping("/getUserByCity/{city}")
	public List<User> getUserByCity(@PathVariable String city) {
		return repository.findByCity(city);
	}
}
