package io.springsecurity.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String login() {
		List<String> roles = new ArrayList<String>();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> authorities =  authentication.getAuthorities();
		
		for (GrantedAuthority a : authorities) {
            roles.add(a.getAuthority());
        }
		
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			if(roles.contains("ROLE_USER")) /// if this work make changes in AuthenticationSuccessHandler including other program
				return "forward:/user";
			else
				return "forward:/admin";
		}
		  
		return "login";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login";
	}
	
	@RequestMapping("/access-denied")
	public String accessDenied() {
		return "access-denied";
	}
}
