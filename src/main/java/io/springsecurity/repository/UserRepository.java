package io.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.springsecurity.domain.User;

public interface UserRepository extends JpaRepository <User, String>{
	User findByUsername(String username);
}
