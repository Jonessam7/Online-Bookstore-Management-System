package com.PageNest.bookStore.dto.respones;

public class PaymentResponse {
	private String paymentId;
	private String orderId;
	private double amount;
	private String method;
	private String paymentStatus;
	private String timestamp;

	public PaymentResponse() {}

	public PaymentResponse(String paymentId, String orderId, double amount, String method, String paymentStatus, String timestamp) {
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.amount = amount;
		this.method = method;
		this.paymentStatus = paymentStatus;
		this.timestamp = timestamp;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}
