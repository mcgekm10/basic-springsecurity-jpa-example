package io.springsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping("/user")
	public String userPage() {
		return "user-page";
	}
	

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("/admin")
	public String adminPage() {
		return "admin-page";
	}
}