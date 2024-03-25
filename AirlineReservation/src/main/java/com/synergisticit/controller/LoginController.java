package com.synergisticit.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.synergisticit.domain.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
	
	
	
	@RequestMapping("login")
	public String loginToApp(@RequestParam(value="logout", required=false) String logout,
			@RequestParam(value="error", required=false) String error,
			HttpServletRequest req, HttpServletResponse res, Model model
			) {
		System.out.println("loginToApp()...");

		
		String message = null;
		
		
		if(logout != null) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if(auth != null) {
				new SecurityContextLogoutHandler().logout(req, res, auth);
				message="You are logged out.";
			}
		}
		
		if(error != null) {
			message="Either username or password is incorrect.";
		}
		
		model.addAttribute("message", message);
		return "loginForm";
	}
	
	@RequestMapping("accessDenied")
	public String accessDenied() {
		
		return "accessDenied";
	}

}
