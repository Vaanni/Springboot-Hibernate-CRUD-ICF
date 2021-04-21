package com.learning.springboot.model;

import java.util.Date;

public class Educational {
	
	private String type;
	private Date startdate;
	private Date enddate;
	private String institution;
	private String address;
	private Long percentage;
	
	public Educational() {
		super();
	}

	public Educational(String type, Date startdate, Date enddate, String institution, String address, Long percentage) {
		super();
		this.type = type;
		this.startdate = startdate;
		this.enddate = enddate;
		this.institution = institution;
		this.address = address;
		this.percentage = percentage;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPercentage() {
		return percentage;
	}

	public void setPercentage(Long percentage) {
		this.percentage = percentage;
	}
	
	
	
	
	

}
