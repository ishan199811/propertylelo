package com.gwaliorestate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gwaliorestate.model.User;

public interface UserRepository extends JpaRepository<User ,Long>{

	User findByEmail(String userName);

}
