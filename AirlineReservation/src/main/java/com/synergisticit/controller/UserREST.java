package com.synergisticit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.synergisticit.domain.Role;
import com.synergisticit.domain.User;
import com.synergisticit.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserREST {
	
	@Autowired
	UserService userService;
	
	@GetMapping(value="rest/userForm")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.findAll();
		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(users, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<User>>(users, HttpStatus.FOUND);
		}
	}
	
	@PostMapping(value="rest/saveUser")
	public ResponseEntity<?> saveUser(@Valid @RequestBody User user) {
		HttpHeaders headers = new HttpHeaders();
		StringBuilder sb = new StringBuilder("");
		
		if(userService.existsById(user.getUserId())) {
			sb.append("User ID existed: " +  user.getUserId());
			headers.add("Error", sb.toString());
			return new ResponseEntity<StringBuilder>(sb, headers, HttpStatus.FOUND);
		} else {
			User u = userService.save(user);
			headers.add("New User", user.getUsername());
			return new ResponseEntity<User>(u, headers, HttpStatus.CREATED);
		}
	}
	@PutMapping(value="rest/updateUser")
	public ResponseEntity<?> updateUser(@RequestBody User user) {
		HttpHeaders headers = new HttpHeaders();
		if (!userService.existsById(user.getUserId())) {
			return new ResponseEntity<String>("No user with id "+user.getUserId(), HttpStatus.NOT_FOUND);
		} else {
			userService.save(user);
			headers.add("Update User", user.getUserId().toString());
			return new ResponseEntity<User>(user,headers, HttpStatus.OK);
		}
	}
	
	
	@DeleteMapping(value="rest/deleteUser")
	public ResponseEntity<?> deleteUser(@RequestParam Long userId) {
		HttpHeaders headers = new HttpHeaders();
		if (!userService.existsById(userId)) {
			return new ResponseEntity<String>("No User with id "+userId, HttpStatus.NOT_FOUND);
		} else {
			userService.deleteById(userId);
			headers.add("User Deleted", String.valueOf(userId));
			return new ResponseEntity<String>("User "+userId+" is deleted", headers, HttpStatus.OK);
		}
	}
}
