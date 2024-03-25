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
import com.synergisticit.service.RoleService;

import jakarta.validation.Valid;

@RestController
public class RoleREST {
	@Autowired
	RoleService roleService;
	
	@GetMapping(value="rest/allRoles")
	public ResponseEntity<List<Role>> getAllRoles() {
		List<Role> roles = roleService.findAll();
		if (roles.isEmpty()) {
			return new ResponseEntity<List<Role>>(roles, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Role>>(roles, HttpStatus.FOUND);
		}
	}
	
	@PostMapping(value="rest/saveRole")
	public ResponseEntity<?> saveRole(@Valid @RequestBody Role role) {
		HttpHeaders headers = new HttpHeaders();
		StringBuilder sb = new StringBuilder("");
		
		if(roleService.existsById(role.getRoleId())) {
			sb.append("Role ID existed: " +  role.getRoleId());
			headers.add("Error", sb.toString());
			return new ResponseEntity<StringBuilder>(sb, headers, HttpStatus.FOUND);
		} else {
			Role r = roleService.save(role);
			headers.add("New Role ", role.getRoleName());
			return new ResponseEntity<Role>(r, headers, HttpStatus.CREATED);
		}
	}
	
	@PutMapping(value="rest/updateRole")
	public ResponseEntity<?> updateRole(@RequestBody Role role) {
		Role r = roleService.findById(role.getRoleId());
		if (r==null) {
			return new ResponseEntity<String>("No Role with id "+role.getRoleId(), HttpStatus.NOT_FOUND);
		} else {
			roleService.save(role);
			return new ResponseEntity<Role>(role, HttpStatus.OK);
		}
	}
	
	@DeleteMapping(value="rest/deleteRole")
	public ResponseEntity<?> deleteRole(@RequestParam Long roleId) {
		HttpHeaders headers = new HttpHeaders();
		Role r = roleService.findById(roleId);
		if (r==null) {
			return new ResponseEntity<String>("No Role with id "+roleId, HttpStatus.NOT_FOUND);
		} else {
			roleService.deleteById(roleId);
			headers.add("Role Deleted", String.valueOf(roleId));
			return new ResponseEntity<String>("Role "+roleId+" is deleted", headers, HttpStatus.OK);
		}
	}
	
}
