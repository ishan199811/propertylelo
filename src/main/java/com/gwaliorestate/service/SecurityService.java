package com.gwaliorestate.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;




@Service
public class SecurityService {
	
	 @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private UserDetailsService userDetailsService;
	    

	  

	 private static final Logger log = LoggerFactory.getLogger(SecurityService.class);
	
	 public boolean isAuthenticated(String email,String password) {
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
	        UsernamePasswordAuthenticationToken auth = 
	        		new UsernamePasswordAuthenticationToken
	        		(userDetails, password, userDetails.getAuthorities());
	        authenticationManager.authenticate( auth); 	
	        if (auth.isAuthenticated()) {
	            SecurityContextHolder.getContext().setAuthentication(auth);
	            log.info(String.format(" login %s successfully!", email));
	            return authentication.isAuthenticated();
	        }
	        else {
	        	log.info(String.format("Auto login %s failed!", email));
	        }
			return false;
	     }

	   
	    public void autoLogin(String email, String password) throws Exception {
	        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
	        log.info("-----------------------------"+userDetails.getUsername());
	        log.info("-----------------------------"+userDetails);
	    
	        
	        
	        UsernamePasswordAuthenticationToken auth = 
	        		new UsernamePasswordAuthenticationToken
	        		(userDetails, password, userDetails.getAuthorities());
	       
	       
	     	 authenticationManager.authenticate( auth); 			
	       //log.info(password+"this is password--------hello--------------------------------");

	        if (auth.isAuthenticated()) {
	            SecurityContextHolder.getContext().setAuthentication(auth);
	            log.debug(String.format("Auto login %s successfully!", email));
	        }
	        else {
	        	log.debug(String.format("Auto login %s failed!", email));
	        }
	    }
	  
		public String findLoggedInUsername() {
			Object userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (userDetails instanceof UserDetails) {
			
		 
				return ((UserDetails) userDetails).getUsername();
			}

			return null;
		}
	

}
