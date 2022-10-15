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
// @CrossOrigin  // CORS 허용 
public class RestApiController {


	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	// 모든 사람이 접근 가능
	@GetMapping("home")
	public String home() {
		return "<h1>home</h1>";
	}

	@GetMapping("/log")
	public String log(HttpSession session) {
		session.invalidate();
		return "log";
	}

	// Tip : JWT를 사용하면 UserDetailsService를 호출하지 않기 때문에 @AuthenticationPrincipal 사용 불가능.
	// 왜냐하면 @AuthenticationPrincipal은 UserDetailsService에서 리턴될 때 만들어지기 때문이다.

	// 유저 혹은 매니저 혹은 어드민이 접근 가능
	@GetMapping("user")
	public String user(Authentication authentication) {
		PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
		System.out.println("principal : "+principal.getUser().getId());
		System.out.println("principal : "+principal.getUser().getUsername());
		System.out.println("principal : "+principal.getUser().getPassword());

		return "<h1>user</h1>";
	}

	@GetMapping("user1")
	public String user1(Authentication authentication) {
		PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
		System.out.println("principal : "+principal.getUser().getId());
		System.out.println("principal : "+principal.getUser().getUsername());
		System.out.println("principal : "+principal.getUser().getPassword());

		return "<h1>user</h1>";
	}

	// 매니저 혹은 어드민이 접근 가능
	@GetMapping("manager/reports")
	public String reports() {
		return "<h1>reports</h1>";
	}

	// 어드민이 접근 가능
	@GetMapping("admin/users")
	public List<User> users(){
		return userRepository.findAll();
	}

	@PostMapping("/join")
	public String join(@RequestBody User user) {
		/*User existUser = userRepository.findByUsername(user.getUsername());
		if(existUser != null){
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		}*/
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles("ROLE_USER");
		userRepository.save(user);
		return "회원가입완료";
	}



}











