package com.PageNest.bookStore.controller;

import com.PageNest.bookStore.dto.respones.PaymentResponse;
import com.PageNest.bookStore.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping("/process")
	public ResponseEntity<PaymentResponse> processPayment(@RequestParam String orderId, @RequestParam String method) {
		return ResponseEntity.ok(paymentService.processPayment(orderId, method));
	}
}
