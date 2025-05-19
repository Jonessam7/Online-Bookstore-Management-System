package com.PageNest.bookStore.dto.respones;

import java.util.List;

public class OrderResponse {
	private String orderId;
	private String userId;
	private List<OrderItem> items;
	private double totalAmount;
	private String status;

	public OrderResponse() {}

	public OrderResponse(String orderId, String userId, List<OrderItem> items, double totalAmount, String status) {
		this.orderId = orderId;
		this.userId = userId;
		this.items = items;
		this.totalAmount = totalAmount;
		this.status = status;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static class OrderItem {
		private String bookId;
		private String title;
		private int quantity;
		private double price;
		private double totalPrice;

		public OrderItem() {}

		public OrderItem(String bookId, String title, int quantity, double price,double totalPrice) {
			this.bookId = bookId;
			this.title = title;
			this.quantity = quantity;
			this.price = price;
			this.totalPrice=totalPrice;
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
}
