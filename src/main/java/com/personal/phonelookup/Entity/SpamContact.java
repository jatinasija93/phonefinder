package com.personal.phonelookup.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class SpamContact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String msisdn;
	private String markedBy;
	
	
	public SpamContact () {
		
	}
	public SpamContact(Long id,String name, String msisdn, String markedBy) {
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "SpamContact [id=" + id + ", msisdn=" + msisdn + ", markedBy=" + markedBy + "]";
	}
	
}
