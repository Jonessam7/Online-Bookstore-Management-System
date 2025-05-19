package com.PageNest.bookStore.dto.respones;

import java.util.Set;

public class JwtResponse {
	private String token;
	private String email;
	private Set<String> roles;

	public JwtResponse(String token, String email, Set<String> roles) {
		this.token = token;
		this.email = email;
		this.roles = roles;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
}
