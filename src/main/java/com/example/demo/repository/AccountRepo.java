package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepo extends CrudRepository<AccountEntity, Long> {
	AccountEntity findByIdAndUserId(Long id, Long userId);
	
	List<AccountEntity> findByUserId(Long userId);
	
	AccountEntity findByAccountNameAndUserId(String accountName, Long userId);
	
}
