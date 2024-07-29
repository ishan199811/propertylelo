package com.gwaliorestate.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gwaliorestate.model.Role;
import com.gwaliorestate.model.User;

import com.gwaliorestate.repository.RoleRepository;
import com.gwaliorestate.repository.UserRepository;



@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public void save(User user) {
		
		
		
		Role role = roleRepository.findByName("USER");
		Set roles = new HashSet<>();
		roles.add(role);
		user.setRoles(roles);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	
		userRepository.save(user);
		
	}

	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	
	

}
