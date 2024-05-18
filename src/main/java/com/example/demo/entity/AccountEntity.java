package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AccountEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long userId;
	
	private String accountName;
	
	private String currency;
	
	private Integer amount;
	
	public AccountEntity() {
	
	}
	
	public Long getId() {
		return id;
	}
	
	public void getId(Long id) {
		this.id = id;
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public void getUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getAccountName() {
		return accountName;
	}
	
	public void getAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public void getCurrency(String currency) {
		this.currency = currency;
	}
	
	public Integer getAmount() {
		return amount;
	}
	
	public void getAmount(Integer amount) {
		this.amount = amount;
	}
}

