package com.personal.phonelookup.controller;

import java.util.List;

import org.springframework.stereotype.Component;

import com.personal.phonelookup.Entity.UserInfo;

@Component
public interface RequestController {

	
	public List<UserInfo> generateRandomData(int count);
	
	
}
