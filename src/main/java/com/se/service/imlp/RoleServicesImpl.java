package com.se.service.imlp;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.entity.Role;
import com.se.repository.RoleRepository;
import com.se.service.RoleServices;

@Service
@Transactional
public class RoleServicesImpl implements RoleServices {
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role getMemberRole(Long id) {
		return roleRepository.getById(id);
	}
}
