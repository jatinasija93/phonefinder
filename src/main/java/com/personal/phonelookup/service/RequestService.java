package com.personal.phonelookup.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.personal.phonelookup.Entity.UserInfo;

@Service
public interface RequestService {

	
	public List<UserInfo> generateRandomUserData(int count);
}
