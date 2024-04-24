package com.example.demo.services;

import java.util.NoSuchElementException;

import com.example.demo.entity.UserEntity;
import com.example.demo.exception.UserAlreadyExistException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;
	public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
		if (userRepo.findByUserName(user.getUserName()) != null) {
			throw new UserAlreadyExistException("User with this name already exist.");
		}
		return userRepo.save(user);
	}
	
	public User getUser(Long id) throws UserNotFoundException {
		UserEntity user = userRepo.findById(id).get();
		if (user == null) {
			throw new NoSuchElementException("This user does not exist.");
		}
		return User.toModel(user);
	}
}
