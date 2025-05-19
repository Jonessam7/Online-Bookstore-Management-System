package com.PageNest.bookStore.controller;

import com.PageNest.bookStore.dto.request.LoginRequest;
import com.PageNest.bookStore.dto.request.SignupRequest;
import com.PageNest.bookStore.dto.respones.JwtResponse;
import com.PageNest.bookStore.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody SignupRequest signupRequest) {
		authService.signup(signupRequest);
		return ResponseEntity.ok("User registered successfully!");
	}

	@PostMapping("/login")
	public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest loginRequest) {
		JwtResponse jwtResponse = authService.login(loginRequest);
		return ResponseEntity.ok(jwtResponse);
	}
}
