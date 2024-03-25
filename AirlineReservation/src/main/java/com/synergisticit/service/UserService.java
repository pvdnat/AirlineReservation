package com.synergisticit.service;

import java.util.List;

import org.springframework.security.access.prepost.PostAuthorize;

import com.synergisticit.domain.User;

public interface UserService {
	
	//returnObject
	//@PostAuthorize("returnObject.username==authentication.principal.username")
	public User save(User user);
	
	@PostAuthorize("returnObject.username==authentication.principal.username")
	public User findById(Long userId);
	
	public List<User> findAll();
	
	public void deleteById(Long userId);
	
	public User updateById(Long userId);
	
	User findUserByUsername(String username);
	
	public boolean existsById(Long userId);
	
	List<String> getRoleName(String username); 
}
