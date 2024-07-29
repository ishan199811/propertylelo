package com.gwaliorestate.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gwaliorestate.model.PropertyCatagory;
import com.gwaliorestate.model.PropertyDetail;
import com.gwaliorestate.model.PropertySubcatagory;
import com.gwaliorestate.model.User;
import com.gwaliorestate.service.CatagoryService;
import com.gwaliorestate.service.PropertyService;
import com.gwaliorestate.service.SecurityService;
import com.gwaliorestate.service.UserService;



@Controller
public class PropertyController {
	
	
	@Autowired
	PropertyService propertyService;
	
	@Autowired
	CatagoryService catagoryService;
	
	@Autowired
	SecurityService securityService;
	
	@Autowired
	UserService userService;
 	
	 @PostMapping("/saveproperty") 
	  public String  editForm(@Valid @ModelAttribute("property") PropertyDetail propertyDetail ,BindingResult
	  bindingResult) {
	  
	  
	 if (bindingResult.hasErrors()) {
	 
	 return "addproperty"; 
	 } 
	 else
	 {
	  propertyService.saveProperty(propertyDetail); 
	 return "redirect:/addProperty.html"; 
	    }
	 }
	 
	 
	 @RequestMapping("/addProperty.html")
		public String return4(Model model) {
			model.addAttribute("property", new PropertyDetail());
			List<PropertyCatagory> propertyCatagory=catagoryService.getAllCatagory();
			List<PropertySubcatagory> propertysubCatagory=catagoryService.getAllSubCatagory();
			List<PropertyDetail> propertyDetail=propertyService.getAllProperty();
			model.addAttribute("propertydetail",propertyDetail);
			model.addAttribute("catagory", propertyCatagory);
			model.addAttribute("subcatagory", propertysubCatagory);
		//	model.addAttribute("property", propertyDetail);
				return "admin/addProperty";
			}
	 
//	 @RequestMapping("/")
//		public String returnProperty(Model model) {
//		 List<PropertyDetail> propertyDetail=propertyService.getAllProperty();
//		List<PropertyCatagory> propertyCatagory=catagoryService.getAllCatagory();
//		List<PropertySubcatagory> propertysubCatagory=catagoryService.getAllSubCatagory();
//		model.addAttribute("catagory", propertyCatagory);
//		model.addAttribute("subcatagory", propertysubCatagory);
//			model.addAttribute("property", propertyDetail);
//			String userName= securityService.findLoggedInUsername();
//			if(userName!=null) {
//				User user =userService.findByEmail(userName);
//				model.addAttribute("user",user);
//				return "index";
//			}
//				return "index";
//			}
//	 
//	 
	 @RequestMapping("/property-list")
		public String returnPropertyOfCatagory(@Param("catagoryId") PropertyCatagory catagoryId,Model model) {
		 
		 List<PropertyDetail> propertyDetail=propertyService.getByCatagory(catagoryId);
			List<PropertyCatagory> propertyCatagory=catagoryService.getAllCatagory();
			
			model.addAttribute("catagory", propertyCatagory);
				model.addAttribute("property", propertyDetail);
				return "property-list";
			}
	 
	 
	 @RequestMapping("/property-list.html")
		public String returnPropertylist(Model model) {
		 
		 List<PropertyDetail> propertyDetail=propertyService.getAllProperty();
			List<PropertyCatagory> propertyCatagory=catagoryService.getAllCatagory();
			model.addAttribute("catagory", propertyCatagory);
				model.addAttribute("property", propertyDetail);
				return "property-list";
			}
		
	 @RequestMapping("/property-type.html")
		public String returnPropertyType(Model model) {
		 List<PropertySubcatagory> propertysubCatagory=catagoryService.getAllSubCatagory();
			model.addAttribute("subcatagory", propertysubCatagory);
				return "property-type";
			}
	 @RequestMapping("/admin")
	 public String returnAdmin() {
		 return "admin/index";
	 }
	 
}
