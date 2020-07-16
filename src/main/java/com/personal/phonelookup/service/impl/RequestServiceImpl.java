package com.personal.phonelookup.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.phonelookup.Entity.UserInfo;
import com.personal.phonelookup.Repository.RequestRepository;
import com.personal.phonelookup.service.RequestService;

@Service
public class RequestServiceImpl implements RequestService {
	
	
	@Autowired
	RequestRepository requestRepository;

	@Override
	public List<UserInfo> generateRandomUserData(int count){
		
		List<UserInfo> userInfo = new ArrayList<UserInfo>();
		for(int i=0;i<count;i++) {
			UserInfo user = new UserInfo();
			
			String name = getRandomString();
			String email = name+"@gmail.com";
			user.setMsisdn(getRandomMsisdn());
			user.setEmail(email);
			user.setName(name);;
			userInfo.add(user);
		}
		requestRepository.saveAll(userInfo);
		return userInfo;
	}
	
	private String getRandomMsisdn() {
		//use of java 8 ThreadLocalRandom
		return Long.toString(ThreadLocalRandom.current().nextLong(6666666666L, 9999999999L+1));
	}
	
	private String getRandomString() {
		
	        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	        StringBuilder salt = new StringBuilder();
	        Random rnd = new Random();
	        while (salt.length() < 10) { // length of the random string.
	            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
	            salt.append(SALTCHARS.charAt(index));
	        }
	        String saltStr = salt.toString();
	        return saltStr;
	}

}
