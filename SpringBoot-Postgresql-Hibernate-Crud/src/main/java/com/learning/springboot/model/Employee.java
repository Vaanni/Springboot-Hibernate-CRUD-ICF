package com.learning.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emplyoee")

public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long id;
	@Column(name="first_name")
	public String firstname;
	@Column(name="last_name")
	public String lastname;
	@Column(name="emplyoment_id")
	public String emplyomentid;
	@Column(name="start_date")
	public int startdate;
	@Column(name="designation")
	public String designation;
	@Column(name="department")
	public String department;
	@Column(name="end_date")
	public int enddate;
	@Column(name="status")
	public String status;
	@Column(name="dob")
	public int dob;
	@Column(name="reporting_manager")
	public String reportingmanager;
	@Column(name="gender")
	public String gender;
	@Column(name="blood_group")
	public String bloodgroup;
	@Column(name="address")
	public String address;
	
	public Employee() {
		super();
	}
	
	public Employee(String firstname, String lastname, String emplyomentid, int startdate, String designation,
			String department, int enddate, String status, int dob, String reportingmanager, String gender,
			String bloodgroup, String address) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.emplyomentid = emplyomentid;
		this.startdate = startdate;
		this.designation = designation;
		this.department = department;
		this.enddate = enddate;
		this.status = status;
		this.dob = dob;
		this.reportingmanager = reportingmanager;
		this.gender = gender;
		this.bloodgroup = bloodgroup;
		this.address = address;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmplyomentid() {
		return emplyomentid;
	}
	public void setEmplyomentid(String emplyomentid) {
		this.emplyomentid = emplyomentid;
	}
	public int getStartdate() {
		return startdate;
	}
	public void setStartdate(int startdate) {
		this.startdate = startdate;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getEnddate() {
		return enddate;
	}
	public void setEnddate(int enddate) {
		this.enddate = enddate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getDob() {
		return dob;
	}
	public void setDob(int dob) {
		this.dob = dob;
	}
	public String getReportingmanager() {
		return reportingmanager;
	}
	public void setReportingmanager(String reportingmanager) {
		this.reportingmanager = reportingmanager;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}

