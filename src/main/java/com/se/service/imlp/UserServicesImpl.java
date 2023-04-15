package com.se.service.imlp;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.se.dto.UserDTO;
import com.se.entity.Permission;
import com.se.entity.Role;
import com.se.entity.User;
import com.se.entity.UserPrincipal;
import com.se.repository.UserRepository;
import com.se.service.RoleServices;
import com.se.service.UserServices;
import com.se.util.JwtUltility;

import ch.qos.logback.classic.joran.action.LoggerAction;

@Service
@Transactional
public class UserServicesImpl implements UserServices{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleServices roleServices;
	
	@Autowired
    private PasswordEncoder bcryptEncoder;
	
	

	
	private JwtUltility jwtUltility = new JwtUltility();
	
	@Override
	public User saveUser(UserDTO u) {
		
		Role memberRole = roleServices.getMemberRole(Long.valueOf(2));
		System.out.println(memberRole);
		
		Set<Role> roles = new HashSet<>();
		roles.add(memberRole);
		
		User user = new User();
		user.setUsername(u.getUsername());
		user.setPassword(bcryptEncoder.encode(u.getPassword()));
		user.setRoles(roles);
		user.setStatus("Đang hoạt động");
		System.out.println(user);
		
		return userRepository.save(user);
	}

	@Override
	public UserPrincipal getUserByUsername(String username) {
		User user = userRepository.findUserByUsername(username);
		UserPrincipal userPrincipal = new UserPrincipal();
		if(user != null) {
			Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
			if(user.getRoles() != null) {
				user.getRoles().forEach(role -> {
					GrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
					grantedAuthorities.add(authority);
				});
			}
			userPrincipal.setId(user.getId());
			userPrincipal.setUsername(user.getUsername());
			userPrincipal.setPassword(user.getPassword());
			userPrincipal.setAuthorities(grantedAuthorities);
		}
		return userPrincipal;
	}

	@Override
	public User getUserByUserName(String username) {
		return userRepository.findUserByUsername(username);
	}

	@Override
	public int getUserNumber() {
		// TODO Auto-generated method stub
		
		return userRepository.getCountUser() ;
	}

	@Override
	public Page<User> getAllUser_Paging(String keyword, Pageable pageable) {
		return userRepository.findAll(keyword, pageable);
	}

	@Override
	public Page<User> getAllUser_Paging(Pageable pageable) {
		
		return userRepository.findAll(pageable);
	}

	@Override
	public User getCurrentAuthenticatedUser(String token) {
		String username = jwtUltility.getUsernameFromToken(token);
		return userRepository.findUserByUsername(username);
	}



	
	
}
