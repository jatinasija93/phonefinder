package com.personal.phonelookup.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.phonelookup.Entity.SpamContact;
import com.personal.phonelookup.Entity.UserInfo;
import com.personal.phonelookup.Entity.UserRegistration;
import com.personal.phonelookup.Repository.RequestRepository;
import com.personal.phonelookup.Repository.SpamContactRepository;
import com.personal.phonelookup.Repository.UserRegistrationRepository;
import com.personal.phonelookup.dto.SpamContactDTO;
import com.personal.phonelookup.dto.UserRegistrationDTO;
import com.personal.phonelookup.service.RequestService;

@Service
public class RequestServiceImpl implements RequestService {
	
	
	@Autowired
	RequestRepository requestRepository;
	
	@Autowired
	SpamContactRepository spamContactRepository;
	
	@Autowired
	UserRegistrationRepository userRegistrationRepository;

	@Override
	public UserRegistration generateRandomUserData(int count){
		
		
		UserRegistration userRegistration = new UserRegistration();
		userRegistration.setMsisdn("9873072132");
		userRegistration.setName("Kashif");
		userRegistration.setEmail("qazi.kashif@gmail.com");
		
		List<UserInfo> userInfo = new ArrayList<UserInfo>();
		for(int i=0;i<count;i++) {
			UserInfo user = new UserInfo();
			
			String name = getRandomString();
			String email = name+"@gmail.com";
			user.setMsisdn(getRandomMsisdn());
			user.setEmail(email);
			user.setName(name);
			//user.setContactOf(arrayOfContact[random.nextInt(arrayOfContact.length-1)]);
			user.setUser(userRegistration);
			userInfo.add(user);
		}
		UserInfo myUser = new UserInfo();
		BeanUtils.copyProperties(userRegistration, myUser);
		myUser.setUser(userRegistration);
		userInfo.add(myUser);
		userRegistration.setPhoneBook(userInfo);
		userRegistrationRepository.save(userRegistration);
//		requestRepository.saveAll(userInfo); // to be done manually if cascade type not set in one to many
//returning null because of infinite recursion caused by one to many relationship		
		return userRegistration;
	}
	
	@Override
	public List<UserInfo> getUserByMsisdn(String  msisdn){
		
		return requestRepository.findByMsisdn(msisdn);
	}
	
	@Override
	public List<UserInfo> getUserByName(String  name){
		
		return requestRepository.findByName(name,name);
	}
	
	@Override
	public SpamContactDTO markAsSpam(SpamContactDTO spamContactDTO) {
		List<UserInfo> userList =  requestRepository.findByMsisdn(spamContactDTO.getMsisdn());
		userList.forEach((element)->{
			element.setSpamCount(element.getSpamCount()+1);
		});

		if(userList.size() == 0) {
			spamContactDTO.setName("SPAM");
			UserInfo userSpamContact= new UserInfo();
			BeanUtils.copyProperties(spamContactDTO, userSpamContact);
			userSpamContact.setName("Spam");
			requestRepository.save(userSpamContact);
		}
		else {
			spamContactDTO.setName(userList.get(0).getName());
		}
		
		SpamContact spamContact = new SpamContact();
		BeanUtils.copyProperties(spamContactDTO, spamContact);
		//spamContact.setName("");
		spamContactRepository.save(spamContact);
		spamContactDTO.setId(spamContact.getId());
		return spamContactDTO;
	}
	
	@Override
	public UserRegistration uploadPhoneBook(UserRegistrationDTO userRegistrationDTO) {
		UserRegistration userRegistration = new UserRegistration();
		BeanUtils.copyProperties(userRegistrationDTO, userRegistration);
		List<UserInfo> toBeCopied = new ArrayList<UserInfo>();
		userRegistrationDTO.getPhoneBook().forEach((userInfoDTO)->{
			UserInfo userInfo = new UserInfo();
			BeanUtils.copyProperties(userInfoDTO, userInfo);
			userInfo.setUser(userRegistration);
			toBeCopied.add(userInfo);
		});
		userRegistration.setPhoneBook(toBeCopied);
		
		
		userRegistrationRepository.save(userRegistration);
		return null;
	}
	
	private String getRandomMsisdn() {
		//use of java 8 ThreadLocalRandom
		return Long.toString(ThreadLocalRandom.current().nextLong(6666666666L, 9999999999L+1));
	}
	
	
	private String getRandomString() {
		
	        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
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
