package com.gwaliorestate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gwaliorestate.model.PropertyCatagory;
import com.gwaliorestate.model.PropertyDetail;

public interface PropertyRepository extends JpaRepository<PropertyDetail , Long> {

	List<PropertyDetail> findByCatagoryId(PropertyCatagory catagoryId);

}
