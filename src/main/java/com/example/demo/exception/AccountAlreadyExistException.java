package com.example.demo.exception;

public class AccountAlreadyExistException extends Exception {
	public AccountAlreadyExistException(String message) {
		super (message);
	}
}
