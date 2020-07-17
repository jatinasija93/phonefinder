package com.personal.phonelookup.dto;

import java.util.List;


public class UserRegistrationDTO {

	private String name;
	private String email;
	private String msisdn;
	private List<UserInfoDTO> phoneBook;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public List<UserInfoDTO> getPhoneBook() {
		return phoneBook;
	}
	public void setPhoneBook(List<UserInfoDTO> phoneBook) {
		this.phoneBook = phoneBook;
	}
}
