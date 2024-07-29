package com.gwaliorestate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gwaliorestate.model.PropertyCatagory;
import com.gwaliorestate.model.PropertyDetail;
import com.gwaliorestate.repository.CatagoryRepository;
import com.gwaliorestate.repository.PropertyRepository;

@Service
public class PropertyService {
	
	@Autowired
	PropertyRepository propertyRepository;
	
	@Autowired
	CatagoryRepository catagoryRepository;
	
	public void saveProperty(PropertyDetail property) {
		long catagoryId=property.getCatagoryId().getCatagoryId();
		PropertyCatagory propertyCatagory=catagoryRepository.findByCatagoryId(catagoryId);
		property.setCatagoryId(propertyCatagory);
		
		
		
		propertyRepository.save(property);
	}
	public List<PropertyDetail> getAllProperty(){
		
		List<PropertyDetail> propertyDetail=propertyRepository.findAll();
		return propertyDetail;
		
	}

	
	public void getdeleteProperty() {
		propertyRepository.deleteById(null);
	}
	public List<PropertyDetail> getByCatagory(PropertyCatagory catagoryId) {
		List<PropertyDetail> propertyDetail=propertyRepository.findByCatagoryId(catagoryId);
		return propertyDetail;
	}
	
	
}
