package com.gwaliorestate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Testcontroller {
//	@RequestMapping("/")
//	public String returnhome() {
//		
//		return "index.html";
//	}

	
	
	@RequestMapping("/about.html")
	public String returnAbout() {
		return "about.html";
	}
	
	@RequestMapping("/property.html")
	public String returnproperty() {
		return "property.html";
	}
	@RequestMapping("/contact.html")
	public String returnContact() {
		return "contact.html";
	}
	@RequestMapping("/blog.html")
	public String returnblog() {
		return "blog.html";
	}
	@RequestMapping("/testimonial.html")
	public String returntetimonial() {
		return "testimonial.html";
	}
}
