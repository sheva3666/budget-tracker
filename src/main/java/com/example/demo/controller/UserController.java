package com.example.demo.controller;

import java.util.NoSuchElementException;

import com.example.demo.entity.UserEntity;
import com.example.demo.exception.UserAlreadyExistException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity createUser(@RequestBody UserEntity user) {
		try {
			userService.registration(user);
			return ResponseEntity.ok("Ok");
		} catch (UserAlreadyExistException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Something went wrong.");
		}
	}

	@GetMapping
	public ResponseEntity getUser(@RequestParam Long id) {
		try {
			return ResponseEntity.ok(userService.getUser(id));
		} catch (NoSuchElementException | UserNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
