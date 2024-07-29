package com.gwaliorestate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gwaliorestate.model.PropertyCatagory;

public interface CatagoryRepository extends JpaRepository<PropertyCatagory,Long>{

	
	PropertyCatagory findByCatagoryId(Long ecatagoryId);
	
}
