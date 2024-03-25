package com.synergisticit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.synergisticit.repository.UserRepository;
import com.synergisticit.domain.Role;
import com.synergisticit.domain.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired UserRepository userRepository;
	@Autowired BCryptPasswordEncoder encoder;
	
	@Override
	public User save(User user) {
		String encryptedPassword = encoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		return userRepository.save(user);
	}

	@Override
	public User findById(Long userId) {
		Optional<User> optUser = userRepository.findById(userId);
		
		if(optUser.isPresent()) {
			System.out.println("working 1");
			return optUser.get();
		}
		System.out.println("working 2");
		return null;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void deleteById(Long userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public User updateById(Long userId) { 
		Optional<User> optUser = userRepository.findById(userId);
		if(optUser.isPresent())
			return optUser.get();
		return null;
	}

	@Override
	public User findUserByUsername(String username) {
		
		return userRepository.findUserByUsername(username);
	}

	@Override
	public boolean existsById(Long userId) {
		return userRepository.existsById(userId);
	}

	@Override
	public List<String> getRoleName(String username) {
		List<String> s = new ArrayList<>();
		User u = userRepository.findUserByUsername(username);
		List<Role> r = u.getRoles();
		for (Role role : r) {
			s.add(role.getRoleName());
		}
		return s;
	}
}
