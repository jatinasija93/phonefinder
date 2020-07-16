package com.personal.phonelookup.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal.phonelookup.Entity.UserInfo;

public interface RequestRepository extends JpaRepository<UserInfo, Long>{

	
	
	
}
