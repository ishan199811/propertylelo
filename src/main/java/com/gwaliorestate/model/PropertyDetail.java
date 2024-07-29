package com.gwaliorestate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class PropertyDetail {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	
	String propertyName;
	String propertyDescription;
	String propertyAddress;
	String phoneNo;
	String landlineNo;
	
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getLandlineNo() {
		return landlineNo;
	}
	public void setLandlineNo(String landlineNo) {
		this.landlineNo = landlineNo;
	}
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "catagory_id", nullable = false)
	private PropertyCatagory catagoryId;

//	@JsonIgnore
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "subCatagory_id", nullable = false)
//	private PropertySubcatagory subCatagoryId;
//	
	private String area;
	
	private String bedRoom;
	
	private String bathRoom;
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getBedRoom() {
		return bedRoom;
	}
	public void setBedRoom(String bedRoom) {
		this.bedRoom = bedRoom;
	}
	public String getBathRoom() {
		return bathRoom;
	}
	public void setBathRoom(String bathRoom) {
		this.bathRoom = bathRoom;
	}
	
	public String getPropertyDescription() {
		return propertyDescription;
	}
	public PropertyCatagory getCatagoryId() {
		return catagoryId;
	}
	public void setCatagoryId(PropertyCatagory catagoryId) {
		this.catagoryId = catagoryId;
	}
	public void setPropertyDescription(String propertyDescription) {
		this.propertyDescription = propertyDescription;
	}
	public String getPropertyAddress() {
		return propertyAddress;
	}
	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
}
