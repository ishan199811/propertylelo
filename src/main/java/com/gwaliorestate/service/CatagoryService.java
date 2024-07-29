package com.gwaliorestate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gwaliorestate.model.PropertyCatagory;
import com.gwaliorestate.model.PropertySubcatagory;
import com.gwaliorestate.repository.CatagoryRepository;
import com.gwaliorestate.repository.SubCatagoryRepository;

@Service
public class CatagoryService {
	
	@Autowired
	CatagoryRepository catagoryRepository;

	@Autowired
	SubCatagoryRepository subcatagoryRepository;
	
	public List<PropertyCatagory> getAllCatagory(){
	
		List<PropertyCatagory>  propertyCatagory=catagoryRepository.findAll();
		
		return propertyCatagory;
		
	}

	
	public List<PropertySubcatagory> getAllSubCatagory(){
		
		List<PropertySubcatagory>  subpropertyCatagory=subcatagoryRepository.findAll();
		
		return subpropertyCatagory;
		
	}

}
