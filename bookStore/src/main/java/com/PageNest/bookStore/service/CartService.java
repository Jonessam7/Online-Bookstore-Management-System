package com.PageNest.bookStore.service;

import com.PageNest.bookStore.dto.request.AddToCartRequest;
import com.PageNest.bookStore.dto.respones.CartItemResponse;
import com.PageNest.bookStore.model.Book;
import com.PageNest.bookStore.model.CartItem;
import com.PageNest.bookStore.model.User;
import com.PageNest.bookStore.repository.BookRepository;
import com.PageNest.bookStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookRepository bookRepository;

	public void addToCart(String userId, AddToCartRequest request) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("User not found"));

		Book book = bookRepository.findById(request.getBookId())
				.orElseThrow(() -> new RuntimeException("Book not found"));

		int quantity = request.getQuantity();
		double totalPrice = book.getPrice() * quantity;

		CartItem cartItem = new CartItem(book, quantity, totalPrice);

		// Assuming User has a List<CartItem> cart:
		List<CartItem> cart = user.getCart();
		if (cart == null) {
			cart = new ArrayList<>();
			user.setCart(cart);  // set it right away if null
		}
		cart.add(cartItem);

		userRepository.save(user);
	}

	public List<CartItemResponse> getCartByUserId(String userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("User not found"));

		List<CartItem> cartItems = user.getCart();
		if (cartItems == null) {
			return new ArrayList<>();
		}

		return cartItems.stream().map(item -> new CartItemResponse(
				item.getBook().getId(),
				item.getBook().getTitle(),
				item.getQuantity(),
				item.getBook().getPrice(),
				item.getTotalPrice()
		)).toList();
	}
}
