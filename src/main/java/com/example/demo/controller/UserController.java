package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepo userRepo;
	
	@PostMapping
	public ResponseEntity createUser(@RequestBody UserEntity user) {
		try {
			if (userRepo.findByUserName(user.getUserName()) != null) {
				return ResponseEntity.badRequest().body("User with this name already exist.");
			}
			userRepo.save(user);
			return ResponseEntity.ok("Everything works fine");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Something went wrong.");
		}
	}

	@GetMapping
	public ResponseEntity getUsers() {
		try {
			return ResponseEntity.ok("Everything works fine");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Something went wrong.");
		}
	}
}
