package com.example.SpringSecurityJWTExample.controller;


import com.example.SpringSecurityJWTExample.config.auth.PrincipalDetails;
import com.example.SpringSecurityJWTExample.model.User;
import com.example.SpringSecurityJWTExample.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class RestApiController {


	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	// 모든 사람이 접근 가능
	@GetMapping("/home")
	public String home() {
		return "<h1>home</h1>";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "logout";
	}

	@GetMapping("/user")
	public PrincipalDetails user(Authentication authentication) {
		PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
		System.out.println("principal : "+principal.getUser().getId());
		System.out.println("principal : "+principal.getUser().getUsername());
		System.out.println("principal : "+principal.getUser().getPassword());

		return principal;
	}

	// 어드민이 접근 가능
	@GetMapping("/admin/users")
	public List<User> users(){
		return userRepository.findAll();
	}

	@PostMapping("/join")
	public String join(@RequestBody User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles("ROLE_USER");
		userRepository.save(user);
		return "회원가입완료";
	}



}











