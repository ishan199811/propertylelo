package com.gwaliorestate.service;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.gwaliorestate.model.User;
import com.gwaliorestate.repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	

	@Override

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
		User user = userRepository.findByEmail(email);
		if(user==null)
		{
			
			throw new UsernameNotFoundException("Could not found user !!");
		}
		
//		 Set<GrantedAuthority> grantedAuthorities = new HashSet<>(); for (Role role :
//		  user.getRoles()) { grantedAuthorities.add(new
//		  SimpleGrantedAuthority(role.getName())); } return new
//		 org.springframework.security.core.userdetails.User(user.getEmail(),
//		 user.getPassword(), grantedAuthorities); }
//		 
	  MyUserDetails customUserDetails=new MyUserDetails(user);
		  
		  return customUserDetails;
		 
		}
}
	




