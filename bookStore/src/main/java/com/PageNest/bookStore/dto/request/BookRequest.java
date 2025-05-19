package com.PageNest.bookStore.dto.request;

public class BookRequest {
	private String title;
	private String author;
	private double price;
	private String description;

	public BookRequest() {}

	public BookRequest(String title, String author, double price, String description) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.description = description;
	}

	// getters and setters
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }

	public String getAuthor() { return author; }
	public void setAuthor(String author) { this.author = author; }

	public double getPrice() { return price; }
	public void setPrice(double price) { this.price = price; }

	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
}
