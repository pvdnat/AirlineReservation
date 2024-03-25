package com.synergisticit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergisticit.repository.RoleRepository;
import com.synergisticit.domain.Role;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	RoleRepository roleRepository;

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public boolean existsById(Long roleId) {
		return roleRepository.existsById(roleId);
	}

	@Override
	public Role findById(Long roleId) {
		Optional<Role> optionalRole = roleRepository.findById(roleId);
		if(optionalRole.isPresent()) {
			return optionalRole.get();
		}else {
			return null;
		}
	}

	@Override
	public void deleteById(Long roleId) {
		roleRepository.deleteById(roleId);
	}

	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
	}

	
	
}
