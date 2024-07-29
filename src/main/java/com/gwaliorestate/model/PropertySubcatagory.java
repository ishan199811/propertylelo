package com.gwaliorestate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class PropertySubcatagory {

	
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long subCatagoryId;
	
	

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subCatagoryId", cascade = CascadeType.ALL)
//	private List<PropertyDetail> products = new ArrayList<>();

	public Long getSubCatagoryId() {
		return subCatagoryId;
	}


	public void setSubCatagoryId(Long subCatagoryId) {
		this.subCatagoryId = subCatagoryId;
	}




	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	String name;
}
