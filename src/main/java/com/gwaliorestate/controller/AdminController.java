package com.gwaliorestate.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	
	@RequestMapping("index.html")
	public String returnAminIndex() {
		return "admin/index";
	}
	@RequestMapping("index2.html")
	public String returnAminIndex2() {
		return "admin/index2";
	}
	@RequestMapping("addVendor.html")
	public String returnVendor() {
		return "admin/addVendor";
	}
	

}
