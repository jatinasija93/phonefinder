package com.personal.phonelookup.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class UserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String msisdn;
	private String email;
	private int spamCount = 0;

	public UserInfo(Long id, String name, String msisdn, String email, int spamCount) {
		super();
		this.id = id;
		this.name = name;
		this.msisdn = msisdn;
		this.email = email;
		this.spamCount = spamCount;
	}
	
	public UserInfo() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSpamCount() {
		return spamCount;
	}

	public void setSpamCount(int spamCount) {
		this.spamCount = spamCount;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + name + ", msisdn=" + msisdn + ", email=" + email + ", spamCount="
				+ spamCount + "]";
	}

}
