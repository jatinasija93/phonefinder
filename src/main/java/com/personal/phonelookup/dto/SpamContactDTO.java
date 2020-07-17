package com.personal.phonelookup.dto;

public class SpamContactDTO {
	private Long id;
	private String msisdn;
	private String markedBy;
	private String name;
	
	public SpamContactDTO () {
		
	}
	public SpamContactDTO(Long id,String name, String msisdn, String markedBy) {
		super();
		this.id = id;
		this.msisdn = msisdn;
		this.markedBy = markedBy;
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getMarkedBy() {
		return markedBy;
	}
	public void setMarkedBy(String markedBy) {
		this.markedBy = markedBy;
	}
	@Override
	public String toString() {
		return "SpamContactDTO [id=" + id + ", msisdn=" + msisdn + ", markedBy=" + markedBy + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
