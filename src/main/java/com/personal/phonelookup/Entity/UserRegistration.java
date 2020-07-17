package com.personal.phonelookup.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserRegistration {

	@Id
	@Column( length = 15, unique = true )
	private String msisdn;
	private String name;
	private String email;
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	private List<UserInfo> phoneBook;
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
	public List<UserInfo> getPhoneBook() {
		return phoneBook;
	}
	public void setPhoneBook(List<UserInfo> phoneBook) {
		this.phoneBook = phoneBook;
	}
}
