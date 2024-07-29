package com.gwaliorestate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gwaliorestate.model.User;
import com.gwaliorestate.service.SecurityService;
import com.gwaliorestate.service.UserService;
import com.gwaliorestate.service.UserValidator;



@Controller
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	@Autowired
	SecurityService securityService;
	
	 @Autowired
	    private UserValidator userValidator;
	
//	@RequestMapping("/login")
//	public String returnLoginPage() {
//		
//		return "login";
//	}

	 @GetMapping("/register")
	    public String registration(Model model) {
	        model.addAttribute("userForm", new User());

	        return "register";
	    }
	
	 @PostMapping("/registration")
	    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) throws Exception {
	       // userValidator.validate(userForm, bindingResult);

	        if (bindingResult.hasErrors()) {
	            return "login";
	        }

	        userService.save(userForm);
	        securityService.autoLogin(userForm.getEmail(), userForm.getConfirmPassword());
	       
	        return "index";
	    }

	 @GetMapping("/login")
	    public String login(Model model, String error, String logout) {
	       model.addAttribute("userForm", new User());
//		 if (securityService.isAuthenticated()) {
//	            return "redirect:/";
//	        }
		 if (error != null) {
	            model.addAttribute("error", "Your username and password is invalid.");
	        return "login";
	        }
	        if (logout != null)
	            model.addAttribute("message", "You have been logged out successfully.");

	        return "login";
	    }
	 @GetMapping("/loginn")
	    public String login(@ModelAttribute("userForm") User userForm,Model model, String error, String logout) {
		 
		 if (securityService.isAuthenticated(userForm.getEmail(),userForm.getConfirmPassword())) {
	           
			 
			 return "redirect:/";
	        }
		 else {
			 return "login";
		 }
	 } 
	 
}
