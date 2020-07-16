package com.personal.phonelookup.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.phonelookup.Entity.UserInfo;
import com.personal.phonelookup.controller.RequestController;
import com.personal.phonelookup.service.RequestService;

@RestController
@RequestMapping("/api")
public class RequestControllerImpl implements RequestController {
	
	
	@Autowired
	RequestService requestService;
	
	@GetMapping("/generateRandomData/{count}")
	public List<UserInfo> generateRandomData(@PathVariable("count")int count){
		
		return requestService.generateRandomUserData(count); 
	}

}
