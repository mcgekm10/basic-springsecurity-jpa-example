package io.springsecurity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.springsecurity.domain.MyUserDetails;
import io.springsecurity.domain.User;
import io.springsecurity.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> ops = Optional.of(repository.findByUsername(username));

        ops
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return ops
                .map(MyUserDetails::new).get();
    }
}
