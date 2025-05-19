package com.PageNest.bookStore.dto.respones;

public class BookResponse {
	private String id;
	private String title;
	private String author;
	private double price;
	private String description;

	public BookResponse() {}

	public BookResponse(String id, String title, String author, double price, String description) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
