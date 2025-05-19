package com.PageNest.bookStore.service;

import com.PageNest.bookStore.dto.respones.PaymentResponse;
import com.PageNest.bookStore.model.Order;
import com.PageNest.bookStore.model.Payment;
import com.PageNest.bookStore.repository.OrderRepository;
import com.PageNest.bookStore.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private OrderRepository orderRepository;

	public PaymentResponse processPayment(String orderId, String method) {
		Order order = orderRepository.findById(orderId)
				.orElseThrow(() -> new RuntimeException("Order not found"));

		Payment payment = new Payment();
		payment.setId(UUID.randomUUID().toString());
		payment.setOrderId(order.getId());
		payment.setAmount(order.getTotalAmount());
		payment.setMethod(method);
		payment.setStatus("PAID");
		payment.setTimestamp(Instant.now().toString());

		paymentRepository.save(payment);

		order.setStatus("PAID");
		orderRepository.save(order);

		return new PaymentResponse(
				payment.getId(),
				orderId,
				payment.getAmount(),
				payment.getMethod(),
				payment.getStatus(),
				payment.getTimestamp()
		);
	}
}
