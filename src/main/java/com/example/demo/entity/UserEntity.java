package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String userName;
	private String password;
	
	public UserEntity() {
	
	}
	
	public Long getId() {
		return id;
	}
	
	public void getId(Long id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void getUserName(String name) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void getPassword(String name) {
		this.password = password;
	}
}
