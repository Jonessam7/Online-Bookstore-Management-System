package com.PageNest.bookStore.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtUtil {

	// Use a secure, randomly generated key
	private final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	private final long EXPIRATION_TIME = 1000 * 60 * 60 * 10;  // 10 hours

	// Generate a JWT token
	public String generateToken(String username) {
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SECRET_KEY)
				.compact();
	}

	// Extract username from the token
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token).getSubject();
	}

	// Validate the token
	public boolean validateToken(String token, String username) {
		String extractedUsername = getUsernameFromToken(token);
		return (extractedUsername.equals(username) && !isTokenExpired(token));
	}

	// Check if the token has expired
	private boolean isTokenExpired(String token) {
		return getClaimFromToken(token).getExpiration().before(new Date());
	}

	// Method to validate the token (used in your code)
	public boolean isTokenValid(String token) {
		return !isTokenExpired(token);
	}

	// Get claims from the token
	private Claims getClaimFromToken(String token) {
		return Jwts.parser()  // Updated method for newer jjwt versions
				.setSigningKey(SECRET_KEY)
				.build()
				.parseClaimsJws(token)
				.getBody();
	}

	// Decode JWT method
	public static String decodeJWT(String token) {
		byte[] decodedBytes = Base64.getUrlDecoder().decode(token);
		return new String(decodedBytes);
	}
}


