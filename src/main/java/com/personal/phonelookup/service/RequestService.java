package com.personal.phonelookup.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.personal.phonelookup.Entity.UserInfo;
import com.personal.phonelookup.Entity.UserRegistration;
import com.personal.phonelookup.dto.SpamContactDTO;
import com.personal.phonelookup.dto.UserRegistrationDTO;

@Service
public interface RequestService {

	
	public UserRegistration generateRandomUserData(int count);
	public List<UserInfo> getUserByMsisdn(String  msisdn);
	public List<UserInfo> getUserByName(String  name);
	public SpamContactDTO markAsSpam(SpamContactDTO spamContactDTO);
	public UserRegistration uploadPhoneBook(UserRegistrationDTO spamContactDTO);
}
