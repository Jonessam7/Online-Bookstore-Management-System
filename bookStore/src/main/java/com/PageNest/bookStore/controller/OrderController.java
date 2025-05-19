package com.PageNest.bookStore.controller;

import com.PageNest.bookStore.dto.request.PlaceOrderRequest;
import com.PageNest.bookStore.dto.respones.OrderResponse;
import com.PageNest.bookStore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/place")
	public ResponseEntity<OrderResponse> placeOrder(@RequestParam String userId, @RequestBody PlaceOrderRequest request) {
		return ResponseEntity.ok(orderService.placeOrder(userId, request));
	}


	@GetMapping("/{userId}")
	public ResponseEntity<List<OrderResponse>> getOrdersByUserId(@PathVariable String userId) {
		return ResponseEntity.ok(orderService.getOrdersByUserId(userId));
	}

	// Get a single order by orderId
//	@GetMapping("/{orderId}")
//	public ResponseEntity<OrderResponse> getOrderById(@PathVariable String orderId) {
//		OrderResponse order = orderService.getOrderById(orderId);
//		return ResponseEntity.ok(order);
//	}
//
//	// Optional: Cancel or delete an order by ID
//	@DeleteMapping("/{orderId}")
//	public ResponseEntity<Void> cancelOrder(@PathVariable String orderId) {
//		orderService.cancelOrder(orderId);
//		return ResponseEntity.noContent().build();
//	}
}
