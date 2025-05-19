package com.PageNest.bookStore.dto.request;

import java.util.List;

public class PlaceOrderRequest {
	private List<CartItemDTO> items;
	private String address;
	private String paymentMethod;

	public PlaceOrderRequest() {}

	public PlaceOrderRequest(List<CartItemDTO> items, String address, String paymentMethod) {
		this.items = items;
		this.address = address;
		this.paymentMethod = paymentMethod;
	}

	public List<CartItemDTO> getItems() {
		return items;
	}

	public void setItems(List<CartItemDTO> items) {
		this.items = items;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	// Inner DTO class for cart items
	public static class CartItemDTO {
		private String bookId;
		private int quantity;

		public CartItemDTO() {}

		public CartItemDTO(String bookId, int quantity) {
			this.bookId = bookId;
			this.quantity = quantity;
		}

		public String getBookId() {
			return bookId;
		}

		public void setBookId(String bookId) {
			this.bookId = bookId;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
	}
}
