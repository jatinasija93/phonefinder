package com.personal.phonelookup.dto;

public class UserInfoDTO {

	private Integer id;
	private String name;
	private String msisdn;
	private String email;
	private int spamCount = 0;

	public UserInfoDTO(Integer id, String name, String msisdn, String email, int spamCount) {
		super();
		this.id = id;
		this.name = name;
		this.msisdn = msisdn;
		this.email = email;
		this.spamCount = spamCount;
	}
	
	public UserInfoDTO() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
