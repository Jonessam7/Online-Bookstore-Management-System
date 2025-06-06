package com.PageNest.bookStore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Logins")
public class User {

	@Id
	private String id;
	private String username;
	private String email;
	private String password;
	private List<CartItem> cart;

	public User() {}

	public User(String id, String username, String email, String password, List<CartItem> cart) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.cart = cart;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<CartItem> getCart() {
		return cart;
	}

	public void setCart(List<CartItem> cart) {
		this.cart = cart;
	}
}
