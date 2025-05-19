package com.PageNest.bookStore.controller;

import com.PageNest.bookStore.dto.request.BookRequest;
import com.PageNest.bookStore.dto.respones.BookResponse;
import com.PageNest.bookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/allBooks")
	public ResponseEntity<List<BookResponse>> getAllBooks() {
		return ResponseEntity.ok(bookService.getAllBooks());
	}

	@PostMapping("/addBooks")
	public ResponseEntity<List<BookResponse>> addBooks(@RequestBody List<BookRequest> bookRequests) {
		List<BookResponse> createdBooks = bookService.addBooks(bookRequests);
		return ResponseEntity.ok(createdBooks);
	}

}
