package com.personal.phonelookup.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Component
public class UserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String msisdn;
	private String email;
	//private String contactOf;
	private int spamCount = 0;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="contactOf", nullable=false)
	private UserRegistration user;

	
	
	public UserInfo() {
		
	}
	
	public UserInfo(Long id, String name, String msisdn, String email, String contactOf, int spamCount,
			UserRegistration user) {
		super();
		this.id = id;
		this.name = name;
		this.msisdn = msisdn;
		this.email = email;
		//this.contactOf = contactOf;
		this.spamCount = spamCount;
		this.user = user;
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

//	public String getContactOf() {
//		return contactOf;
//	}
//
//	public void setContactOf(String contactOf) {
//		this.contactOf = contactOf;
//	}

	public UserRegistration getUser() {
		return user;
	}

	public void setUser(UserRegistration user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + name + ", msisdn=" + msisdn + ", email=" + email + ", contactOf="
				+ "contactOf" + ", spamCount=" + spamCount + ", user=" + user + "]";
	}

	

}
