package com.personal.phonelookup.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal.phonelookup.Entity.UserRegistration;

public interface UserRegistrationRepository extends JpaRepository<UserRegistration, String>{

	
	
}
