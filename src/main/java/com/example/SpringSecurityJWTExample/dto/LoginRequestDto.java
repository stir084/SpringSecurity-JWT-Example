package com.example.SpringSecurityJWTExample.dto;

import lombok.Data;

@Data
public class LoginRequestDto {
	private String username;
	private String password;
}
