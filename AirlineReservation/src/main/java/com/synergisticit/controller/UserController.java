package com.synergisticit.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.synergisticit.domain.User;
import com.synergisticit.service.RoleService;
import com.synergisticit.service.UserService;

import jakarta.validation.Valid;

@Controller
public class UserController {
	
	@Autowired UserService userService;
	@Autowired RoleService roleService;
	
	
	@RequestMapping("/userForm")
	public String userForm(User user, Model model, Principal principal) {
		model.addAttribute("users", userService.findAll());
		model.addAttribute("roles", roleService.findAll());
		
		if(principal != null)
		model.addAttribute("loggedInUser", principal.getName());
		
		return "userForm";
	}
	
	@RequestMapping("/saveUser")
	public String saveUser(@Valid @ModelAttribute User user, BindingResult br, Model model) {
		System.out.println("1. br.hasErrors(): "+br.hasErrors());
		model.addAttribute("users", userService.findAll());
		model.addAttribute("roles", roleService.findAll());
		
		if(br.hasErrors()) {
			model.addAttribute("hasErrors", true);
			System.out.println("2. br.hasErrors(): "+br.hasErrors());
			return "userForm";
		}else {
			userService.save(user);
			return "redirect:userForm";
		}
		
	}
	
	//update?userId=1
	@RequestMapping("/update")
	public String updateUser(User user, Model model) {
		user = userService.findById(user.getUserId());
		user.setPassword("");
		model.addAttribute("user", user);
		model.addAttribute("retrievedRole", user.getRoles());
		model.addAttribute("users", userService.findAll());	
		model.addAttribute("roles", roleService.findAll());
		
		return "userForm";
	}
	
	//delete?userId=1
	@RequestMapping("/delete")
	public String deleteUser(User user, Model model) {
		userService.deleteById(user.getUserId());
		return "redirect:userForm";
	}
	
	@RequestMapping("/showUser")
	public String showUser(BindingResult br, Model model, Principal principal) {
		if(br.hasErrors()) {
			model.addAttribute("hasErrors", true);
			return "home";
		} else {
			User u = userService.findUserByUsername(principal.getName());
			model.addAttribute("users", u);
			return "home";
		}
		
	}

}
