package com.personal.phonelookup.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.personal.phonelookup.Entity.UserInfo;
import com.personal.phonelookup.Entity.UserRegistration;
import com.personal.phonelookup.dto.SpamContactDTO;
import com.personal.phonelookup.dto.UserRegistrationDTO;

@Component
public interface RequestController {

	
	public UserRegistration generateRandomData(int count);
	public ResponseEntity<List<UserInfo>> findByMsisdn(String msisdn);
	public ResponseEntity<List<UserInfo>> findByName(String name);
	public SpamContactDTO markAsSpam(SpamContactDTO spamContact);
	public UserRegistration uploadPhoneBook(@RequestBody UserRegistrationDTO userRegistrationDTO);
}
