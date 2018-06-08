package io.springsecurity.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.springsecurity.domain.Role;
import io.springsecurity.domain.User;
import io.springsecurity.security.SecurityConfig;
import io.springsecurity.service.UserService;

@Controller
public class RegistrationController {
	
	@Autowired
	private UserService service;
	@Autowired
	private SecurityConfig config;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}
	
	@RequestMapping("/submit-form")
	public String register(@Valid @ModelAttribute("user") User user,
			BindingResult result,@RequestParam("role") String role,
			 Model model) {
		Role r = new Role();
		
		if(result.hasErrors()) {
			return "registration";
		}
		
		if(role.equals("Admin")) {
			r.setRole("ROLE_ADMIN");
			user.getRoles().add(r);
		}else {
			r.setRole("ROLE_USER");
			user.getRoles().add(r);
		}
		
		user.setPassword(config.passwordEncoder().encode(user.getPassword()));
		user.setEnabled(true);
		service.save(user);
		
		return "login";
	}
}
