package com.example.SpringSecurityJWTExample.repository;

import com.example.SpringSecurityJWTExample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
