package com.example.SpringSecurityJWTExample.config.jwt;

public interface JwtProperties {
	String SECRET = "loose"; // 우리 서버만 알고 있는 비밀값
	int EXPIRATION_TIME = 10000; // 10초 (1/1000초)
	String TOKEN_PREFIX = "Bearer ";
	String HEADER_STRING = "Authorization";
}
