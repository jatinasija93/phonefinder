package com.personal.phonelookup.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.phonelookup.PhonelookupApplication;
import com.personal.phonelookup.Entity.UserInfo;
import com.personal.phonelookup.Entity.UserRegistration;
import com.personal.phonelookup.controller.RequestController;
import com.personal.phonelookup.dto.SpamContactDTO;
import com.personal.phonelookup.dto.UserRegistrationDTO;
import com.personal.phonelookup.service.RequestService;

@RestController
@RequestMapping("/api")
public class RequestControllerImpl implements RequestController {
	
	
	@Autowired
	RequestService requestService;
	
	@Override
	@GetMapping("/generateRandomData/{count}")
	public UserRegistration generateRandomData(@PathVariable("count")int count){
		
		return requestService.generateRandomUserData(count); 
	}
	
	@Override
	@GetMapping("/getUserByMobileNo/{msisdn}")
	public ResponseEntity<List<UserInfo>> findByMsisdn(@PathVariable String msisdn){
		return new ResponseEntity<List<UserInfo>>(requestService.getUserByMsisdn(msisdn),HttpStatus.OK);
	}
	
	@Override
	@GetMapping("/getUserByName/{name}")
	public ResponseEntity<List<UserInfo>> findByName(@PathVariable String name){
		return new ResponseEntity<List<UserInfo>>(requestService.getUserByName(name),HttpStatus.OK);
	}
	
	@Override
	@PostMapping(path="/markAsSpam")
	public SpamContactDTO markAsSpam(@RequestBody SpamContactDTO spamContactDTO){
		return requestService.markAsSpam(spamContactDTO);
	}
	
	@Override
	@PostMapping(path="/uploadPhoneBook")
	public UserRegistration uploadPhoneBook(@RequestBody UserRegistrationDTO userRegistrationDTO){
		return requestService.uploadPhoneBook(userRegistrationDTO);
	}
}
