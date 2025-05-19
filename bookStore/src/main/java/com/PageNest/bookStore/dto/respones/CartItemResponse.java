package com.PageNest.bookStore.dto.respones;

public class CartItemResponse {
	private String bookId;
	private String title;
	private int quantity;
	private double price;
	private double totalPrice;

	public CartItemResponse() {}

	public CartItemResponse(String bookId, String title, int quantity, double price, double totalPrice) {
		this.bookId = bookId;
		this.title = title;
		this.quantity = quantity;
		this.price = price;
		this.totalPrice = totalPrice;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
