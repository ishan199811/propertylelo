package com.gwaliorestate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gwaliorestate.model.Role;


public interface RoleRepository extends JpaRepository<Role ,Long>{

	Role findByName(String string);

}
