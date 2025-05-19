package com.PageNest.bookStore.service;

import com.PageNest.bookStore.dto.request.BookRequest;
import com.PageNest.bookStore.dto.respones.BookResponse;
import com.PageNest.bookStore.model.Book;
import com.PageNest.bookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<BookResponse> getAllBooks() {
		return bookRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
	}

	public BookResponse getBookById(String id) {
		Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
		return mapToResponse(book);
	}

	private BookResponse mapToResponse(Book book) {
		return new BookResponse(book.getId(), book.getTitle(), book.getAuthor(), book.getPrice(), book.getDescription());
	}

	public List<BookResponse> addBooks(List<BookRequest> bookRequests) {
		List<Book> books = bookRequests.stream()
				.map(req -> new Book(null, req.getTitle(), req.getAuthor(), req.getPrice(), req.getDescription()))
				.collect(Collectors.toList());

		List<Book> savedBooks = bookRepository.saveAll(books);

		return savedBooks.stream()
				.map(book -> new BookResponse(book.getId(), book.getTitle(), book.getAuthor(), book.getPrice(), book.getDescription()))
				.collect(Collectors.toList());
	}

}
