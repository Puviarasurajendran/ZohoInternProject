package com.example.spring_restapi.service;

public class CustomerDBModel {

	private String custId;
	private String fname;
	private String lname;
	private String mail;
	private String contact;

	public CustomerDBModel() {

	}

	public CustomerDBModel(String custId, String fname, String lname, String mail, String contact) {
		this.custId = custId;
		this.fname = fname;
		this.lname = lname;
		this.mail = mail;
		this.contact = contact;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "CustomerDBModel [custId=" + custId + ", fname=" + fname + ", lname=" + lname + ", mail=" + mail
				+ ", contact=" + contact + "]";
	}

}
