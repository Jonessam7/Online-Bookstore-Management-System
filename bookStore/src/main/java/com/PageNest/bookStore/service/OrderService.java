package com.PageNest.bookStore.service;

import com.PageNest.bookStore.dto.request.PlaceOrderRequest;
import com.PageNest.bookStore.dto.request.PlaceOrderRequest.CartItemDTO;
import com.PageNest.bookStore.dto.respones.OrderResponse;
import com.PageNest.bookStore.model.Book;
import com.PageNest.bookStore.model.OrderItem;
import com.PageNest.bookStore.model.Order;
import com.PageNest.bookStore.model.User;
import com.PageNest.bookStore.repository.BookRepository;
import com.PageNest.bookStore.repository.OrderRepository;
import com.PageNest.bookStore.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private OrderRepository orderRepository;

	public OrderResponse placeOrder(String userId, PlaceOrderRequest request) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("User not found"));

		List<OrderItem> orderItems = new ArrayList<>();
		double totalAmount = 0;

		for (CartItemDTO dto : request.getItems()) {
			Book book = bookRepository.findById(dto.getBookId())
					.orElseThrow(() -> new RuntimeException("Book not found: " + dto.getBookId()));

			double totalPrice = book.getPrice() * dto.getQuantity();
			totalAmount += totalPrice;

			OrderItem orderItem = new OrderItem();
			orderItem.setBookId(book.getId());
			orderItem.setTitle(book.getTitle());
			orderItem.setQuantity(dto.getQuantity());
			orderItem.setPrice(book.getPrice());
			orderItem.setTotalPrice(totalPrice);

			orderItems.add(orderItem);
		}

		Order order = new Order();
		order.setId(UUID.randomUUID().toString());
		order.setUserId(user.getId());
		order.setItems(orderItems); // now using OrderItem list
		order.setTotalAmount(totalAmount);
		order.setStatus("PENDING");
		order.setOrderDate(new Date());
		order.setAddress(request.getAddress());
		order.setPaymentMethod(request.getPaymentMethod());

		orderRepository.save(order);

		// Clear user's cart (optional)
		user.getCart().clear();
		userRepository.save(user);

		return new OrderResponse(
				order.getId(),
				user.getId(),
				mapToOrderItemDTOs(order.getItems()),
				order.getTotalAmount(),
				order.getStatus()
		);
	}

	private List<OrderResponse.OrderItem> mapToOrderItemDTOs(List<com.PageNest.bookStore.model.OrderItem> items) {
		List<OrderResponse.OrderItem> dtoItems = new ArrayList<>();
		for (com.PageNest.bookStore.model.OrderItem item : items) {
			OrderResponse.OrderItem dtoItem = new OrderResponse.OrderItem();
			dtoItem.setBookId(item.getBookId());
			dtoItem.setTitle(item.getTitle());
			dtoItem.setQuantity(item.getQuantity());
			dtoItem.setPrice(item.getPrice());
			dtoItem.setTotalPrice(item.getTotalPrice());
			dtoItems.add(dtoItem);
		}
		return dtoItems;
	}
	public List<OrderResponse> getOrdersByUserId(String userId) {
		List<Order> orders = orderRepository.findByUserId(userId);

		List<OrderResponse> responseList = new ArrayList<>();
		for (Order order : orders) {
			OrderResponse response = new OrderResponse(
					order.getId(),
					userId,
					mapToOrderItemDTOs(order.getItems()),
					order.getTotalAmount(),
					order.getStatus()
			);
			responseList.add(response);
		}
		return responseList;
	}

}
