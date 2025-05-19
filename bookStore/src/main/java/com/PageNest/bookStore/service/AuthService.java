package com.PageNest.bookStore.service;

import com.PageNest.bookStore.dto.request.LoginRequest;
import com.PageNest.bookStore.dto.request.SignupRequest;
import com.PageNest.bookStore.dto.respones.JwtResponse;
import com.PageNest.bookStore.model.User;
import com.PageNest.bookStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public JwtResponse login(LoginRequest loginRequest) {
		User user = userRepository.findByEmail(loginRequest.getEmail())
				.orElseThrow(() -> new RuntimeException("User not found"));

		if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
			throw new RuntimeException("Invalid credentials");
		}

		String fakeToken = UUID.randomUUID().toString();
		return new JwtResponse(fakeToken, user.getEmail(), Collections.singleton("ROLE_USER"));


	}


	public void signup(SignupRequest signupRequest) {
		if (userRepository.findByUsername(signupRequest.getUsername()).isPresent()) {
			throw new RuntimeException("Username already exists");
		}

		User user = new User();
		user.setUsername(signupRequest.getUsername());
		user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
		user.setEmail(signupRequest.getEmail());
		user.setCart(Collections.emptyList());

		userRepository.save(user);
	}
}
