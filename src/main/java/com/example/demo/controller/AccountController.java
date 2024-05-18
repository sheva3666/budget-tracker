package com.example.demo.controller;

import java.util.NoSuchElementException;

import com.example.demo.entity.AccountEntity;
import com.example.demo.exception.AccountAlreadyExistException;
import com.example.demo.exception.AccountNotFoundException;
import com.example.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@PostMapping
	public ResponseEntity createAccount(@RequestBody AccountEntity account) {
		try {
			AccountEntity newAccount = accountService.createAccount(account);
			return ResponseEntity.ok(newAccount);
		} catch (AccountAlreadyExistException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Something went wrong.");
		}
	}
	
	@GetMapping()
	public ResponseEntity getAccount(@RequestParam Long accountId, Long userId) {
		try {
			return ResponseEntity.ok(accountService.getAccount(accountId, userId));
		} catch (NoSuchElementException | AccountNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity getAllAccounts(@RequestParam Long userId) {
		try {
			return ResponseEntity.ok(accountService.getAccounts(userId));
		} catch (NoSuchElementException | AccountNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
