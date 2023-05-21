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

import com.se.dto.UpdateInforDTO;
import com.se.dto.UserDTO;
import com.se.dto.UserUpdate;
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
	public User registerUser(UserDTO u) {
		
		Role memberRole = roleServices.getMemberRole(Long.valueOf(2));
		System.out.println(memberRole);
		
		Set<Role> roles = new HashSet<>();
		roles.add(memberRole);
		
		User user = new User();
		user.setUsername(u.getUsername());
		user.setPassword(bcryptEncoder.encode(u.getPassword()));
		user.setRoles(roles);
		user.setStatus("Đang hoạt động");
		user.setUrl("https://res.cloudinary.com/dps8mwvsi/image/upload/v1666187220/cld-sample-2.jpg");
		user.setName(u.getUsername());
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
		return userRepository.getUserActive(keyword, pageable);
	}

	@Override
	public Page<User> getAllUser_Paging(Pageable pageable) {
		
		return userRepository.getUserActive(pageable);
	}

	@Override
	public User getCurrentAuthenticatedUser(String token) {
		String username = jwtUltility.getUsernameFromToken(token);
		return userRepository.findUserByUsername(username);
	}

	@Override
	public void Deductmoneywhenposting(long id) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(id).get();
		user.setSurplus(user.getSurplus()-50000);
		userRepository.save(user);
		
	}

	@Override
	public Page<User> getAllUserLock(String keyword, Pageable pageable) {
		// TODO Auto-generated method stub
		return userRepository.getUserLock(keyword, pageable);
	}

	@Override
	public Page<User> getAllUserLock(Pageable pageable) {
		// TODO Auto-generated method stub
		return userRepository.getUserLock(pageable);
	}

	@Override
	public User unlockUser(long id) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(id).get();
		user.setStatus("Đang hoạt động");
		userRepository.save(user);
		return user;
	}

	@Override
	public User lockUser(long id) {
		User user = userRepository.findById(id).get();
		user.setStatus("Đã khóa");
		userRepository.save(user);
		return user;
	}

	@Override
	public User PublicMoney(long id ,double money) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(id).get();
		user.setSurplus(user.getSurplus()+money);
		userRepository.save(user);
		return user;
	}

	@Override
	public User saveUser(UserDTO u, long role) {
		Role memberRole = roleServices.getMemberRole(role);
		System.out.println(memberRole);
		
		Set<Role> roles = new HashSet<>();
		roles.add(memberRole);
		
		User user = new User();
		user.setUsername(u.getUsername());
		user.setPassword(bcryptEncoder.encode(u.getPassword()));
		user.setRoles(roles);
		user.setStatus("Đang hoạt động");
		user.setUrl("https://res.cloudinary.com/dps8mwvsi/image/upload/v1666187220/cld-sample-2.jpg");
		user.setName(u.getUsername());
		System.out.println(user);
		
		return userRepository.save(user);
	}

	@Override
	public User UpdateUser(UserUpdate u, long role) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(u.getIdUserUpdate()).get();
		
		Role memberRole = roleServices.getMemberRole(role);
		System.out.println(memberRole);
		
		Set<Role> roles = new HashSet<>();
		roles.add(memberRole);
		
		user.setName(u.getNameUpdate());
		user.setUsername(u.getEmailUpdate());
		user.setPhone(u.getPhoneUpdate());
		user.setSurplus(u.getSurplusUpdate());
		user.setStatus(u.getStatusUpdate());
		user.setUrl(u.getImg1Update());
		user.setRoles(roles);
		
		userRepository.save(user);
		return user ;
	}

	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}

	@Override
	public User UpdateInforUser(UpdateInforDTO u) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(u.getIdUserUpdate()).get();
		user.setName(u.getNameUpdate());
		user.setUsername(u.getEmailUpdate());
		user.setPhone(u.getPhoneUpdate());
		user.setUrl(u.getImg1Update());
		userRepository.save(user);
		return user;
	}

	@Override
	public String checkUser(String userName) {
		// TODO Auto-generated method stub
		User user =  userRepository.findByUsername(userName);
		System.out.println(user);
		if (user!=null) {
			return "Đã tồn tại";
		}
		return "Không tồn tại";
	}

	@Override
	public User checkLock(String userName) {
		User user =  userRepository.findByUsername(userName);
		return user;
	}
	
	




	
	
}
