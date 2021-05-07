package com.sumit.shingari.mogodb.embedded.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import com.sumit.shingari.mogodb.embedded.model.Book;
import com.sumit.shingari.mogodb.embedded.repository.BookRepository;
import com.sumit.shingari.mogodb.embedded.service.DbSequenceService;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

	private final BookRepository repository;
	private final DbSequenceService service;
	
	@PostMapping
	public Book saveBook(@RequestBody Book book) {
		book.setId(service.getSequenceNumber(Book.SEQUENCE_NAME));
		return repository.save(book);
	}
	
	@GetMapping
	public List<Book> getAllBooks() {
		return repository.findAll();
	}
}
