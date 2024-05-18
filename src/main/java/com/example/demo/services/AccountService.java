package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;

import com.example.demo.entity.AccountEntity;
import com.example.demo.exception.AccountAlreadyExistException;
import com.example.demo.exception.AccountNotFoundException;
import com.example.demo.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepo accountRepo;
	
	public AccountEntity getAccount(Long id, Long userId) throws AccountNotFoundException {
		AccountEntity account = accountRepo.findByIdAndUserId(id, userId);
		if (account == null) {
			throw new NoSuchElementException("This user does not exist.");
		}
		return account;
	}
	
	public List<AccountEntity> getAccounts(Long userId) throws AccountNotFoundException {
		List<AccountEntity> userAccounts = accountRepo.findByUserId(userId);
		if (userAccounts == null) {
			throw new NoSuchElementException("This user does not exist.");
		}
		return userAccounts;
	}
	
	public AccountEntity createAccount(AccountEntity account) throws AccountAlreadyExistException {
		if (accountRepo.findByAccountNameAndUserId(account.getAccountName(), account.getUserId()) != null) {
			throw new AccountAlreadyExistException("Account with this name already exist.");
		}
		return accountRepo.save(account);
	}
	
}
