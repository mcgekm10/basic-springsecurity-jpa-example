package io.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.springsecurity.domain.User;
import io.springsecurity.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	public void save(User user) {
		repository.save(user);
	}
}
