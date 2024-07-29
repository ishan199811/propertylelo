package com.gwaliorestate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class PropertyCatagory {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long catagoryId;
	
	String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catagoryId", cascade = CascadeType.ALL)
	private Set<PropertyDetail> products = new HashSet<PropertyDetail>(); 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCatagoryId() {
		return catagoryId;
	}

	public void setCatagoryId(Long catagoryId) {
		this.catagoryId = catagoryId;
	}

	public Set<PropertyDetail> getProducts() {
		return products;
	}

	public void setProducts(Set<PropertyDetail> products) {
		this.products = products;
	}

	

}
