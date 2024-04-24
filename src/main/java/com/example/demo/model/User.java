package com.example.demo.model;

import com.example.demo.entity.UserEntity;

public class User {
	private Long id;
	private String userName;
	
	public static User toModel(UserEntity entity) {
		User model = new User();
		model.id = entity.getId();
		model.userName = entity.getUserName();
		return model;
		
	}
	
	public User() {
	
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
	
	public void getUserName(String userName) {
		this.userName = userName;
	}
	
}
