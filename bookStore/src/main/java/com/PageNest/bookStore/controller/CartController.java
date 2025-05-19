package com.PageNest.bookStore.controller;

import com.PageNest.bookStore.dto.request.AddToCartRequest;
import com.PageNest.bookStore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping("/add")
	public ResponseEntity<String> addToCart(@RequestParam String userId, @RequestBody AddToCartRequest request) {
		cartService.addToCart(userId, request);
		return ResponseEntity.ok("Item added to cart successfully");
	}

	@GetMapping("/{userId}")
	public ResponseEntity<?> getCartByUserId(@PathVariable String userId) {
		return ResponseEntity.ok(cartService.getCartByUserId(userId));
	}

}
